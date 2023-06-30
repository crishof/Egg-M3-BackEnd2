package entidades;

import interfaces.CalculosFormas;

public class Rectangulo implements CalculosFormas {

    public int base;
    public int altura;

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularPerimetro() {

        return (base + altura) * 2;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }
}
