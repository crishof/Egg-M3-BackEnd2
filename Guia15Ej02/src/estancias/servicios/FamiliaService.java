package estancias.servicios;

import estancias.entidades.Familia;
import estancias.persistencia.FamiliaDaoEx;

import java.util.Collection;

public class FamiliaService {

    private final FamiliaDaoEx dao;

    public FamiliaService() {
        this.dao = new FamiliaDaoEx();
    }

    public void imprimirFamiliasHijos() throws Exception {

        try {
            Collection<Familia> familias = dao.listarFamiliaXHijos();
            if (familias.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Familia aux : familias) {
                    System.out.println(aux.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
