package estados;

import java.util.Scanner;

import singleton.AppComunicador;
import singleton.SingletonClosedException;
import usuarios.Usuario;
/**
 * Estado que se ejecuta cuando el usuario está iniciando sesión.
 * @author Brayan Montiel Ramírez.
 */
public class EstadoInicioSesion extends Estado {
    
    public Estado ejecutar(Scanner s) throws Exception{
        if (validaCredenciales(s)) {
            System.out.println("Credenciales válidas." +
                                "\n¡Bienvenido " + AppComunicador.getInstancia().getUsuarioActual().getNickname() + "!");
            return new EstadoUsoGeneral();
        } else {
            System.out.print("\nLas credenciales ingresadas no son válidas.");
            /* Se pregunta si se quiere repetir la operación */
            if (! MetodosGenerales.repetirOperacion(s)) {
                return new EstadoInicioApp();
            }
        }
        return new EstadoInicioSesion();
    }
    /**
     * Le solicita las credenciales al usuario y verifica si existe un usuario con ellas.
     * En ese caso establece {@code usuarioActual} como ese usuario.
     * @param s Scanner con el que el usuario se comunica con el programa.
     * @return {@code true} si las credenciales son de un usuario existente y {@code false}
     * si no.
     */
    public static boolean validaCredenciales(Scanner s) {
        System.out.println("Ingrese su correo/nombre de usuario y su contraseña.");
        System.out.print("Correo/Nombre de usuario: ");
        s.nextLine();
        String emailNickname = s.nextLine(); //TODO: OPCIONAL manejo de excepciones Long.
        for (Usuario usuario : AppComunicador.getInstancia().getListaUsuarios()) {
            /* Optimización de búsqueda */
            if (usuario.getEmail().equals(emailNickname) || usuario.getNickname().equals(emailNickname)) {
                System.out.print("Contraseña: ");
                String password = s.next(); //TODO: OPCIONAL manejo de excepciones Long.
                if (usuario.getPassword().equals(password)) {
                    try {
                        AppComunicador.getInstancia().setUsuarioActual(usuario);
                    } catch (SingletonClosedException sce) {
                        System.out.println("El singleton no debió ser cerrado hasta el final del programa.");
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoInicioSesion() {
        super(EstadosApp.INICIO_SESION);
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- UTILERÍA ----- */
    @Override
    public String toString() {
        return "EstadoInicioSesion []";
    }
    /* ----- UTILERÍA ----- */
}
