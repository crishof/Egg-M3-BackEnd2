import entidades.Animal;
import entidades.Caballo;
import entidades.Gato;
import entidades.Perro;

public class Main {
    public static void main(String[] args) {

    Animal perro1 = new Perro("Stich","Carnivoro",15,"Doberman");
    perro1.alimentarse();
    Animal perro2 = new Perro("Teddy","Croquetas",10,"Chihuahua");
    perro2.alimentarse();
    Animal gato1 = new Gato("Pelusa","Galletas",15,"Siames");
    gato1.alimentarse();
    Animal caballo1 = new Caballo("Spark","Pasto",25,"Fino");
    caballo1.alimentarse();
    }
}