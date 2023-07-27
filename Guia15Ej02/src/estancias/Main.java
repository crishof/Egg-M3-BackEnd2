package estancias;

import estancias.servicios.CasaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        CasaService ps = new CasaService();
        FabricanteServicio fs = new FabricanteServicio();

        int opcion;
        do {
            Scanner scanner = new Scanner(System.in).useDelimiter("\n");
            System.out.println("""
                     = = = = MENU = = = =
                    Ingrese la opcion deseada
                    a) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.
                    b) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 
                        2020 y el 31 de agosto de 2020 en Reino Unido.                                                             
                    c) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail               
                    d) Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada
                        y un número de días específico.
                    e) Listar los datos de todos los clientes que en algún momento realizaron una estancia y la
                        descripción de la casa donde la realizaron.
                    f) Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y
                        ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a
                        la anterior
                    g) Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el
                        precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios
                        actualizados.
                    h) Obtener el número de casas que existen para cada uno de los países diferentes.
                    i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios)
                        que están ‘limpias’.
                    j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.
                    x) SALIR
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