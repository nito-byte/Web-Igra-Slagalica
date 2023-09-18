package ucesnici;

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
public class UcesnikDAOImpl implements UcesnikDAO {

    protected EntityManager entityManager;

    public UcesnikDAOImpl() {
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

    public User getById(final int id) {
        return entityManager.find(pojo.User.class, id);
    }

    public List<User> getStujardesa(String kompanija) {
        String sql = " from User u where u.tipKorisnika=:tip"
                + " and u.prihvacenZahtev=:zahtev"
                + " and u.airline=:kompanija ";
        Query query = entityManager.createQuery(sql);
        query.setParameter("tip", "stujardesa");
        query.setParameter("zahtev", "true");
        query.setParameter("kompanija", kompanija);
        return query.getResultList();
    }

    public List<User> getPilot(String kompanija) {
        String sql = " from User u where u.tipKorisnika=:tip"
                + " and u.prihvacenZahtev=:zahtev"
                + " and u.airline=:kompanija ";

        Query query = entityManager.createQuery(sql);
        query.setParameter("tip", "pilot");
        query.setParameter("zahtev", "true");
        query.setParameter("kompanija", kompanija);
        return query.getResultList();
    }

    public User getWithUsername(String usern, String pass) {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<User> query = entityManager.createQuery("SELECT c FROM User c WHERE c.username = ?1 and c.password=?2 and c.prihvacenZahtev=:da", User.class);
            query.setParameter(1, usern);
            query.setParameter(2, pass);
            query.setParameter("da", "true");

            entityManager.getTransaction().commit();
            return query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        }

    }

    public List<User> findAll() {
        // return entityManager.createQuery("FROM " + User.class.getName()).getResultList();
        return entityManager.createQuery("FROM User").getResultList();

    }

    public List<User> findByNijePrihvacenZahtev() {

        String sql = " from User u where u.prihvacenZahtev=:name";
        Query query = entityManager.createQuery(sql);
        query.setParameter("name", "false");
        return query.getResultList();
    }

    public List<User> findByPrihvacenZahtev() {

        String sql = " from User u where u.prihvacenZahtev=:name  and u.tipKorisnika=:tip";
        Query query = entityManager.createQuery(sql);
        query.setParameter("name", "true");
        query.setParameter("tip", "pilot");
        return query.getResultList();
    }

    public User getWithOnlyUsername(String usern) {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<User> query = entityManager.createQuery("SELECT c FROM User c WHERE c.username = ?1 and c.prihvacenZahtev=:da", User.class);
            query.setParameter(1, usern);
            query.setParameter("da", "true");

            entityManager.getTransaction().commit();
            return query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }

    }

    @Override
    public List najboljiUcesniciNedelje() {
        try {
            Query query = this.entityManager.createQuery(
                    " SELECT p.username, SUM(p.poeni) "
                    + " FROM Pobednici p "
                    + " WHERE DATEDIFF (NOW(), p.datumIgranja) <= 7 "
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

    @Override
    public List slobodnePartijeZaIgranje(String ucesnikUsername) {
        try {
            Query query = this.entityManager.createQuery(
                    " SELECT p.id, p.plaviUsername "
                    + " FROM Partija p "
                    + " WHERE p.aktivnaIgra = :vr "
                    + " AND p.plaviUsername <> :ucesnik "
            );
            query.setParameter("vr", 0);
            query.setParameter("ucesnik", ucesnikUsername);
            List result = query.getResultList();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }
    }

    @Override
    public List potvrdiPartijeZaIgranje(String ucesnikUsername) {
        try {
            Query query = this.entityManager.createQuery(
                    " SELECT p.id, p.crveniUsername "
                    + " FROM Partija p "
                    + " WHERE p.aktivnaIgra = :vr "
                    + " AND p.plaviUsername = :ucesnik "
                    + " AND  p.potvrdioCrveni =:vr1 "
            );
            query.setParameter("vr", 0);
            query.setParameter("vr1", 1);
            query.setParameter("ucesnik", ucesnikUsername);
            List result = query.getResultList();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return new ArrayList();
        }
    }

}
