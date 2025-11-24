package estados;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import tareas.ListaTareas;
import usuarios.Usuario;
/**
 * Sirve para que los estados se comuniquen con la aplicación y con los datos que
 * esta maneja.
 * @author Brayan Montiel Ramírez.
 */
public abstract class AppComunicador {
    /* ----- REFERENCIAS PARA FUNCIONAMIENTO ----- */
    public static final String listaTareas_dir = "\\src\\archivos\\lista_tareas.dat";
    public static final String listaUsuarios_dir = "\\src\\archivos\\usuarios.dat";
    public static Usuario usuarioActual; // El usuario que corre la App.
    public static ListaTareas listaTareas;
    public static List<Usuario> listaUsuarios;
    /* ----- REFERENCIAS PARA FUNCIONAMIENTO ----- */
    /**
     * Carga la lista de tareas del comunicador.
     */
    public static void cargaTareas() {
        listaTareas = ListaTareas.cargarDesdeArchivo(listaTareas_dir);;
    }
    /**
     * Carga la lista de usuarios del comunicador.
     */
    public static void cargaUsuarios() {
        listaUsuarios = cargarDesdeArchivo(listaUsuarios_dir);
    }
    @SuppressWarnings("unchecked")
    /**
     * Carga la lista de usuarios desde el archivo con la ruta que pasa como parámetro.
     * @param ruta Ruta del archivo de usuarios.
     * @return Lista de usuarios del archivo.
     */
    private static ArrayList<Usuario> cargarDesdeArchivo(String ruta) {
        File f = new File(ruta);
        if (!f.exists()) {
            return new ArrayList<Usuario>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Object obj = ois.readObject();
            ois.close();
            if (obj instanceof ArrayList<?>) {
                return (ArrayList<Usuario>) obj;
            }
        } catch (Exception e) {
            System.out.println("No se pudo cargar la lista de usuarios. Se iniciará una nueva. Detalle: " + e.getMessage());
        }
        return new ArrayList<Usuario>();
    }
    
}
