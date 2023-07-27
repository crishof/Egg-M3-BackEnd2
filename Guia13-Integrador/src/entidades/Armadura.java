package entidades;

public class Armadura {

    Casco casco;
    private int salud;
    private int bateria;
    private int resistencia;

    public Armadura() {
        salud = 100;
        bateria = 100;
        resistencia = 100;
        casco = new Casco();
    }

    public Casco getCasco() {
        return casco;
    }

    public void setCasco(Casco casco) {
        this.casco = casco;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public String toString() {
        return "Armadura{" + "casco=" + casco + ", salud=" + salud + ", bateria=" + bateria + ", resistencia='" + resistencia + '\'' + '}';
    }
}
