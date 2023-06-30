package entidades;

import java.util.Scanner;

public class Electrodomestico {

    protected int precio;
    protected String color;
    protected char consumo;
    protected int peso;

    public Electrodomestico() {
    }

    public Electrodomestico(int precio, String color, char consumo, int peso) {
        this.precio = precio;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumo() {
        return consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = consumo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    //    Método comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta,
//    sino es correcta usara la letra F por defecto. Este método se debe invocar al crear el
//    objeto y no será visible.
    public char comprobarConsumoEnergetico(char letra) {

//        System.out.println("Metodo comprobar Consumo Energetico");

        if (letra != 'A' && letra != 'B' && letra != 'C' && letra != 'D' && letra != 'E' && letra != 'F') {
            letra = 'F';
        }
        return letra;

    }

    //    Método comprobarColor(String color): comprueba que el color es correcto, y si no lo es,
//    usa el color blanco por defecto. Los colores disponibles para los electrodomésticos son
//    blanco, negro, rojo, azul y gris. No importa si el nombre está en mayúsculas o en
//    minúsculas. Este método se invocará al crear el objeto y no será visible.
    public String comprobarColor(String color) {

//        System.out.println("Metodo comprobar color");

        if (!color.equalsIgnoreCase("Blanco") && !color.equalsIgnoreCase("NEGRO") && !color.equalsIgnoreCase("ROJO") && !color.equalsIgnoreCase("AZUL") && !color.equalsIgnoreCase("GRIS")) {

            color = "Blanco";
        }

        return color;

    }

//    Metodo crearElectrodomestico(): le pide la información al usuario y llena el
//    electrodoméstico, también llama los métodos para comprobar el color y el consumo. Al
//    precio se le da un valor base de $1000.

    public void crearElectrodomestico() {

//        System.out.println("Metodo crear Electrodoméstico");
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese Color");
        String color = leer.next();

        System.out.println("Ingrese consumo ( letras A a la F");
        char consumo = leer.next().charAt(0);

        System.out.println("Ingrese peso");
        int peso = leer.nextInt();

        this.precio = 1000;
        this.color = comprobarColor(color);
        this.peso = peso;
        this.consumo = comprobarConsumoEnergetico(consumo);
    }

//    Método precioFinal(): según el consumo energético y su tamaño, aumentará el valor del
//    precio. Esta es la lista de precios:

    public void precioFinal() {

//        System.out.println("metodo Precio Final electrodomestico");

        switch (consumo) {
            case 'A' -> precio = precio + 1000;
            case 'B' -> precio = precio + 800;
            case 'C' -> precio = precio + 600;
            case 'D' -> precio = precio + 500;
            case 'E' -> precio = precio + 300;
            case 'F' -> precio = precio + 100;
        }

        if (peso >= 1 && peso <= 19) precio = precio + 100;
        if (peso >= 20 && peso <= 40) precio = precio + 500;
        if (peso >= 50 && peso <= 79) precio = precio + 800;
        if (peso >= 80) precio = precio + 1000;

    }
}
