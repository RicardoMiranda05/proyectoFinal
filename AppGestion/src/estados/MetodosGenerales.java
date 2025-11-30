package estados;

import java.util.NoSuchElementException;
import java.util.Scanner;

import excepciones.IdNoEncontradoException;
import menues.Menu;
import menues.MenuConfirmacion;
import menues.MenuOperacion;
import recursos.InvalidCharException;
import recursos.ScannerHelper;
/**
 * Provee métodos comunes para las clases que interactúan con el usuario.
 * @author Brayan Montiel Ramírez.
 */
public class MetodosGenerales {
    /**
     * Solicita al usuario confirmar la operación reciente, para mayor seguridad.
     * @param s Teclado con el que se comunica el usuario.
     * @return {@code true} si el usuario confirma y {@code false} si no.
     */
    public static boolean usuarioConfirma(Scanner s) throws Exception {
        MenuConfirmacion menuConfirmacion = new MenuConfirmacion();
        menuConfirmacion.close();
        MetodosGenerales.solicitaEntrada(s, menuConfirmacion, "¿Desea confirmar la operación?");
        if (menuConfirmacion.getEleccion().getIdentificador() == MenuConfirmacion.IDENTIFICADOR_CONFIRMAR) {
            return true;
        } else {
            System.out.println("La operación fue cancelada.");
            return false;
        }
    }
    /**
     * Verifica si se desea repetir la operación reciente.
     * @param s Teclado con el que se comunica el usuario.
     * @return {@code true} si el usuario desea repetir la operación y {@code false} si no.
     * @throws Exception Si el identificador del menú no es '1' o el de salida.
     */
    public static boolean repetirOperacion(Scanner s) throws Exception{
        MenuOperacion menuOperacion = new MenuOperacion();
        menuOperacion.close();
        solicitaEntrada(s, menuOperacion, "");
        switch (menuOperacion.getEleccion().getIdentificador()) {
            case '1':
                return true;
            case MenuOperacion.IDENTIFICADOR_SALIDA:
                return false;
        
            default:
                throw new Exception();
        }
    }
    /**
     * Solicita al usuario una entrada de tipo {@code char}, imprimiendo el mensaje que pasa
     * como parámetro. 
     * <p>Ya implementa la separación de líneas (estética) y setea la elección
     * dentro del menú.</p>
     * <p><b>Incluye el manejo de excepciones del menú y del scanner. </b></p>
     * @param s : Teclado con el que se comunica el usuario.
     * @param menu : Menú del cual se solicita la entrada.
     * @param mensaje : Mensaje que se imprime en pantalla.
     */
    public static void solicitaEntrada(Scanner s, Menu menu, String mensaje) {
        while (true) {
            try {
                System.out.println();
                System.out.println(mensaje);
                System.out.println(menu);
                System.out.println();
                char identificador = ScannerHelper.leerChar(s);
                menu.setEleccion(identificador);
                break;
            } catch (InvalidCharException | NoSuchElementException | IdNoEncontradoException e) {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
