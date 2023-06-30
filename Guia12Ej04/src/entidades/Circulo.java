package entidades;

import interfaces.CalculosFormas;

public class Circulo implements CalculosFormas {

    public int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    //    Área circulo: PI * radio ^ 2 / Perímetro circulo: PI * diámetro.

    @Override
    public double calcularPerimetro() {
        return VALOR_PI * (radio * 2);
    }

    @Override
    public double calcularArea() {
        return VALOR_PI * Math.pow(radio, 2);
    }
}
