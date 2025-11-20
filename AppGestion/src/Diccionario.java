/**
 * ----- Mensaje genérico -----
 * Clase administrada sólo por BRAYAN.
 * Puede modificarse por alguien más SÓLO en caso de que quiera hacer pruebas, pero debe
 * regresarse a su estado original. En caso de que no se reestablezca a su estado original,
 * el pull request será rechazado.
 * ----- Mensaje genérico -----
 * 
 * ----- Mensaje para VISITANTES -----
 * 
 * ----- Mensaje para VISITANTES -----
 * 
 * INSERTA TU PROPIO COMENTARIO DE LA CLASE.
 */
public class Diccionario<K,V> {
    private Object[] keys;
    private Object[] values;

    /**
     * Busca si el diccionario tiene el valor que pasa como parámetro.
     * @param value El valor que se busca.
     * @return true si sí tiene a value y false si no.
     */
    public boolean hasValue(V value) {
        return isObject(values, value);
    }
    /**
     * Busca si el diccionario tiene la llave que pasa como parámetro.
     * @param key La llave que se busca.
     * @return true si sí tiene a key y false si no.
     */
    public boolean hasKey(K key) {
        return isObject(keys, key);
    }
    /**
     * Busca el índice dentro del diccionario de la llave que pasa como parámetro.
     * @param key Llave cuyo índice se busca.
     * @return El índice de key o -1 si no existe dentro del diccionario. 
     */
    public int getIndice(K key) {
        return buscaIndice(keys, key);
    }
    /**
     * Busca la llave que le corresponde el valor value dentro del diccionario.
     * @param value Valor cuya llave se busca.
     * @return La llave a la que le corresponde value.
     */
    public K getKey(V value) {
        if (!isObject(values, value)) {
            return null;
        }
        return (K) values[buscaIndice(values, value)];
    }
    /**
     * Busca el valor en el diccionario de la llave que pasa como parámetro.
     * @param key Llave cuyo valor se busca.
     * @return El valor que le corresponde a la llave key.
     */
    public V getValue(K key) {
        if (!isObject(keys, key)) {
            return null;
        }
        return (V) values[buscaIndice(keys, key)];
    }
    /**
     * Ve si existe un objeto dado dentro de un arreglo.
     * @param <C> Clase a la que pertenece obj.
     * @param array Arreglo donde se busca el objeto.
     * @param obj Objeto que se busca.
     * @return true si obj está en array y false si no.
     */
    private <C> boolean isObject(C[] array, C obj) {
        return buscaIndice(array, obj) != -1;
    }
    /**
     * Busca el índice de un objeto dentro de un array.
     * @param <C> Clase a la que pertenece el objeto buscado.
     * @param array Arreglo donde se busca el objeto.
     * @param obj Objeto que se busca.
     * @return El índice que value ocupa o -1 si no existe.
     */
    private <C> int buscaIndice(C[] array, C obj) {
        int salida = 0;
        for (int i = 0; i < array.length; i++) {
            if (obj.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Calcula el tamaño/longitud del diccionario.
     * @return El tamaño del diccionario.
     */
    public int getSize() {
        return keys.length;
    }
    /* ----- CONSTRUCTORES ----- */
    public Diccionario() {
        super();
        keys = new Object[0];
        values = new Object[0];
    }
    public Diccionario(int capacidad) {
        super();
        keys = new Object[capacidad];
        values = new Object[capacidad];
    }
    public Diccionario(K[] keys, V[] values) {
        super();
        if (keys.length != values.length) {
            System.out.println("El número de llaves ("
                                + keys.length + 
                                ") no coincide con el número de valores ("
                                + values.length +
                                ").");
            return;
        }
        this.keys = keys;
        this.values = values;
    }
    /* ----- CONSTRUCTORES ----- */
    /* ----- ACCESO ----- */
    public Object[] getKeys() {
        return keys;
    }
    public Object[] getValues() {
        return values;
    }
    /* ----- ACCESO ----- */
}
