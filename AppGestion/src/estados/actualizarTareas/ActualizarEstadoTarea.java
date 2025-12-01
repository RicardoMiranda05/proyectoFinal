package estados.actualizarTareas;

import java.util.Scanner;

import estados.Estado;
import estados.EstadosApp;
import estados.MetodosGenerales;
import menues.MenuDicotomico;
import recursos.EstadoTarea;
import singleton.AppComunicador;
import tareas.ListaTareas;
import tareas.Tarea;
import usuarios.Usuario;

public class ActualizarEstadoTarea extends EstadoActualizarTareas {
    @Override
    public Estado ejecutar(Scanner s) throws Exception {
        Usuario usuarioActual = AppComunicador.getInstancia().getUsuarioActual();
        ListaTareas listaTareas = AppComunicador.getInstancia().getListaTareas();
        Tarea tarea = listaTareas.buscarPorId(getIdTarea());
        MenuDicotomico menuDicotomico = new MenuDicotomico();
        menuDicotomico.close();
        
        switch (tarea.getEstado()) {
            case EstadoTarea.PENDIENTE:
                MetodosGenerales.solicitaEntrada(s, menuDicotomico, "Su tarea se encuentra en estado PENDIENTE." +
                                    "¿Desea pasarlo a EN CURSO?");
                if (menuDicotomico.getEleccion().getIdentificador() == MenuDicotomico.IDENTIFICADOR_SI) {
                    System.out.println("Estado de la tarea actualizado a EN CURSO.");
                    listaTareas.cambiarEstado(usuarioActual, getIdTarea(), EstadoTarea.EN_CURSO);
                } else {
                    System.out.println("Estado de la tarea NO actualizado. Permanece en PENDIENTE.");
                }
                break;
            case EstadoTarea.EN_CURSO:
                MetodosGenerales.solicitaEntrada(s, menuDicotomico, "Su tarea se encuentra en estado EN CURSO." +
                                    "¿Desea pasarlo a COMPLETADA?");
                if (menuDicotomico.getEleccion().getIdentificador() == MenuDicotomico.IDENTIFICADOR_SI) {
                    System.out.println("Estado de la tarea actualizado a COMPLETADA.");
                    listaTareas.cambiarEstado(usuarioActual, getIdTarea(), EstadoTarea.COMPLETADA);
                } else {
                    System.out.println("Estado de la tarea NO actualizado. Permanece en EN CURSO.");
                }
                break;
            case EstadoTarea.COMPLETADA:
                System.out.println("Su tarea se encuentra en estado COMPLETADA." +
                                    " Ya no puede modificarse."
                );
                break;
            default:
                throw new Exception("Estado de la tarea no identificado.");
        }
        return new EstadoActualizarTareas(getIdTarea());
    }
    public ActualizarEstadoTarea(String idTarea) {
        super(EstadosApp.ACTUALIZAR_ESTADO_TAREA, idTarea);
    }
}
