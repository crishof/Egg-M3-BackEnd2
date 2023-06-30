package entidades;

import java.util.Scanner;

public class Lavadora extends Electrodomestico {

    private int carga;

    public Lavadora() {
    }

    public Lavadora(int precio, String color, char consumo, int peso, int carga) {
        super(precio, color, consumo, peso);
        this.carga = carga;
    }


    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

//    Método crearLavadora (): este método llama a crearElectrodomestico() de la clase
//    padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
//    el atributo propio de la lavadora.

    public void crearLavadora() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("metodo crear lavadora");

        crearElectrodomestico();

        System.out.println("Ingrese el volumen de carga");
        this.carga = leer.nextInt();

    }

//    Método precioFinal(): este método será heredado y se le sumará la siguiente
//    funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500, si la
//    carga es menor o igual, no se incrementará el precio. Este método debe llamar al
//    método padre y añadir el código necesario. Recuerda que las condiciones que hemos
//    visto en la clase Electrodoméstico también deben afectar al precio.

    @Override
    public void precioFinal() {

//        System.out.println("Metodo precio final de la lavadora");

        super.precioFinal();
        if (carga > 30) {
            this.precio += 500;
        }
    }

    @Override
    public String toString() {
        return "Lavadora{" + "carga=" + carga + "} " + super.toString();
    }
}
