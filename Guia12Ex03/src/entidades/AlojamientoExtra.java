package entidades;

public class AlojamientoExtra extends Alojamiento {

    private boolean privado;
    private int superficie;

    public AlojamientoExtra() {
    }

    public AlojamientoExtra(String name, String address, String location, String gerente, boolean privado, int superficie) {
        super(name, address, location, gerente);
        this.privado = privado;
        this.superficie = superficie;
    }

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    @Override
    public String toString() {
        return super.toString() + "\n privado: " + privado + "\n superficie: " + superficie + "m2";
    }
}
