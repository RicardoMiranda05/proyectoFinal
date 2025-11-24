package estados;

import java.util.NoSuchElementException;
import java.util.Scanner;

import excepciones.IdNoEncontradoException;
import menues.MenuOperacion;
import recursos.InvalidCharException;
import recursos.ScannerHelper;
/**
 * Provee métodos comunes para las clases que interactúan con el usuario.
 * @author Brayan Montiel Ramírez.
 */
public class MetodosGenerales {
    /**
     * Verifica si se desea repetir la operación reciente.
     * @param s Teclado con el que se comunica el usuario.
     * @return {@code true} si el usuario desea repetir la operación y {@code false} si no.
     */
    public static boolean repetirOperacion(Scanner s) throws Exception{
        MenuOperacion menuOperacion = new MenuOperacion();
        menuOperacion.close();
        System.out.println(menuOperacion);
        while (true) {
            try {
                char identificador = ScannerHelper.leerChar(s);
                menuOperacion.setEleccion(identificador);
                break;
            } catch (InvalidCharException | NoSuchElementException | IdNoEncontradoException e) {
                e.printStackTrace();
                System.out.println("Operación no válida. Intente de nuevo. AAA");
            }
        }
        switch (menuOperacion.getEleccion().getIdentificador()) {
            case '1':
                return true;
            case MenuOperacion.identificadorSalida:
                return false;
        
            default:
                throw new Exception();
        }
    }
}
