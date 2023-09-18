package admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.HibernateException;
import pojo.IgraDana;
import pojo.User;

/**
 *
 * @author tijana
 */
public class IgraDanaDAOImpl implements IgraDanaDAO {

    protected EntityManager entityManager;

    public IgraDanaDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void persist(IgraDana igraDana) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(igraDana);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(IgraDana igraDana) {
        try {
            entityManager.getTransaction().begin();
            igraDana = entityManager.find(pojo.IgraDana.class, igraDana.getId());
            entityManager.remove(igraDana);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(IgraDana igraDana) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(igraDana);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
//
//    public User getById(final int id) {
//        return entityManager.find(pojo.User.class, id);
//    }
//
//    public List<User> getStujardesa(String kompanija) {
//        String sql = " from User u where u.tipKorisnika=:tip"
//                + " and u.prihvacenZahtev=:zahtev"
//                + " and u.airline=:kompanija ";
//        Query query = entityManager.createQuery(sql);
//        query.setParameter("tip", "stujardesa");
//        query.setParameter("zahtev", "true");
//        query.setParameter("kompanija", kompanija);
//        return query.getResultList();
//    }
//
//    public List<User> getPilot(String kompanija) {
//        String sql = " from User u where u.tipKorisnika=:tip"
//                + " and u.prihvacenZahtev=:zahtev"
//                + " and u.airline=:kompanija ";
//
//        Query query = entityManager.createQuery(sql);
//        query.setParameter("tip", "pilot");
//        query.setParameter("zahtev", "true");
//        query.setParameter("kompanija", kompanija);
//        return query.getResultList();
//    }
//
//    public User getWithUsername(String usern, String pass) {
//        try {
//            entityManager.getTransaction().begin();
//            TypedQuery<User> query = entityManager.createQuery("SELECT c FROM User c WHERE c.username = ?1 and c.password=?2 and c.prihvacenZahtev=:da", User.class);
//            query.setParameter(1, usern);
//            query.setParameter(2, pass);
//            query.setParameter("da", "true");
//
//            entityManager.getTransaction().commit();
//            return query.getSingleResult();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//
//        }
//
//    }
//
//    public List<User> findAll() {
//        // return entityManager.createQuery("FROM " + User.class.getName()).getResultList();
//        return entityManager.createQuery("FROM User").getResultList();
//
//    }
//
//    public List<User> findByNijePrihvacenZahtev() {
//
//        String sql = " from User u where u.prihvacenZahtev=:name";
//        Query query = entityManager.createQuery(sql);
//        query.setParameter("name", "false");
//        return query.getResultList();
//    }
//
//    public List<User> findByPrihvacenZahtev() {
//
//        String sql = " from User u where u.prihvacenZahtev=:name  and u.tipKorisnika=:tip";
//        Query query = entityManager.createQuery(sql);
//        query.setParameter("name", "true");
//        query.setParameter("tip", "pilot");
//        return query.getResultList();
//    }
//
//    public User getWithOnlyUsername(String usern) {
//        try {
//            entityManager.getTransaction().begin();
//            TypedQuery<User> query = entityManager.createQuery("SELECT c FROM User c WHERE c.username = ?1 and c.prihvacenZahtev=:da", User.class);
//            query.setParameter(1, usern);
//            query.setParameter("da", "true");
//
//            entityManager.getTransaction().commit();
//            return query.getSingleResult();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            entityManager.getTransaction().rollback();
//            return null;
//        }
//
//    }

    @Override
    public boolean vecPostojiIgra(Date when) {

        Query query = this.entityManager.createQuery("SELECT f "
                + "FROM IgraDana f "
                + "WHERE day(f.start) = :day AND month(f.start) = :month AND year(f.start) = :year "
                + "ORDER BY f.start DESC "
        );

        Calendar cal = Calendar.getInstance();
        cal.setTime(when);
        query.setParameter("day", cal.get(Calendar.DAY_OF_MONTH));
        query.setParameter("month", cal.get(Calendar.MONTH) + 1);
        query.setParameter("year", cal.get(Calendar.YEAR));
        List result = query.getResultList();

        if (result.size() == 0) {
            return false; //ne postoji u bazi
        } else {
            return true;  //postoji u bazi
        }

    }
    
    public IgraDana getTodayIgraDanaPostoji() {
        Query query = this.entityManager.createQuery("SELECT f "
                + "FROM IgraDana f "
                + "WHERE day(f.start) = :day AND month(f.start) = :month AND year(f.start) = :year "
                + "ORDER BY f.start DESC "
        );

        Date today = Calendar.getInstance().getTime();

        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        query.setParameter("day", cal.get(Calendar.DAY_OF_MONTH));
        query.setParameter("month", cal.get(Calendar.MONTH) + 1);
        query.setParameter("year", cal.get(Calendar.YEAR));
        IgraDana result = (IgraDana) query.getSingleResult();

        if (result==null) {
            return null;
        } else {
            return result;
        }
    }

    public IgraDana getTodayIgraDana() {
        Query query = this.entityManager.createQuery("SELECT f "
                + "FROM IgraDana f "
                + "WHERE day(f.start) = :day AND month(f.start) = :month AND year(f.start) = :year "
                + "ORDER BY f.start DESC "
        );

        Date today = Calendar.getInstance().getTime();

        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        query.setParameter("day", cal.get(Calendar.DAY_OF_MONTH));
        query.setParameter("month", cal.get(Calendar.MONTH) + 1);
        query.setParameter("year", cal.get(Calendar.YEAR));
        List result = query.getResultList();

        if (result.size() == 0) {
            return null;
        } else {
            return (IgraDana) result.get(0);
        }
    }

    public IgraDana getIgraDanaPostojiINijeOdigrana() {
        Query query = this.entityManager.createQuery("SELECT f "
                + "FROM IgraDana f "
                + "WHERE day(f.start) = :day AND month(f.start) = :month AND year(f.start) = :year "
                + "AND f.odigrano =:odigrano "
                + "ORDER BY f.start DESC "
        );

        Date today = Calendar.getInstance().getTime();

        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        query.setParameter("day", cal.get(Calendar.DAY_OF_MONTH));
        query.setParameter("month", cal.get(Calendar.MONTH) + 1);
        query.setParameter("year", cal.get(Calendar.YEAR));
        query.setParameter("odigrano", 0);
        List result = query.getResultList();

        if (result.size() == 0) {
            return null;
        } else {
            return (IgraDana) result.get(0);
        }
    }

    @Override
    public int dohvatiIdAsocijacijaZaIgruDana() {
        try {
            Query query = this.entityManager.createQuery(
                    " select d.idasocijacija "
                    + "from IgraDana d "
                    + "where date(d.start)=current_date() "
            );

            int result = (int) query.getSingleResult();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }
    
     @Override
    public int dohvatiIdSpojnicaZaIgruDana() {
        try {
            Query query = this.entityManager.createQuery(
                    " select d.idspojnice "
                    + "from IgraDana d "
                    + "where date(d.start)=current_date() "
            );

            int result = (int) query.getSingleResult();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

}
