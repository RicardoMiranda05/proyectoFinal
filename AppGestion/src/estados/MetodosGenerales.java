package estados;

import java.time.DateTimeException;
import java.time.LocalDate;
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
     * Solicita una fecha al usuario hasta que se encuentre en un formato válido DD/MM/AAAA
     * y se encuentre después de una fecha mínima.
     * @param s : Método de comunicación del usuario.
     * @param mensaje : Mensaje que aparece por detrás de la línea que el usuario introduce.
     * @param fechaMinima : Fecha que se debe rebasar.
     * @param error : Mensaje que aparece en caso de estar ingresar una fecha anterior a la
     * mínima.
     * @return
     */
    public static LocalDate solicitaFechaDespues(Scanner s, String mensaje, LocalDate fechaMinima, String error) {
        LocalDate salida;
        while (true) {
            salida = solicitaFecha(s, mensaje);
            if (salida.isBefore(fechaMinima)) {
                System.out.println(error);
            } else {
                break;
            }
        }
        return salida;
    }
    /**
     * Solicita una fecha al usuario hasta que se encuentre en un formato válido DD/MM/AAAA
     * y se encuentre por detrás de una fecha máxima.
     * @param s : Método de comunicación del usuario.
     * @param mensaje : Mensaje que aparece por detrás de la línea que el usuario introduce.
     * @param fechaMaxima : Fecha que no se puede rebasar.
     * @param error : Mensaje que aparece en caso de exceder la fecha máxima.
     * @return
     */
    public static LocalDate solicitaFechaAntes(Scanner s, String mensaje, LocalDate fechaMaxima, String error) {
        LocalDate salida;
        while (true) {
            salida = solicitaFecha(s, mensaje);
            if (salida.isAfter(fechaMaxima)) {
                System.out.println(error);
            } else {
                break;
            }
        }
        return salida;
    }
    /**
     * Solicita una fecha al usuario hasta que cumpla con un formato válido DD/MM/AAAA.
     * @param s : Método de comunicación del usuario.
     * @param mensaje : Mensaje que aparece por detrás de la línea que el usuario introduce.
     * @return La fecha que el usuario registra.
     */
    public static LocalDate solicitaFecha(Scanner s, String mensaje) {
        LocalDate salida;
        while (true) {
            try {
                System.out.print(mensaje);
                salida = leerFecha(s);
                if (salida == null) {
                    System.out.println("Formato de fecha no válido, intente de nuevo.");
                    continue;
                }
            } catch (DateTimeException e) {
                System.out.println("La fecha no existe en el calendario, intente con una fecha válida.");
                continue;
            }
            return salida;
        }
    }
    /**
     * Lee la fecha introducida en consola con un formato DD/MM/AAAA.
     * @param s : Método de comunicación del usuario.
     * @return La fecha que se ingresó o {@code null} si no se introdujo en un formato
     * válido.
     * @throws DateTimeException Si la fecha no existe en el calendario.
     */
    public static LocalDate leerFecha(Scanner s) throws DateTimeException {
        int year;
        int month;
        int day;
        String date = s.nextLine();
        if (date.length() != 10) {
            return null;
        }
        if (date.charAt(2) != '/' || date.charAt(5) != '/') {
            return null;
        }
        try {
            year = Integer.parseInt(date.substring(6, 10));
            month = Integer.parseInt(date.substring(3, 5));
            day = Integer.parseInt(date.substring(0, 2));
        } catch (Exception e) {
            return null;
        }
        return LocalDate.of(year, month, day);
    }
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
