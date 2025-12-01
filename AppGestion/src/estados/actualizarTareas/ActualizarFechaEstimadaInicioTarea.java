package estados.actualizarTareas;

import java.time.LocalDate;
import java.util.Scanner;

import estados.Estado;
import estados.EstadosApp;
import estados.MetodosGenerales;
import singleton.AppComunicador;
import tareas.ListaTareas;
import usuarios.Usuario;

public class ActualizarFechaEstimadaInicioTarea {
    @Override
    public Estado ejecutar(Scanner s) throws Exception {
        Usuario usuarioActual = AppComunicador.getInstancia().getUsuarioActual();
        ListaTareas listaTareas = AppComunicador.getInstancia().getListaTareas();
        LocalDate fechaEstimadaInicio;
        
        System.out.println("Ingrese la nueva fecha estimada de inicio de su tarea (DD/MM/AAAA):");
        fechaEstimadaInicio = MetodosGenerales.leerFecha(s);
        
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
