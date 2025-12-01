package estados.actualizarTareas;

import java.util.Scanner;

import estados.Estado;
import estados.EstadosApp;
import singleton.AppComunicador;
import tareas.ListaTareas;
import usuarios.Usuario;

public class ActualizarDescripcionTarea extends EstadoActualizarTareas {
    @Override
    public Estado ejecutar(Scanner s) throws Exception {
        Usuario usuarioActual = AppComunicador.getInstancia().getUsuarioActual();
        ListaTareas listaTareas = AppComunicador.getInstancia().getListaTareas();
        String nuevaDescripcion;

        System.out.println("Ingrese la nueva descripción de su tarea:");
        s.nextLine();
        nuevaDescripcion = s.nextLine(); //TODO: OPCIONAL excepciones long.
        listaTareas.actualizarDescripcion(usuarioActual, getIdTarea(), nuevaDescripcion);
        System.out.println("Su descripción se ha actualizado.");

        return new EstadoActualizarTareas(getIdTarea());
    }
    /* ----- CONSTRUCTOR ----- */
    public ActualizarDescripcionTarea(String idTarea) {
        super(EstadosApp.ACTUALIZAR_DESCRIPCION_TAREA, idTarea);
    }
}
