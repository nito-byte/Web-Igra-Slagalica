package sinonimi;

import admin.IgraDanaDAO;
import admin.IgraDanaDAOImpl;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import pojo.PojmoviAsocijacije;
import pojo.SinonimiKonacno;
import pojo.User;

/**
 *
 * @author tijana
 */
public class SinKDAOImpl implements SinKDAO {

    protected EntityManager entityManager;

    public SinKDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    
    public SinonimiKonacno getById(final int id) {
        return entityManager.find(pojo.SinonimiKonacno.class, id);
    }

    @Override
    public List<String> dohvati(int s) {

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(" "
                    + "select s.konacno "
                    + "from SinonimiKonacno s "
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
