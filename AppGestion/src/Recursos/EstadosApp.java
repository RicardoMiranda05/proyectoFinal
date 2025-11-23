package recursos;
/**
 * Contiene a los estados en los que la aplicación se encuentra
 * en tiempo de ejecución. 
 */
public enum EstadosApp {
    /* ----- ESTADOS PRINCIPALES ----- */
    INICIO,
    SALIR,
    INICIO_SESION,
    USO_GENERAL,
    /* ----- ESTADOS ESPECÍFICOS ----- */
    AGREGAR_USUARIO, // Administrador.
    CREAR_TAREA, // Administrador y desarrollador.
    DESPLEGAR_TAREAS, // General.
    FILTRAR_TAREAS, // General
    ACTUALIZAR_TAREAS, // Administrador y desarrollador.
    ELIMINAR_TAREAS, // Administrador.
    CERRAR_SESION // General.
}
