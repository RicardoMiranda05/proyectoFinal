import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;

import excepciones.UsuarioExisteException;
import maquinas.EstadosApp;
import usuarios.*;
import recursos.*;
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
        super(getDiccionarioOpciones());
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
class MenuOperacion extends Menu {
    public static final char OPCION_REPETIR= '1';
    public static final char OPCION_CANCELAR = '2';
    /* ----- CONSTRUCTOR ----- */
    public MenuOperacion () {
        super(getDiccionarioOpciones());
    }
    /**
     * Construye el diccionario de opciones para este menú.
     * @return El diccionario de opciones del menú.
     */
    private static Diccionario<Character,String> getDiccionarioOpciones() {
        Character[] selecciones = {OPCION_REPETIR, OPCION_CANCELAR};
        String[] etiquetas = {"Volver a intentar", "Cancelar operación"};
        return new Diccionario<>(selecciones, etiquetas);
    }
    /* ----- CONSTRUCTOR ----- */
}
class MenuConfirmacion extends Menu {
    public static final char OPCION_CONFIRMAR = '1';
    public static final char OPCION_CANCELAR = '2';
    /* ----- CONSTRUCTOR ----- */
    public MenuConfirmacion () {
        super(getDiccionarioOpciones());
    }
    /**
     * Construye el diccionario de opciones para este menú.
     * @return El diccionario de opciones del menú.
     */
    private static Diccionario<Character,String> getDiccionarioOpciones() {
        Character[] selecciones = {OPCION_CONFIRMAR, OPCION_CANCELAR};
        String[] etiquetas = {"Confirmar", "Cancelar"};
        return new Diccionario<>(selecciones, etiquetas);
    }
    /* ----- CONSTRUCTOR ----- */
}
/**
 * 
 */
class MenuUsuario extends Menu {
    public static final char OPCION_CERRAR_SESION = 'c';
    /* ----- CONSTRUCTOR ----- */
    public MenuUsuario (Diccionario<Character, String> opciones) {
        super(opciones);
    }
    /* ----- CONSTRUCTOR ----- */
}
/**
 * Menú para el administrador.
 */
