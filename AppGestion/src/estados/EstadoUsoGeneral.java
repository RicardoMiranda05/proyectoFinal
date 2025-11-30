package estados;

import java.util.Scanner;

import estados.actualizarTareas.EstadoActualizarTareas;
import menues.MenuClosedException;
import menues.MenuSalida;
import recursos.TipoUsuario;
import singleton.AppComunicador;

/**
 * Menú del usuario genérico, con la opción de cerrar sesión.
 * @author Brayan Montiel Ramírez.
 */
class MenuUsuario extends MenuSalida {
    public static final char IDENTIFICADOR_CERRAR_SESION = MenuSalida.IDENTIFICADOR_SALIDA;
    /* ----- CONSTRUCTOR ----- */
    public MenuUsuario() throws MenuClosedException {
        super("Cerrar sesión");
    }
    /* ----- CONSTRUCTOR ----- */
}
/**
 * Menú del administrador, con todas sus funciones generales.
 * @author Brayan Montiel Ramírez.
 */
class MenuAdministrador extends MenuUsuario {
    /* ----- CONSTRUCTOR ----- */
    public MenuAdministrador() throws MenuClosedException {
        super();
        addOpcion("Agregar usuario nuevo");
        addOpcion("Crear tarea nueva");
        addOpcion("Desplegar tareas");
        addOpcion("Filtrar tareas");
        addOpcion("Actualizar tareas");
        addOpcion("Eliminar tareas");
    }
    /* ----- CONSTRUCTOR ----- */
}
/**
 * Menú del desarrollador, con todas sus funciones generales.
 * @author Brayan Montiel Ramírez.
 */
class MenuDesarrollador extends MenuUsuario {
    /* ----- CONSTRUCTOR ----- */
    public MenuDesarrollador() throws MenuClosedException {
        super();
        addOpcion("Crear tarea para mí");
        addOpcion("Desplegar mis tareas");
        addOpcion("Filtrar tareas por estado");
        addOpcion("Actualizar mis tareas");
    }
    /* ----- CONSTRUCTOR ----- */
}
/**
 * Menú del invitado, con todas sus funciones generales.
 * @author Brayan Montiel Ramírez.
 */
class MenuInvitado extends MenuUsuario {
    /* ----- CONSTRUCTOR ----- */
    public MenuInvitado() throws MenuClosedException {
        super();
        addOpcion("Visualizar tareas");
        addOpcion("Filtrar tareas");
    }
    /* ----- CONSTRUCTOR ----- */
}
/**
 * Estado de uso general de la aplicación (donde se muestran todas las
 * funciones que el usuario ingresado tiene).
 * @author Brayan Montiel Ramírez.
 */
public class EstadoUsoGeneral extends Estado {
    
    public Estado ejecutar(Scanner s) throws Exception {
        MenuUsuario menuUsuario = new MenuUsuario();
        switch (AppComunicador.getInstancia().getUsuarioActual().getTipo()) {
            case TipoUsuario.ADMINISTRADOR:
                menuUsuario = new MenuAdministrador();
                menuUsuario.close();
                MetodosGenerales.solicitaEntrada(s, menuUsuario, "Seleccione la acción que desea realizar");
                /* ----- CAMBIO DE ESTADO ----- */
                switch (menuUsuario.getEleccion().getIdentificador()) {
                    case '1':
                        return new EstadoAgregarUsuario();
                    case '2':
                        return new EstadoCrearTarea();
                    case '3':
                        return new EstadoDesplegarTareas();
                    case '4':
                        return new EstadoFiltrarTareas();
                    case '5':
                        return new EstadoActualizarTareas();
                    case '6':
                        return new EstadoEliminarTareas();
                    case MenuUsuario.IDENTIFICADOR_CERRAR_SESION:
                        return new EstadoCerrarSesion();
                    default:
                        throw new Exception();
                }
            case TipoUsuario.DESARROLLADOR:
                menuUsuario = new MenuDesarrollador();
                menuUsuario.close();
                System.out.println(menuUsuario);
                MetodosGenerales.solicitaEntrada(s, menuUsuario, "Seleccione la acción que desea realizar");
                /* ----- CAMBIO DE ESTADO ----- */
                switch (menuUsuario.getEleccion().getIdentificador()) {
                    case '1':
                        return new EstadoCrearTarea();
                    case '2':
                        return new EstadoDesplegarTareas();
                    case '3':
                        return new EstadoFiltrarTareas();
                    case '4':
                        return new EstadoActualizarTareas();
                    case MenuUsuario.IDENTIFICADOR_CERRAR_SESION:
                        return new EstadoCerrarSesion();
                    default:
                        throw new Exception();
                }
            case TipoUsuario.INVITADO:
                menuUsuario = new MenuInvitado();
                menuUsuario.close();
                System.out.println(menuUsuario);
                MetodosGenerales.solicitaEntrada(s, menuUsuario, "Seleccione la acción que desea realizar");
                /* ----- CAMBIO DE ESTADO ----- */
                switch (menuUsuario.getEleccion().getIdentificador()) {
                    case '1':
                        return new EstadoCrearTarea();
                    case '2':
                        return new EstadoDesplegarTareas();
                    case MenuUsuario.IDENTIFICADOR_CERRAR_SESION:
                        return new EstadoCerrarSesion();
                    default:
                        throw new Exception();
                }
            default:
                throw new Exception();
        }
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoUsoGeneral() {
        super(EstadosApp.USO_GENERAL);
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- UTILERÍA ----- */
    @Override
    public String toString() {
        return "EstadoInicioSesion []";
    }
    /* ----- UTILERÍA ----- */
}