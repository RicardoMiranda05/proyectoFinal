package estados.actualizarTareas;
import java.util.Scanner;

import estados.Estado;
import estados.EstadoUsoGeneral;
import estados.EstadosApp;
import estados.MetodosGenerales;
import menues.MenuClosedException;
import menues.MenuSalida;
import recursos.EstadoTarea;
import recursos.TipoUsuario;
import singleton.AppComunicador;
import tareas.ListaTareas;
import tareas.Tarea;
import usuarios.Usuario;

class MenuAdministrador extends MenuSalida {
    public static final char IDENTIFICADOR_REGRESAR = IDENTIFICADOR_SALIDA;
    /* ----- CONSTRUCTOR ----- */
    public MenuAdministrador() throws MenuClosedException {
        super("Regresar");
        addOpcion("Estado");
        addOpcion("Usuario al que le pertenece");
        addOpcion("Descripción");
        addOpcion("Fecha estimada de inicio");
        addOpcion("Fecha estimada de fin");
    }
    /* ----- CONSTRUCTOR ----- */
}
class MenuDesarrollador extends MenuSalida {
    public static final char IDENTIFICADOR_REGRESAR = IDENTIFICADOR_SALIDA;
    /* ----- CONSTRUCTOR ----- */
    public MenuDesarrollador() throws MenuClosedException {
        super("Regresar");
        addOpcion("Estado");
        addOpcion("Descripción");
        addOpcion("Fecha estimada de inicio");
        addOpcion("Fecha estimada de fin");
    }
    /* ----- CONSTRUCTOR ----- */
}
/**
 * @author Brayan Montiel Ramírez
 */
public class EstadoActualizarTareas extends Estado {
    private String idTarea = null; // ID de la tarea que se actualiza.

