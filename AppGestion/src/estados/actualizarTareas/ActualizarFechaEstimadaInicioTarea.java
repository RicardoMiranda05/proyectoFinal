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

public class ActualizarFechaEstimadaInicioTarea extends EstadoActualizarTareas {
    @Override
    public Estado ejecutar(Scanner s) throws Exception {
        Usuario usuarioActual = AppComunicador.getInstancia().getUsuarioActual();
        ListaTareas listaTareas = AppComunicador.getInstancia().getListaTareas();
        Tarea tareaActualizada = listaTareas.buscarPorId(getIdTarea());
        LocalDate fechaEstimadaInicio;
        LocalDate hoy = LocalDate.now();
        
        System.out.println("Ingrese la nueva fecha estimada de inicio de su tarea:");
        s.nextLine();
        fechaEstimadaInicio = MetodosGenerales.solicitaFechaDespues(s,
                                                                    "Fecha estimada de inicio (DD/MM/AAAA):",
                                                                    hoy, 
                                                                    "La fecha estimada de inicio no puede ser anterior a hoy.");
        if (fechaEstimadaInicio.isAfter(tareaActualizada.getFechaEstimadaFin())) {
            System.out.println("No puede establecer la fecha estimada de inicio posterior a la fecha estimada de finalización." + 
                                "Primero reestablezca la fecha estimada de finalización."
            );
            return new EstadoActualizarTareas(getIdTarea());
        }
        listaTareas.actualizarFechasEstimadas(usuarioActual, getIdTarea(), fechaEstimadaInicio, tareaActualizada.getFechaEstimadaFin());
        System.out.println("Se ha reestablecido la fecha estimada de inicio correctamente.");

        return new EstadoActualizarTareas(getIdTarea());
    }
    /* ----- CONSTRUCTOR ----- */
    public ActualizarFechaEstimadaInicioTarea(String idTarea) {
        super(EstadosApp.ACTUALIZAR_DESCRIPCION_TAREA, idTarea);
    }
}
