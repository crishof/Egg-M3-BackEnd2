import java.util.ArrayList;
import java.util.Scanner;

/*
Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String.
El programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir.
Si decide salir, se mostrará todos los perros guardados en el ArrayList.
 */
public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ArrayList<String> razas = new ArrayList<>();

        String check = "S";
        do {
                System.out.println("ingrese una raza de perro");
                razas.add(leer.next());
                System.out.println("Desea ingresar otra? S/N");
                check = leer.next();
                while (!check.equalsIgnoreCase("S") && !check.equalsIgnoreCase("N")){
                    System.out.println("Opción incorrecta, reingrese");
                    check = leer.next();
                }
        } while (check.equalsIgnoreCase("S"));

        System.out.println("Las razas ingresadas son: ");
        for ( String perros : razas){
            System.out.println(perros);
        }
    }
}
