import entidades.Juego;
import entidades.Jugador;
import entidades.Revolver;

import java.util.ArrayList;
import java.util.Scanner;

/*
Realizar el juego de la ruleta rusa de agua en Java. Como muchos saben, el juego se trata de
un número de jugadores, que, con un revolver de agua, el cual posee una sola carga de agua,
se dispara y se moja. Las clases por hacer del juego son las siguientes:

Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual (posición
del tambor que se dispara, puede que esté el agua o no) y posición agua (la posición del
tambor donde se encuentra el agua). Estas dos posiciones, se generarán aleatoriamente.
Métodos:
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)

Clase Jugador: esta clase posee los siguientes atributos: id (representa el número del
jugador), nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (indica
si está mojado o no el jugador). El número de jugadores será decidido por el usuario, pero
debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.
 r r): el método, recibe el revolver de agua y llama a los métodos de
mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
devuelve true, sino false.

Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y
Revolver
Métodos:
• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
y el revolver para guardarlos en los atributos del juego.
• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
 */
public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        ArrayList<Jugador> jugadores = new ArrayList<>();

        System.out.println("Ingrese la cantidad de jugadores");
        int cantidad;
        boolean fueraDeRango = false;

        do {
            if (fueraDeRango) {
                System.out.println("Ingrese un valor entre 2 y 6");
            }
            cantidad = leer.nextInt();
            fueraDeRango = (cantidad < 1 || cantidad > 6);
        } while (fueraDeRango);

        for (int i = 0; i < cantidad; i++) {
            jugadores.add(new Jugador(i + 1));
        }

        Revolver revolver = new Revolver();
        revolver.llenarRevolver();

        Juego juego = new Juego();
        juego.llenarJuego(jugadores, revolver);

        boolean check = true;

        int i = 0;
        do {
            System.out.println(jugadores.get(i).getNombre() + " presione enter para disparar");
            leer.next();
            if (juego.ronda()) {
                System.out.println(jugadores.get(i).getNombre() + " te paso el champú???!");
                System.out.println("Fin del juego");
                check = false;
            } else {
                System.out.println("uff...");
            }
            if (i < cantidad - 1) {
                i++;
            } else {
                i = 0;
            }
        } while (check);


    }
}

