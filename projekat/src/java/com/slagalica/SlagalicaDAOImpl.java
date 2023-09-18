package com.slagalica;

import ucesnici.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import pojo.Partija;
import pojo.PojmoviAsocijacije;
import pojo.User;

/**
 *
 * @author tijana
 */
public class SlagalicaDAOImpl implements SlagalicaDAO {

    protected EntityManager entityManager;

    public SlagalicaDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void persist(PojmoviAsocijacije pojmoviAsocijacije) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pojmoviAsocijacije);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(PojmoviAsocijacije pojmoviAsocijacije) {
        try {
            entityManager.getTransaction().begin();
            pojmoviAsocijacije = entityManager.find(pojo.PojmoviAsocijacije.class, pojmoviAsocijacije.getId());
            entityManager.remove(pojmoviAsocijacije);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(PojmoviAsocijacije pojmoviAsocijacije) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pojmoviAsocijacije);
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

}
