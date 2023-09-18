package predjiDalje;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pojo.PredjiDalje;

/**
 *
 * @author tijana
 */
public class PredjiDaljeDAOImpl implements PredjiDaljeDAO {

    protected EntityManager entityManager;

    public PredjiDaljeDAOImpl() {
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
    public void persist(PredjiDalje p) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public PredjiDalje getById(final int id) {
        return entityManager.find(pojo.PredjiDalje.class, id);
    }
    
   
    @Override
    public List<PredjiDalje> findAll() {
        // return entityManager.createQuery("FROM " + User.class.getName()).getResultList();
        return entityManager.createQuery("FROM PredjiDalje").getResultList();

    }
    
    
//    @Override
//    public List<PredjiDalje> getWithUsername(String username) {
//        try{
//        
//        
//        String sql = "FROM PredjiDalje "
//                + "Where s1=:username "
//                + "or s2=:username "
//                + "or s3=:username " 
//                + "or s4=:username "
//                + "or s5=:username ";
//        
//        Query query = entityManager.createQuery(sql);
//        query.setParameter("username", username);
//        return query.getResultList();
//        
//        }catch(Exception e){
//            e.printStackTrace();
//            return null;
//            
//        }
//    }

    
    @Override
    public void remove(PredjiDalje posada) {
        try {
            entityManager.getTransaction().begin();
            posada = entityManager.find(pojo.PredjiDalje.class, posada.getId());
            entityManager.remove(posada);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void merge(PredjiDalje posada) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(posada);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

   

}
