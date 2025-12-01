package menues;

public class MenuDicotomico extends Menu {
    public static final char IDENTIFICADOR_SI = 'S';
    public static final char IDENTIFICADOR_NO = 'N';
    /* ----- CONSTRUCTOR ----- */
    public MenuDicotomico() {
        super();
        try {
            addOpcion("Sí", 'S');
            addOpcion("No", 'N');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* ----- CONSTRUCTOR ----- */
}
