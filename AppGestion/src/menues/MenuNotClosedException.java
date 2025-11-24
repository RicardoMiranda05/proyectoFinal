package menues;
/**
 * Se lanza cuando se intenta modificar la lista de opciones de un menú
 * que ya ha sido cerrado.
 * @author Brayan Montiel Ramírez.
 */
public class MenuNotClosedException extends MenuRuntimeException {
    public MenuNotClosedException(String msg) {
        super(msg);
    }
}
