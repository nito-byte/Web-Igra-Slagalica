package com.pojmovi_asocijacije;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pojo.SinonimiG;


public class SinonimiGDAOImpl implements SinonimiGDAO{

    
    protected EntityManager entityManager;

    public SinonimiGDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void persist(SinonimiG sinonimiG) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(sinonimiG);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


    public void remove(SinonimiG sinonimiG) {
        try {
            entityManager.getTransaction().begin();
            sinonimiG = entityManager.find(pojo.SinonimiG.class, sinonimiG.getId());
            entityManager.remove(sinonimiG);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(SinonimiG sinonimiG) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(sinonimiG);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


}
