

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import estados.*;
import singleton.AppComunicador;
import usuarios.Administrador;
import usuarios.Desarrollador;
import usuarios.Usuario;

public class App {
    public static final String listaTareas_dir = AppComunicador.listaTareas_dir;
    public static final String listaUsuarios_dir = AppComunicador.listaUsuarios_dir;
    /* ----- VARIABLES PARA LA MÁQUINA ----- */
    private static Estado estadoActual = new EstadoInicioApp();
    private static Scanner s = new Scanner(System.in);
    private static EstadoSalir estadoSalida = new EstadoSalir();
    /* ----- VARIABLES PARA LA MÁQUINA ----- */
    public static void main(String[] args) throws Exception {
        verificarListaInicial();
        System.out.println(AppComunicador.getInstancia().getListaUsuarios()); // TODO: Quitar al finalizar el programa (sirve para ver los usuarios existentes)
        AppComunicador.getInstancia().getListaTareas().listarTodas(); // TODO: Quitar al finalizar el programa (sirve para ver los usuarios existentes)
        System.out.println("\n¡Bienvenido a nuestra App de Gestión de Tareas!" +
                            "\nGracias por su preferencia."
        );
        /* ----- MÁQUINA DE ESTADOS ----- */
        while (! estadoActual.equals(estadoSalida)) {
            estadoActual = estadoActual.ejecutar(s);
            //AppComunicador.getInstancia().setEstadoPrevio(estadoActual);
        }
        s.close();
        AppComunicador.getInstancia().close();
        /* ----- MÁQUINA DE ESTADOS ----- */
    }
    /**
     * Verifica si ya hay una lista inicial de usuarios. En caso de no haberla, la
     * crea con tres usuarios de ejemplo, cuya información se encuentra en el archivo datos/usuarios_default.txt
     */
    public static void verificarListaInicial() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(listaUsuarios_dir));
            ois.readObject();
            ois.close();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            List<Usuario> usuarios = new ArrayList<>();
            usuarios.add(new Administrador("Juan Morales",
                                            "juan", 
                                            "juanitoMorales@gmail.com",
                                            "juanitoClave"));
            usuarios.add(new Desarrollador("Alberto Flores",
                                            "alberto", 
                                            "albertoFlores@gmail.com",
                                            "albertoClave"));
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(listaUsuarios_dir));
                oos.writeObject(usuarios);
                oos.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
