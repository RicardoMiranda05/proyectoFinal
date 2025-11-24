package menues;

import excepciones.IdRepetidoException;

public class MenuInicio extends MenuSalida {
    public MenuInicio() throws IdRepetidoException, MenuClosedException {
        super("Salir");
        addOpcion("Iniciar sesión");
    }
}
