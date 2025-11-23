/**
 * ----- Mensaje genérico -----
 * Clase administrada sólo por RICARDO.
 * Puede modificarse por alguien más SÓLO en caso de que quiera hacer pruebas, pero debe
 * regresarse a su estado original. En caso de que no se reestablezca a su estado original,
 * el pull request será rechazado.
 * ----- Mensaje genérico -----
 * 
 * ----- Mensaje para VISITANTES -----
 * 
 * ----- Mensaje para VISITANTES -----
 * 
 * INSERTA TU PROPIO COMENTARIO DE LA CLASE.
 */
import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Representa una lista de tareas (colección) implementada con un arreglo.
 * Aquí se maneja la lógica de negocio:
 *  - Crear tareas respetando permisos y validaciones.
 *  - Cambiar estado respetando el flujo PENDIENTE -> EN_CURSO -> COMPLETADA.
 *  - Actualizar descripción, fechas, usuario asignado (según rol).
 *  - Eliminar tareas.
 *  - Filtrar por usuario o estado.
 *  - Guardar/cargar desde archivo (serialización).
 */
public class ListaTareas implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int MAX_TAREAS = 1000;

    private Tarea[] tareas;
    private int numTareas;

    public ListaTareas() {
        this.tareas = new Tarea[MAX_TAREAS];
        this.numTareas = 0;
    }

    // ===================== PERSISTENCIA =====================

    /**
     * Guarda la lista completa de tareas en un archivo usando serialización.
     */
    public void guardarEnArchivo(String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error al guardar tareas: " + e.getMessage());
        }
    }

    /**
     * Carga una lista de tareas desde archivo.
     * Si no existe el archivo, devuelve una nueva ListaTareas vacía.
     */
    public static ListaTareas cargarDesdeArchivo(String ruta) {
        File f = new File(ruta);
        if (!f.exists()) {
            return new ListaTareas();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Object obj = ois.readObject();
            if (obj instanceof ListaTareas) {
                return (ListaTareas) obj;
            }
        } catch (Exception e) {
            System.out.println("No se pudo cargar la lista de tareas. Se iniciará una nueva. Detalle: " + e.getMessage());
        }
        return new ListaTareas();
    }

    // ===================== BÚSQUEDAS BÁSICAS =====================

    /**
     * Busca una tarea por su ID (String UUID).
     */
    public Tarea buscarPorId(String idTarea) {
        for (int i = 0; i < numTareas; i++) {
            if (tareas[i].getId().equals(idTarea)) {
                return tareas[i];
            }
        }
        return null;
    }

    /**
     * Devuelve cuántas tareas hay actualmente.
     */
    public int getNumTareas() {
        return numTareas;
    }

    // ===================== CREACIÓN DE TAREAS =====================

    /**
     * Crea una tarea nueva en estado PENDIENTE.
     *
     * Reglas de negocio:
     *  - Administrador puede crear tareas para cualquier usuario.
     *  - Desarrollador solo puede crear tareas para sí mismo.
     *  - Invitado NO puede crear tareas.
     *  - La fecha estimada de inicio no puede ser anterior a hoy.
     *  - La fecha estimada de fin no puede ser anterior a la fecha estimada de inicio.
     */
    public Tarea crearTarea(Usuario creador,
                            Usuario usuarioAsignado,
                            String descripcion,
                            LocalDate fechaEstimadaInicio,
                            LocalDate fechaEstimadaFin)
            throws FechaInvalidaException, IllegalArgumentException {

        if (numTareas >= MAX_TAREAS) {
            throw new IllegalStateException("No se pueden agregar más tareas (límite alcanzado).");
        }

        if (usuarioAsignado == null) {
            throw new IllegalArgumentException("El usuario asignado no puede ser null.");
        }

        // Permisos según rol
        if (creador instanceof Invitado) {
            throw new IllegalArgumentException("Un invitado no puede crear tareas.");
        }
        if (creador instanceof Desarrollador &&
            !creador.getId().equals(usuarioAsignado.getId())) {
            // Desarrollador solo para sí mismo
            throw new IllegalArgumentException("Un desarrollador solo puede crear tareas para sí mismo.");
        }

        // Validaciones de fechas
        LocalDate hoy = LocalDate.now();
        if (fechaEstimadaInicio.isBefore(hoy)) {
            throw new FechaInvalidaException("La fecha estimada de inicio no puede ser anterior a hoy.");
        }
        if (fechaEstimadaFin.isBefore(fechaEstimadaInicio)) {
            throw new FechaInvalidaException("La fecha estimada de fin no puede ser anterior a la de inicio.");
        }

        Tarea nueva = new Tarea(usuarioAsignado, descripcion, fechaEstimadaInicio, fechaEstimadaFin);
        tareas[numTareas++] = nueva;
        return nueva;
    }

    // ===================== LISTADOS =====================

    /**
     * Muestra todas las tareas en consola.
     */
    public void listarTodas() {
        System.out.println("=== Todas las tareas ===");
        for (int i = 0; i < numTareas; i++) {
            System.out.println(tareas[i]);
            System.out.println("------------------------");
        }
    }

    /**
     * Muestra las tareas asignadas a un usuario específico.
     */
    public void listarPorUsuario(Usuario usuario) {
        System.out.println("=== Tareas de " + usuario.getNombre() + " ===");
        for (int i = 0; i < numTareas; i++) {
            Tarea t = tareas[i];
            if (t.getUsuarioAsignado() != null &&
                t.getUsuarioAsignado().getId().equals(usuario.getId())) {
                System.out.println(t);
                System.out.println("------------------------");
            }
        }
    }

    /**
     * Muestra las tareas con un estado específico.
     */
    public void listarPorEstado(EstadoTarea estado) {
        System.out.println("=== Tareas con estado " + estado + " ===");
        for (int i = 0; i < numTareas; i++) {
            if (tareas[i].getEstado() == estado) {
                System.out.println(tareas[i]);
                System.out.println("------------------------");
            }
        }
    }

    // ===================== ACTUALIZACIONES =====================

    /**
     * Cambia el estado de una tarea respetando el flujo:
     *   PENDIENTE -> EN_CURSO -> COMPLETADA
     *
     * Permisos:
     *  - Administrador puede cambiar cualquier tarea.
     *  - Desarrollador solo puede cambiar sus tareas.
     *  - Invitado no puede cambiar estados.
     */
    public void cambiarEstado(Usuario actor, String idTarea, EstadoTarea nuevoEstado) {
        Tarea tarea = buscarPorId(idTarea);
        if (tarea == null) {
            throw new IllegalArgumentException("La tarea con ID " + idTarea + " no existe.");
        }

        if (actor instanceof Invitado) {
            throw new IllegalArgumentException("Un invitado no puede cambiar el estado de las tareas.");
        }

        if (actor instanceof Desarrollador &&
            !tarea.getUsuarioAsignado().getId().equals(actor.getId())) {
            throw new IllegalArgumentException("No puedes modificar tareas que no te pertenecen.");
        }

        EstadoTarea actual = tarea.getEstado();

        if (actual == EstadoTarea.PENDIENTE && nuevoEstado == EstadoTarea.EN_CURSO) {
            tarea.setEstado(EstadoTarea.EN_CURSO);
            tarea.setFechaInicio(LocalDate.now());
        } else if (actual == EstadoTarea.EN_CURSO && nuevoEstado == EstadoTarea.COMPLETADA) {
            tarea.setEstado(EstadoTarea.COMPLETADA);
            tarea.setFechaFin(LocalDate.now());
        } else {
            throw new IllegalArgumentException(
                "Cambio de estado no permitido. Flujo válido: PENDIENTE -> EN_CURSO -> COMPLETADA."
            );
        }
    }

    /**
     * Actualiza la descripción de una tarea.
     *
     * Permisos:
     *  - Admin: cualquier tarea.
     *  - Dev: solo sus tareas.
     *  - Invitado: no puede.
     */
    public void actualizarDescripcion(Usuario actor, String idTarea, String nuevaDescripcion) {
        Tarea tarea = buscarPorId(idTarea);
        if (tarea == null) {
            throw new IllegalArgumentException("La tarea no existe.");
        }

        if (actor instanceof Invitado) {
            throw new IllegalArgumentException("Un invitado no puede modificar tareas.");
        }

        if (actor instanceof Desarrollador &&
            !tarea.getUsuarioAsignado().getId().equals(actor.getId())) {
            throw new IllegalArgumentException("No puedes modificar tareas que no te pertenecen.");
        }

        tarea.setDescripcion(nuevaDescripcion);
    }

    /**
     * Actualiza las fechas estimadas de una tarea.
     *
     * Permisos:
     *  - Admin: cualquier tarea.
     *  - Dev: solo sus tareas.
     *  - Invitado: no puede.
     */
    public void actualizarFechasEstimadas(Usuario actor, String idTarea,
                                          LocalDate nuevaEstimadaInicio,
                                          LocalDate nuevaEstimadaFin)
            throws FechaInvalidaException {

        Tarea tarea = buscarPorId(idTarea);
        if (tarea == null) {
            throw new IllegalArgumentException("La tarea no existe.");
        }

        if (actor instanceof Invitado) {
            throw new IllegalArgumentException("Un invitado no puede modificar tareas.");
        }

        if (actor instanceof Desarrollador &&
            !tarea.getUsuarioAsignado().getId().equals(actor.getId())) {
            throw new IllegalArgumentException("No puedes modificar tareas que no te pertenecen.");
        }

        LocalDate hoy = LocalDate.now();
        if (nuevaEstimadaInicio.isBefore(hoy)) {
            throw new FechaInvalidaException("La nueva fecha estimada de inicio no puede ser anterior a hoy.");
        }
        if (nuevaEstimadaFin.isBefore(nuevaEstimadaInicio)) {
            throw new FechaInvalidaException("La nueva fecha estimada de fin no puede ser anterior a la de inicio.");
        }

        tarea.setFechaEstimadaInicio(nuevaEstimadaInicio);
        tarea.setFechaEstimadaFin(nuevaEstimadaFin);
    }

    /**
     * Cambia el usuario asignado de una tarea.
     * Solo un Administrador puede hacer esto.
     */
    public void cambiarUsuarioAsignado(Usuario actor, String idTarea, Usuario nuevoUsuario) {
        if (!(actor instanceof Administrador)) {
            throw new IllegalArgumentException("Solo un administrador puede cambiar el usuario asignado.");
        }

        Tarea tarea = buscarPorId(idTarea);
        if (tarea == null) {
            throw new IllegalArgumentException("La tarea no existe.");
        }
        if (nuevoUsuario == null) {
            throw new IllegalArgumentException("El nuevo usuario no puede ser null.");
        }

        tarea.setUsuarioAsignado(nuevoUsuario);
    }

    /**
     * Elimina una tarea de la lista.
     * Solo un Administrador puede eliminar tareas.
     */
    public void eliminarTarea(Usuario actor, String idTarea) {
        if (!(actor instanceof Administrador)) {
            throw new IllegalArgumentException("Solo un administrador puede eliminar tareas.");
        }

        int pos = -1;
        for (int i = 0; i < numTareas; i++) {
            if (tareas[i].getId().equals(idTarea)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            throw new IllegalArgumentException("La tarea no existe.");
        }

        // Desplazar elementos para mantener compacto el arreglo.
        for (int i = pos; i < numTareas - 1; i++) {
            tareas[i] = tareas[i + 1];
        }
        tareas[numTareas - 1] = null;
        numTareas--;
    }
}


