package menues;

import java.util.Scanner;

public class PruebaMenu {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        /*
        MenuSalida menuSalida= new MenuSalida("Salir");
        menuSalida.addOpcion("Iniciar sesión");
        System.out.println(menuSalida);
        System.out.println(menuSalida.getListaOpciones()); */
        MenuSalida menuSalida = new MenuSalida("Salir");
        menuSalida.addOpcion("Opción 1");
        menuSalida.addOpcion("Opción 2");
        menuSalida.addOpcion("Opción 3");
        menuSalida.close();
        System.out.println(menuSalida);
        MenuInicio menuInicio = new MenuInicio();
        menuInicio.close();
        System.out.println(menuInicio);

    }
}
