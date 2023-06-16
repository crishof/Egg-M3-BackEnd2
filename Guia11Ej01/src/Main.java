import entidades.Perro;
import entidades.Persona;

/*
Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
 */
public class Main {

    public static void main(String[] args) {

        Perro perro1 = new Perro("Dona","Rootwailer", 11, "Grande");
        Perro perro2 = new Perro("Frida","Golden",7,"Mediano");

        Persona persona1 = new Persona("Juan","Suarez",34,55443234,perro1);
        Persona persona2 = new Persona("Carlos","Messi",32,29222333,perro2);

        Persona persona3 = new Persona("Max","Smart",22,34211344,new Perro("Olivia","Golden",4,"Chico"));


        System.out.println("persona1 = " + persona1);
        System.out.println(" - - - - -- - ");
        System.out.println("persona2 = " + persona2);
        System.out.println(" - - - - - - -");
        System.out.println("persona3 = " + persona3);
    }
}
