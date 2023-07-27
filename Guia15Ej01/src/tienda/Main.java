package tienda;

import tienda.servicios.FabricanteServicio;
import tienda.servicios.ProductoServicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        ProductoServicio ps = new ProductoServicio();
        FabricanteServicio fs = new FabricanteServicio();

        int opcion;
        do {
            Scanner scanner = new Scanner(System.in).useDelimiter("\n");
            System.out.println("""
                     = = = = MENU = = = =
                    Ingrese la opcion deseada
                    1) Lista el nombre de todos los productos que hay en la tabla producto
                    2) Lista los nombres y los precios de todos los productos de la tabla producto
                    3) Listar aquellos productos que su precio esté entre 120 y 202
                    4) Buscar y listar todos los Portátiles de la tabla producto
                    5) Listar el nombre y el precio del producto más barato
                    6) Ingresar un producto a la base de datos
                    7) Ingresar un fabricante a la base de datos
                    8) Editar un producto con datos a elección
                    0) SALIR
                    """);

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> ps.imprimirProductosNombre();
                case 2 -> ps.imprimirProdNombrePrecio();
                case 3 -> ps.imprimirPrecioBetween();
                case 4 -> ps.imprimirNombreLike();
                case 5 -> ps.imprimirPrecioMin();
                case 6 -> ps.crearProducto();
                case 7 -> fs.crearFabricante();
                case 8 -> ps.modificarProducto();
                case 0 -> System.out.println("Programa finalizado. Hasta luego!");
                default -> throw new IllegalStateException("Unexpected value: " + opcion);
            }
        } while (opcion != 0);
    }
}