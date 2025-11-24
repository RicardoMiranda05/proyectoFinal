package menues;

public class Opcion {
    private final String etiqueta;
    private char identificador;
    /* ----- CONSTRUCTOR ----- */
    public Opcion(String etiqueta, char identificador) {
        this.etiqueta = etiqueta;
        this.identificador = identificador;
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- ACCESO ----- */
    public String getEtiqueta() {
        return etiqueta;
    }
    public char getIdentificador() {
        return identificador;
    }
    public void setIdentificador(char identificador) {
        this.identificador = identificador;
    }
    /* ----- ACCESO ----- */
    /* ----- UTILERÍA ----- */
    @Override
    public String toString() {
        return etiqueta;
    }
    public boolean equals(Opcion obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Opcion))
            return false;
        if (identificador != obj.identificador)
            return false;
        return true;
    }
    /**
     * Clona este opción con una nueva etiqueta.
     * @param nuevaEtiqueta : Nueva etiqueta para la opción clonada.
     * @return Una opción idéntica a esta pero con una etiqueta nueva.
     */
    public Opcion clone(String nuevaEtiqueta) {
        return new Opcion(nuevaEtiqueta, identificador);
    }
    public Opcion clone() {
        return new Opcion(etiqueta, identificador);
    }
    /*  En el menú nos interesa que las opciones se comparen como objetos, por eso no
        colocamos el método equals */
    /* ----- UTILERÍA ----- */
    
}
