package com.pojmovi_asocijacije;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pojo.SinonimiA;
import pojo.SinonimiB;


public class SinonimiBDAOImpl implements SinonimiBDAO{

    
    protected EntityManager entityManager;

    public SinonimiBDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void persist(SinonimiB sinonimiB) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(sinonimiB);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


    public void remove(SinonimiB sinonimiB) {
        try {
            entityManager.getTransaction().begin();
            sinonimiB = entityManager.find(pojo.SinonimiB.class, sinonimiB.getId());
            entityManager.remove(sinonimiB);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(SinonimiB sinonimiB) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(sinonimiB);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }


}
