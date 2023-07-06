import entidades.Persona;
import servicios.PersonaServicio;

public class Main {
    public static void main(String[] args) {

        PersonaServicio ps = new PersonaServicio();
        Persona[] persona = new Persona[4];
        int[] masa = new int[4];
        boolean[] mayor = new boolean[4];

        persona[0] = new Persona("Cris", 40, 'H', 78, 1.73);
        persona[1] = new Persona("Ana", 18, 'M', 56, 1.6);
        persona[2] = new Persona("Pepe", 14, 'H', 40, 1.4);
        persona[3] = new Persona("Juana", 30, 'M', 20, 1.73);

        for (int i = 0; i < persona.length; i++) {
            mayor[i] = ps.esMayorDeEdad(persona[i]);
            masa[i] = ps.calcularMC(persona[i]);
        }

        ps.mostrarDatos(mayor, masa);

        persona[0] = null;
        try {
            ps.esMayorDeEdad(persona[0]);
        }catch (NullPointerException e){
            System.out.println("getMessage: " + e.getMessage());
        }finally {
            System.out.println("Text desde finally");
        }




    }
}
