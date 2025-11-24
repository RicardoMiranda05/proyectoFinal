import java.util.Scanner;

import estados.*;

public class AppAlt {
    /* ----- VARIABLES PARA LA MÁQUINA ----- */
    private static Estado estadoActual = new EstadoInicioApp();
    private static Scanner s = new Scanner(System.in);
    private static EstadoSalir estadoSalida = new EstadoSalir();
    /* ----- VARIABLES PARA LA MÁQUINA ----- */
    public static void main(String[] args) throws Exception {
        AppComunicador.cargaUsuarios();
        AppComunicador.cargaTareas();
        System.out.println("\n¡Bienvenido a nuestra App de Gestión de Tareas!" +
                            "\nGracias por su preferencia."
        );
        /* ----- MÁQUINA DE ESTADOS ----- */
        while (! estadoActual.equals(estadoSalida)) {
            estadoActual = estadoActual.ejecutar(s);
        }
        s.close();
        /* ----- MÁQUINA DE ESTADOS ----- */
        System.out.println("Gracias por usar nuestra App." +
                            "\n¡Hasta luego!\n"
        );
    }
}
