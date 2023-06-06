package servicio;
import java.util.*;

public class PaisServicio {

    public HashSet<String> ingresarPaises() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        HashSet<String> paises = new HashSet<>();
        String check;
        do {
            System.out.println("Ingrese el nombre de un pais");
            paises.add(leer.next());
            System.out.println("Desea ingresar otro pais? digite S/N");
            check = leer.next();
            while (!check.equalsIgnoreCase("S") && !check.equalsIgnoreCase("N")) {
                    System.out.println("Opción incorrecta, reingrese");
                    check = leer.next();
            }
        } while (check.equalsIgnoreCase("S"));

//        paises.add("Argentina");
//        paises.add("Chile");
//        paises.add("Irlanda");
//        paises.add("Suecia");
//        paises.add("Argentina");
//        paises.add("China");

        return paises;
    }

    public void mostrarPaises(HashSet<String> paises) {

        System.out.println("-------------------");
        System.out.println("Mostrar paises");
        for (String pais : paises) {
            System.out.println(pais);
        }
    }

    public void ordenarPaises(HashSet<String> paises) {

        System.out.println("-------------------");
        System.out.println("Ordenar paises");

        ArrayList<String> paisesOrdenados = new ArrayList<>(paises);
        Collections.sort(paisesOrdenados);

        for (String pais : paisesOrdenados) {
            System.out.println(pais);
        }
    }

    public void buscarPais(HashSet<String> paises) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el pais que desea buscar");
        String paisBuscar = leer.next();

        Iterator<String> iterator = paises.iterator();

        boolean check = false;
        while (iterator.hasNext()) {
            String paisLeido = iterator.next();
            if (paisLeido.equalsIgnoreCase(paisBuscar)) {
                System.out.println("El pais se encuentra en la lista");
                iterator.remove();
                check = true;
                break;
            }
        }

        if (!check) System.out.println("No se encuentra el pais");

    }
}
