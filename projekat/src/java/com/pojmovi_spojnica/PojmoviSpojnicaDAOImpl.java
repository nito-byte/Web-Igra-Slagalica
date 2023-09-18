package com.pojmovi_spojnica;

import admin.IgraDanaDAO;
import admin.IgraDanaDAOImpl;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import pojo.PojmoviSpojnice;

/**
 *
 * @author tijana
 */
public class PojmoviSpojnicaDAOImpl implements PojmoviSpojnicaDAO {

    protected EntityManager entityManager;

    public PojmoviSpojnicaDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void persist(PojmoviSpojnice pojmoviSpojnice) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pojmoviSpojnice);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(PojmoviSpojnice pojmoviSpojnice) {
        try {
            entityManager.getTransaction().begin();
            pojmoviSpojnice = entityManager.find(pojo.PojmoviSpojnice.class, pojmoviSpojnice.getId());
            entityManager.remove(pojmoviSpojnice);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(PojmoviSpojnice pojmoviSpojnice) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pojmoviSpojnice);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public PojmoviSpojnice getById(final int id) {
        return entityManager.find(pojo.PojmoviSpojnice.class,  id);
    }
    
    public List<PojmoviSpojnice> findAll() {
        // return entityManager.createQuery("FROM " + Airplane.class.getName()).getResultList();
        return entityManager.createQuery("FROM PojmoviSpojnice").getResultList();
    }

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

//    public List<PojmoviSpojnice> findAll() {
//        // return entityManager.createQuery("FROM " + User.class.getName()).getResultList();
//        return entityManager.createQuery("FROM User").getResultList();
//
//    }

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
    public PojmoviSpojnice dohvatiSpojnicu() {
        
        IgraDanaDAO dao = new IgraDanaDAOImpl();
        int rez =dao.dohvatiIdSpojnicaZaIgruDana();
    
//        //dohvatim najpre broj svih spojnica u tabeli
//        Long b = dohvatiBrojSpojnicaUTabeli();
//        int broj=b.intValue();  
//        
//        //izaberem slucajan broj u tabeli
//        Random random = new Random();
//        int min=1;
//        int max=broj;
//        int randomNumber = random.nextInt(max + 1 - min) + min;
//        
//        //provera greske
//        if((randomNumber>broj) || (randomNumber<=0)) randomNumber=1;
//        
        //dohvatim taj red u tabeli PojmoviSpojnice
        try {
            entityManager.getTransaction().begin();
            TypedQuery<PojmoviSpojnice> query = entityManager.createQuery(" SELECT c FROM PojmoviSpojnice c WHERE c.id=?1 ", PojmoviSpojnice.class);
            query.setParameter(1, rez);
            entityManager.getTransaction().commit();
            return  query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        
    }

    @Override
    public Long dohvatiBrojSpojnicaUTabeli() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(" SELECT COUNT(*) FROM PojmoviSpojnice c ");

            entityManager.getTransaction().commit();
            return (Long) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
