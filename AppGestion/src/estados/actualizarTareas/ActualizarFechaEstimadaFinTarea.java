package estados.actualizarTareas;

import java.time.LocalDate;
import java.util.Scanner;

import estados.Estado;
import estados.EstadosApp;
import estados.MetodosGenerales;
import singleton.AppComunicador;
import tareas.ListaTareas;
import tareas.Tarea;
import usuarios.Usuario;

public class ActualizarFechaEstimadaFinTarea extends EstadoActualizarTareas {
    @Override
    public Estado ejecutar(Scanner s) throws Exception {
        Usuario usuarioActual = AppComunicador.getInstancia().getUsuarioActual();
        ListaTareas listaTareas = AppComunicador.getInstancia().getListaTareas();
        Tarea tareaActualizada = listaTareas.buscarPorId(getIdTarea());
        LocalDate fechaEstimadaFin;
        
        System.out.println("Ingrese la nueva fecha estimada de finalización de su tarea:");
        s.nextLine();
        fechaEstimadaFin = MetodosGenerales.solicitaFechaDespues(s,
                                                                    "Fecha estimada de finalización (DD/MM/AAAA):",
                                                                    tareaActualizada.getFechaEstimadaInicio(), 
                                                                    "La fecha estimada de finalización no puede ser anterior a la de inicio.");
        listaTareas.actualizarFechasEstimadas(usuarioActual, getIdTarea(), tareaActualizada.getFechaEstimadaInicio(), fechaEstimadaFin);
        System.out.println("Se ha reestablecido la fecha estimada de finalización correctamente.");

        return new EstadoActualizarTareas(getIdTarea());
    }
    /* ----- CONSTRUCTOR ----- */
    public ActualizarFechaEstimadaFinTarea(String idTarea) {
        super(EstadosApp.ACTUALIZAR_DESCRIPCION_TAREA, idTarea);
    }
}
