package supervizor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import pojo.Gramatika;
import pojo.Partija;
import pojo.SupervizorOdobri;
import pojo.User;

public class SupervizorOdobriDAOImpl implements SupervizorOdobriDAO {

    protected EntityManager entityManager;

    public SupervizorOdobriDAOImpl() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("controleFinanc");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    @Override
    public void persist(SupervizorOdobri supervizorOdobri) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(supervizorOdobri);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public SupervizorOdobri getById(final int id) {
        return entityManager.find(pojo.SupervizorOdobri.class, id);
    }

    @Override
    public List<SupervizorOdobri> findAll() {
        return entityManager.createQuery("FROM SupervizorOdobri").getResultList();

    }
    
    
    
    @Override
    public List<SupervizorOdobri> findByNijePrihvacenZahtev() {

        String sql = " from SupervizorOdobri u "
                + " where u.odobreno=:vr ";
        Query query = entityManager.createQuery(sql);
        query.setParameter("vr", 0);
        return query.getResultList();
    }

    @Override
    public void remove(SupervizorOdobri supervizorOdobri) {
        try {
            entityManager.getTransaction().begin();
            supervizorOdobri = entityManager.find(pojo.SupervizorOdobri.class, supervizorOdobri.getId());
            entityManager.remove(supervizorOdobri);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void merge(SupervizorOdobri SupervizorOdobri) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(SupervizorOdobri);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public int dohvatiDaLiJeSupervizorOdobrioRec(String username, String rec) {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<SupervizorOdobri> query = entityManager.createQuery("SELECT c FROM SupervizorOdobri c "
                    + "WHERE c.username = ?1 "
                    + "AND c.rec = ?2 ",
                    SupervizorOdobri.class);
            query.setParameter(1, username);
            query.setParameter(2, rec);
            entityManager.getTransaction().commit();
            return query.getSingleResult().getOdobreno();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;

        }

    }

    @Override
    public int dohvatiDaLiJePlaviPrihvationIgru(String username, int id) {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Partija> query = entityManager.createQuery("SELECT c FROM Partija c "
                    // + "WHERE c.crveniUsername = ?1 "
                    + "WHERE c.id = ?1 ",
                    Partija.class);
            //   query.setParameter(1, username);
            query.setParameter(1, id);
            entityManager.getTransaction().commit();
            return query.getSingleResult().getPotvrdionPlavi();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;

        }

    }

}
