package servicio;

import entidades.Edificio;
import entidades.Oficinas;
import entidades.Polideportivo;

import java.util.ArrayList;

public class EdificioServicio {

    public ArrayList<Edificio> crearEdificios() {

        ArrayList<Edificio> edificios = new ArrayList<>();
        edificios.add(new Oficinas(10, 3, 14, 5, 8, 10));
        edificios.add(new Oficinas(6, 3, 11, 4, 6, 6));
        edificios.add(new Polideportivo("Malaga", 50, 20, 100, true));
        edificios.add(new Polideportivo("Granada", 32, 14, 60, false));

        return edificios;
    }

    public void calculos(ArrayList<Edificio> edificios) {

        int techadosCant = 0;

        for (Edificio aux : edificios) {

            aux.calcularVolumen();
            aux.calcularSuperficie();

            if (aux instanceof Polideportivo) {
                if (((Polideportivo) aux).isTechado()) {
                    techadosCant += 1;
                    System.out.println("El polideportivo es techado");
                    System.out.println();
                } else {
                    System.out.println("El polideportivo no es techado");
                    System.out.println();
                }
            } else if (aux instanceof Oficinas) {
                cantPersonas(((Oficinas) aux).getPersonasOficinas(), ((Oficinas) aux).getNumeroOficinas(), ((Oficinas) aux).getNumeroPisos());
            }
        }

        System.out.println("Cantidad de polideportivos techados: " + techadosCant);
    }

    public void cantPersonas(int personas, int oficinas, int pisos) {

        System.out.println("La capacidad del edificio es de " + personas * oficinas * pisos + " personas");
        System.out.println();

    }
}
