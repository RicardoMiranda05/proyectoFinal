package menues;
/**
 * Se lanza por métodos que modifican la lista de opciones de un menú cuando
 * este ya ha sido cerrado.
 * @author Brayan Montiel Ramírez.
 */
public class MenuClosedException extends MenuException {
    public MenuClosedException(String msg) {
        super(msg);
    }
}
