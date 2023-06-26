package entidades;

public class Perro extends Animal {
    public Perro(String nombre,String alimento, int edad, String raza) {
        super(nombre,alimento, edad, raza);
    }

    @Override
    public void alimentarse() {
        super.alimentarse();
        System.out.println("El perro come");

    }
}
