/**
 * Excepción personalizada para indicar errores en el manejo de fechas
 * de las tareas.
 */
public class FechaInvalidaException extends Exception {
    public FechaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
