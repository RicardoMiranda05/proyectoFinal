package estados;

import java.util.Scanner;
/**
 * Estado que se ejecuta cuando el usuario decide salir de la aplicación.
 * @author Brayan Montiel Ramírez.
 */
public class EstadoSalir extends Estado {
    
    public Estado ejecutar(Scanner s) {
        return new EstadoSalir();
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoSalir() {
        super(EstadosApp.SALIR);
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- UTILERÍA ----- */
    @Override
    public String toString() {
        return "EstadoSalida []";
    }
    /* ----- UTILERÍA ----- */
}
