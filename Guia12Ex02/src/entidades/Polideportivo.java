package entidades;

public class Polideportivo extends Edificio {

    private final String nombre;
    private final boolean techado;

    public Polideportivo(String nombre, int ancho, int alto, int largo, boolean techado) {
        super(ancho, alto, largo);
        this.nombre = nombre;
        this.techado = techado;
    }

    public boolean isTechado() {
        return techado;
    }

    @Override
    public void calcularVolumen() {
        System.out.println("Polideportivo: " + nombre);
        System.out.println("Volumen: " + getAlto() * getAncho() * getLargo() + "m3");
    }

    @Override
    public void calcularSuperficie() {

        System.out.println("Superficie: " + getAncho() * getLargo() + "m2");
    }
}
