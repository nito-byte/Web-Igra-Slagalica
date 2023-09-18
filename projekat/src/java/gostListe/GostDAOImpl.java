package gostListe;

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
public class GostDAOImpl implements GostDAO {

    protected EntityManager entityManager;

    public GostDAOImpl() {
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
    public List najboljiUcesniciNedelje() {
        try {
            Query query = this.entityManager.createQuery(
                    " SELECT p.username, SUM(p.poeni) "
                    + " FROM Pobednici p "
                    + " WHERE DATEDIFF (NOW(), p.datumIgranja) <= 6 "
                    + " GROUP BY p.username "
                    + " ORDER BY SUM(p.poeni) DESC "
            );

            List result = query.getResultList();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }
    }

    @Override
    public List najboljiUcesniciMeseca() {
        try {
            Query query = this.entityManager.createQuery(
                    " SELECT p.username, SUM(p.poeni) "
                    + " FROM Pobednici p "
                    + " WHERE MONTH(p.datumIgranja) = MONTH(CURRENT_DATE()) "
                    + " AND YEAR(p.datumIgranja) = YEAR(CURRENT_DATE()) "
                    + " AND p.datumIgranja <=  current_date()"
                    + " GROUP BY p.username "
                    + " ORDER BY SUM(p.poeni) DESC "
            );

            List result = query.getResultList();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }
    }

   

}
