package servicios;

import entidades.Armadura;

import java.util.Scanner;

public class Jarvis {

    Armadura armadura = iniciarArmadura();
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Armadura iniciarArmadura() {
        return new Armadura();
    }

    public void iniciarSistema(Armadura armadura) {
        System.out.println("Hola Tony");
        armadura.getCasco().usarSintetizador(armadura);
        System.out.println("Que deseas hacer hoy?");
        armadura.getCasco().usarSintetizador(armadura);
        String respuesta = leer.next();
        armadura.getCasco().usarConsola(armadura);
        consultarEstadoArmadura(armadura);
    }

    public void consultarEstadoArmadura(Armadura armadura) {

        System.out.println(armadura);


    }
}
