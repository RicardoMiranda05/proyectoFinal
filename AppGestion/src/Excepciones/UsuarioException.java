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
 * Errores para el programador al usar la clase Usuario.
 * @author Brayan Montiel Ramírez.
 */
public class UsuarioException extends Exception {
    public UsuarioException(String msg) {
        super(msg);
    }
}
