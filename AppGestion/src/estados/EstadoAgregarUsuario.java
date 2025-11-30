package estados;

import java.util.Scanner;

import menues.Menu;
import menues.MenuClosedException;
import menues.MenuConfirmacion;
import recursos.TipoUsuario;
import singleton.AppComunicador;
import usuarios.Administrador;
import usuarios.UsuarioExisteException;
import java.util.List;
import usuarios.Usuario;

class MenuRoles extends Menu {
    /* ----- CONSTRUCTOR ----- */
    public MenuRoles() {
        super();
        try {
            addOpcion("Administrador");
            addOpcion("Desarrollador");
            addOpcion("Invitado");
        } catch (MenuClosedException mce) {
            System.out.println("El menú no debería de estar cerrado.");
            mce.printStackTrace();
        }
    }
    /* ----- CONSTRUCTOR ----- */
}
/**
 * Estado que representa cuando un administrador agrega a un usuario.
 * @author Brayan Montiel Ramírez.
 */
public class EstadoAgregarUsuario extends Estado {
    
    public Estado ejecutar(Scanner s) throws Exception {
        if (agregaUsuario(s)) {
            System.out.println("Se ha agregado con éxito al usuario.");
            return new EstadoUsoGeneral();
        /* Se pregunta si se quiere repetir la operación */
        } else if (! MetodosGenerales.repetirOperacion(s)) {
            return new EstadoUsoGeneral();
        }
        return new EstadoAgregarUsuario();
    }

    /**
     * Solicita los datos de un usuario para agregarlo al archivo usuarios.dat e indica si la
     * operación se realizó con éxito.
     * @param s Teclado con el que el usuario se comunica.
     * @return {@code true} si se agregó al usuario a la lista de usuarios y {@code false} si no.
     */
    private boolean agregaUsuario(Scanner s) throws Exception {
        List<Usuario> usuarios = AppComunicador.getInstancia().getListaUsuarios();
        System.out.print("Nombre: ");
        s.nextLine();
        String nombre = s.nextLine();
        String nickname;
        boolean existeNickname;
        do {
            existeNickname = false;
            System.out.print("Nombre de usuario: ");
            nickname = s.nextLine();
            for (Usuario usuario : usuarios) {
                if (nickname.equals(usuario.getNickname())) {
                    existeNickname = true;
                    System.out.println("Ya existe un usuario con el nombre de usuario ingresado. " +
                                        "Por favor, ingrese uno diferente."
                    );
                    break;
                }
            }
        } while (existeNickname);
        System.out.print("Correo electrónico: ");
        String email = s.nextLine();
        System.out.print("Contraseña: ");
        String password = s.nextLine();
        TipoUsuario rol;
        MenuRoles menuRoles = new MenuRoles();
        menuRoles.close();
        MetodosGenerales.solicitaEntrada(s, menuRoles, "¿Qué rol le asigna?");
        switch (menuRoles.getEleccion().getIdentificador()) {
            case '1':
                rol = TipoUsuario.ADMINISTRADOR;
                break;
            case '2':
                rol = TipoUsuario.DESARROLLADOR;
                break;
            case '3':
                rol = TipoUsuario.INVITADO;
                break;
            default:
                throw new Exception("Rol no válido");
        }

        try {
            if (MetodosGenerales.usuarioConfirma(s)) {
                Administrador admin = (Administrador) AppComunicador.getInstancia().getUsuarioActual();

                admin.agregarUsuario(usuarios, nombre, nickname, email, password, rol);
                return true; // <--- Si se añade.
            }
        } catch (UsuarioExisteException uee) {
            String mensajeBonito;

            switch (uee.getDatoDuplicado()) {
                case "nickname":
                    mensajeBonito = "El nombre de usuario \"" + nickname + "\" ya ha sido registrado. "
                                  + "Por favor, elige otro nickname.";
                    break;
                case "email":
                    mensajeBonito = "El correo electrónico \"" + email + "\" ya ha sido registrado. "
                                  + "Por favor, usa otro correo.";
                    break;
                default:
                    mensajeBonito = "Alguno de los datos ingresados ya está registrado. "
                                  + "Intente de nuevo con otros datos.";
            }

            System.out.println(mensajeBonito);
        }

        return false; //<--- Si no se añade.
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoAgregarUsuario() {
        super(EstadosApp.AGREGAR_USUARIO);
    }
    /* ----- CONSTRUCTOR ----- */
}
