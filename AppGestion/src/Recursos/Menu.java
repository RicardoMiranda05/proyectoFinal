package recursos;
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
 */

/**
 * Esta clase se encarga de manejar cada tipo diferente de menú que sale en pantalla,
 * ya sea para iniciar sesión, elegir el modo de ingreso del usuario a la app, etc. 
 */
public class Menu {
    public static final char OPCION_SALIR = 's';
    private final String INDICACIONES;
    private final Diccionario<Character,String> OPCIONES;

    private char eleccion;

    /* ----- CONSTRUCTOR ----- */
    public Menu (Diccionario<Character, String> opciones) {
        super();
        INDICACIONES = "Seleccione una de las siguientes opciones:";
        this.OPCIONES = opciones;
    }
    public Menu (String indicaciones, Diccionario<Character, String> opciones) {
        super();
        INDICACIONES = indicaciones;
        this.OPCIONES = opciones;
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- ACCESO ----- */
    public String getIndicaciones() {
        return INDICACIONES;
    }
    public void setIndicaciones(String indicaciones) {
        System.out.println("INDICACIONES no puede ser modificado.");
    }
    public Diccionario<Character, String> getOpciones() {
        return OPCIONES;
    }
    public void setOpciones(Diccionario<Character, String> opciones) {
        System.out.println("OPCIONES no puede ser modificado.");
    }
    public char getEleccion() {
        return eleccion;
    }
    public void setEleccion(char eleccion) {
        this.eleccion = eleccion;
    }
    /* ----- ACCESO ----- */
    /* ----- UTILERÍA ----- */
    @Override
    public String toString() {
        String salida = INDICACIONES + "\n";
        for (int i = 0; i < OPCIONES.getSize(); i++) {
            salida += OPCIONES.getKey(i) + ") " + OPCIONES.getValue(i) + ".\n";
        }
        return salida;
    }
    /* ----- UTILERÍA ----- */
}