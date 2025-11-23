package recursos;

import java.util.ArrayList;
import java.util.List;

public class MenuAlt {
    private List<Opcion> listaOpciones;
    private Opcion eleccion;
    
    /**
     * Agrega una opción a la lista de opciones.
     * @param opcion : Opción que se agrega.
     */
    public void addOpcion(Opcion opcion) {
        listaOpciones.add(opcion);
    }
    /**
     * Extrae una opción de la lista de opciones.
     * @param i : Índice de la opción en la lista.
     * @return : La opción con el índice {@code i}.
     */
    public Opcion getOpcion(int i) {
        return listaOpciones.get(i);
    }
    /* ----- CONSTRUCTOR ----- */
    public MenuAlt() {
        listaOpciones = new ArrayList<>();
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- ACCESO ----- */
    public Opcion getEleccion() {
        return eleccion;
    }
    public void setEleccion(Opcion eleccion) {
        this.eleccion = eleccion;
    }
    public List<Opcion> getListaOpciones() {
        return listaOpciones;
    }
    public void setListaOpciones(List<Opcion> listaOpciones) {
        this.listaOpciones = listaOpciones;
    }
    /* ----- ACCESO ----- */

}
