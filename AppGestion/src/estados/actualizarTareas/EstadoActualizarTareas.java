package estados.actualizarTareas;
import java.util.List;
import java.util.Scanner;

import estados.Estado;
import estados.EstadoUsoGeneral;
import estados.EstadosApp;
import estados.MetodosGenerales;
import menues.Menu;
import menues.MenuClosedException;
import menues.MenuDicotomico;
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
    private String idTarea; // ID de la tarea que se actualiza.

    public Estado ejecutar(Scanner s) throws Exception {
        Usuario usuarioActual = AppComunicador.getInstancia().getUsuarioActual();
        ListaTareas listaTareas = AppComunicador.getInstancia().getListaTareas();
        boolean operacionCancelada;
        Estado estadoPrevio = AppComunicador.getInstancia().getEstadoPrevio();
        switch (usuarioActual.getTipo()) {
            case TipoUsuario.ADMINISTRADOR:
                operacionCancelada = false;
                if (idTarea == null) {
                    /* Solicitud del id de la tarea */
                    do {
                        idTarea = solicitarIdTarea(s);
                        if (idTarea != null) {
                            break;
                        }
                        System.out.println("No existe una tarea con el ID ingresado.");
                        operacionCancelada = ! MetodosGenerales.repetirOperacion(s);
                    } while (! operacionCancelada);
                    if (operacionCancelada) {
                        return new EstadoUsoGeneral();
                    }
                }
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
                        String nuevaDescripcion;
                        System.out.println("Ingrese la nueva descripción de su tarea:");
                        nuevaDescripcion = s.nextLine(); //TODO: OPCIONAL excepciones long.
                        listaTareas.actualizarDescripcion(usuarioActual, idTarea, nuevaDescripcion);
                        System.out.println("Su descripción se ha actualizado.");
                        return new EstadoActualizarTareas();
                    case '4':
                        break;
                    case '5':
                        break;
                    case MenuAdministrador.IDENTIFICADOR_REGRESAR:
                        return new EstadoUsoGeneral();
                    default:
                        break;
                }
                operacionCancelada = false;
                do {
                    if (crearTarea(s, usuarioActual, usuarioDestino)) {
                        System.out.println("Tarea creada con éxito.");
                        break;
                    }
                    System.out.println("La tarea no ha sido creada.");
                    operacionCancelada = ! MetodosGenerales.repetirOperacion(s);
                } while (! operacionCancelada);
                
                return new EstadoUsoGeneral();
                System.out.println("Ingrese el id de la tarea que desea modificar");
                String id = s.nextLine(); //TODO: manejo de excepciones
                listaTareas.imprimeTarea(id);
                MenuActualizacionAdmin menuActAdmin = new MenuActualizacionAdmin();
                System.out.println(menuActAdmin);
                System.out.println("¿Qué desea modificar?");
                menuActAdmin.setEleccion(s.nextLine().charAt(0)); //TODO: manejo de excepciones
                switch (menuActAdmin.getEleccion()) {
                    case MenuActualizacionAdmin.OPCION_ESTADO:
                        System.out.println("¿A qué estado pasará la tarea?");
                        EstadoTarea nuevoEstado = getEleccionEstado(s); // TODO: manejo de excepciones
                        listaTareas.cambiarEstado(usuarioActual, id, nuevoEstado); // TODO: manejo de excepciones
                        break;
                    case MenuActualizacionAdmin.OPCION_USUARIO:
                        System.out.println("Ingrese el nickname del usuario al que le será asignada:");
                        String nickname = s.nextLine(); //TODO: manejo de excepciones
                        Usuario nuevoUsuario = getUsuario(nickname); // TODO: manejo de excepciones
                        if (nuevoEstado != null) {
                            System.out.println("La tarea ha sido reasignada a " + nuevoUsuario.getNickname());
                            listaTareas.cambiarUsuarioAsignado(usuarioActual, id, nuevoUsuario);
                        }
                        break;
                    case MenuActualizacionAdmin.OPCION_DESCRIPCION:
                        System.out.println("Ingrese la nueva descripción:");
                        String nuevDescripcion = s.nextLine(); // TODO: manejo de excepciones
                        listaTareas.actualizarDescripcion(usuarioActual, id, nuevDescripcion); // TODO: manejo de excepciones
                        break;
                    case MenuActualizacionAdmin.OPCION_FECHA_INICIO:
                        System.out.println("Ingrese la nueva fecha estimada de inicio:");
                        String nuevaFechaInicio = s.nextLine(); // TODO: manejo de excepciones
                        listaTareas.actualizarFechaEstimadaInicio(nuevoUsuario, id, nuevaFechaInicio);// TODO: manejo de excepciones
                        break;
                    case MenuActualizacionAdmin.OPCION_FECHA_FIN:
                        System.out.println("Ingrese la nueva fecha estimada de inicio:");
                        String nuevaFechaFin = s.nextLine(); // TODO: manejo de excepciones
                        listaTareas.actualizarFechaEstimadaFin(nuevoUsuario, id, nuevaFechaFin);// TODO: manejo de excepciones
                        break;
                }
                break;
            case TipoUsuario.DESARROLLADOR:
                System.out.println("Ingrese el id de la tarea que desea modificar");
                String id_ = s.nextLine(); //TODO: manejo de excepciones de entrada y de DEV accediendo a tareas de otros
                MenuActualizacionDes menuActDes = new MenuActualizacionDes();
                System.out.println(menuActDes);
                System.out.println("¿Qué desea modificar?");
                menuActAdmin.setEleccion(s.nextLine().charAt(0)); //TODO: manejo de excepciones
                switch (menuActAdmin.getEleccion()) {
                    case MenuActualizacionAdmin.OPCION_ESTADO:
                        System.out.println("¿A qué estado pasará la tarea?");
                        EstadoTarea nuevoEstado = getEleccionEstado(s); // TODO: manejo de excepciones
                        listaTareas.cambiarEstado(usuarioActual, id_, nuevoEstado); // TODO: manejo de excepciones
                        break;
                    case MenuActualizacionAdmin.OPCION_DESCRIPCION:
                        System.out.println("Ingrese la nueva descripción:");
                        String nuevDescripcion = s.nextLine(); // TODO: manejo de excepciones
                        listaTareas.actualizarDescripcion(usuarioActual, id_, nuevDescripcion); // TODO: manejo de excepciones
                        break;
                    case MenuActualizacionAdmin.OPCION_FECHA_INICIO:
                        System.out.println("Ingrese la nueva fecha estimada de inicio:");
                        String nuevaFechaInicio = s.nextLine(); // TODO: manejo de excepciones
                        listaTareas.actualizarFechaEstimadaInicio(usuarioActual, id_, nuevaFechaInicio);// TODO: manejo de excepciones
                        break;
                    case MenuActualizacionAdmin.OPCION_FECHA_FIN:
                        System.out.println("Ingrese la nueva fecha estimada de inicio:");
                        String nuevaFechaFin = s.nextLine(); // TODO: manejo de excepciones
                        listaTareas.actualizarFechaEstimadaFin(usuarioActual, id_, nuevaFechaFin);// TODO: manejo de excepciones
                        break;
                }
                // TODO: Modificar estado de sus tareas.
                // TODO: Modificar descripción de sus tareas.
                // TODO: Modificar fecha estimada de inicio de sus tareas.
                // TODO: Modificar fecha estimada de fin de sus tareas.
                break;
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
