package excepciones;
/**
 * ----- Mensaje genérico -----
 * Clase administrada sólo por BRAYAN.
 * Puede modificarse por alguien más SÓLO en caso de que quiera hacer pruebas, pero debe
 * regresarse a su estado original. En caso de que no se reestablezca a su estado original,
 * el pull request será rechazado.
 * ----- Mensaje genérico -----
 * 
 * ----- Mensaje para VISITANTES -----
 * 
 * ----- Mensaje para VISITANTES -----
 * Indica que un se intentó 
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
