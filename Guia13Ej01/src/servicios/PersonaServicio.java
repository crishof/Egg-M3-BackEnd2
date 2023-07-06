package servicios;

import entidades.Persona;

public class PersonaServicio {

    public boolean esMayorDeEdad(Persona persona) {

        return persona.getAge() >= 18;

    }

    public int calcularMC(Persona persona) {
        double imc = (persona.getPeso()) / (Math.pow(persona.getAltura(), 2));
        int c;
        if (imc < 20) c = (-1);

        else if (imc >= 20 && imc <= 25) {
            c = 0;
        } else {
            c = 1;
        }
        return c;
    }

    public void mostrarDatos(boolean[] mayor, int[] masa) {
        int cantmay = 0;
        int cantmen = 0;
        for (boolean b : mayor) {
            if (b) cantmay++;
            else cantmen++;
        }

        int mb = 0;
        int mi = 0;
        int ma = 0;
        for (int j : masa) {
            switch (j) {
                case -1 -> mb++;
                case 0 -> mi++;
                default -> ma++;
            }
        }
        System.out.println("Porcentaje de mayores: " + (cantmay * 100 / 4) + "%");
        System.out.println("Porcentaje de menores: " + (cantmen * 100 / 4) + "%");
        System.out.println("       -------------");
        System.out.println("Masa corporal baja: " + (mb * 100 / 4) + "%");
        System.out.println("Masa corporal ideal: " + (mi * 100 / 4) + "%");
        System.out.println("Masa corporal alta: " + (ma * 100 / 4) + "%");
    }
}
