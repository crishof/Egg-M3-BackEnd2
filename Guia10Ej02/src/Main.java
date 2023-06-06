import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/*
Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
la lista ordenada.
 */
public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        ArrayList<String> razas = new ArrayList<>();

//        String check;
//        do {
//            System.out.println("ingrese una raza de perro");
//            razas.add(leer.next());
//            System.out.println("Desea ingresar otra? S/N");
//            check = leer.next();
//            while (!check.equalsIgnoreCase("S") && !check.equalsIgnoreCase("N")){
//                System.out.println("Opción incorrecta, reingrese");
//                check = leer.next();
//            }
//        } while (check.equalsIgnoreCase("S"));

        razas.add("ovejero");
        razas.add("beagle");
        razas.add("dogo");
        razas.add("caniche");


        System.out.println("Las razas ingresadas son: ");
        for (String perros : razas) {
            System.out.println(perros);
        }

        System.out.println("Ingrese un perro a buscar");
        String perro = leer.next();

        Iterator<String> iterator = razas.iterator();
        boolean noEncontrado = true;


        while (iterator.hasNext()) {
            if (iterator.next().equals(perro)) {
                System.out.println("Perro encontrado");
                iterator.remove();
                noEncontrado = false;

            }
        }

        Collections.sort(razas);

        for (String perros : razas) {
            System.out.println(perros);
        }

        razas.add("dalmata");
        razas.add("caniche");

        for (String perros : razas) {
            System.out.println(perros);
        }

        if (noEncontrado) {
            System.out.println("La raza ingresada no se encuentra");
            System.out.println("No se eliminó ninguna raza");
        }
    }
}
