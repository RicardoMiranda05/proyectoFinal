package singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import estados.Estado;
import tareas.ListaTareas;
import usuarios.Usuario;
/**
 * Singleton para que diferentes clases (principalmente los estados) se comuniquen con la applicación,
 * cargando los datos de usuario y tareas en cada instancia.
 * @author Brayan Montiel Ramírez.
 */
public class AppComunicador {
    private static AppComunicador instancia;
    private static boolean closed = false;
    /* ----- REFERENCIAS PARA FUNCIONAMIENTO ----- */
    public static final String listaTareas_dir = "datos/lista_tareas.dat";
    public static final String listaUsuarios_dir = "datos/usuarios.dat";
    private Usuario usuarioActual; // El usuario que corre la App.
    private ListaTareas listaTareas;
    private List<Usuario> listaUsuarios;
    private Estado estadoPrevio = null;
    /* ----- REFERENCIAS PARA FUNCIONAMIENTO ----- */
    /**
     * Cierra el Singleton y guarda los cambios.
     */
    public void close() throws SingletonClosedException {
        if (closed) {
            throw new SingletonClosedException();
        }
        if (listaTareas != null) {
            // TODO: Decidir si es mejor una verificación por longitud no nula de la lista en lugar de null. 
            listaTareas.guardarEnArchivo(listaTareas_dir);
        }
        if (listaUsuarios != null) {
            guardarUsuariosEn(listaUsuarios_dir);
        }
        closed = true;
    }
    /**
     * Guarda la lista completa de usuarios en un archivo usando serialización.
     */
    private void guardarUsuariosEn(String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(listaUsuarios);
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    /**
     * Carga la lista de usuarios desde el archivo con la ruta que pasa como parámetro.
     * @param ruta Ruta del archivo de usuarios.
     * @return Lista de usuarios del archivo.
     */
    private ArrayList<Usuario> cargarDesdeArchivo(String ruta) {
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
        System.out.println("Se mandó vacía");
        return new ArrayList<Usuario>();
    }
    /* ----- ACCESO ----- */
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
    public void setUsuarioActual(Usuario usuarioActual) throws SingletonClosedException {
        if (closed) {
            throw new SingletonClosedException();
        }
        this.usuarioActual = usuarioActual;
    }
    public ListaTareas getListaTareas() {
        return listaTareas;
    }
    public void setListaTareas(ListaTareas listaTareas) throws SingletonClosedException {
        if (closed) {
            throw new SingletonClosedException();
        }
        this.listaTareas = listaTareas;
    }
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    public void setListaUsuarios(List<Usuario> listaUsuarios) throws SingletonClosedException {
        if (closed) {
            throw new SingletonClosedException();
        }
        this.listaUsuarios = listaUsuarios;
    }
    /**
     * Encuentra al usuario con el nickname que pasa como parámetro.
     * @param nickname : Nombre de usuario del usuario que se busca.
     * @return : Al usuario si este existe y {@code null} si no.
     */
    public Usuario getUsuario(String nickname) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNickname().equals(nickname)) {
                return usuario;
            }
        }
        return null;
    }
    /* ----- ACCESO ----- */
    public Estado getEstadoPrevio() {
        return estadoPrevio;
    }
    public void setEstadoPrevio(Estado nuevoEstado) {
        estadoPrevio = nuevoEstado;
    }
    /* ----- CONSTRUCTOR ----- */
    private AppComunicador() {
        listaTareas = ListaTareas.cargarDesdeArchivo(listaTareas_dir);
        listaUsuarios = cargarDesdeArchivo(listaUsuarios_dir);
    }
    /* ----- CONSTRUCTOR ----- */
    /* ----- INSTANCIADOR ----- */
    /**
     * @return : Instancia del comunicador.
     */
    public static AppComunicador getInstancia() {
        if (instancia == null) {
            instancia = new AppComunicador();
        }
        return instancia;
    }
    /* ----- INSTANCIADOR ----- */
}