    public Estado ejecutar(Scanner s) throws Exception {
        Usuario usuarioActual = AppComunicador.getInstancia().getUsuarioActual();
        ListaTareas listaTareas = AppComunicador.getInstancia().getListaTareas();
        Tarea tareaActualizada;
        boolean operacionCancelada = false;
        if (idTarea == null) {
            /* Solicitud del id de la tarea */
            do {
                idTarea = solicitarIdTarea(s);
                if (idTarea != null) {
                    tareaActualizada = listaTareas.buscarPorId(idTarea);
                    if (usuarioActual.getTipo() == TipoUsuario.DESARROLLADOR
                        && ! tareaActualizada.getUsuarioAsignado().getId().equals(usuarioActual.getId())) {
                            System.out.println("Esta tarea no es de su propiedad. " +
                                                "Por favor, ingrese una que le pertenezca."
                            );
                            return new EstadoActualizarTareas();
                        }
                    break;
                }
                System.out.println("No existe una tarea con el ID ingresado.");
                operacionCancelada = ! MetodosGenerales.repetirOperacion(s);
            } while (! operacionCancelada);
            if (operacionCancelada) {
                return new EstadoUsoGeneral();
            }
        }
        /* Validación de su estado */
        tareaActualizada = listaTareas.buscarPorId(idTarea);
        if (tareaActualizada.getEstado() == EstadoTarea.COMPLETADA) {
            System.out.println("La tarea se encuentra en estado COMPLETADA, por lo cual ya no puede actualizarse.");
            return new EstadoActualizarTareas();
        }
        switch (usuarioActual.getTipo()) {
            case TipoUsuario.ADMINISTRADOR:
                /* Actualización de la tarea */
                MenuAdministrador menuAdmin = new MenuAdministrador();
                menuAdmin.close();
                MetodosGenerales.solicitaEntrada(s, menuAdmin, "¿Qué desea modificar?");
                switch (menuAdmin.getEleccion().getIdentificador()) {
                    case '1':
                        return new ActualizarEstadoTarea(idTarea);
                    case '2':
                        return new ActualizarUsuarioTarea(idTarea);
                    case '3':
                        return new ActualizarDescripcionTarea(idTarea);
                    case '4':
                        if (tareaActualizada.getEstado() == EstadoTarea.EN_CURSO) {
                            System.out.println("La tarea se encuentra EN CURSO, por lo cual ya no puede " +
                                                "modificar su fecha estimada de inicio.");
                            return new EstadoActualizarTareas(idTarea);
                        }
                        return new ActualizarFechaEstimadaInicioTarea(idTarea);
                    case '5':
                        if (tareaActualizada.getEstado() == EstadoTarea.EN_CURSO) {
                            System.out.println("La tarea se encuentra EN CURSO, por lo cual ya no puede " +
                                                "modificar su fecha estimada de finalización.");
                            return new EstadoActualizarTareas(idTarea);
                        }
                        return new ActualizarFechaEstimadaFinTarea(idTarea);
                    case MenuAdministrador.IDENTIFICADOR_REGRESAR:
                        return new EstadoUsoGeneral();
                    default:
                        throw new Exception("Elección no identificada.");
                }
            case TipoUsuario.DESARROLLADOR:
                /* Actualización de la tarea */
                MenuDesarrollador menuDes = new MenuDesarrollador();
                menuDes.close();
                MetodosGenerales.solicitaEntrada(s, menuDes, "¿Qué desea modificar?");
                switch (menuDes.getEleccion().getIdentificador()) {
                    case '1':
                        return new ActualizarEstadoTarea(idTarea);
                    case '2':
                        return new ActualizarDescripcionTarea(idTarea);
                    case '3':
                        if (tareaActualizada.getEstado().equals(EstadoTarea.EN_CURSO)) {
                            System.out.println("Su tarea se encuentra EN CURSO, por lo cual ya no puede " +
                                                "modificar su fecha estimada de inicio.");
                            return new EstadoActualizarTareas(idTarea);
                        }
                        return new ActualizarFechaEstimadaInicioTarea(idTarea);
                    case '4':
                        if (tareaActualizada.getEstado().equals(EstadoTarea.EN_CURSO)) {
                            System.out.println("Su tarea se encuentra EN CURSO, por lo cual ya no puede " +
                                                "modificar su fecha estimada de inicio.");
                            return new EstadoActualizarTareas(idTarea);
                        }
                        return new ActualizarFechaEstimadaFinTarea(idTarea);
                    case MenuAdministrador.IDENTIFICADOR_REGRESAR:
                        return new EstadoUsoGeneral();
                    default:
                        throw new Exception("Elección no identificada.");
                }
            
            case TipoUsuario.INVITADO:
                throw new Exception("Un invitado no debe tener acceso a esta opción.");
            default:
                throw new Exception("El usuario salió dentro de los tipos existentes.");
        }
    }
    
    /**
     * Solicita el ide de la tarea que se actualizará.
     * @param s : Método de comunicación con el usuario que usa la App.
     * @return : El ID de la tarea que se actualizará si existe dentro de la lista de tareas o 
     * {@code null} si no existe.
     */
    private String solicitarIdTarea(Scanner s) {
        ListaTareas listaTareas = AppComunicador.getInstancia().getListaTareas();
        System.out.println("Ingrese el ID de la tarea que quiere actualizar: ");
        System.out.print("ID: ");
        s.nextLine();
        String idTarea = s.nextLine(); // TODO: OPCIONAL manejo de excepciones long.
        if (listaTareas.buscarPorId(idTarea) == null) {
            return null;
        }
        return idTarea;
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoActualizarTareas() {
        super(EstadosApp.ACTUALIZAR_TAREAS);
    }
    /**
     * Constructor para subestados.
     * @param referencia : Referencia del estado en {@link EstadosApp}.
     * @param idTarea : ID de la tarea que se está actualizando.
     */
    protected EstadoActualizarTareas(EstadosApp referencia, String idTarea) {
        super(referencia);
        this.idTarea = idTarea;
    }
    /**
     * Constructor para subestados almacenamiento de ID.
     * @param idTarea : ID de la tarea que se está actualizando.
     */
    protected EstadoActualizarTareas(String idTarea) {
        super(EstadosApp.ACTUALIZAR_TAREAS);
        this.idTarea = idTarea;
    }
    /* ----- ACCESO ----- */
    protected String getIdTarea() {
        return idTarea;
    }
    protected void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
    }
    
}
