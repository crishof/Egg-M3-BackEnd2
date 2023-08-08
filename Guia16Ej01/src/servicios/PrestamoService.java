package servicios;

import entidades.Cliente;
import entidades.Libro;
import entidades.Prestamo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import persistencia.PrestamoDAO;

public class PrestamoService {

    LibroService ls;
    ClienteService cs;
    PrestamoDAO dao;

    public PrestamoService() {

        dao = new PrestamoDAO();
        ls = new LibroService();
        cs = new ClienteService();
    }

    public void prestarLibro() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese dni del cliente");
        long dni = leer.nextLong();

        Cliente cliente = null;
        List<Cliente> clientes = cs.buscarCliente(dni);

        if (clientes.isEmpty()) {
            System.out.println("El cliente no existe, desea crearlo? S/N");
            if (leer.next().equalsIgnoreCase("S")) {

                cs.guardarCliente(dni);
                System.out.println("dni: " + dni);
            } else {
                System.out.println("Cliente no guardado. Volviendo al menu");
                return;
            }
        }
        cliente = cs.buscarClienteSingle(dni);

        System.out.println("Ingrese el nombre del libro a retirar");
        String nombre = leer.next();

        Libro libro = ls.buscarLibroTitulo(nombre);

        Date fechaInicio = new Date();

        // Crear instancia de Calendar y establecer la fecha inicial
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);

        // Sumar 7 días
        calendar.add(Calendar.DAY_OF_YEAR, 7);

        // Obtener la nueva fecha
        Date fechaFinal = calendar.getTime();

        if (libro.getEjemplaresRestantes() > 0) {
            System.out.println("Deberá devolverlo el " + fechaFinal.toString());

            ls.prestarLibro(libro);

            Prestamo prestamo = new Prestamo();

            prestamo.setCliente(cliente);
            System.out.println("cliente = " + cliente);
            prestamo.setFechaDevolucion(fechaFinal);
            prestamo.setFechaPrestamo(fechaInicio);
            prestamo.setLibro(libro);

            dao.persistirPrestamo(prestamo);
        } else {
            System.out.println("No quedan unidades disponibles");
        }

    }

    public void devolverLibro() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese dni del cliente");
        long dni = leer.nextLong();
        Cliente cliente = null;
        cliente = cs.buscarClienteSingle(dni);

        List<Prestamo> prestamos = dao.buscarPrestamosPorDni(dni);

        if (prestamos.isEmpty()) {
            System.out.println("El cliente no tiene libros para devolver");
            return;
        }
        System.out.println("Indique el libro que desea devolver");
        int indice = 1;
        for (Prestamo aux : prestamos) {

            System.out.println("Id prestamo: " + indice + " - libro: " + aux.getLibro().getTitulo() + " - fecha devolucion: " + aux.getFechaDevolucion());
            indice++;
        }

    }
//    
//    public void listarPrestamosCliente(){
//        
//        Scanner leer = new Scanner(System.in).useDelimiter("\n");
//        
//        System.out.println("Ingrese el dni del cliente");
//        int dniCliente = leer.nextInt();
//        
//        List<Prestamo> prestamos = buscarPrestamoCliente(dniCliente);
//        
//        
//    }
//    
//    public List<Prestamo> buscarPrestamoCliente(int dniCliente) {
//        return dao.consultaGenerica("Prestamo", "cliente.dni", );
//    }

}
