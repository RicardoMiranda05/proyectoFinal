import java.io.Serializable;

/**
 * Representa el estado de una tarea dentro del sistema.
 * Solo puede ser: PENDIENTE, EN_CURSO o COMPLETADA.
 */
public enum EstadoTarea implements Serializable {
    PENDIENTE,
    EN_CURSO,
    COMPLETADA
}
