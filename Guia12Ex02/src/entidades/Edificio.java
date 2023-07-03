package entidades;

public abstract class Edificio {

    private int ancho;
    private int alto;
    private int largo;

    public Edificio() {
    }

    public Edificio(int ancho, int alto, int largo) {
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }


    public int getAlto() {
        return alto;
    }

    public int getLargo() {
        return largo;
    }

    public abstract void calcularVolumen();

    public abstract void calcularSuperficie();


}
