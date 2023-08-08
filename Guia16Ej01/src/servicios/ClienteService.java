package servicios;

import entidades.Cliente;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import persistencia.ClienteDAO;

public class ClienteService {

    ClienteDAO dao;

    public ClienteService() {

        dao = new ClienteDAO();
    }

    public void guardarCliente() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean loop;

//        Ingresamos el dni del cliente
        do {
            loop = false;

            Cliente cliente = null;
            System.out.println("Ingrese dni del cliente");
            long dni = leer.nextLong();

// Validamos que el cliente no está en la base
            List<Cliente> clientes = buscarCliente(dni);
            if (clientes.isEmpty()) {
                cliente = new Cliente();
                cliente.setDni(dni);

                System.out.println("Ingrese nombre");
                String nombre = leer.next();
                System.out.println("Ingrese apellido");
                String apellido = leer.next();
                System.out.println("Ingrese telefono");
                String telefono = leer.next();

                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setTelefono(telefono);

//                Enviamos los datos del cliente a persistencia
                System.out.println(cliente);
                dao.persistirCliente(cliente);

            } else {
                System.out.println("Ya existe un cliente con el dni ingresado");
            }

            System.out.println("¿Desea cargar otro Cliente? S/N");
            if (leer.next().equalsIgnoreCase("S")) {
                loop = true;
            } else {
                System.out.println("Cliente cargado.");
            }
        } while (loop);
    }

    public void guardarCliente(long dni) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        Cliente cliente = new Cliente();

        cliente.setDni(dni);

        System.out.println("Ingrese nombre del Cliente");
        String nombre = leer.next();
        cliente.setNombre(nombre);

        System.out.println("Ingrese apellido del Cliente");
        String apellido = leer.next();
        cliente.setApellido(apellido);

        System.out.println("Ingrese numero de telefono del Cliente");
        String telefono = leer.next();
        cliente.setTelefono(telefono);

        dao.persistirCliente(cliente);
        System.out.println("Cliente guardado exitosamente");

    }

    public List buscarCliente(long dni) {

        List<Cliente> clientes = dao.buscarClienteDni(dni);

        return clientes;

    }

    public Cliente buscarClienteSingle(long dni) {

        Cliente cliente = dao.buscarClienteDniSingle(dni);

        return cliente;

    }

//    public void bajaCliente() {
//        Scanner leer = new Scanner(System.in).useDelimiter("\n");
//
//        boolean noEncontrado = true;
//        boolean alta = true;
//        boolean loop;
//
//        Cliente cliente = buscarClienteNombre();
//        if (cliente != null) {
//            do {
//                System.out.println("1 - Dar de baja");
//                System.out.println("2 - Dar de Alta");
//                int opcion = leer.nextInt();
//                switch (opcion) {
//                    case 1 -> {
//                        alta = false;
//                        loop = false;
//                    }
//                    case 2 -> {
//                        alta = true;
//                        loop = false;
//                    }
//                    default -> {
//                        System.out.println("Opcion incorrecta");
//                        loop = true;
//                    }
//                }
//
//            } while (loop);
//            cliente.setAlta(alta);
//            noEncontrado = false;
//            dao.actualizarCliente(cliente);
//
//        }
//        if (noEncontrado) {
//            System.out.println("Cliente no encontrado");
//            leer.next();
//        }
//    }
//    
//    public void modificarCliente() {
//        Scanner leer = new Scanner(System.in).useDelimiter("\n");
//        Cliente cliente = null;
//
//        cliente = buscarClienteNombre();
//
//        boolean noEncontrado = true;
//        if (cliente != null) {
//            boolean alta = true;
//            boolean bucle2;
//            do {
//                bucle2 = false;
//                System.out.println("1- Darlo de baja");
//                System.out.println("2- Darlo de alta");
//                int opcion = leer.nextInt();
//                switch (opcion) {
//                    case 1 ->
//                        alta = false;
//                    case 2 ->
//                        alta = true;
//                    default -> {
//                        System.out.println("Opción no reconocida");
//                        bucle2 = true;
//                    }
//                }
//            } while (bucle2);
//            cliente.setAlta(alta);
//            noEncontrado = false;
//            dao.actualizarCliente(cliente);
//        }
//
//        if (noEncontrado) {
//            System.out.println("Cliente no encontrado");
//            leer.next();
//        }
//    }
//    
}
