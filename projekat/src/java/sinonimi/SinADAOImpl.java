package sinonimi;

import admin.IgraDanaDAO;
import admin.IgraDanaDAOImpl;
import com.pojmovi_asocijacije.SinonimiADAO;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import pojo.PojmoviAsocijacije;
import pojo.SinonimiA;
import pojo.User;

/**
 *
 * @author tijana
 */
public class SinADAOImpl implements SinADAO {

    protected EntityManager entityManager;

    public SinADAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    
    public SinonimiA getById(final int id) {
        return entityManager.find(pojo.SinonimiA.class, id);
    }

    @Override
    public List<String> dohvati(int s) {

        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(" "
                    + "select s.kolonaA "
                    + "from SinonimiA s "
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
