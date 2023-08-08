package persistencia;

import entidades.Prestamo;
import java.util.List;
import javax.persistence.Query;

public class PrestamoDAO extends DAO{
    
    public void persistirPrestamo(Prestamo prestamo) {
        persistirEntidad(prestamo);
    }

    public void actualizarPrestamo(Prestamo prestamo) {
        actualizarEntidad(prestamo);
    }

    public void borrarPrestamo(Prestamo prestamo) {
        borrarEntidad(prestamo);
    }

    public Object buscarPrestamo(String nombre) {

        conectarBase();
        String jpql = "Select a from Prestamo a where a.nombre = :nombre";
        Object prestamo = em.createQuery(jpql)
                .setParameter("nombre", nombre).getSingleResult();

        desconectarBase();
        return prestamo;
    }

    public List<Prestamo> buscarPrestamosPorDni(Long dni) {
        conectarBase();
        String jpql = "SELECT p FROM Prestamo p JOIN p.cliente c WHERE c.dni = :dni";

        List<Prestamo> prestamos = em.createQuery(jpql).setParameter("dni", dni).getResultList();

        desconectarBase();

        return prestamos;
        
    }
    
//    public List consultaGenerica(String entidad, String atributo, String variable) {
//        conectarBase();
//        String jpql = "SELECT e FROM " + entidad + " e WHERE e." + atributo + " LIKE :variable";
//        Query query = em.createQuery(jpql);
//        query.setParameter("variable", "%" + variable + "%");
////        desconectarBase();
//        return query.getResultList();
//    }
    
}
