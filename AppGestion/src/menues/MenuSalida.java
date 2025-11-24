package menues;

import excepciones.IdRepetidoException;

/**
 * Representa a un menú donde se da la opción de <i>salir</i> o cualquier opción equivalente,
 * como <i>cancelar una operación</i>.
 * @author Brayan Montiel Ramírez.
 */
public class MenuSalida extends Menu {
    private final Opcion opcionSalida;
    public static final char identificadorSalida = 's';

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
        opcionSalida = new Opcion(etiquetaSalida, identificadorSalida);
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- ACCESO ----- */
    public Opcion getOpcionSalida() {
        return opcionSalida;
    }
    public char getIdentificadorSalida() {
        return identificadorSalida;
    }
    /* ----- ACCESO ----- */
}
