package menues;

import excepciones.IdRepetidoException;

/**
 * Representa a un menú donde se da la opción de <i>salir</i> o cualquier opción equivalente,
 * como <i>cancelar una operación</i>.
 * @author Brayan Montiel Ramírez.
 */
public class MenuSalida extends Menu {
    private final Opcion OPCION_SALIDA;
    public static final char IDENTIFICADOR_SALIDA = 's';

    @Override
    public void close() throws Exception {
        /* ----- Antes de cerrar ----- */
        try {
            addOpcion(OPCION_SALIDA);
        } catch (IdRepetidoException ire) {
            throw new IdRepetidoException("No se puede añadir una opción con el identificador reservado \'s\'.");
        }
        /* ----- Antes de cerrar ----- */
        super.close();

    }
    /* ----- CONSTRUCTOR ----- */
    public MenuSalida(String etiquetaSalida) {
        super();
        OPCION_SALIDA = new Opcion(etiquetaSalida, IDENTIFICADOR_SALIDA);
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- ACCESO ----- */
    public Opcion getOpcionSalida() {
        return OPCION_SALIDA;
    }
    public char getIdentificadorSalida() {
        return IDENTIFICADOR_SALIDA;
    }
    /* ----- ACCESO ----- */
}
