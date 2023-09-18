package com.pojmovi_asocijacije;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pojo.SinonimiV;


public class SinonimiVDAOImpl implements SinonimiVDAO{

    
    protected EntityManager entityManager;

    public SinonimiVDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void persist(SinonimiV sinonimiV) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(sinonimiV);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


    public void remove(SinonimiV sinonimiV) {
        try {
            entityManager.getTransaction().begin();
            sinonimiV = entityManager.find(pojo.SinonimiV.class, sinonimiV.getId());
            entityManager.remove(sinonimiV);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(SinonimiV sinonimiV) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(sinonimiV);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
