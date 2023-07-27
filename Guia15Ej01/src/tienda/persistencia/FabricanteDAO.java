package tienda.persistencia;

import tienda.entidades.Fabricante;
public class FabricanteDAO extends DAO {

    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar un fabricante");
            }
            String sql = "INSERT INTO Fabricante (nombre, nacionalidad) VALUES ( '" + fabricante.getNombre() + "' , '" + fabricante.getNacionalidad() + "' );";

            insertarModificarEliminar(sql);
        } finally {
            desconectarBase();
        }
    }
    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {
        try {

            String sql = "SELECT * FROM fabricante WHERE nombre = '" + nombre + "';";

            consultarBase(sql);

            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricante.setNacionalidad(resultado.getString(3));
            }
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        } finally {
            desconectarBase();
        }
    }
}