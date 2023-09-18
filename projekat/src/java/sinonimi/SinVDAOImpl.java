package sinonimi;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pojo.SinonimiV;

/**
 *
 * @author tijana
 */
public class SinVDAOImpl implements SinVDAO {

    protected EntityManager entityManager;

    public SinVDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    
    public SinonimiV getById(final int id) {
        return entityManager.find(pojo.SinonimiV.class, id);
    }

    @Override
    public List<String> dohvati(int s) {

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(" "
                    + "select s.kolonaV "
                    + "from SinonimiV s "
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
