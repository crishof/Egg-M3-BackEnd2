package entidades;

import java.util.Scanner;

public class Televisor extends Electrodomestico {

    protected int resolution;
    protected boolean tdt;

    public Televisor() {
    }

    public Televisor(int precio, String color, char consumo, int peso, int resolution, boolean tdt) {
        super(precio, color, consumo, peso);
        this.resolution = resolution;
        this.tdt = tdt;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public boolean isTdt() {
        return tdt;
    }

    public void setTdt(boolean tdt) {
        this.tdt = tdt;
    }

    public void crearTelevisor() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Metodo crear televisor");

        super.crearElectrodomestico();

        System.out.println("Ingrese pulgadas");
        this.resolution = leer.nextInt();
        String check = "N";
        do {
            System.out.println("tiene sintonizador? S/N");
            check = leer.next();
        } while (!check.equalsIgnoreCase("N") && !check.equalsIgnoreCase("S"));
        if (check.equalsIgnoreCase("S")) this.tdt = true;
    }

    @Override
    public void precioFinal() {

//        System.out.println("Metodo precio final del televisor");

        super.precioFinal();
        if (resolution > 40) {
            this.precio = (int) (precio * 1.3);
        }
        if (tdt) this.precio += 500;
    }
}
