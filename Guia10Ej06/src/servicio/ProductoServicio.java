package servicio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductoServicio {

    public void cargarProductos(HashMap<String,Double> productos) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String carga;
        do {
            System.out.println("Ingrese el nombre y el precio del producto");
            productos.put(leer.next(), leer.nextDouble());
            System.out.println("Desea cargar otro artículo) S/N");
            carga = leer.next();
        } while (carga.equalsIgnoreCase("S"));
    }

    public void actualizarPrecios(HashMap<String, Double> productos) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el producto que desea modificar");
        String producto = leer.next();
        System.out.println("Ingrese el nuevo precio");
        Double newPrice = leer.nextDouble();

        if (productos.containsKey(producto)) {
            productos.replace(producto, newPrice);
        }

    }

    public void borrarProducto(HashMap<String, Double> productos) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el producto que desea borrar");
        String producto = leer.next();

        productos.remove(producto);
    }

    public void mostrarProductos(HashMap<String, Double> productos) {

        for (Map.Entry<String, Double> muestra : productos.entrySet()) {
            System.out.println("Producto: " + muestra.getKey() + "Precio: " + muestra.getValue());
        }
    }
}
