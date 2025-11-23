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
import java.time.LocalDate;
import java.util.UUID;

/**
 * Representa una tarea dentro del sistema To-Do List.
 * Cada tarea pertenece a un Usuario y tiene un estado y fechas asociadas.
 */
public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;

    // ID único de la tarea, generado con UUID.
    private final String id;

    // Estado actual de la tarea.
    private EstadoTarea estado;

    // Usuario al que pertenece la tarea.
    private Usuario usuarioAsignado;

    // Descripción de la tarea.
    private String descripcion;

    // Fechas requeridas por el enunciado.
    private LocalDate fechaEstimadaInicio;
    private LocalDate fechaInicio;        // Se fija al pasar a EN_CURSO.
    private LocalDate fechaEstimadaFin;
    private LocalDate fechaFin;           // Se fija al pasar a COMPLETADA.

    /**
     * Crea una nueva tarea en estado PENDIENTE.
     *
     * @param usuarioAsignado     Usuario al que se le asigna la tarea.
     * @param descripcion         Descripción de la tarea.
     * @param fechaEstimadaInicio Fecha estimada de inicio.
     * @param fechaEstimadaFin    Fecha estimada de finalización.
     */
    public Tarea(Usuario usuarioAsignado,
                 String descripcion,
                 LocalDate fechaEstimadaInicio,
                 LocalDate fechaEstimadaFin) {

        this.id = UUID.randomUUID().toString(); // ID único tipo String
        this.usuarioAsignado = usuarioAsignado;
        this.descripcion = descripcion;
        this.fechaEstimadaInicio = fechaEstimadaInicio;
        this.fechaEstimadaFin = fechaEstimadaFin;
        this.estado = EstadoTarea.PENDIENTE;   // Regla: siempre inicia como PENDIENTE
    }

    // ---------- GETTERS (no hay setter para id, es inmutable) ----------

    public String getId() {
        return id;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    /**
     * Se deja público, pero la lógica del flujo de estados
     * (PENDIENTE -> EN_CURSO -> COMPLETADA) se controla en ListaTareas.
     */
    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    public Usuario getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(Usuario usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaEstimadaInicio() {
        return fechaEstimadaInicio;
    }

    public void setFechaEstimadaInicio(LocalDate fechaEstimadaInicio) {
        this.fechaEstimadaInicio = fechaEstimadaInicio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaEstimadaFin() {
        return fechaEstimadaFin;
    }

    public void setFechaEstimadaFin(LocalDate fechaEstimadaFin) {
        this.fechaEstimadaFin = fechaEstimadaFin;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        String nombreUsuario = (usuarioAsignado != null) ? usuarioAsignado.getNombre() : "Sin asignar";
        String idUsuario = (usuarioAsignado != null) ? usuarioAsignado.getId() : "N/A";

        return "Tarea ID: " + id +
               "\n  Estado: " + estado +
               "\n  Usuario asignado: " + nombreUsuario + " (ID " + idUsuario + ")" +
               "\n  Descripción: " + descripcion +
               "\n  Fecha estimada inicio: " + fechaEstimadaInicio +
               "\n  Fecha inicio: " + fechaInicio +
               "\n  Fecha estimada fin: " + fechaEstimadaFin +
               "\n  Fecha fin: " + fechaFin;
    }
}
