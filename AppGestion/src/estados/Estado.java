package estados;

import java.util.Scanner;
/**
 * Representa un posible estado de la aplicación en tiempo de ejecución.
 * Se implementa para ver a la App como una máquina de estados que se mueve entre sus
 * diferentes estados. Un ejemplo del flujo natural sería:
 * Pantalla de inicio --> Inicio de sesión --> Uso de la applicación --> Crear tarea --> 
 * --> Uso de la aplicación --> Ver tareas --> Uso de la aplicación --> Cerrar sesión -->
 * --> Pantalla de inicio --> Salida de la App.
 * También se implementa para que el código del App sea más claro y estructurado.
 * @author Brayan Montiel Ramírez.
 */
public abstract class Estado {
    private EstadosApp referencia; // Referencia de la etiqueta que representa a este estado.
    /* ----- CONSTRUCTOR ----- */
    public Estado(EstadosApp referencia) {
        super();
        this.referencia = referencia;
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- ACCESO ----- */
    public EstadosApp getReferencia() {
        return referencia;
    }
    /* ----- ACCESO ----- */
    /* ----- UTILERÍA ----- */
    
    /* ----- UTILERÍA ----- */
    /**
     * Implementa la lógica del estado en curso.
     * @param s : Teclado con el cual se comunica el usuario.
     * @return : El nuevo estado al que pasa la aplicación tras la ejecución de este.
     * @throws Exception 
     */
    public abstract Estado ejecutar(Scanner s) throws Exception;
    /**
     * Compara a dos estados por su referencia.
     * @param estado : Estado con el que {@code this} se compara.
     * @return {@code true} si tienen la misma referencia y {@code false} si no.
     */
    public boolean equals(Estado estado) {
        if (this == estado)
            return true;
        if (estado == null)
            return false;
        if (referencia != estado.referencia)
            return false;
        return true;
    }
    
    
}
