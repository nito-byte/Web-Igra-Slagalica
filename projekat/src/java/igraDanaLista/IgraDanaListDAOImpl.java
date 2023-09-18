package igraDanaLista;

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
public class IgraDanaListDAOImpl implements IgraDanaListDAO {

    protected EntityManager entityManager;

    public IgraDanaListDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public List najboljiIgraDana() {
        try {
            Query query = this.entityManager.createQuery(
                    " SELECT o.username, o.bodovi "
                    + "From OdigranaIgraDana o "
                    + "where o.datum=current_date() "
                    + "and o.odigrano=:br "
                    + "order by o.bodovi  desc "
            );
            query.setParameter("br", 1);
            List result = query.getResultList();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }

    }

    public List najboljiIgraDanaUsername() {
        try {
            Query query = this.entityManager.createQuery(
                    " SELECT o.username "
                    + "From OdigranaIgraDana o "
                    + "where o.datum=current_date() "
                    + "order by o.bodovi  desc "
            );

            List result = query.getResultList();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }

    }

    @Override
    public int dohvatiBodove(String username) {
        try {
            Query query = this.entityManager.createQuery(
                    " SELECT o.bodovi "
                    + "From OdigranaIgraDana o "
                    + "where o.datum=current_date() "
                    + "and o.username=:ime "
            );
            query.setParameter("ime", username);
            int result = (int) query.getSingleResult();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

}
