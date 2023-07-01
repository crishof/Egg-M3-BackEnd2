package servicios;

import entidades.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

public class AlquilerServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Cliente crearCliente() {

        System.out.println("Ingrese nombre");
        String nombre = leer.next();
        System.out.println("Ingrese su DNI");
        int dni = leer.nextInt();

        return new Cliente(nombre, dni);
    }

    public Barco registroBarco() {

        System.out.println("Ingrese matricula");
        String matricula = leer.next();
        System.out.println("Ingrese eslora");
        int eslora = leer.nextInt();
        System.out.println("Ingrese año de fabricacion");
        int year = leer.nextInt();

        return new Barco(matricula, eslora, year);
    }

    public Barco crearVelero() {

        System.out.println("Ingrese cantidad de mástiles");
        int mastiles = leer.nextInt();
        Barco barco = registroBarco();
        return new Velero(barco.getMatricula(), barco.getEslora(), barco.getYear(), mastiles);
    }

    public BarcoMotor crearBarcoMotor() {

        System.out.println("Ingrese la potencia del barco");
        int potencia = leer.nextInt();
        Barco barco = registroBarco();
        return new BarcoMotor(barco.getMatricula(), barco.getEslora(), barco.getYear(), potencia);
    }

    public Barco crearYate() {

        System.out.println("Ingrese la cantidad de camarotes");
        int camarotes = leer.nextInt();
        BarcoMotor barco = crearBarcoMotor();
        return new YateLujo(barco.getMatricula(), barco.getEslora(), barco.getYear(), barco.getPotencia(), camarotes);

    }

    public Barco crearBarco() {

        int opcion;
        do {
            System.out.println("""
                    Ingrese el tipo de barco que va a amarrar:
                    1. Velero
                    2. Barco a motor
                    3. Yate
                            """);
            opcion = leer.nextInt();
            if (opcion < 1 || opcion > 3) {
                System.out.println("Opcion incorrecta, reingrese");
                opcion = leer.nextInt();
            }
        } while ((opcion < 1) || (opcion > 3));

        return switch (opcion) {
            case 1 -> crearVelero();
            case 2 -> crearBarcoMotor();
            case 3 -> crearYate();
            default -> new Barco();
        };
    }

    public Amarre Alquilar() {

        Random random = new Random();

        System.out.println("Ingrese fecha de entrada en formato AAAA-MM-DD");
        LocalDate ingreso = LocalDate.parse(leer.next());

        System.out.println("Ingrese fecha de salida en formato AAAA-MM-DD");
        LocalDate salida = LocalDate.parse(leer.next());

        int posicion = random.nextInt(1, 50);
        System.out.println("La posicion de amarre asigada en el muelle es: " + posicion);

        Barco barco = crearBarco();

        long periodo = calcularDias(ingreso,salida);

        double precio = calcularPrecio(periodo, barco);

        System.out.println("El precio del alquiler es: " + precio);

        return new Amarre(crearCliente(), ingreso, salida, posicion, barco);

    }

    public double calcularPrecio(long periodo, Barco barco) {

        double modulo = barco.getEslora() * 10;
        if (barco instanceof Velero) {
            modulo += ((Velero) barco).getMastiles();
        }
        if (barco instanceof BarcoMotor) {
            modulo += ((BarcoMotor) barco).getPotencia();
        }
        if (barco instanceof YateLujo) {
            modulo += (((YateLujo) barco).getPotencia() + ((YateLujo) barco).getCamarotes());
        }

        return periodo * modulo;
    }

    public long calcularDias(LocalDate ingreso,LocalDate salida) {

//        ingreso = LocalDate.of(2023, 1, 20);
//        salida = LocalDate.of(2023, 3, 20);
        var dias = DAYS.between(ingreso, salida);
        System.out.println("Solicitud por " + dias + " dias");

        return dias;
    }
}
