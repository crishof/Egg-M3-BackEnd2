import entidades.DNI;
import entidades.Persona;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona("Carlos","Perez",new DNI(29224555,'A'));

        System.out.println("persona = " + persona);

        persona.setApellido("Suarez");
        persona.setNombre("Oscar");
        persona.setDni(new DNI(22333222,'A'));

        System.out.println("persona = " + persona);

        DNI docu1 = new DNI();

        docu1.setNumero(45345656);
        docu1.setSerie('B');

        System.out.println("docu1 = " + docu1);

        Persona persona1 = new Persona("Juan","Garcia", docu1);

        System.out.println("persona1 = " + persona1);



        System.out.println("persona1 = " + persona1);
    }
}
