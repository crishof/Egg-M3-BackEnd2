package estancias.persistencia;

import estancias.entidades.Producto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public final class EXDAO extends DAO {
    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante) VALUES ('" + producto.getNombre() + "' , '" + producto.getPrecio() + "' , '" + producto.getCodigoFabricante() + "' );";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }

            Scanner leer = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Ingrese el nuevo nombre");
            String nombre = leer.next();
            System.out.println("Ingrese el nuevo precio");
            double precio = leer.nextDouble();
            System.out.println("Ingrese el nuevo codigo de fabricante");
            int codigoFab = leer.nextInt();
            String sql = "UPDATE Producto SET nombre = '" + nombre + "', precio = '" + precio + "', codigo_fabricante = '" + codigoFab + "' WHERE codigo = '" + producto.getCodigo() + "';";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE codigo = '" + codigo + "';";
            System.out.println("sql = " + sql);
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;

        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    public Collection<Producto> listarProductosNombre() throws Exception {
        try {
            String sql = "SELECT nombre FROM Producto;";
            consultarBase(sql);
            Producto producto;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    public Collection<Producto> listarProdNombrePrecio() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM Producto;";
            consultarBase(sql);
            Producto producto;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    public Collection<Producto> listarPrecioBetween() throws Exception {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese los precios por los que desea filtrar\n" +
                "Ingrese el precio minimo");
        int minPrice = scanner.nextInt();
        System.out.println("Ingrese el precio maximo");
        int maxPrice = scanner.nextInt();
        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN " + minPrice + " AND " + maxPrice + ";";
            consultarBase(sql);
            Producto producto;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    public Collection<Producto> listarProductosNombreLike() throws Exception {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese la frase que desea buscar");
        String frase = scanner.next();
        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%" + frase + "%';";
            consultarBase(sql);
            Producto producto;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    public Collection<Producto> listarPrecioMin() throws Exception {

        try {
            String sql = "select nombre, precio from producto where precio = (select min(precio) from producto);";
            consultarBase(sql);
            Producto producto;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}

