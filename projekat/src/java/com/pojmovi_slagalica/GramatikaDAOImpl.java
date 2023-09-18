package com.pojmovi_slagalica;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pojo.Gramatika;


public class GramatikaDAOImpl implements GramatikaDAO{

    
    protected EntityManager entityManager;

    public GramatikaDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public void persist(Gramatika gramatika) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(gramatika);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public Gramatika getById(final int id) {
        return entityManager.find(pojo.Gramatika.class, id);
    }

    public List<Gramatika> findAll() {
       // return entityManager.createQuery("FROM " + TerminalGejt.class.getName()).getResultList();
        return entityManager.createQuery("FROM Gramatika").getResultList();

    }

    public void remove(Gramatika gramatika) {
        try {
            entityManager.getTransaction().begin();
            gramatika = entityManager.find(pojo.Gramatika.class, gramatika.getId());
            entityManager.remove(gramatika);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Gramatika gramatika) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(gramatika);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
