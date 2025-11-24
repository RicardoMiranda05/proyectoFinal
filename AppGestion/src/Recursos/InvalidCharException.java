package recursos;
/**
 * Se lanza por métodos que esperan un dato de tipo char y reciben otro.
 * @author Brayan Montiel Ramírez.
 */
public class InvalidCharException extends Exception {
    public InvalidCharException(String msg) {
        super(msg);
    }
}
