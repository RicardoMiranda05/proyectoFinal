package usuarios;

import recursos.TipoUsuario;

import java.util.List;
import java.io.*;

/**
 * ----- Mensaje genérico -----
 * Clase administrada sólo por BLANCA.
 * Puede modificarse por alguien más SÓLO en caso de que quiera hacer pruebas, pero debe
 * regresarse a su estado original. En caso de que no se reestablezca a su estado original,
 * el pull request será rechazado.
 * ----- Mensaje genérico -----
 * 
 * ----- Mensaje para VISITANTES -----
 * Esta clase representa a un usuario Administrador.
 * Ahora implementa la creación de usuarios y todos los métodos abstractos que exige Usuario.
 * ----- Mensaje para VISITANTES -----
 */
public class Administrador extends Usuario {

    // ===== CONSTRUCTOR =====
    public Administrador(String nombre, String nickname, String email, String password) {
        super(nombre, nickname, email, password);
    }

    // ---- IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS ----
    @Override
    public void verTareas(Usuario user) {
        // Se implementará cuando Ricardo termine ListaTareas
        System.out.println("Función verTareas(user) aún no disponible.");
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.ADMINISTRADOR;
    }

    // ---- MÉTODO OBLIGATORIO :) ----
    public void agregarUsuario(String nombre,
                               String nickname,
                               String email,
                               String password,
                               TipoUsuario rol)
                               throws UsuarioExisteException {

        // Cargar archivo de usuarios
        File archivo = new File("src/archivos/usuarios.dat");
        List<Usuario> usuarios;

        try {
            if (archivo.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
                usuarios = (List<Usuario>) ois.readObject();
                ois.close();
            } else {
                usuarios = new java.util.ArrayList<>();
            }

            // Validar nickname o email duplicado
            for (Usuario u : usuarios) {
                if (u.getNickname().equals(nickname)) {
                    throw new UsuarioExisteException("Nickname duplicado", "nickname");
                }
                if (u.getEmail().equals(email)) {
                    throw new UsuarioExisteException("Email duplicado", "email");
                }
            }

            // Crear el usuario según rol
            Usuario nuevo = null;
            switch (rol) {
                case ADMINISTRADOR:
                    nuevo = new Administrador(nombre, nickname, email, password);
                    break;
                case DESARROLLADOR:
                    nuevo = new Desarrollador(nombre, nickname, email, password);
                    break;
                case INVITADO:
                    nuevo = new Invitado(nombre, nickname, email, password);
                    break;
            }

            usuarios.add(nuevo);

            // Guardar de nuevo en archivo
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(usuarios);
            oos.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
