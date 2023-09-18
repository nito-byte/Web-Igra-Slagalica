package sinonimi;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pojo.SinonimiG;

/**
 *
 * @author tijana
 */
public class SinGDAOImpl implements SinGDAO {

    protected EntityManager entityManager;

    public SinGDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    
    public SinonimiG getById(final int id) {
        return entityManager.find(pojo.SinonimiG.class, id);
    }

    @Override
    public List<String> dohvati(int s) {

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(" "
                    + "select s.kolonaG "
                    + "from SinonimiG s "
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
