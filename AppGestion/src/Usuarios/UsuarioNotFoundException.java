package usuarios;
/**
 * Se lanza por métodos que buscan a un usuario dentro de algún objeto que los
 * almacena y no lo encuentra.
 * @author Brayan Montiel Ramírez.
 */
public class UsuarioNotFoundException extends UsuarioException {
    public UsuarioNotFoundException(String msg) {
        super(msg);
    }
}
