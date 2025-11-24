package usuarios;
/**
 * Se lanza por métodos al encontrar un usuario con un dato ya existente
 * dentro de un objeto que almacena usuarios. 
 * @author Brayan Montiel Ramírez.
 */
public class UsuarioExisteException extends Exception {
    private String datoDuplicado;
    /* ----- CONSTRUCTOR ----- */
    public UsuarioExisteException(String msg, String datoDuplicado) {
        super(msg);
        this.datoDuplicado = datoDuplicado;
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- ACCESO ----- */
    public String getDatoDuplicado() {
        return datoDuplicado;
    }
    public void setDatoDuplicado(String datoDuplicado) {
        this.datoDuplicado = datoDuplicado;
    }
    /* ----- ACCESO ----- */
}
