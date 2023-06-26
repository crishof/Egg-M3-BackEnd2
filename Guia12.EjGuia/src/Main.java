import entidad.Animal;
import entidad.Gato;
import entidad.Perro;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Gato());
        animals.add(new Perro());
        animals.add(new Animal());

        for ( Animal aux : animals){

            aux.haceRuido();
        }


    }
}