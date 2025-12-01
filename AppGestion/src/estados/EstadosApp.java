package estados;
/**
 * Etiqueta los estados de la app.
 * @author Brayan Montiel Ramírez.
 */
public enum EstadosApp {
    /* ----- Generales ----- */
    INICIO_APP, // (COMPLETO)
    INICIO_SESION, // (COMPLETO)
    USO_GENERAL, // (COMPLETO)
    SALIR, // (COMPLETO)
    /* ----- Generales ----- */
    /* ----- Funciones de la App ----- */
    // A la derecha se encuentra quién tiene acceso.
    AGREGAR_USUARIO,    // Administrador. (COMPLETO)
    CREAR_TAREA,        // Administrador y desarrollador. (COMPLETO)
    DESPLEGAR_TAREAS,   // Todos.
    FILTRAR_TAREAS,     // Todos.
    ACTUALIZAR_TAREAS,  // Administrador y desarrollador.
    /* Subestados */
        ACTUALIZAR_ESTADO_TAREA,
        ACTUALIZAR_USUARIO_TAREA,
        ACTUALIZAR_DESCRIPCION_TAREA,
        ACTUALIZAR_FECHA_ESTIMADA_INICIO_TAREA,
        ACTUALIZAR_FECHA_ESTIMADA_FIN_TAREA,
    ELIMINAR_TAREAS,    // Administrador.
    CERRAR_SESION       // Todos.
    /* ----- Funciones de la App ----- */
}
