package usuarios;

import recursos.TipoUsuario;

/**
 * ----- Mensaje genérico -----
 * Clase administrada sólo por FERNANDA.
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
public class Invitado extends Usuario {
    public Invitado(String nombre, String nickname, String email, String password) {
        super(nombre, nickname, email, password);
    }

    // ---- IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS ----
    public void verTareas(Usuario user) {
        // Se implementará cuando Ricardo termine ListaTareas
        System.out.println("Función verTareas(user) aún no disponible.");
    }
    public TipoUsuario getTipo() {
        return TipoUsuario.INVITADO;
    }
}