class MenuAdministrador extends MenuUsuario {
    public static final char OPCION_AGREGAR_USUARIO = '1';
    public static final char OPCION_CREAR_TAREA = '2';
    public static final char OPCION_DESPLEGAR_TAREAS = '3';
    public static final char OPCION_FILTRAR_TAREAS = '4';
    public static final char OPCION_ACTUALIZAR_TAREAS = '5';
    public static final char OPCION_ELIMINAR_TAREAS = '6';
    /* ----- CONSTRUCTOR ----- */
    public MenuAdministrador () {
        super(getDiccionarioOpciones());
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
                                    OPCION_ELIMINAR_TAREAS,
                                    OPCION_CERRAR_SESION};
        String[] etiquetas = {"Agregar un usuario nuevo",
                                "Crear tarea nueva",
                                "Desplegar tareas",
                                "Filtrar tareas",
                                "Actualizar tareas",
                                "Eliminar tareas"};
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
        super(getDiccionarioOpciones());
        
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
class MenuDesarrollador extends MenuUsuario {
    public static final char OPCION_DESPLEGAR_TAREAS = '1';
    public static final char OPCION_FILTRAR_TAREAS = '2';
    public static final char OPCION_ACTUALIZAR_TAREAS = '3';
    /* ----- CONSTRUCTOR ----- */
    public MenuDesarrollador () {
        super(getDiccionarioOpciones());
        
    }
    /**
     * Construye el diccionario de opciones para este menú.
     * @return El diccionario de opciones del menú.
     */
    private static Diccionario<Character,String> getDiccionarioOpciones() {
        Character[] selecciones = {OPCION_DESPLEGAR_TAREAS,
                                    OPCION_FILTRAR_TAREAS,
                                    OPCION_ACTUALIZAR_TAREAS,
                                    OPCION_CERRAR_SESION};
        String[] etiquetas = {"Desplegar tareas",
                                "Filtrar tareas",
                                "Actualizar tareas",
                                "Cerrar sesión"};
        return new Diccionario<>(selecciones, etiquetas);
    }
    /* ----- CONSTRUCTOR ----- */
}
/**
 * Menú para el invitado.
 */
class MenuInvitado extends MenuUsuario {
    public static final char OPCION_CREAR_TAREA = '1';
    public static final char OPCION_DESPLEGAR_TAREAS = '2';
    public static final char OPCION_FILTRAR_TAREAS = '3';
    public static final char OPCION_ACTUALIZAR_TAREAS = '4';
    /* ----- CONSTRUCTOR ----- */
    public MenuInvitado () {
        super(getDiccionarioOpciones());
        
    }
    /**
     * Construye el diccionario de opciones para este menú.
     * @return El diccionario de opciones del menú.
     */
    private static Diccionario<Character,String> getDiccionarioOpciones() {
        Character[] selecciones = {OPCION_CREAR_TAREA,
                                    OPCION_DESPLEGAR_TAREAS,
                                    OPCION_FILTRAR_TAREAS,
                                    OPCION_ACTUALIZAR_TAREAS,
                                    OPCION_CERRAR_SESION};
        String[] etiquetas = {"Crear tarea nueva",
                                "Desplegar tareas",
                                "Filtrar tareas",
                                "Actualizar tareas",
                                "Cerrar sesión"};
        return new Diccionario<>(selecciones, etiquetas);
    }
    /* ----- CONSTRUCTOR ----- */
}

public class App {
    public static Usuario usuarioActual; // El usuario que corre la App.
    public static EstadosApp estadoActual;
    public static final EstadosApp estadoIncial = EstadosApp.INICIO; 
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        estadoActual = estadoIncial;
        /* ----- Máquina de estados de la App ----- */
        do {
            switch (estadoActual) {
                /* ----- Lógica del estado de inicio ----- */
                case EstadosApp.INICIO:
                    MenuInicio menuInicio = new MenuInicio();
                    System.out.println("Seleccione la opción deseada: ");
                    System.out.println(menuInicio);
                    menuInicio.setEleccion(s.nextLine().charAt(0)); // TODO: manejo de excepciones.
                    /* ----- CAMBIO DE ESTADO ----- */
                    switch (menuInicio.getEleccion()) {
                        case MenuInicio.OPCION_INICIAR_SESION:
                            estadoActual = EstadosApp.INICIO_SESION;
                            break;
                        case MenuInicio.OPCION_SALIR:
                            estadoActual = EstadosApp.SALIR;
                            break;
                        default:
                            break;
                    }
                    break;
                /* ----- Lógica del estado de inicio de sesión ----- */
                case EstadosApp.INICIO_SESION:
                    if (validaCredenciales(s)) {
                        System.out.println("Credenciales válidas." +
                                            "\n¡Bienvenido" + usuarioActual.getNickname() + "!");
                        /* ----- CAMBIO DE ESTADO ----- */
                        estadoActual = EstadosApp.USO_GENERAL;
                    } else {
                        System.out.println("Las credenciales ingresadas no son válidas.");
                        MenuOperacion menuOperacion = new MenuOperacion();
                        System.out.println(menuOperacion);
                        menuOperacion.setEleccion(s.nextLine().charAt(0)); // TODO: manejo de excepciones
                        /* ----- CAMBIO DE ESTADO ----- */
                        switch (menuOperacion.getEleccion()) {
                            case MenuOperacion.OPCION_REPETIR:
                                // Mantengo el estado actual.
                                break;
                            case MenuOperacion.OPCION_CANCELAR:
                                estadoActual = EstadosApp.INICIO;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                /* ----- Lógica del estado de uso general de la app ----- */
                case EstadosApp.USO_GENERAL:
                    MenuUsuario menuUsuario = null;
                    switch (usuarioActual.getTipo()) {
                        case TipoUsuario.ADMINISTRADOR:
                            MenuAdministrador menuAdmin = new MenuAdministrador();
                            System.out.println("Seleccione la acción que desea realizar:");
                            System.out.println(menuAdmin);
                            menuAdmin.setEleccion(s.nextLine().charAt(0)); // TODO: manejo de excepciones
                            /* ----- CAMBIO DE ESTADO ----- */
                            switch (menuAdmin.getEleccion()) {
                                case MenuAdministrador.OPCION_AGREGAR_USUARIO:
                                    estadoActual = EstadosApp.AGREGAR_USUARIO;
                                    break;
                                case MenuAdministrador.OPCION_CREAR_TAREA:
                                    estadoActual = EstadosApp.CREAR_TAREA;
                                    break;
                                case MenuAdministrador.OPCION_DESPLEGAR_TAREAS:
                                    estadoActual = EstadosApp.DESPLEGAR_TAREAS;
                                    break;
                                case MenuAdministrador.OPCION_FILTRAR_TAREAS:
                                    estadoActual = EstadosApp.FILTRAR_TAREAS;
                                    break;
                                case MenuAdministrador.OPCION_ACTUALIZAR_TAREAS:
                                    estadoActual = EstadosApp.ACTUALIZAR_TAREAS;
                                    break;
                                case MenuAdministrador.OPCION_ELIMINAR_TAREAS:
                                    estadoActual = EstadosApp.ELIMINAR_TAREAS;
                                    break;
                                case MenuAdministrador.OPCION_CERRAR_SESION:
                                    estadoActual = EstadosApp.CERRAR_SESION;
                                    break;
                            }
                            break;
                        case TipoUsuario.DESARROLLADOR:
                            MenuDesarrollador menuDes = new MenuDesarrollador();
                            System.out.println("Seleccione la acción que desea realizar:");
                            System.out.println(menuDes);
                            menuDes.setEleccion(s.nextLine().charAt(0)); // TODO: manejo de excepciones
                            /* ----- CAMBIO DE ESTADO ----- */
                            switch (menuDes.getEleccion()) {
                                case MenuAdministrador.OPCION_CREAR_TAREA:
                                    estadoActual = EstadosApp.CREAR_TAREA;
                                    break;
                                case MenuAdministrador.OPCION_DESPLEGAR_TAREAS:
                                    estadoActual = EstadosApp.DESPLEGAR_TAREAS;
                                    break;
                                case MenuAdministrador.OPCION_FILTRAR_TAREAS:
                                    estadoActual = EstadosApp.FILTRAR_TAREAS;
                                    break;
                                case MenuAdministrador.OPCION_ACTUALIZAR_TAREAS:
                                    estadoActual = EstadosApp.ACTUALIZAR_TAREAS;
                                    break;
                                case MenuAdministrador.OPCION_CERRAR_SESION:
                                    estadoActual = EstadosApp.CERRAR_SESION;
                                    break;
                            }
                        case TipoUsuario.INVITADO:
                            MenuInvitado menuInv = new MenuInvitado();
                            System.out.println("Seleccione la acción que desea realizar:");
                            System.out.println(menuInv);
                            menuInv.setEleccion(s.nextLine().charAt(0)); // TODO: manejo de excepciones
                            /* ----- CAMBIO DE ESTADO ----- */
                            switch (menuInv.getEleccion()) {
                                case MenuAdministrador.OPCION_DESPLEGAR_TAREAS:
                                    estadoActual = EstadosApp.DESPLEGAR_TAREAS;
                                    break;
                                case MenuAdministrador.OPCION_FILTRAR_TAREAS:
                                    estadoActual = EstadosApp.FILTRAR_TAREAS;
                                    break;
                                case MenuAdministrador.OPCION_CERRAR_SESION:
                                    estadoActual = EstadosApp.CERRAR_SESION;
                                    break;
                            }
                    }
                    break;
                /* ----- ESTADOS PARA LAS FUNCIONES DEL USUARIO ----- */
                case EstadosApp.AGREGAR_USUARIO:
                    if (agregaUsuario(s)) {
                        System.out.println("Se ha agregado con éxito al usuario.");
                        estadoActual = EstadosApp.USO_GENERAL;
                    } else if (!repetirOperacion(s)) {
                        estadoActual = EstadosApp.USO_GENERAL;
                    }
                    break;
                case EstadosApp.CREAR_TAREA:
                    break;
                case EstadosApp.DESPLEGAR_TAREAS:
                    break;
                case EstadosApp.FILTRAR_TAREAS:
                    break;
                case EstadosApp.ACTUALIZAR_TAREAS:
                    break;
                case EstadosApp.ELIMINAR_TAREAS:
                    break;
                case EstadosApp.CERRAR_SESION:
                    estadoActual = EstadosApp.INICIO_SESION;
                    break;
            }
        } while (!estadoActual.equals(EstadosApp.SALIR));
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
        System.out.println("Ingrese su correo/nombre de usuario y su contraseña.");
        System.out.println("Correo/Nombre de usuario: ");
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
    /**
     * Verifica si se desea repetir la operación reciente.
     * @param s Teclado con el que se comunica el usuario.
     * @return {@code true} si el usuario desea repetir la operación y {@code false} si no.
     */
    public static boolean repetirOperacion(Scanner s) {
        MenuOperacion menuOperacion = new MenuOperacion();
        System.out.println(menuOperacion);
        menuOperacion.setEleccion(s.nextLine().charAt(0)); // TODO: manejo de excepciones
        if (menuOperacion.getEleccion() == MenuOperacion.OPCION_REPETIR) {
            return true;
        }
        return false;
    }
    /**
     * Solicita los datos de un usuario para agregarlo al achivo usuarios.dat e indica si la
     * operación se realizó con éxito-
     * @param s Teclado con el que el usuario se comunica.
     * @return {@code true} si se agregó al usuario al archivo usuarios.dat y {@code false} si no.
     */
    public static boolean agregaUsuario(Scanner s) {
        System.out.println("Nombre: ");
        String nombre = s.next();
        System.out.println("Nombre de usuario: ");
        String nickname = s.next();
        System.out.println("Correo electrónico: ");
        String email = s.next();
        System.out.println("Contraseña: ");
        String password = s.next();
        TipoUsuario rol;
        MenuRoles menuRoles = new MenuRoles();
        System.out.println("¿Qué rol le asigna?");
        System.out.println(menuRoles);
        menuRoles.setEleccion(s.nextLine().charAt(0));
        switch (menuRoles.getEleccion()) {
            case MenuRoles.OPCION_ADMINISTRADOR:
                rol = TipoUsuario.ADMINISTRADOR;
                break;
            case MenuRoles.OPCION_DESARROLLADOR:
                rol = TipoUsuario.DESARROLLADOR;
                break;
            case MenuRoles.OPCION_INVITADO:
                rol = TipoUsuario.INVITADO;
                break;
        }
        MenuConfirmacion menuConfirmacion = new MenuConfirmacion();
        System.out.println("¿Desea confirmar la operación?");
        System.out.println(menuConfirmacion);
        menuConfirmacion.setEleccion(s.nextLine().charAt(0));
        try {
            switch (menuConfirmacion.getEleccion()) {
            case MenuConfirmacion.OPCION_CONFIRMAR:
                ((Administrador) usuarioActual).agregarUsuario(nombre, nickname, email, password, rol);
                return true;
            case MenuConfirmacion.OPCION_CANCELAR:
                return false;
            }
        } catch (UsuarioExisteException uee) {
            String datoDuplicado;
            switch (uee.getDatoDuplicado()) {
                case "nickname":
                    datoDuplicado = "nombre de usuario";
                    break;
                case "email":
                    datoDuplicado = "correo electrónico";
                    break;
            }
            System.out.println("El " + datoDuplicado + " ya ha sido registrado.");
            return false;
        }
        
    }
}
