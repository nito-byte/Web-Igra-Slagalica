package sinonimi;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pojo.SinonimiB;

/**
 *
 * @author tijana
 */
public class SinBDAOImpl implements SinBDAO {

    protected EntityManager entityManager;

    public SinBDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    
    public SinonimiB getById(final int id) {
        return entityManager.find(pojo.SinonimiB.class, id);
    }

    @Override
    public List<String> dohvati(int s) {

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(" "
                    + "select s.kolonaB "
                    + "from SinonimiB s "
                    + "where sifra=?1 ");
            query.setParameter(1, s);
            entityManager.getTransaction().commit();
            return query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

}
