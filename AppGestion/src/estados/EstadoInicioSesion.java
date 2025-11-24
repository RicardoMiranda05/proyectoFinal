package estados;

import java.util.List;
import java.util.Scanner;

import usuarios.Usuario;
/**
 * Estado que se ejecuta cuando el usuario está iniciando sesión.
 * @author Brayan Montiel Ramírez.
 */
public class EstadoInicioSesion extends Estado {
    public static Usuario usuarioActual = AppComunicador.usuarioActual;
    public static List<Usuario> listaUsuarios = AppComunicador.listaUsuarios;
    
    public Estado ejecutar(Scanner s) throws Exception{
        if (validaCredenciales(s)) {
            System.out.println("Credenciales válidas." +
                                "\n¡Bienvenido" + usuarioActual.getNickname() + "!");
            return null;//new EstadoUsoGeneral(EstadosApp.USO_GENERAL); // TODO: Cambiar cuando se implemente
        } else {
            System.out.println("Las credenciales ingresadas no son válidas.");
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
        System.out.println(listaUsuarios);
        System.out.println("Ingrese su correo/nombre de usuario y su contraseña.");
        System.out.println("Correo/Nombre de usuario: ");
        String emailNickname = s.next(); //TODO: manejo de excepciones.
        for (Usuario usuario : listaUsuarios) {
            /* Optimización de búsqueda */
            if (usuario.getEmail().equals(emailNickname) || usuario.getNickname().equals(emailNickname)) {
                break;
            }
            return false;
        }
        System.out.println("Contraseña: ");
        String password = s.next(); //TODO: manejo de excepciones.
        for (Usuario usuario : listaUsuarios) {
            /* Optimización de búsqueda */
            if (usuario.getEmail().equals(emailNickname) || usuario.getNickname().equals(emailNickname)) {
                if (usuario.getPassword() == password) {
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
