import java.util.Scanner;

import recursos.Diccionario;
import recursos.Menu;
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

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        MenuInicio menuInicio = new MenuInicio();
        do {
            System.out.println(menuInicio);
            char eleccion = s.nextLine().charAt(0);
            menuInicio.setEleccion(eleccion);
            //TODO: hacer el manejo de excepciones por si el usuario pone algo que no toca.
            if (eleccion == MenuInicio.OPCION_INICIAR_SESION) {
                solicitarCredenciales(s);
            }
        } while (menuInicio.getEleccion() != MenuInicio.OPCION_SALIR);
        s.close();
    }
    /**
     * NOTA: Método no implementable. Se requiere el uso de persistencia de datos de usuarios.
     * Le solicita las credenciales al usuario.
     * @param s T
     * @return
     */
    public static boolean solicitarCredenciales(Scanner s) {
        System.out.println("Ingrese su correo/nickname y su contraseña.");
        System.out.println("Correo/nickname: ");
        String email = s.next(); //TODO: manejo de excepciones.
        System.out.println("Contraseña: ");
        String contraseña = s.next(); //TODO: manejo de excepciones.
        return true; // TODO: hacer la verificación correcta de que las credenciales son correctas.
    }
}
