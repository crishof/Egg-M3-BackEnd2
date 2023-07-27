package entidades;

public class Consola {
    private int consumo;
    public Consola() {
        consumo = 1;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    @Override
    public String toString() {
        return "Consola{" +
                "consumo=" + consumo +
                '}';
    }
}
