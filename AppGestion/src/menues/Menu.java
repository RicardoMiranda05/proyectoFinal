package menues;

import java.util.ArrayList;
import java.util.List;

import excepciones.IdNoEncontradoException;
import excepciones.IdRepetidoException;
/**
 * Representa el estado más básico de un menú sólo con opciones e identificadores de estas que
 * se crean de manera creciente de acuerdo al número de opciones que este tiene.
 * @author Brayan Montiel Ramírez.
 */
public class Menu {
    private List<Opcion> listaOpciones = new ArrayList<>();
    private Opcion eleccion;
    private int numOpciones;
    private boolean closed; // Cerrado significa que el menú no admite más modifaciones en su lista de opciones.
    /** NOTAS
     * Mover salida al final
     * 
     */

    
    /**
     * Cambia dos opciones de lugar en la lista de opciones de acuerdo a sus índices.
     * @param indice1
     * @param indice2
     */
    public void cambiaOpciones(int indice1, int indice2) throws IndexOutOfBoundsException, MenuClosedException {
        if (closed) {
            throw new MenuClosedException("Operación no válida: El menú ya ha sido cerrado");
        }
        if (Math.abs(indice1) > numOpciones || Math.abs(indice2) > numOpciones) {
            throw new IndexOutOfBoundsException(Math.abs(indice1) > numOpciones ? indice1 : indice2);
        }
        Opcion nuevaOpcion1 = getOpcion(indice2).clone();
        Opcion nuevaOpcion2 = getOpcion(indice1).clone();
        listaOpciones.set(indice1, nuevaOpcion1);
        listaOpciones.set(indice2, nuevaOpcion2);
    }
    /**
     * Agrega una opción a la lista de opciones con la etiqueta que pasa como parámetro y
     * el identificador dado.
     * @param etiqueta
     * @param identificador
     */
    public void addOpcion(String etiqueta, char identificador) throws IdRepetidoException, MenuClosedException {
        if (closed) {
            throw new MenuClosedException("Operación no válida: El menú ya ha sido cerrado");
        }
        if (hasOpcion(identificador)) {
            throw new IdRepetidoException("Ya existe una opción con el identificador \"" + identificador + "\"");
        }
        numOpciones++;
        listaOpciones.add(new Opcion(etiqueta, identificador));
    }
    /**
     * Agrega una opción a la lista de opciones con la etiqueta que pasa como parámetro.
     * @param etiqueta : Etiqueta de la opción que se agrega.
     */
    public void addOpcion(String etiqueta) throws MenuClosedException {
        if (closed) {
            throw new MenuClosedException("Operación no válida: El menú ya ha sido cerrado");
        }
        numOpciones++;
        listaOpciones.add(new Opcion(etiqueta, Character.forDigit(numOpciones, 10)));
    }
    /**
     * Agrega una opción a la lista de opciones.
     * @param opcion : Opción que se agrega.
     */
    public void addOpcion(Opcion opcion) throws IdRepetidoException, MenuClosedException {
        if (closed) {
            throw new MenuClosedException("Operación no válida: El menú ya ha sido cerrado");
        }
        if (hasOpcion(opcion.getIdentificador())) {
            throw new IdRepetidoException("Ya existe la opción");
        }
        numOpciones++;
        listaOpciones.add(opcion);
    }
    /**
     * Verifica si existe una opción con un identificador dado.
     * @param identificador : Identificador de la opción que se busca saber si existe.
     * @return : {@code true} si el menú tiene la opción y {@code false} si no.
     */
    public boolean hasOpcion(char identificador) {
        for (Opcion opcion : listaOpciones) {
            if (opcion.getIdentificador() == identificador) {
                return true;
            }
        }
        return false;
    }
    /**
     * Extrae una opción con el identificador dado.
     * @param identificador : Índice de la opción en la lista.
     * @return : La opción con el identificador. 
     */
    public Opcion getOpcion(char identificador) throws IdNoEncontradoException {
        for (Opcion opcion : listaOpciones) {
            if (opcion.getIdentificador() == identificador) {
                return opcion;
            }
        }
        throw new IdNoEncontradoException("La opción con el identificador \"" +  identificador + "\" no existe.");
    }
    /**
     * Extrae una opción de la lista de opciones.
     * @param i : Índice de la opción en la lista.
     * @return : La opción con el índice {@code i}.
     */
    public Opcion getOpcion(int i) throws IndexOutOfBoundsException {
        if (Math.abs(i) > numOpciones) {
            throw new IndexOutOfBoundsException(i);
        }
        return listaOpciones.get(i);
    }
    /* ----- CONSTRUCTOR ----- */
    public Menu() {
        super();
        listaOpciones = new ArrayList<>();
        numOpciones = 0;
        closed = false;
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- ACCESO ----- */
    public Opcion getEleccion() {
        return eleccion;
    }
    /**
     * Establece la elección por el identificador que pasa por parámetro.
     * @param identificador
     * @throws IdNoEncontradoException
     */
    public void setEleccion(char identificador) throws IdNoEncontradoException {
        for (Opcion opcion : listaOpciones) {
            if (opcion.getIdentificador() == identificador) {
                eleccion = opcion;
                return;
            }
        }
        throw new IdNoEncontradoException("La opción con el identificador " + identificador + " no ha sido hallada." );
    }
    public void setEleccion(Opcion eleccion) {
        this.eleccion = eleccion;
    }
    public List<Opcion> getListaOpciones() {
        return listaOpciones;
    }
    public void setListaOpciones(List<Opcion> listaOpciones) throws MenuClosedException{
        if (closed) {
            throw new MenuClosedException("Operación no válida: El menú ya ha sido cerrado");
        }
        this.listaOpciones = listaOpciones;
    }
    public int getNumOpciones() {
        return numOpciones;
    }
    public boolean isClosed() {
        return closed;
    }
    public void close() throws MenuClosedException {
        if (closed) {
            throw new MenuClosedException("El menú ya ha sido cerrado anteriormente.");
        }
        closed = true;
    }
    /* ----- ACCESO ----- */
    /* ----- UTILERÍA ----- */
    @Override
    public String toString() throws MenuNotClosedException {
        if (!closed) {
            throw new MenuNotClosedException("El menú no ha sido cerrado antes de ser impreso.");
        }
        String salida = "";
        for (int i = 0; i < numOpciones; i++) {
            salida += getOpcion(i).getIdentificador() + ") " + getOpcion(i) + (i == numOpciones -1 ? "." : ".\n");
        }
        return salida;
    }
    /* ----- UTILERÍA ----- */  
}
