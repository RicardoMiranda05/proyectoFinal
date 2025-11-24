package estados;
/**
 * Etiqueta los estados de la app.
 * @author Brayan Montiel Ramírez.
 */
public enum EstadosApp {
    /* ----- Generales ----- */
    INICIO_APP,
    INICIO_SESION,
    USO_GENERAL,
    SALIR,
    /* ----- Generales ----- */
    /* ----- Funciones de la App ----- */
    // A la derecha se encuentra quién tiene acceso.
    AGREGAR_USUARIO,    // Administrador.
    CREAR_TAREA,        // Administrador y desarrollador.
    DESPLEGAR_TAREAS,   // Todos.
    FILTRAR_TAREAS,     // Todos.
    ACTUALIZAR_TAREAS,  // Administrador y desarrollador.
    ELIMINAR_TAREAS,    // Administrador.
    CERRAR_SESION       // Todos.
    /* ----- Funciones de la App ----- */
}
