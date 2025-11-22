import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;

import usuarios.*;
import recursos.Diccionario;
import recursos.Menu;
import recursos.TipoUsuario;
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
class MenuInicio extends Menu {
    public static final char OPCION_INICIAR_SESION = '1';
    /* ----- CONSTRUCTOR ----- */
    public MenuInicio () {
        super("Seleccione una de las siguientes opciones:", getDiccionarioOpciones());
        
    }
    /**
     * Construye el diccionario de opciones para este menú.
     * @return El diccionario de opciones del menú.
     */
    private static Diccionario<Character,String> getDiccionarioOpciones() {
        Character[] selecciones = {OPCION_INICIAR_SESION, OPCION_SALIR};
        String[] etiquetas = {"Iniciar sesión", "Salir"};
        return new Diccionario<>(selecciones, etiquetas);
    }
    /* ----- CONSTRUCTOR ----- */
}
/**
 * Menú para el administrador.
 */
class MenuAdministrador extends Menu {
    public static final char OPCION_AGREGAR_USUARIO = '1';
    public static final char OPCION_CREAR_TAREA = '2';
    public static final char OPCION_DESPLEGAR_TAREAS = '3';
    public static final char OPCION_FILTRAR_TAREAS = '4';
    public static final char OPCION_ACTUALIZAR_TAREAS = '5';
    public static final char OPCION_ELIMINAR_TAREAS = '6';
    /* ----- CONSTRUCTOR ----- */
    public MenuAdministrador () {
        super("Seleccione la acción que desea realizar:", getDiccionarioOpciones());
        
    }
    /**
     * Construye el diccionario de opciones para este menú.
     * @return El diccionario de opciones del menú.
     */
    private static Diccionario<Character,String> getDiccionarioOpciones() {
        Character[] selecciones = {OPCION_AGREGAR_USUARIO, 
                                    OPCION_CREAR_TAREA,
                                    OPCION_DESPLEGAR_TAREAS,
                                    OPCION_FILTRAR_TAREAS,
                                    OPCION_ACTUALIZAR_TAREAS,
                                    OPCION_ELIMINAR_TAREAS};
        String[] etiquetas = {"Agregar un usuario nuevo",
                                "Crear tarea nueva",
                                "Desplegar tareas",
                                "Filtrar tareas",
                                "Actualizar tareas",
                                "Eliminar tarea"};
        return new Diccionario<>(selecciones, etiquetas);
    }
    /* ----- CONSTRUCTOR ----- */
}
class MenuRoles extends Menu {
    public static final char OPCION_ADMINISTRADOR = '1';
    public static final char OPCION_DESARROLLADOR = '2';
    public static final char OPCION_INVITADO = '3';
    /* ----- CONSTRUCTOR ----- */
    public MenuRoles () {
        super("¿Qué rol desempeñará?", getDiccionarioOpciones());
        
    }
    /**
     * Construye el diccionario de opciones para este menú.
     * @return El diccionario de opciones del menú.
     */
    private static Diccionario<Character,String> getDiccionarioOpciones() {
        Character[] selecciones = {OPCION_ADMINISTRADOR,
                                    OPCION_DESARROLLADOR,
                                    OPCION_INVITADO};
        String[] etiquetas = {"Administrador",
                                "Desarrollador",
                                "Invitado"};
        return new Diccionario<>(selecciones, etiquetas);
    }
    /* ----- CONSTRUCTOR ----- */
}

/**
 * Menú para el desarrollador.
 */
class MenuDesarrollador extends Menu {
    public static final char OPCION_DESPLEGAR_TAREAS = '1';
    public static final char OPCION_FILTRAR_TAREAS = '2';
    /* ----- CONSTRUCTOR ----- */
    public MenuDesarrollador () {
        super("Seleccione la acción que desea realizar:", getDiccionarioOpciones());
        
    }
    /**
     * Construye el diccionario de opciones para este menú.
     * @return El diccionario de opciones del menú.
     */
    private static Diccionario<Character,String> getDiccionarioOpciones() {
        Character[] selecciones = {OPCION_DESPLEGAR_TAREAS,
                                    OPCION_FILTRAR_TAREAS};
        String[] etiquetas = {"Desplegar tareas",
                                "Filtrar tareas"};
        return new Diccionario<>(selecciones, etiquetas);
    }
    /* ----- CONSTRUCTOR ----- */
}
/**
 * Menú para el invitado.
 */
class MenuInvitado extends Menu {
    public static final char OPCION_CREAR_TAREA = '1';
    public static final char OPCION_DESPLEGAR_TAREAS = '2';
    public static final char OPCION_FILTRAR_TAREAS = '3';
    public static final char OPCION_ACTUALIZAR_TAREAS = '4';
    /* ----- CONSTRUCTOR ----- */
    public MenuInvitado () {
        super("Seleccione la acción que desea realizar:", getDiccionarioOpciones());
        
    }
    /**
     * Construye el diccionario de opciones para este menú.
     * @return El diccionario de opciones del menú.
     */
    private static Diccionario<Character,String> getDiccionarioOpciones() {
        Character[] selecciones = {OPCION_CREAR_TAREA,
                                    OPCION_DESPLEGAR_TAREAS,
                                    OPCION_FILTRAR_TAREAS,
                                    OPCION_ACTUALIZAR_TAREAS};
        String[] etiquetas = {"Crear tarea nueva",
                                "Desplegar tareas",
                                "Filtrar tareas",
                                "Actualizar tareas"};
        return new Diccionario<>(selecciones, etiquetas);
    }
    /* ----- CONSTRUCTOR ----- */
}

