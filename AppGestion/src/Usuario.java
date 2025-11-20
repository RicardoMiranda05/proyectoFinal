import java.util.Scanner;
import java.util.UUID;
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
 * 
 * INSERTA TU PROPIO COMENTARIO DE LA CLASE.
 */
public class Usuario {
    private final String id;
    private String nombre;
    private String nickname;
    private String email;
    private String password;

    private ListaTareas tareasAsignadas;

    /**
     * Ve las tareas asignadas de user.
     * @param user Nombre del usuario de quien se consultan las tareas.
     */
    public void verTareas(Usuario user) {
        
    }
    /* ----- CONSTRUCTOR ----- */
    protected Usuario (String nombre, String nickname, String email, String password) {
        super();
        id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }
    /* ----- CONSTRUCTOR ----- */

    /* ----- ACCESO ----- */
    public String getId() {
        return id;
    }
    public void setId(String id) {
        System.out.println("El ID no puede ser sobreescrito.");
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    /* ----- ACCESO ----- */
    /* ----- UTILERÍA ----- */
    @Override
    public String toString() {
        String salida = getClass().toString().substring(6);
        salida += " [id=" + id + 
                    ", nombre=" + nombre +
                    ", nickname=" + nickname +
                    ", email=" + email +
                    ", password=" + password + "]";
        return salida;
    }
    /**
     * Compara dos usuarios mediante su ID.
     * @param user Usuario con el cual this se va a comparar.
     * @return true si this tiene el mismo ID que usuario y false si no.
     */
    public boolean equals(Usuario user) {
        if (this == user)
            return true;
        if (user == null)
            return false;
        return id == user.id;
    }
    /* ----- UTILERÍA ----- */
}
