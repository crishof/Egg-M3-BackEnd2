package entidades;

import java.util.Random;

public class Revolver {

    /*
Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual (posición
del tambor que se dispara, puede que esté el agua o no) y posición agua (la posición del
tambor donde se encuentra el agua). Estas dos posiciones, se generarán aleatoriamente.
*/
    private int posicionAgua;
    private int posicionActual;

    public Revolver() {
        posicionActual = 0;
        posicionAgua = 0;
    }

    //• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores deben ser aleatorios.
    public void llenarRevolver() {

        Random rand = new Random();
        int min = 1;
        int max = 8;

        do {
            posicionActual = rand.nextInt(max - min + 1) + min;
            posicionAgua = rand.nextInt(max - min + 1) + min;
        }while ((posicionActual>=posicionAgua));

    }

    public boolean mojar() { // devuelve true si la posición del agua coincide con la posición actual

        return posicionActual == posicionAgua;
    }

    public void siguienteChorro() { // cambia a la siguiente posición del tambor
        System.out.println("posicionAgua = " + posicionAgua);
        System.out.println("posicionActual = " + posicionActual);
        posicionActual++;
    }

    //• toString(): muestra información del revolver (posición actual y donde está el agua)
    @Override
    public String toString() {
        return "Revolver{" + "posicionAgua=" + posicionAgua + ", posicionActual=" + posicionActual + '}';
    }
}
