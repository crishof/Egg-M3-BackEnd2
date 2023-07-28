///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package estancias.servicios;
//
//import estancias.entidades.Familia;
//import estancias.entidades.Producto;
//import estancias.persistencia.CasaDaoEx;
//import estancias.persistencia.EXDAO;
//
//import java.util.Collection;
//import java.util.Scanner;
//
//public class CasaService {
//
//
//    private final CasaDaoEx dao;
//
//    public CasaService() {
//        this.dao = new CasaDaoEx();
//    }
//
//    public void crearProducto() throws Exception {
//
//        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
//        System.out.println("Ingrese el nombre del producto");
//        String nombre = scanner.next();
//        System.out.println("Ingrese precio");
//        double precio = scanner.nextDouble();
//        System.out.println("Ingrese el nombre del fabricante");
//        String nombreFabricante = scanner.next();
//
//        if (fs.buscarFabricantePorNombre(nombreFabricante) == null) {
//            System.out.println("El fabricante no existe, vamos a crearlo");
//            fs.crearFabricante();
//        }
//
//        int codigoFabricante = fs.buscarCodigoFabricante(nombreFabricante);
//
//        try {
//            if (nombre == null || nombre.trim().isEmpty()) {
//                throw new Exception("Debe indicar el nombre");
//            }
//            if (precio == 0) {
//                throw new Exception("Debe indicar el precio");
//            }
//
//            Producto producto = new Producto();
//            producto.setNombre(nombre);
//            producto.setPrecio(precio);
//            producto.setCodigoFabricante(codigoFabricante);
//            dao.guardarProducto(producto);
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//    public Producto buscarProducto() throws Exception {
//
//        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
//        System.out.println("Ingrese el codigo del producto que desea modificar");
//        int codigo = scanner.nextInt();
//
//        try {
//
//            //Validamos
//            if (codigo <= 0) {
//                throw new Exception("Debe indicar el codigo del producto");
//            }
//            Producto producto = dao.buscarProductoPorCodigo(codigo);
//            //Verificamos
//            if (producto == null) {
//                throw new Exception("No se econtró ningún producto para el codigo indicado");
//            }
//
//            return producto;
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//    public void imprimirProductosNombre() throws Exception {
//
//        try {
//
//            Collection<Producto> productos = dao.listarProductosNombre();
//
//            if (productos.isEmpty()) {
//                throw new Exception("No existen productos para imprimir");
//            } else {
//                for (Producto aux : productos) {
//                    System.out.println(aux.getNombre());
//                }
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//    public void imprimirPrecioBetween() throws Exception {
//
//        try {
//
//            Collection<Producto> productos = dao.listarPrecioBetween();
//
//            if (productos.isEmpty()) {
//                throw new Exception("No existen productos para imprimir");
//            } else {
//                for (Producto aux : productos) {
//                    System.out.println(aux.toString());
//                }
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//    public void imprimirNombreLike() throws Exception {
//
//        try {
//
//            Collection<Producto> productos = dao.listarProductosNombreLike();
//
//            if (productos.isEmpty()) {
//                throw new Exception("No existen productos para imprimir");
//            } else {
//                for (Producto aux : productos) {
//                    System.out.println(aux.toString());
//                }
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//    public void imprimirPrecioMin() throws Exception {
//
//        try {
//
//            Collection<Producto> productos = dao.listarPrecioMin();
//
//            if (productos.isEmpty()) {
//                throw new Exception("No existen productos para imprimir");
//            } else {
//                for (Producto aux : productos) {
//                    System.out.println("Nombre: " + aux.getNombre() + " - Precio: " + aux.getPrecio());
//                }
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//    public void modificarProducto() throws Exception {
//        try {
//            Producto producto = buscarProducto();
//            System.out.println("producto = " + producto);
//            dao.modificarProducto(producto);
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//}
