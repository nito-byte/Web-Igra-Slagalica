package com.pojmovi_slagalica;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import pojo.Gramatika;
import pojo.OdigranaIgraDana;
import pojo.PojmoviAsocijacije;
import pojo.User;

/**
 *
 * @author tijana
 */
public class PojmoviSlagalicaDAOImpl implements PojmoviSlagalicaDAO {

    protected EntityManager entityManager;

    public PojmoviSlagalicaDAOImpl() {
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

    @Override
    public Gramatika postojiUGramatici(String rec) {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Gramatika> query = entityManager.createQuery("SELECT c FROM Gramatika c "
                    + "WHERE c.ispravnaRec = ?1 ",
                    Gramatika.class);
            query.setParameter(1, rec);
            entityManager.getTransaction().commit();
            return query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        }

    }

    //*************************************************************************
    // mislim da mi ovo dole ne treba, proveri jos jednom
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

    public void zapoceoIgruDana(OdigranaIgraDana o) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(o);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
    public void odigranaIgraDana(OdigranaIgraDana o) {
        try {
            entityManager.getTransaction().begin();
            
            entityManager.merge(o);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


    
    @Override
    public OdigranaIgraDana getIgraDana(Date d, String s) {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<OdigranaIgraDana> query = entityManager.createQuery("SELECT c FROM OdigranaIgraDana c "
                    + "WHERE c.username=?1 "
                    + "and c.odigrano=?2 "
                    + "and c.datum=?3 ", OdigranaIgraDana.class);
            query.setParameter(1, s);
            query.setParameter(2, 0);
            java.sql.Date dd= (java.sql.Date) new java.sql.Date(d.getTime());
            query.setParameter(3, dd);

            entityManager.getTransaction().commit();
            OdigranaIgraDana a=query.getResultList().get(0);
            return a;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
    
     @Override
    public OdigranaIgraDana proveraIgraDana(Date d, String s ) {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<OdigranaIgraDana> query = entityManager.createQuery("SELECT c FROM OdigranaIgraDana c "
                    + "WHERE c.username=?1 "
                    + "and c.odigrano=?2 "
                    + "and c.datum=?3 ", OdigranaIgraDana.class);
            query.setParameter(1, s);
            query.setParameter(2, 1);
            java.sql.Date dd= (java.sql.Date) new java.sql.Date(d.getTime());
            query.setParameter(3, dd);

            entityManager.getTransaction().commit();
            OdigranaIgraDana a=query.getSingleResult();
            return a;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
    
    

}
