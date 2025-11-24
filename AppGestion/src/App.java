import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import menues.Menu;
import recursos.*;
import tareas.*;
import usuarios.*;
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
        String[] etiquetas = {"Desplegar mis tareas",
                                "Filtrar mis tareas por estado",
                                "Actualizar mis tareas",
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

class MenuFiltroAdmin extends Menu {
    public static final char OPCION_POR_ESTADO = '1';
    public static final char OPCION_POR_USUARIO = '2';
    public static final char CANCELAR_OPERACION = '3';
    /* ----- CONSTRUCTOR ----- */
    public MenuFiltroAdmin () {
        super(getDiccionarioOpciones());
        
    }
    /**
     * Construye el diccionario de opciones para este menú.
     * @return El diccionario de opciones del menú.
     */
    private static Diccionario<Character,String> getDiccionarioOpciones() {
        Character[] selecciones = {OPCION_POR_ESTADO,
                                    OPCION_POR_USUARIO,
                                    CANCELAR_OPERACION};
        String[] etiquetas = {"Por estado",
                                "Por usuario",
                                "Cancelar Operación"};
        return new Diccionario<>(selecciones, etiquetas);
    }
    /* ----- CONSTRUCTOR ----- */
}
class MenuEstado extends Menu {
    public static final char OPCION_PENDIENTE = '1';
    public static final char OPCION_EN_CURSO = '2';
    public static final char OPCION_COMPLETADA = '3';
    /* ----- CONSTRUCTOR ----- */
    public MenuEstado () {
        super(getDiccionarioOpciones());
        
    }
    /**
     * Construye el diccionario de opciones para este menú.
     * @return El diccionario de opciones del menú.
     */
    private static Diccionario<Character,String> getDiccionarioOpciones() {
        Character[] selecciones = {OPCION_PENDIENTE,
                                    OPCION_EN_CURSO,
                                    OPCION_COMPLETADA};
        String[] etiquetas = {"Pendiente",
                                "En curso",
                                "Completada"};
        return new Diccionario<>(selecciones, etiquetas);
    }
    /* ----- CONSTRUCTOR ----- */
}

class MenuActualizacionAdmin extends Menu {
    public static final char OPCION_ESTADO = '1';
    public static final char OPCION_USUARIO = '2';
    public static final char OPCION_DESCRIPCION = '3';
    public static final char OPCION_FECHA_INICIO = '4';
    public static final char OPCION_FECHA_FIN = '5';
    /* ----- CONSTRUCTOR ----- */
    public MenuActualizacionAdmin () {
        super(getDiccionarioOpciones());
        
    }
    /**
     * Construye el diccionario de opciones para este menú.
     * @return El diccionario de opciones del menú.
     */
    private static Diccionario<Character,String> getDiccionarioOpciones() {
        Character[] selecciones = {OPCION_ESTADO,
                                    OPCION_USUARIO,
                                    OPCION_DESCRIPCION,
                                    OPCION_FECHA_INICIO,
                                    OPCION_FECHA_FIN};
        String[] etiquetas = {"Estado",
                                "Usuario al que le pertenece",
                                "Descripción",
                                "Fecha estimada de inicio",
                                "Fecha estimada de fin"};
        return new Diccionario<>(selecciones, etiquetas);
    }
    /* ----- CONSTRUCTOR ----- */
}
class MenuActualizacionDes extends Menu {
    public static final char OPCION_ESTADO = '1';
    public static final char OPCION_DESCRIPCION = '2';
    public static final char OPCION_FECHA_INICIO = '3';
    public static final char OPCION_FECHA_FIN = '4';
    /* ----- CONSTRUCTOR ----- */
    public MenuActualizacionDes () {
        super(getDiccionarioOpciones());
        
    }
    /**
     * Construye el diccionario de opciones para este menú.
     * @return El diccionario de opciones del menú.
     */
    private static Diccionario<Character,String> getDiccionarioOpciones() {
        Character[] selecciones = {OPCION_ESTADO,
                                    OPCION_DESCRIPCION,
                                    OPCION_FECHA_INICIO,
                                    OPCION_FECHA_FIN};
        String[] etiquetas = {"Estado",
                                "Descripción",
                                "Fecha estimada de inicio",
                                "Fecha estimada de fin"};
        return new Diccionario<>(selecciones, etiquetas);
    }
    /* ----- CONSTRUCTOR ----- */
}
public class App {
    public static final String listaTareas_dir = "\\src\\archivos\\lista_tareas.dat";
    public static final String listaUsuarios_dir = "\\src\\archivos\\usuarios.dat";
    public static Usuario usuarioActual; // El usuario que corre la App.
    public static ListaTareas listaTareas = ListaTareas.cargarDesdeArchivo(listaTareas_dir);
    public static List<Usuario> listaUsuarios = cargarDesdeArchivo(listaUsuarios_dir);
    public static EstadosApp estadoActual;
    public static final EstadosApp estadoIncial = EstadosApp.INICIO; 
    @SuppressWarnings("incomplete-switch")
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
                /* ----- CAMBIO DE ESTADO ----- */
                case EstadosApp.INICIO_SESION:
                    if (validaCredenciales(s)) {
                        System.out.println("Credenciales válidas." +
                                            "\n¡Bienvenido" + usuarioActual.getNickname() + "!");
                        estadoActual = EstadosApp.USO_GENERAL;
                    } else {
                        System.out.println("Las credenciales ingresadas no son válidas.");
                        /* Se pregunta si se quiere repetir la operación */
                        if (!repetirOperacion(s)) {
                            estadoActual = EstadosApp.INICIO;
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
                    /* ----- CAMBIO DE ESTADO ----- */
                    if (agregaUsuario(s)) {
                        System.out.println("Se ha agregado con éxito al usuario.");
                        estadoActual = EstadosApp.USO_GENERAL;
                    /* Se pregunta si se quiere repetir la operación */
                    } else if (!repetirOperacion(s)) {
                        estadoActual = EstadosApp.USO_GENERAL;
                    }
                    break;
                case EstadosApp.CREAR_TAREA:
                    switch (usuarioActual.getTipo()) {
                        case TipoUsuario.ADMINISTRADOR:
                            boolean repetirOperacion;
                            do {
                                repetirOperacion = false;
                                System.out.println("Ingrese el nombre de usuario del usuario al que se le asignará esta tarea: ");
                                String nickname = s.nextLine(); // TODO: manejo de excepciones
                                /* ----- CAMBIO DE ESTADO ----- */
                                if (crearTareaPara(s, nickname)) {
                                    System.out.println("Tarea creada con éxito.");
                                    // TODO: OPCIONAL, hacer código para dar la opción de repetir crear
                                } else {
                                    System.out.println("No se pudo crear la tarea.");
                                    if (!repetirOperacion(s)) {
                                        repetirOperacion = true;
                                    }
                                }
                            } while (repetirOperacion);
                            break;
                        case TipoUsuario.DESARROLLADOR:
                            boolean repetirOperacion_;
                            do {
                                repetirOperacion_ = false;
                                if (crearTareaParaMi(s)) {
                                    System.out.println("Tarea creada con éxito.");
                                    // TODO: OPCIONAL, hacer código para repetir operación
                                estadoActual = EstadosApp.USO_GENERAL;
                                } else {
                                    System.out.println("No se pudo crear la tarea.");
                                    if (!repetirOperacion(s)) {
                                        estadoActual = EstadosApp.USO_GENERAL;
                                    }
                                }
                            } while (repetirOperacion_);
                            break;
                    }
                    break;
                case EstadosApp.DESPLEGAR_TAREAS:
                    switch (usuarioActual.getTipo()) {
                        case TipoUsuario.ADMINISTRADOR:
                            listaTareas.listarTodas();
                            break;
                        case TipoUsuario.DESARROLLADOR:
                            listaTareas.listarPorUsuario(usuarioActual);
                            break;
                        case TipoUsuario.INVITADO:
                            listaTareas.listarTodas();
                            break;
                    }
                    estadoActual = EstadosApp.USO_GENERAL;
                    break;
                case EstadosApp.FILTRAR_TAREAS:
                    switch (usuarioActual.getTipo()) {
                        case TipoUsuario.ADMINISTRADOR:
                            System.out.println("Indique el tipo de filtro de búsqueda:");
                            MenuFiltroAdmin menuFiltroAdmin = new MenuFiltroAdmin();
                            System.out.println(menuFiltroAdmin);
                            menuFiltroAdmin.setEleccion(s.nextLine().charAt(0)); // TODO: manejo de excepciones
                            switch (menuFiltroAdmin.getEleccion()) {
                                case MenuFiltroAdmin.OPCION_POR_ESTADO:
                                    System.out.println("Seleccione el estado:");
                                    EstadoTarea estadoTarea = getEleccionEstado(s); // TODO: manejo de excepciones
                                    listaTareas.listarPorEstado(estadoTarea);
                                    break;
                                case MenuFiltroAdmin.OPCION_POR_USUARIO:
                                    boolean repetirOperacion;
                                    do {
                                        repetirOperacion = false;
                                        System.out.println("Ingrese el nombre de usuario:");
                                        String nickname = s.nextLine(); // TODO: manejo de excepciones
                                        Usuario usuarioDestino = getUsuario(nickname);
                                        /* ----- CAMBIO DE ESTADO ----- */
                                        if (usuarioDestino != null) {
                                            listaTareas.listarPorUsuario(usuarioDestino);
                                        } else if (repetirOperacion(s)) {
                                            repetirOperacion = true;
                                        }
                                    } while (repetirOperacion);
                                    estadoActual = EstadosApp.USO_GENERAL;
                                    break;
                                case MenuFiltroAdmin.CANCELAR_OPERACION:
                                    estadoActual = EstadosApp.USO_GENERAL;
                                    break;
                            }
                            break;
                        case TipoUsuario.DESARROLLADOR:
                            EstadoTarea estadoTarea = getEleccionEstado(s);
                            listaTareas.listarPorEstado(estadoTarea);
                            break;
                        case TipoUsuario.INVITADO:
                            // TODO: Filtrar por estado.
                            // TODO: Filtrar por usuario.
                            // TODO: Cambio de estado.
                            break;
                    }
                    break;
                case EstadosApp.ACTUALIZAR_TAREAS:
                    switch (usuarioActual.getTipo()) {
                        case TipoUsuario.ADMINISTRADOR:
                            System.out.println("Ingrese el id de la tarea que desea modificar");
                            String id = s.nextLine(); //TODO: manejo de excepciones
                            listaTareas.imprimeTarea(id);
                            MenuActualizacionAdmin menuActAdmin = new MenuActualizacionAdmin();
                            System.out.println(menuActAdmin);
                            System.out.println("¿Qué desea modificar?");
                            menuActAdmin.setEleccion(s.nextLine().charAt(0)); //TODO: manejo de excepciones
                            switch (menuActAdmin.getEleccion()) {
                                case MenuActualizacionAdmin.OPCION_ESTADO:
                                    System.out.println("¿A qué estado pasará la tarea?");
                                    EstadoTarea nuevoEstado = getEleccionEstado(s); // TODO: manejo de excepciones
                                    listaTareas.cambiarEstado(usuarioActual, id, nuevoEstado); // TODO: manejo de excepciones
                                    break;
                                case MenuActualizacionAdmin.OPCION_USUARIO:
                                    System.out.println("Ingrese el nickname del usuario al que le será asignada:");
                                    String nickname = s.nextLine(); //TODO: manejo de excepciones
                                    Usuario nuevoUsuario = getUsuario(nickname); // TODO: manejo de excepciones
                                    if (nuevoEstado != null) {
                                        System.out.println("La tarea ha sido reasignada a " + nuevoUsuario.getNickname());
                                        listaTareas.cambiarUsuarioAsignado(usuarioActual, id, nuevoUsuario);
                                    }
                                    break;
                                case MenuActualizacionAdmin.OPCION_DESCRIPCION:
                                    System.out.println("Ingrese la nueva descripción:");
                                    String nuevDescripcion = s.nextLine(); // TODO: manejo de excepciones
                                    listaTareas.actualizarDescripcion(usuarioActual, id, nuevDescripcion); // TODO: manejo de excepciones
                                    break;
                                case MenuActualizacionAdmin.OPCION_FECHA_INICIO:
                                    System.out.println("Ingrese la nueva fecha estimada de inicio:");
                                    String nuevaFechaInicio = s.nextLine(); // TODO: manejo de excepciones
                                    listaTareas.actualizarFechaEstimadaInicio(nuevoUsuario, id, nuevaFechaInicio);// TODO: manejo de excepciones
                                    break;
                                case MenuActualizacionAdmin.OPCION_FECHA_FIN:
                                    System.out.println("Ingrese la nueva fecha estimada de inicio:");
                                    String nuevaFechaFin = s.nextLine(); // TODO: manejo de excepciones
                                    listaTareas.actualizarFechaEstimadaFin(nuevoUsuario, id, nuevaFechaFin);// TODO: manejo de excepciones
                                    break;
                            }
                            break;
                        case TipoUsuario.DESARROLLADOR:
                            System.out.println("Ingrese el id de la tarea que desea modificar");
                            String id_ = s.nextLine(); //TODO: manejo de excepciones de entrada y de DEV accediendo a tareas de otros
                            MenuActualizacionDes menuActDes = new MenuActualizacionDes();
                            System.out.println(menuActDes);
                            System.out.println("¿Qué desea modificar?");
                            menuActAdmin.setEleccion(s.nextLine().charAt(0)); //TODO: manejo de excepciones
                            switch (menuActAdmin.getEleccion()) {
                                case MenuActualizacionAdmin.OPCION_ESTADO:
                                    System.out.println("¿A qué estado pasará la tarea?");
                                    EstadoTarea nuevoEstado = getEleccionEstado(s); // TODO: manejo de excepciones
                                    listaTareas.cambiarEstado(usuarioActual, id_, nuevoEstado); // TODO: manejo de excepciones
                                    break;
                                case MenuActualizacionAdmin.OPCION_DESCRIPCION:
                                    System.out.println("Ingrese la nueva descripción:");
                                    String nuevDescripcion = s.nextLine(); // TODO: manejo de excepciones
                                    listaTareas.actualizarDescripcion(usuarioActual, id_, nuevDescripcion); // TODO: manejo de excepciones
                                    break;
                                case MenuActualizacionAdmin.OPCION_FECHA_INICIO:
                                    System.out.println("Ingrese la nueva fecha estimada de inicio:");
                                    String nuevaFechaInicio = s.nextLine(); // TODO: manejo de excepciones
                                    listaTareas.actualizarFechaEstimadaInicio(usuarioActual, id_, nuevaFechaInicio);// TODO: manejo de excepciones
                                    break;
                                case MenuActualizacionAdmin.OPCION_FECHA_FIN:
                                    System.out.println("Ingrese la nueva fecha estimada de inicio:");
                                    String nuevaFechaFin = s.nextLine(); // TODO: manejo de excepciones
                                    listaTareas.actualizarFechaEstimadaFin(usuarioActual, id_, nuevaFechaFin);// TODO: manejo de excepciones
                                    break;
                            }
                            break;
                            // TODO: Modificar estado de sus tareas.
                            // TODO: Modificar descripción de sus tareas.
                            // TODO: Modificar fecha estimada de inicio de sus tareas.
                            // TODO: Modificar fecha estimada de fin de sus tareas.
                            break;
                    }
                    break;
                case EstadosApp.ELIMINAR_TAREAS:
                    // TODO: Eliminar tareas.
                    break;
                case EstadosApp.CERRAR_SESION:
                    System.out.println("¡Hasta luego " +  usuarioActual.getNickname() + "!");
                    estadoActual = EstadosApp.INICIO_SESION;
                    break;
            }
        } while (!estadoActual.equals(EstadosApp.SALIR));
        s.close();
    }
    public static boolean modificarTarea(Scanner s) {
        System.out.println("Ingrese el id de la tarea que desea modificar");
        String id = s.nextLine(); //TODO: manejo de excepciones
        listaTareas.imprimeTarea(id);
        if (usuarioActual.getTipo().equals(TipoUsuario.ADMINISTRADOR)) {
            MenuActualizacionAdmin menuActAdmin = new MenuActualizacionAdmin();
            System.out.println(menuActAdmin);
            System.out.println("¿Qué desea modificar?");
            menuActAdmin.setEleccion(s.nextLine().charAt(0)); //TODO: manejo de excepciones
            switch (menuActAdmin.getEleccion()) {
                case MenuActualizacionAdmin.OPCION_ESTADO:
                    System.out.println("¿A qué estado pasará la tarea?");
                    EstadoTarea nuevoEstado = getEleccionEstado(s); // TODO: manejo de excepciones
                    listaTareas.cambiarEstado(usuarioActual, id, nuevoEstado); // TODO: manejo de excepciones
                    break;
                case MenuActualizacionAdmin.OPCION_USUARIO:
                    System.out.println("Ingrese el nickname del usuario al que le será asignada:");
                    String nickname = s.nextLine(); //TODO: manejo de excepciones
                    Usuario nuevoUsuario = getUsuario(nickname); // TODO: manejo de excepciones
                    if (nuevoEstado != null) {
                        System.out.println("La tarea ha sido reasignada a " + nuevoUsuario.getNickname());
                        listaTareas.cambiarUsuarioAsignado(usuarioActual, id, nuevoUsuario);
                    }
                    break;
                case MenuActualizacionAdmin.OPCION_DESCRIPCION:
                    System.out.println("Ingrese la nueva descripción:");
                    String nuevDescripcion = s.nextLine(); // TODO: manejo de excepciones
                    listaTareas.actualizarDescripcion(usuarioActual, id, nuevDescripcion); // TODO: manejo de excepciones
                    break;
                case MenuActualizacionAdmin.OPCION_FECHA_INICIO:
                    System.out.println("Ingrese la nueva fecha estimada de inicio:");
                    String nuevaFechaInicio = s.nextLine(); // TODO: manejo de excepciones
                    listaTareas.actualizarFechaEstimadaInicio(nuevoUsuario, id, nuevaFechaInicio);// TODO: manejo de excepciones
                    break;
                case MenuActualizacionAdmin.OPCION_FECHA_FIN:
                    System.out.println("Ingrese la nueva fecha estimada de inicio:");
                    String nuevaFechaFin = s.nextLine(); // TODO: manejo de excepciones
                    listaTareas.actualizarFechaEstimadaFin(nuevoUsuario, id, nuevaFechaFin);// TODO: manejo de excepciones
                    break;
        } else {
            System.out.println("Ingrese el id de la tarea que desea modificar");
            String id_ = s.nextLine(); //TODO: manejo de excepciones de entrada y de DEV accediendo a tareas de otros
            MenuActualizacionDes menuActDes = new MenuActualizacionDes();
            System.out.println(menuActDes);
            System.out.println("¿Qué desea modificar?");
            menuActDes.setEleccion(s.nextLine().charAt(0)); //TODO: manejo de excepciones
            switch (menuActDes.getEleccion()) {
                case MenuActualizacionDes.OPCION_ESTADO:
                    System.out.println("¿A qué estado pasará la tarea?");
                    EstadoTarea nuevoEstado = getEleccionEstado(s); // TODO: manejo de excepciones
                    listaTareas.cambiarEstado(usuarioActual, id_, nuevoEstado); // TODO: manejo de excepciones
                    break;
                case MenuActualizacionDes.OPCION_DESCRIPCION:
                    System.out.println("Ingrese la nueva descripción:");
                    String nuevDescripcion = s.nextLine(); // TODO: manejo de excepciones
                    listaTareas.actualizarDescripcion(usuarioActual, id_, nuevDescripcion); // TODO: manejo de excepciones
                    break;
                case MenuActualizacionDes.OPCION_FECHA_INICIO:
                    System.out.println("Ingrese la nueva fecha estimada de inicio:");
                    String nuevaFechaInicio = s.nextLine(); // TODO: manejo de excepciones
                    listaTareas.actualizarFechaEstimadaInicio(usuarioActual, id_, nuevaFechaInicio);// TODO: manejo de excepciones
                    break;
                case MenuActualizacionDes.OPCION_FECHA_FIN:
                    System.out.println("Ingrese la nueva fecha estimada de inicio:");
                    String nuevaFechaFin = s.nextLine(); // TODO: manejo de excepciones
                    listaTareas.actualizarFechaEstimadaFin(usuarioActual, id_, nuevaFechaFin);// TODO: manejo de excepciones
                    break;
            }
        }
        break;
    }
    /**
     * Crea un menú para que el usuario ingrese el estado de la tarea de interés.
     * @param s Teclado con el que se comunica el usuario.
     * @return El estado de tarea de interés del usuario.
     */
    public static EstadoTarea getEleccionEstado(Scanner s) {
        MenuEstado menuEstado = new MenuEstado();
        menuEstado.setEleccion(s.nextLine().charAt(0)); // TODO: manejo de excepciones.
        switch (menuEstado.getEleccion()) {
            case MenuEstado.OPCION_PENDIENTE:
                return EstadoTarea.PENDIENTE;
            case MenuEstado.OPCION_EN_CURSO:
                return EstadoTarea.EN_CURSO;
            case MenuEstado.OPCION_COMPLETADA:
                return EstadoTarea.COMPLETADA;
            default:
                return null; //TODO: lanzar error "Estado no existe"
        }
    }
    /**
     * Crea una tarea para sí mismo.
     * @param s
     * @param nickname
     * @return
     */
    public static boolean crearTareaParaMi(Scanner s) {
        System.out.println("Ingrese la descripción de la tarea: ");
        String descripcion = s.nextLine(); // TODO: manejo de excepciones
        System.out.println("Ingrese la fecha estimada de inicio: ");
        String fechaEstimadaInicio = s.nextLine(); // TODO: manejo de excepciones
        System.out.println("Ingrese la fecha estimada de fin: ");
        String fechaEstimadaFin = s.nextLine(); // TODO: manejo de excepciones
        ((Administrador) usuarioActual).crearTareaParaMi(/*Otros parámetros a considerar*/descripcion, fechaEstimadaInicio, fechaEstimadaFin); // TODO: manejo de excepciones
        /* TODO: código para volver a intentar o cancelar operación */
    }
    /**
     * Crea una tarea para un usuario igual o diferente a quien la está creando.
     * @param s
     * @param nickname
     * @return
     */
    public static boolean crearTareaPara(Scanner s, String nickname) {
        Usuario usuarioDestino = getUsuario(nickname);
        if (usuarioDestino != null) {
            System.out.println("Ingrese la descripción de la tarea: ");
            String descripcion = s.nextLine(); // TODO: manejo de excepciones
            System.out.println("Ingrese la fecha estimada de inicio: ");
            String fechaEstimadaInicio = s.nextLine(); // TODO: manejo de excepciones
            System.out.println("Ingrese la fecha estimada de fin: ");
            String fechaEstimadaFin = s.nextLine(); // TODO: manejo de excepciones
            ((Administrador) usuarioActual).crearTarea(/*Otros parámetros a considerar*/usuarioDestino, descripcion, fechaEstimadaInicio, fechaEstimadaFin); // TODO: manejo de excepciones
            /* TODO: código para volver a intentar o cancelar operación */
        }
    }
    /**
     * Encuentra al usuario con el nickname que pasa como parámetro.
     * @param nickname Nombre de usuario del usuario que se busca.
     * @return Al usuario si este existe y {@code null} si no.
     */
    @SuppressWarnings("unchecked")
    public static Usuario getUsuario(String nickname) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNickname().equals(nickname)) {
                return usuario;
            }
        }
        return null;
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
        TipoUsuario rol = null;
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
        try {
            if (usuarioConfirma(s)) {
                ((Administrador) usuarioActual).agregarUsuario(nombre, nickname, email, password, rol);
                return true; // <--- Si se añade.
            }
        } catch (UsuarioExisteException uee) {
            String datoDuplicado = "";
            switch (uee.getDatoDuplicado()) {
                case "nickname":
                    datoDuplicado = "nombre de usuario \"" + nickname + "\"";
                    break;
                case "email":
                    datoDuplicado = "correo electrónico \"" + email + "\"";
                    break;
            }
            System.out.println("El " + datoDuplicado + " " + 
                                (datoDuplicado == "nickname" ? nickname : email ) + 
                                " ya ha sido registrado.");
            // TODO: mejorar el sistema para que lo especifique en el momento donde se introdujo el dato.
        }
        return false; //<--- Si no se añade.
    }
    /**
     * Solicita al usuario confirmar la operación reciente, para mayor seguridad.
     * @param s Teclado con el que se comunica el usuario.
     * @return {@code true} si el usuario confirma y {@code false} si no.
     */
    public static boolean usuarioConfirma(Scanner s) {
        MenuConfirmacion menuConfirmacion = new MenuConfirmacion();
        System.out.println("¿Desea confirmar la operación?");
        System.out.println(menuConfirmacion);
        menuConfirmacion.setEleccion(s.nextLine().charAt(0)); // TODO: manejo de excepciones
        return menuConfirmacion.getEleccion() == MenuConfirmacion.OPCION_CONFIRMAR;
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
            for (Usuario usuario : listaUsuarios) {
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
        } catch (IOException e) {
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
    @SuppressWarnings("unchecked")
    /**
     * Carga la lista de usuarios desde el archivo con la ruta que pasa como parámetro.
     * @param ruta Ruta del archivo de usuarios.
     * @return Lista de usuarios del archivo.
     */
    public static ArrayList<Usuario> cargarDesdeArchivo(String ruta) {
        File f = new File(ruta);
        if (!f.exists()) {
            return new ArrayList<Usuario>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Object obj = ois.readObject();
            ois.close();
            if (obj instanceof ArrayList<?>) {
                return (ArrayList<Usuario>) obj;
            }
        } catch (Exception e) {
            System.out.println("No se pudo cargar la lista de usuarios. Se iniciará una nueva. Detalle: " + e.getMessage());
        }
        return new ArrayList<Usuario>();
    }
}
