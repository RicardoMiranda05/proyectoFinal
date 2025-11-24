package menues;

/**
 * Es un menú que permite dos operaciones: volver a intentar la última operación
 * o cancelar la operación.
 * @author Brayan Montiel Ramírez.
 */
public class MenuConfirmacion extends MenuSalida {
    public static final char IDENTIFICADOR_CONFIRMAR = '1';
    public static final char IDENTIFICADOR_CANCELAR = MenuSalida.IDENTIFICADOR_SALIDA; 
    /* ----- CONSTRUCTOR ----- */
    public MenuConfirmacion() {
        super("Cancelar operación");
        try {
            addOpcion("Confirmar operación");
        } catch (MenuClosedException mce) {
            System.out.println("El menú no debería estar cerrado.");
            mce.printStackTrace();
        }
    }
    /* ----- CONSTRUCTOR ----- */
}