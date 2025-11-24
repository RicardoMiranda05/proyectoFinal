package menues;

import excepciones.IdRepetidoException;
/**
 * Es la plantilla del menú de inicio de la aplicación.
 * @author Brayan Montiel Ramírez.
 */
public class MenuInicioApp extends MenuSalida {
    public MenuInicioApp() throws IdRepetidoException, MenuClosedException {
        super("Salir");
        addOpcion("Iniciar sesión");
    }
}
