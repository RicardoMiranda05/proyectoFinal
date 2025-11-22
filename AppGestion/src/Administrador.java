import java.util.UUID;


/**
 * ----- Mensaje genérico -----
 * Clase administrada sólo por BLANCA.
 * Puede modificarse por alguien más SÓLO en caso de que quiera hacer pruebas, pero debe
 * regresarse a su estado original. En caso de que no se reestablezca a su estado original,
 * el pull request será rechazado.
 * ----- Mensaje genérico -----
 * 
 * ----- Mensaje para VISITANTES -----
 * El método crearUsuario todavía no está disponible para su uso, ya que las clases
 * Desarrollador e Invitado no han definido sus métodos constructores en este punto del
 * proyecto.
 * ----- Mensaje para VISITANTES -----
 * 
 * INSERTA TU PROPIO COMENTARIO DE LA CLASE.
 */
public class Administrador extends Usuario {
    /**
     * 
     * @param nombre Nombre del usuario.
     * @param nickname Nickname del usuario.
     * @param email Correo del usuario.
     * @param password Contraseñña del usuario.
     * @param rol Rol que el usuario creado desempeñará (administrador, desarrollador o invitado).
     * @return
     */
    public Usuario crearUsuario (String nombre, String nickname, String email, String password, String rol) {
        switch (rol) {
            case "Administrador":
                return new Administrador(nombre, nickname, email, password);
            case "Desarrollador":
                return new Desarrollador(nombre, nickname, email, password);
            case "Invitado":
                return new Invitado(nombre, nickname, email, password);
            default:
                System.out.println("No existe el rol " + rol + ".");
                return null;
        }
    }
    /* ----- CONSTRUCTORES ----- */
    public Administrador (String nombre, String nickname, String email, String password) {
        super(nombre, nickname, email, password);
    }
    /* ----- CONSTRUCTORES ----- */
}