public class App {
    public static Usuario usuarioActual; // El usuario que corre la App.
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        MenuInicio menuInicio = new MenuInicio();
        do {
            System.out.println(menuInicio);
            menuInicio.setEleccion(s.nextLine().charAt(0));  //TODO: manejo de excepciones.

            if (menuInicio.getEleccion() == MenuInicio.OPCION_INICIAR_SESION) {
                /* solicitamos y validamos credenciales. */
                if (validaCredenciales(s)) {
                    switch (usuarioActual.getTipo()) {
                        case TipoUsuario.ADMINISTRADOR:
                            MenuAdministrador menuAdmin = new MenuAdministrador();
                            System.out.println(menuAdmin);
                            menuAdmin.setEleccion(s.nextLine().charAt(0));
                            switch (menuAdmin.getEleccion()) {
                                case MenuAdministrador.OPCION_AGREGAR_USUARIO:
                                    System.out.println("Nombre: ");
                                    String nombre = s.next();
                                    System.out.println("Nombre de usuario: ");
                                    String nickname = s.next();
                                    System.out.println("Correo electrónico: ");
                                    String email = s.next();
                                    System.out.println("Contraseña: ");
                                    String password = s.next();
                                    String rol;
                                    MenuRoles menuRoles = new MenuRoles();
                                    System.err.println(menuRoles);
                                    menuRoles.setEleccion(s.nextLine().charAt(0));
                                    switch (menuRoles.getEleccion()) {
                                        case MenuRoles.OPCION_ADMINISTRADOR:
                                            rol = "Administrador";
                                            break;
                                        case MenuRoles.OPCION_DESARROLLADOR:
                                            rol = "Desarrollador";
                                            break;
                                        case MenuRoles.OPCION_INVITADO:
                                            rol = "Desarrollador";
                                            break;
                                        default:
                                            break;
                                    }

                                    ((Administrador) usuarioActual).crearUsuario(nombre, nickname, email, password, null);
                                    break;
                                case MenuAdministrador.OPCION_CREAR_TAREA:
                                    
                                    break;
                                case MenuAdministrador.OPCION_DESPLEGAR_TAREAS:
                                    
                                    break;
                                case MenuAdministrador.OPCION_FILTRAR_TAREAS:
                                    
                                    break;
                                case MenuAdministrador.OPCION_ACTUALIZAR_TAREAS:
                                    
                                    break;
                                case MenuAdministrador.OPCION_ELIMINAR_TAREAS:
                                    
                                    break;
                                default:
                                    break;
                            }

                            break;
                        case TipoUsuario.DESARROLLADOR:
                            MenuDesarrollador menuDes = new MenuDesarrollador();
                            System.out.println(menuDes);
                            menuDes.setEleccion(s.nextLine().charAt(0));
                            break;
                        case TipoUsuario.INVITADO:
                            MenuInvitado menuInv = new MenuInvitado();
                            System.out.println(menuInv);
                            menuInv.setEleccion(s.nextLine().charAt(0));
                            break;
                        default:
                            break;
                    } 
                } else {
                    System.out.println("Las credenciales son incorrectas.");
                    // TODO: Si da tiempo, hacer un menú para volver a intentar o salir.
                }
            }
        } while (menuInicio.getEleccion() != MenuInicio.OPCION_SALIR);
        s.close();
    }
    /**
     * Le solicita las credenciales al usuario y verifica si existe un usuario con ellas.
     * En ese caso establece {@code usuarioActual} como ese usuario.
     * @param s Scanner con el que el usuario se comunica con el programa.
     * @return {@code true} si las credenciales son de un usuario existente y {@code false}
     * si no.
     */
    public static boolean validaCredenciales(Scanner s) {
        System.out.println("Ingrese su correo/nickname y su contraseña.");
        System.out.println("Correo/nickname: ");
        String emailNickname = s.next(); //TODO: manejo de excepciones.
        System.out.println("Contraseña: ");
        String password = s.next(); //TODO: manejo de excepciones.
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\archivos\\usuarios.dat"));
            List<Usuario> usuarios = (List<Usuario>) ois.readObject();
            for (Usuario usuario : usuarios) {
                /* Optimización de búsqueda */
                if (usuario.getEmail().equals(emailNickname) || usuario.getNickname().equals(emailNickname)) {
                    if (usuario.getPassword() == password) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            ois.close(); // TODO: Revisar si sí lo debo cerrar aquí o si lo necesito después.
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
