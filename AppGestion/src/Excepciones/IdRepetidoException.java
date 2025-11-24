package excepciones;
/**
 * Se lanza por métodos de clases que administran objetos con identificadores (ID)
 * cuando se intenta almacenar un objeto con un ID que ya existe.
 * @author Brayan Montiel Ramírez.
 */
public class IdRepetidoException extends Exception {
    public IdRepetidoException(String msg) {
        super(msg);
    }
}
