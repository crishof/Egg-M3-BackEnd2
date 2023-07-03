package entidades;

public class Oficinas extends Edificio{

    private final int numeroOficinas;
    private final int personasOficinas;
    private final int numeroPisos;

    public Oficinas(int ancho, int alto, int largo, int numeroOficinas, int personasOficinas, int numeroPisos) {
        super(ancho, alto, largo);
        this.numeroOficinas = numeroOficinas;
        this.personasOficinas = personasOficinas;
        this.numeroPisos = numeroPisos;
    }

    public int getNumeroOficinas() {
        return numeroOficinas;
    }


    public int getPersonasOficinas() {
        return personasOficinas;
    }

    public int getNumeroPisos() {
        return numeroPisos;
    }

    @Override
    public void calcularVolumen() {
        System.out.println("Edificio de oficinas");
        System.out.println("Volumen: " +  getAlto() * getAncho() * getLargo() + "m3");
    }

    @Override
    public void calcularSuperficie() {

        System.out.println("Superficie: " +  getAncho() * getLargo() + "m2");

    }

}
