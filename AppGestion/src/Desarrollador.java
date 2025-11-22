/**
 * ----- Mensaje genérico -----
 * Clase administrada sólo por BLANCA.
 * Puede modificarse por alguien más SÓLO en caso de que quiera hacer pruebas, pero debe
 * regresarse a su estado original. En caso de que no se reestablezca a su estado original,
 * el pull request será rechazado.
 * ----- Mensaje genérico -----
 * 
 * ----- Mensaje para VISITANTES -----
 * Los métodos relacionados con tareas (crear, ver, filtrar, actualizar) se dejarán como
 * incompletos por ahora porque las clases Tarea y ListaTareas aún no están implementadas.
 * Cuando esas ramas estén listas, estos métodos se completarán.
 * ----- Mensaje para VISITANTES -----
 * 
 * Esta clase representa a un usuario Desarrollador. 
 * Un desarrollador solo puede crear y modificar sus propias tareas.
 */
public class Desarrollador extends Usuario {

    /* ----- CONSTRUCTORES ----- */
    public Desarrollador(String nombre, String nickname, String email, String password) {
        super(nombre, nickname, email, password);
    }
    /* ----- CONSTRUCTORES ----- */

    /* ----- MÉTODOS (incompletos) ----- */

    /**
     * Crea una tarea para este desarrollador.
     * Nota: se implementa cuando exista la clase Tarea y ListaTareas.
     */
    public void crearTareaParaMi(/* parámetros de Tarea si los definen */) {
        // TODO: implementar cuando Tarea/ListaTareas estén listas
    }

    
    public void verMisTareas() {
        // TODO: implementar con tareasAsignadas
    }

    public void filtrarMisTareasPorEstado(/* String estado o enum Estado */) {
        // TODO: implementar cuando Tarea tenga atributo estado
    }

    public void actualizarMiTarea(/* idTarea, campos a cambiar */) {
        // TODO: implementar cuando ListaTareas y Tarea estén listas
    }

    /* ----- MÉTODOS (incompletos) ----- */
}

