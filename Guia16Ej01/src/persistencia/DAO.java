package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    public DAO() {
        emf = Persistence.createEntityManagerFactory("JpaTestPU");
        em = emf.createEntityManager();
    }
//    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaTestPU");
//    EntityManager em = emf.createEntityManager();

//    Instancia resumida
//    EntityManager em = 
//            Persistence.createEntityManagerFactory("JpaTestPU")
//                        .createEntityManager();
    protected void conectarBase() {
        if (!em.isOpen()) {
            emf = Persistence.createEntityManagerFactory("JpaTestPU");
            em = emf.createEntityManager();
        }
    }

    protected void desconectarBase() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void persistirEntidad(Object object) {

        try {
            conectarBase();
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo cargar");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            desconectarBase();
        }
    }

    protected void actualizarEntidad(Object object) {
        try {
            conectarBase();
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo actualizar");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            desconectarBase();
        }

    }

    protected void borrarEntidad(Object object) {
        try {
            conectarBase();
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No se pudo borrar");
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            desconectarBase();
        }

    }

}
