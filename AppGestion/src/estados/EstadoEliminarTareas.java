package estados;

import java.util.Scanner;

import menues.MenuConfirmacion;
import recursos.TipoUsuario;
import singleton.AppComunicador;
import tareas.ListaTareas;
import tareas.Tarea;
import usuarios.Usuario;

/**
 * Estado que representa la opción de eliminar tareas.
 * Solo los usuarios de tipo ADMINISTRADOR pueden eliminar tareas.
 */
public class EstadoEliminarTareas extends Estado {

    @Override
    public Estado ejecutar(Scanner s) throws Exception {
        if (eliminarTarea(s)) {
            System.out.println("La tarea ha sido eliminada con éxito.");
            return new EstadoUsoGeneral();
        } else if (!MetodosGenerales.repetirOperacion(s)) {
            // Si el usuario no quiere volver a intentar, regresamos al menú general
            return new EstadoUsoGeneral();
        }
        // Si quiere volver a intentar, repetimos este mismo estado
        return new EstadoEliminarTareas();
    }

    /**
     * Lógica para eliminar una tarea:
     *  1. Verifica que el usuario actual sea ADMINISTRADOR.
     *  2. Solicita el ID de la tarea.
     *  3. Busca la tarea en la lista.
     *  4. Muestra los datos de la tarea.
     *  5. Pide confirmación antes de eliminar.
     *  6. Llama a ListaTareas.eliminarTarea().
     *
     * @param s Scanner con el que se comunica el usuario.
     * @return true si la tarea se eliminó, false si no.
     */
    private boolean eliminarTarea(Scanner s) throws Exception {
        AppComunicador app = AppComunicador.getInstancia();
        Usuario usuarioActual = app.getUsuarioActual();
        ListaTareas listaTareas = app.getListaTareas();

        // 1. Verificar que el usuario sea administrador
        if (usuarioActual.getTipo() != TipoUsuario.ADMINISTRADOR) {
            System.out.println("Solo un administrador puede eliminar tareas.");
            return false;
        }

        // 2. Solicitar ID de la tarea
        System.out.print("Ingrese el ID de la tarea que desea eliminar: ");
        String idTarea = s.next();  // Se usa next() igual que en otros estados

        // 3. Buscar la tarea
        Tarea tarea = listaTareas.buscarPorId(idTarea);
        if (tarea == null) {
            System.out.println("No existe una tarea con el ID proporcionado.");
            return false;
        }

        // 4. Mostrar la tarea encontrada
        System.out.println("=== Tarea seleccionada ===");
        System.out.println(tarea);
        System.out.println("==========================");

        // 5. Pedir confirmación
        MenuConfirmacion menuConfirmacion = new MenuConfirmacion();
        menuConfirmacion.close();
        MetodosGenerales.solicitaEntrada(s, menuConfirmacion,
                                         "¿Desea eliminar esta tarea?");
        
        if (menuConfirmacion.getEleccion().getIdentificador()
                == MenuConfirmacion.IDENTIFICADOR_CONFIRMAR) {
            // 6. Intentar eliminar
            try {
                listaTareas.eliminarTarea(usuarioActual, idTarea);
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error al eliminar la tarea: " + e.getMessage());
                return false;
            }
        } else {
            System.out.println("La operación de eliminación fue cancelada.");
            return false;
        }
    }

    /* ----- CONSTRUCTOR ----- */
    public EstadoEliminarTareas() {
        super(EstadosApp.ELIMINAR_TAREAS);
    }
    /* ----- CONSTRUCTOR ----- */
}
