package estancias.persistencia;

import java.sql.*;

public abstract class DAO {

    private static final String USER = "root";
    private static final String PASSWORD = "root1234";
    private static final String DATABASE = "estancias_exterior";
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    protected void conectarBase() throws ClassNotFoundException, SQLException {
        String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
    }
    protected void desconectarBase() throws Exception {
        try {
            if (sentencia != null) {
                sentencia.close();
            }
            if (resultado != null) {
                resultado.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }
    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException ex) {
            throw ex;
        } finally {
            desconectarBase();
        }
    }
    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
