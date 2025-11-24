package menues;
/**
 * Engloba a las excepciones en tiempo de ejecución por el uso de la clase Menu.
 * @author Brayan Montiel Ramírez.
 */
public class MenuRuntimeException extends RuntimeException{
    public MenuRuntimeException(String msg) {
        super(msg);
    }
}
