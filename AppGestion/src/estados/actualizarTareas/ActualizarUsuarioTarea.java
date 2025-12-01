package estados.actualizarTareas;

import java.util.Scanner;

import estados.Estado;
import estados.EstadosApp;
import estados.MetodosGenerales;
import singleton.AppComunicador;
import tareas.ListaTareas;
import usuarios.Usuario;

public class ActualizarUsuarioTarea extends EstadoActualizarTareas {
    @Override
    public Estado ejecutar(Scanner s) throws Exception {
        Usuario usuarioActual = AppComunicador.getInstancia().getUsuarioActual();
        Usuario reemplazo;
        ListaTareas listaTareas = AppComunicador.getInstancia().getListaTareas();
        boolean operacionCancelada = false;
        /* Solicitud del usuario reemplazo */
        do {
            reemplazo = solicitarUsuario(s, "Ingrese el nickname del usuario a quien se le asignará esta tarea o el suyo si será para usted: ");
            if (reemplazo != null) {
                break;
            }
            System.out.println("No existe un usuario con el nickname ingresado.");
            operacionCancelada = ! MetodosGenerales.repetirOperacion(s);
        } while (! operacionCancelada);
        if (operacionCancelada) {
            return new EstadoActualizarTareas(getIdTarea());
        }
        listaTareas.cambiarUsuarioAsignado(usuarioActual, getIdTarea(), reemplazo);
        System.out.println("Se le ha reasignado esta tarea a " + reemplazo.getNickname() + ".");
        return new EstadoActualizarTareas(getIdTarea());
    }
    /**
     * Solicita el nickname de un usuario.
     * @param s : Método de comunicación con el usuario que usa la App.
     * @param mensaje : Instrucción que se imprime en consola.
     * @return : El usuario destino si existe dentro de la lista de usuarios o {@code null} si no.
     */
    private Usuario solicitarUsuario(Scanner s, String mensaje) {
        Usuario usuarioDestino;
        System.out.println(mensaje);
        System.out.print("Nombre de usuario: ");
        s.nextLine();
        String nickname = s.nextLine(); // TODO: OPCIONAL manejo de excepciones long.
        usuarioDestino = AppComunicador.getInstancia().getUsuario(nickname);
        return usuarioDestino;
    }

    public ActualizarUsuarioTarea(String idTarea) {
        super(EstadosApp.ACTUALIZAR_USUARIO_TAREA, idTarea);
    }
}
