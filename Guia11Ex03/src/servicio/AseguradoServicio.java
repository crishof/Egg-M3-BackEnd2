package servicio;

import entidad.Poliza;

import java.util.Scanner;

public class AseguradoServicio {

    public void crearPoliza(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese su nombre");
        String nombre = leer.next();
        System.out.println("Ingrese su apellido");
        String apellido = leer.next();
        System.out.println("Ingrese su DNI");
        long dni = leer.nextLong();
        System.out.println("Ingrese su email");
        String email = leer.next();
        System.out.println();


    }

    public void menu(){

    }
}
