package estados;

import java.util.NoSuchElementException;
import java.util.Scanner;

import excepciones.IdNoEncontradoException;
import menues.MenuInicioApp;
import recursos.InvalidCharException;
import recursos.ScannerHelper;
/**
 * Estado de inicio de la App.
 * @author Brayan Montiel Ramírez.
 */
public class EstadoInicioApp extends Estado {
    
    public Estado ejecutar(Scanner s) throws Exception {
        MenuInicioApp menuInicio = new MenuInicioApp();
        menuInicio.close();
        while (true) {
            try {
                System.out.println();
                System.out.println("Seleccione la opción deseada: ");
                System.out.println(menuInicio);
                System.out.println();
                char identificador = ScannerHelper.leerChar(s);
                menuInicio.setEleccion(identificador);
                break;
            } catch (InvalidCharException | NoSuchElementException | IdNoEncontradoException e) {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        /* ----- CAMBIO DE ESTADO ----- */
        switch (menuInicio.getEleccion().getIdentificador()) {
            case '1':
                return new EstadoInicioSesion();
            case MenuInicioApp.identificadorSalida:
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
