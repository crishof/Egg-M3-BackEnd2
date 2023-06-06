package servicio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CiudadServicio {

    public HashMap<Integer, String> cargarCodigosAutom() {

        HashMap<Integer, String> codigos = new HashMap<>();

        codigos.put(23654, "Tokio");
        codigos.put(114566, "Berlin");
        codigos.put(102345, "Lisboa");
        codigos.put(654432, "Oslo");
        codigos.put(999999, "Denver");
        codigos.put(445302, "Helsinki");
        codigos.put(592857, "Rio");
        codigos.put(2829340, "Marsella");
        codigos.put(945435, "Tokio");
        codigos.put(23495, "Tokio");

        return codigos;
    }

    public void mostrarDatos(HashMap<Integer, String> codigos) {

        System.out.println("= = = LISTADO DE CODIGOS = = =");
        for (Map.Entry<Integer, String> city : codigos.entrySet()) {
            System.out.println("Codigo: " + city.getKey()
                    + ", Ciudad: " + city.getValue());
        }
        System.out.println("-------------------------------");
    }

    public void buscarCodigo(HashMap<Integer, String> codigos) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el codigo que desea buscar");
        int codigoBuscar = leer.nextInt();

        if ( codigos.containsKey(codigoBuscar)){
            String ciudad = codigos.get(codigoBuscar);
            System.out.println("La ciudad correspondiente es: " + ciudad);
        }
        else {
            System.out.println("No se encuentra el código");
        }
    }

    public void agregarCiudad(HashMap<Integer,String> codigos){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el nombre de la ciudad que desea agregar");
        var nombre = leer.next();
        System.out.println("Ingrese el código postal");
        var cp = leer.nextInt();

        codigos.put(cp,nombre);
    }

    public void eliminarCiudades(HashMap<Integer,String> codigos){

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese las 3 ciudades que desea eliminar");
        String ciudad1 = leer.next();
        String ciudad2 = leer.next();
        String ciudad3 = leer.next();

        int clave = 0, clave2 = 0, clave3 = 0;

        for (Map.Entry<Integer, String> ciudades : codigos.entrySet()) {
            if (ciudades.getValue().equals(ciudad1)) {
                clave = ciudades.getKey();
                break; // Si solo deseas encontrar la primera coincidencia, puedes salir del bucle aquí.
            }
            if (ciudades.getValue().equals(ciudad2)) {
                clave = ciudades.getKey();
                break; // Si solo deseas encontrar la primera coincidencia, puedes salir del bucle aquí.
            }
            if (ciudades.getValue().equals(ciudad3)) {
                clave = ciudades.getKey();
                break; // Si solo deseas encontrar la primera coincidencia, puedes salir del bucle aquí.
            }
        }

        if

    }
}



