package igraPoslDesetDana;

import igraDanaLista.*;
import gostListe.*;
import ucesnici.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.HibernateException;
import pojo.OdigranaIgraDana;
import pojo.Partija;
import pojo.User;

/**
 *
 * @author tijana
 */
public class IgraPoslDesetDanaDAOImpl implements IgraPoslDesetDanaDAO {

    protected EntityManager entityManager;

    public IgraPoslDesetDanaDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    @Override
    public List mojePartijePrethodnihDesetDana(String username) {
        try {
            Query query = this.entityManager.createQuery(
                    " select p.plaviUsername, p.plaviPoeni, p.crveniUsername, p.crveniPoeni, p.ishod, p.datumIganja "
                    + "from Partija p "
                    + "where DATEDIFF (NOW(), p.datumIganja) <= 9 "
                    + "and p.plaviUsername=:ime "
                    + "or p.crveniUsername=:ime "
            );
            query.setParameter("ime", username);
            List result = query.getResultList();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }

    }

}
