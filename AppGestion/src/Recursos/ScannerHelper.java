package recursos;

import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Sirve como auxiliar de algunos métodos de la clase Scanner.
 */
public abstract class ScannerHelper {
    public static char leerChar(Scanner s) throws InvalidCharException, NoSuchElementException {
        String linea = s.next();
        if (linea.isEmpty()) {
            throw new NoSuchElementException("Línea vacía fue ingresada.");
        }
        if (linea.length() > 1) {
            throw new InvalidCharException("No se permite más de un carácter.");
        }
        return linea.charAt(0);
    }
}