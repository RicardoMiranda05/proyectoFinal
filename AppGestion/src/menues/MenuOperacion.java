package menues;

/**
 * Es un menú que permite dos operaciones: volver a intentar la última operación
 * o cancelar la operación.
 * @author Brayan Montiel Ramírez.
 */
public class MenuOperacion extends MenuSalida {
    public MenuOperacion() throws MenuClosedException {
        super("Cancelar operación");
        addOpcion("Volver a intentar");
    }
}
