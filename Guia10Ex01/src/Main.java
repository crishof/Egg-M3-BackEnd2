import java.util.ArrayList;
import java.util.Scanner;
/*
1. Diseñar un programa que lea una serie de valores numéricos enteros desde el teclado
y los guarde en un ArrayList de tipo Integer. La lectura de números termina cuando se
introduzca el valor -99. Este valor no se guarda en el ArrayList. A continuación, el
programa mostrará por pantalla el número de valores que se han leído, su suma y su
media (promedio).
 */

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = ingresoNumeros();

        System.out.println("Se ingresaron " + numeros.size() + " numeros");

        int suma = sumarLista(numeros);
        System.out.println("suma = " + suma);
        double promedio = suma / numeros.size();
        System.out.println("promedio = " + promedio);
    }

    public static ArrayList<Integer> ingresoNumeros() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int numIngreso = 0;
        ArrayList<Integer> numeros = new ArrayList<>();

        while (numIngreso != -99) {
            System.out.println("Ingrese un numero");
            numIngreso = leer.nextInt();
            if (numIngreso != -99) {
                numeros.add(numIngreso);
            } else {
                System.out.println("Ingreso finalizado");
            }
        }
        return numeros;
    }

    public static int sumarLista(ArrayList<Integer> numeros) {

        int suma = 0;
        for (Integer sum : numeros) {
            suma += sum;
        }
        return suma;
    }
}
