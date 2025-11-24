package excepciones;
/**
 * Se lanza por métodos de clases que administran objetos con identificadores (ID)
 * cuando estos no son encontrados.
 * @author Brayan Montiel Ramírez.
 */
public class IdNoEncontradoException extends Exception{
    public IdNoEncontradoException(String msg) {
        super(msg);
    }
}
