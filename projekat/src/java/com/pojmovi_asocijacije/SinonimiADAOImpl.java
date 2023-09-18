package com.pojmovi_asocijacije;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pojo.SinonimiA;


public class SinonimiADAOImpl implements SinonimiADAO{

    
    protected EntityManager entityManager;

    public SinonimiADAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void persist(SinonimiA sinonimiA) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(sinonimiA);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


    public void remove(SinonimiA sinonimiA) {
        try {
            entityManager.getTransaction().begin();
            sinonimiA = entityManager.find(pojo.SinonimiA.class, sinonimiA.getId());
            entityManager.remove(sinonimiA);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(SinonimiA sinonimiA) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(sinonimiA);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
