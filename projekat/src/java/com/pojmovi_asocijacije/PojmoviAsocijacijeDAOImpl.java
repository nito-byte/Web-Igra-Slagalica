package com.pojmovi_asocijacije;

import admin.IgraDanaDAO;
import admin.IgraDanaDAOImpl;
import java.sql.Driver;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import pojo.IgraDana;
import pojo.PojmoviAsocijacije;
import pojo.PojmoviAsocijacije;

/**
 *
 * @author tijana
 */
public class PojmoviAsocijacijeDAOImpl implements PojmoviAsocijacijeDAO {

    protected EntityManager entityManager;

    public PojmoviAsocijacijeDAOImpl() {
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

    public PojmoviAsocijacije getById(final int id) {
        return entityManager.find(pojo.PojmoviAsocijacije.class, id);
    }

    public List<PojmoviAsocijacije> findAll() {
        // return entityManager.createQuery("FROM " + Airplane.class.getName()).getResultList();
        return entityManager.createQuery("FROM PojmoviAsocijacije").getResultList();
    }

    public PojmoviAsocijacije getId(PojmoviAsocijacije pojmovi) {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<PojmoviAsocijacije> query = entityManager.createQuery("SELECT c FROM PojmoviAsocijacije c "
                    + "WHERE c.a1 = ?1 and c.a2=?2 and c.a3=?3 and c.a4=?4 "
                    + "AND c.b1 = ?5 and c.b2=?6 and c.b3=?7 and c.b4=?8 "
                    + "AND c.v1 = ?9 and c.v2=?10 and c.v3=?11 and c.v4=?12 "
                    + "AND c.g1 = ?13 and c.g2=?14 and c.g3=?15 and c.g4=?16 ",
                    PojmoviAsocijacije.class);
            query.setParameter(1, pojmovi.getA1());
            query.setParameter(2, pojmovi.getA2());
            query.setParameter(3, pojmovi.getA3());
            query.setParameter(4, pojmovi.getA4());
            query.setParameter(5, pojmovi.getB1());
            query.setParameter(6, pojmovi.getB2());
            query.setParameter(7, pojmovi.getB3());
            query.setParameter(8, pojmovi.getB4());
            query.setParameter(9, pojmovi.getV1());
            query.setParameter(10, pojmovi.getV2());
            query.setParameter(11, pojmovi.getV3());
            query.setParameter(12, pojmovi.getV4());
            query.setParameter(13, pojmovi.getG1());
            query.setParameter(14, pojmovi.getG2());
            query.setParameter(15, pojmovi.getG3());
            query.setParameter(16, pojmovi.getG4());

            entityManager.getTransaction().commit();
            return query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        }
    }

    @Override
    public PojmoviAsocijacije dohvatiAsocijaciju() {

        //ovde treba da odem i da dohvatim za igru dana id asocijacije
        IgraDanaDAO dao = new IgraDanaDAOImpl();
        int rez =dao.dohvatiIdAsocijacijaZaIgruDana();

//        //dohvatim najpre broj svih spojnica u tabeli
//        Long b = dohvatiBrojAsocijacijaUTabeli();
//        int broj = b.intValue();
//
//        //izaberem slucajan broj u tabeli
//        Random random = new Random();
//        int min = 1;
//        int max = broj;
//        int randomNumber = random.nextInt(max + 1 - min) + min;
//
//        //provera greske
//        if ((randomNumber > broj) || (randomNumber <= 0)) {
//            randomNumber = 1;
//        }
        //dohvatim taj red u tabeli PojmoviAsocijacije
        try {
            entityManager.getTransaction().begin();
            TypedQuery<PojmoviAsocijacije> query = entityManager.createQuery(" SELECT c FROM PojmoviAsocijacije c WHERE c.id=?1 ", PojmoviAsocijacije.class);
            query.setParameter(1, rez);
            entityManager.getTransaction().commit();
            return query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public Long dohvatiBrojAsocijacijaUTabeli() {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery(" SELECT COUNT(*) FROM PojmoviAsocijacije c ");

            entityManager.getTransaction().commit();
            return (Long) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
