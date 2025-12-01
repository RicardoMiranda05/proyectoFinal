package estados;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import recursos.TipoUsuario;
import singleton.AppComunicador;
import tareas.ListaTareas;
import tareas.Tarea;
import usuarios.Usuario;
/**
 * Estado para que el usuario cree una tarea.
 * @author Brayan Montiel Ramírez
 */
public class EstadoCrearTarea extends Estado {

    public Estado ejecutar(Scanner s) throws Exception {
        Usuario usuarioActual = AppComunicador.getInstancia().getUsuarioActual();
        Usuario usuarioDestino;
        boolean operacionCancelada;
        switch (usuarioActual.getTipo()) {
            case TipoUsuario.ADMINISTRADOR:
                operacionCancelada = false;
                /* Solicitud del usuario destino */
                do {
                    usuarioDestino = solicitarUsuarioDestino(s);
                    if (usuarioDestino != null) {
                        break;
                    }
                    System.out.println("No existe un usuario con el nickname ingresado.");
                    operacionCancelada = ! MetodosGenerales.repetirOperacion(s);
                } while (! operacionCancelada);
                if (operacionCancelada) {
                    return new EstadoUsoGeneral();
                }
                /* Creación de la tarea */
                operacionCancelada = false;
                do {
                    if (crearTarea(s, usuarioActual, usuarioDestino)) {
                        System.out.println("Tarea creada con éxito.");
                        break;
                    }
                    System.out.println("La tarea no ha sido creada.");
                    operacionCancelada = ! MetodosGenerales.repetirOperacion(s);
                } while (! operacionCancelada);
                
                return new EstadoUsoGeneral();

            case TipoUsuario.DESARROLLADOR:
                usuarioDestino = usuarioActual;
                /* Creación de la tarea */
                operacionCancelada = false;
                do {
                    if (crearTarea(s, usuarioActual, usuarioDestino)) {
                    System.out.println("Tarea creada con éxito.");
                    break;
                    }
                    System.out.println("La tarea no ha sido creada.");
                    operacionCancelada = ! MetodosGenerales.repetirOperacion(s);
                } while (! operacionCancelada);

                return new EstadoUsoGeneral();
            case TipoUsuario.INVITADO:
                throw new Exception("Un invitado no debe tener acceso a esta opción.");
            default:
                throw new Exception("El usuario salió dentro de los tipos existentes.");
        }
    }
    /**
     * Solicita el usuario al que se le asignará la tarea.
     * @param s : Método de comunicación con el usuario que usa la App.
     * @return : El usuario destino si existe dentro de la lista de usuarios o {@code null} si no.
     */
    private Usuario solicitarUsuarioDestino(Scanner s) {
        Usuario usuarioDestino;
        System.out.println("Ingrese el nickname del usuario a quien se le asignará esta tarea o el suyo si será para usted: ");
        System.out.print("Nombre de usuario: ");
        s.nextLine();
        String nickname = s.nextLine(); // TODO: OPCIONAL manejo de excepciones long.
        usuarioDestino = AppComunicador.getInstancia().getUsuario(nickname);
        return usuarioDestino;
    }
    /**
     * Crea una tarea para un usuario igual o diferente a quien la está creando.
     * Sólo es accesible por un usuario de tipo Administrador.
     * @param s
     * @param nickname
     * @return
     */
    private boolean crearTarea(Scanner s, Usuario usuarioActual, Usuario usuarioDestino) throws Exception {
        ListaTareas listaTareas = AppComunicador.getInstancia().getListaTareas();
        System.out.println("Ingrese la descripción de la tarea: ");
        String descripcion = s.nextLine(); // TODO: OPCIONAL manejo de excepciones long
        LocalDate fechaEstimadaInicio;
        LocalDate fechaEstimadaFin;
        LocalDate hoy = LocalDate.now();
        /* Fecha estimada de inicio */
        fechaEstimadaInicio = MetodosGenerales.solicitaFechaDespues(s,
                                                                    "Fecha estimada de inicio (DD/MM/AAAA):",
                                                                    hoy, 
                                                                    "La fecha estimada de inicio no puede ser anterior a hoy.");
        /* Fecha estimada de fin */
        fechaEstimadaFin = MetodosGenerales.solicitaFechaDespues(s,
                                                                "Fecha estimada de fin (DD/MM/AAAA):",
                                                                fechaEstimadaInicio, 
                                                                "La fecha estimada de fin no puede ser anterior a la de inicio.");
        if (MetodosGenerales.usuarioConfirma(s)) {
            listaTareas.crearTarea(usuarioActual, usuarioDestino, descripcion, fechaEstimadaInicio, fechaEstimadaInicio);
            return true;
        }
        return false;
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoCrearTarea() {
        super(EstadosApp.CREAR_TAREA);
    }
    /* ----- CONSTRUCTOR ----- */
}
