package menues;

import excepciones.IdRepetidoException;

/**
 * Representa a un menú donde se da la opción de salir o cualquier opción equivalente,
 * como <i>cancelar una operación</i>.
 * @author Brayan Montiel Ramírez.
 */
public class MenuSalida extends Menu {
    private final Opcion opcionSalida;

    @Override
    public void close() throws MenuClosedException {
        /* ----- Antes de cerrar ----- */
        try {
            addOpcion(opcionSalida);
        } catch (IdRepetidoException ire) {
            ire.printStackTrace();
            System.out.println("hint: No crear una opción con el identificador \'s\' (ya existe).");
        }
        /* ----- Antes de cerrar ----- */
        super.close();

    }
    /* ----- CONSTRUCTOR ----- */
    public MenuSalida(String etiquetaSalida) throws IdRepetidoException, MenuClosedException {
        super();
        opcionSalida = new Opcion(etiquetaSalida, 's');
    }
    /* ----- CONSTRUCTOR ----- */
}
