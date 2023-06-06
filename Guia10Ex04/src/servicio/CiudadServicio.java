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
        codigos.put(945435, "Nairobi");
        codigos.put(23495, "Estocolmo");

        return codigos;
    }

    public HashMap<Integer, String> cargarCodigosManual(){

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        HashMap<Integer,String> codigos = new HashMap<>();
        String nombre;
        int cp;
        String check = "S";

        while (check.equalsIgnoreCase("S")) {
            System.out.println("Ingrese el nombre de la ciudad");
            nombre = leer.next();
            System.out.println("Ingrese el codigo postal");
            cp = leer.nextInt();

            nombre = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
            codigos.put(cp, nombre);

            System.out.println("desea ingresar otra ciudad? S/N");
            check = leer.next();
            if (!check.equalsIgnoreCase("S") && !check.equalsIgnoreCase("N")) {
                System.out.println("Opción invalida, reingrese S/N");
                check = leer.next();
            }
        }
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

        int clave1 = 0, clave2 = 0, clave3 = 0;

        for (Map.Entry<Integer, String> ciudades : codigos.entrySet()) {
            if (ciudades.getValue().equalsIgnoreCase(ciudad1)) {
                clave1 = ciudades.getKey();
            }
            if (ciudades.getValue().equalsIgnoreCase(ciudad2)) {
                clave2 = ciudades.getKey();
            }
            if (ciudades.getValue().equalsIgnoreCase(ciudad3)) {
                clave3 = ciudades.getKey();
            }
        }

        codigos.remove(clave1);
        codigos.remove(clave2);
        codigos.remove(clave3);

    }
}



