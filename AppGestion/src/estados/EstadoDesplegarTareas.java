package estados;

import java.util.Scanner;

import recursos.TipoUsuario;
import singleton.AppComunicador;
import tareas.ListaTareas;
import usuarios.Usuario;

public class EstadoDesplegarTareas extends Estado {

    @Override
    public Estado ejecutar(Scanner s) throws Exception {
        Usuario usuarioActual = AppComunicador.getInstancia().getUsuarioActual();
        ListaTareas listaTareas = AppComunicador.getInstancia().getListaTareas();

        // Si por alguna razón la lista está nula o vacía, avisamos y regresamos al menú general
        if (listaTareas == null || listaTareas.getNumTareas() == 0) {
            System.out.println("Por el momento no hay tareas registradas en el sistema.");
            return new EstadoUsoGeneral();
        }

        switch (usuarioActual.getTipo()) {
            case ADMINISTRADOR:
                System.out.println("=== Todas las tareas del sistema ===");
                listaTareas.listarTodas();
                break;

            case DESARROLLADOR:
                System.out.println("=== Tus tareas ===");
                listaTareas.listarPorUsuario(usuarioActual);
                break;

            case INVITADO:
                System.out.println("=== Tareas visibles para invitados ===");
                listaTareas.listarTodas();
                break;

            default:
                throw new Exception("Tipo de usuario no reconocido al desplegar tareas.");
        }

        // Después de mostrar las tareas, siempre regresamos al menú de uso general
        return new EstadoUsoGeneral();
    }

    /* ----- CONSTRUCTOR ----- */
    public EstadoDesplegarTareas() {
        super(EstadosApp.DESPLEGAR_TAREAS);
    }
    /* ----- CONSTRUCTOR ----- */
}
