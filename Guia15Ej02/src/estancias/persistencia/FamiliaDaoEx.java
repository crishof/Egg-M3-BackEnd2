package estancias.persistencia;

import estancias.entidades.Familia;

import java.util.ArrayList;
import java.util.Collection;

public class FamiliaDaoEx extends DAO {

    public Familia listarFamilias() throws Exception {
        try {
            String sql = "select * from familia";
            consultarBase(sql);
            Familia familia = null;
            while (resultado.next()) {
                familia = new Familia();
                familia.setIdFamilia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMin(resultado.getInt(3));
                familia.setEdadMax(resultado.getInt(4));
                familia.setNumHijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setIdCasaFamilia(resultado.getInt(7));
            }
            desconectarBase();
            return familia;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    public Collection<Familia> listarFamiliaXHijos() throws Exception {
        try {
            String sql = "select * from familias where num_hijos >= 3 and edad_maxima < 10;";
            System.out.println("sql = " + sql);
            consultarBase(sql);
            Familia familia = null;
            Collection<Familia> familias = new ArrayList<>();
            while (resultado.next()) {
                familia = new Familia();
                familia.setIdFamilia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMin(resultado.getInt(3));
                familia.setEdadMax(resultado.getInt(4));
                familia.setNumHijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setIdCasaFamilia(resultado.getInt(7));
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
}
