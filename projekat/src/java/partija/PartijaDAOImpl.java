package partija;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pojo.Partija;
import pojo.User;

/**
 *
 * @author tijana
 */
public class PartijaDAOImpl implements PartijaDAO {

    protected EntityManager entityManager;

    public PartijaDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void persist(Partija partija) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(partija);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Partija partija) {
        try {
            entityManager.getTransaction().begin();
            partija = entityManager.find(pojo.Partija.class, partija.getId());
            entityManager.remove(partija);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Partija partija) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(partija);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public Partija getById(final int id) {
        return entityManager.find(pojo.Partija.class, id);
    }

    

}
