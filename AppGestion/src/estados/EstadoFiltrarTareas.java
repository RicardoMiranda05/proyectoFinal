package estados;

import java.util.Scanner;

import estados.Estado;
import estados.EstadosApp;
import estados.MetodosGenerales;
import menues.MenuClosedException;
import menues.MenuSalida;
import recursos.EstadoTarea;
import recursos.TipoUsuario;
import singleton.AppComunicador;
import tareas.ListaTareas;
import usuarios.Usuario;

/**
 * Menú de filtrado para ADMINISTRADOR:
 * - Filtrar por estado
 * - Filtrar por usuario
 */
class MenuFiltroAdmin extends MenuSalida {
    public static final char IDENTIFICADOR_REGRESAR = IDENTIFICADOR_SALIDA;

    public MenuFiltroAdmin() throws MenuClosedException {
        super("Regresar");
        addOpcion("Filtrar por estado");
        addOpcion("Filtrar por usuario");
    }
}

/**
 * Menú para elegir un estado de tarea.
 * Opciones:
 * 1) PENDIENTE
 * 2) EN_CURSO
 * 3) COMPLETADA
 * s) Regresar
 */
class MenuEstadoTarea extends MenuSalida {
    public static final char IDENTIFICADOR_REGRESAR = IDENTIFICADOR_SALIDA;

    public MenuEstadoTarea() throws MenuClosedException {
        super("Regresar");
        addOpcion("Pendientes");
        addOpcion("En curso");
        addOpcion("Completadas");
    }
}

/**
 * Estado que representa la opción de filtrar tareas.
 * - ADMINISTRADOR: puede filtrar por estado o por usuario.
 * - DESARROLLADOR: filtra tareas por estado.
 * - INVITADO: filtra tareas por estado.
 */
public class EstadoFiltrarTareas extends Estado {

    @Override
    public Estado ejecutar(Scanner s) throws Exception {
        AppComunicador app = AppComunicador.getInstancia();
        Usuario usuarioActual = app.getUsuarioActual();
        ListaTareas listaTareas = app.getListaTareas();

        switch (usuarioActual.getTipo()) {

            case TipoUsuario.ADMINISTRADOR:
                return ejecutarFiltroAdmin(s, listaTareas);

            case TipoUsuario.DESARROLLADOR:
                return ejecutarFiltroPorEstadoGenerico(s, listaTareas);

            case TipoUsuario.INVITADO:
                return ejecutarFiltroPorEstadoGenerico(s, listaTareas);

            default:
                throw new Exception("Tipo de usuario no identificado en EstadoFiltrarTareas.");
        }
    }

    /**
     * ADMINISTRADOR:
     * - Menú: filtrar por estado / filtrar por usuario / regresar.
     */
    private Estado ejecutarFiltroAdmin(Scanner s, ListaTareas listaTareas) throws Exception {
        MenuFiltroAdmin menuAdmin = new MenuFiltroAdmin();
        menuAdmin.close();
        MetodosGenerales.solicitaEntrada(s, menuAdmin, "¿Cómo desea filtrar las tareas?");

        switch (menuAdmin.getEleccion().getIdentificador()) {
            case '1': { // Filtrar por estado
                EstadoTarea estado = solicitarEstadoTarea(s);
                if (estado == null) {
                    // Usuario decidió regresar
                    return new EstadoUsoGeneral();
                }
                listaTareas.listarPorEstado(estado);
                break;
            }
            case '2': { // Filtrar por usuario
                Usuario usuarioDestino = solicitarUsuarioPorNickname(s);
                if (usuarioDestino == null) {
                    System.out.println("No existe un usuario con el nickname ingresado.");
                    return new EstadoUsoGeneral();
                }
                listaTareas.listarPorUsuario(usuarioDestino);
                break;
            }
            case MenuFiltroAdmin.IDENTIFICADOR_REGRESAR:
                return new EstadoUsoGeneral();

            default:
                throw new Exception("Elección no identificada en MenuFiltroAdmin.");
        }

        // Después de mostrar resultados, regresamos al menú general
        return new EstadoUsoGeneral();
    }

    /**
     * Lógica de filtrado por estado usada por DESARROLLADOR e INVITADO.
     * - Muestra menú de estados.
     * - Lista por estado.
     */
    private Estado ejecutarFiltroPorEstadoGenerico(Scanner s, ListaTareas listaTareas) throws Exception {
        EstadoTarea estado = solicitarEstadoTarea(s);
        if (estado == null) {
            return new EstadoUsoGeneral();
        }
        listaTareas.listarPorEstado(estado);
        return new EstadoUsoGeneral();
    }

    /**
     * Muestra un menú de estados y devuelve el EstadoTarea elegido, o null si el usuario decide regresar.
     */
    private EstadoTarea solicitarEstadoTarea(Scanner s) throws Exception {
        MenuEstadoTarea menuEstado = new MenuEstadoTarea();
        menuEstado.close();
        MetodosGenerales.solicitaEntrada(s, menuEstado, "Seleccione el estado por el que desea filtrar:");

        switch (menuEstado.getEleccion().getIdentificador()) {
            case '1':
                return EstadoTarea.PENDIENTE;
            case '2':
                return EstadoTarea.EN_CURSO;
            case '3':
                return EstadoTarea.COMPLETADA;
            case MenuEstadoTarea.IDENTIFICADOR_REGRESAR:
                return null;
            default:
                throw new Exception("Elección no identificada en MenuEstadoTarea.");
        }
    }

    /**
     * Pide un nickname y devuelve el Usuario correspondiente, o null si no existe.
     */
    private Usuario solicitarUsuarioPorNickname(Scanner s) {
        System.out.println("Ingrese el nickname del usuario por el que desea filtrar:");
        System.out.print("Nombre de usuario: ");
        s.nextLine();
        String nickname = s.nextLine(); 
        return AppComunicador.getInstancia().getUsuario(nickname);
    }

    /* ----- CONSTRUCTOR ----- */
    public EstadoFiltrarTareas() {
        super(EstadosApp.FILTRAR_TAREAS);
    }
    /* ----- CONSTRUCTOR ----- */
}
