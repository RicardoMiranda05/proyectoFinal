package estados;

import java.util.NoSuchElementException;
import java.util.Scanner;

import excepciones.*;
import menues.MenuClosedException;
import menues.MenuSalida;
import recursos.InvalidCharException;
import recursos.ScannerHelper;
/**
 * Es la plantilla del menú de inicio de la aplicación.
 * @author Brayan Montiel Ramírez.
 */
class MenuInicioApp extends MenuSalida {
    public MenuInicioApp() throws IdRepetidoException {
        super("Salir");
        try {
            addOpcion("Iniciar sesión");
        } catch (MenuClosedException mce) {
            System.out.println("Esta excepción no debería ocurrir." +
                                "\nhint: Revisa si hay un error en el método close de sus padres.");
            mce.printStackTrace();
        }
        
    }
}
/**
 * Estado de inicio de la App.
 * @author Brayan Montiel Ramírez.
 */
public class EstadoInicioApp extends Estado {
    
    public Estado ejecutar(Scanner s) throws Exception {
        MenuInicioApp menuInicio = new MenuInicioApp();
        menuInicio.close();
        MetodosGenerales.solicitaEntrada(s, menuInicio, "Seleccione la opción deseada: ");
        /* ----- CAMBIO DE ESTADO ----- */
        switch (menuInicio.getEleccion().getIdentificador()) {
            case '1':
                return new EstadoInicioSesion();
            case MenuInicioApp.IDENTIFICADOR_SALIDA:
                return new EstadoSalir();
            default:
                throw new Exception();
        }
    }
    /* ----- CONSTRUCTOR ----- */
    public EstadoInicioApp() {
        super(EstadosApp.INICIO_APP);
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- UTILERÍA ----- */
    @Override
    public String toString() {
        return "EstadoInicioApp []";
    }
    /* ----- UTILERÍA ----- */
}
