package entidad;

public class Carta {
    int numero;
    String palo;

    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }
    @Override
    public String toString() {
        return numero + " de " + palo + '\'';
    }
}
