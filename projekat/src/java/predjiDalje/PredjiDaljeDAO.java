package predjiDalje;

import java.util.List;
import pojo.PredjiDalje;

/**
 *
 * @author tijana
 */
public interface PredjiDaljeDAO {
    
    public void persist(PredjiDalje p);

    public PredjiDalje getById(final int id);

    public List<PredjiDalje> findAll();

    public void remove(PredjiDalje posada);

    public void merge(PredjiDalje posada);
    
  // public List<Posada> getWithUsername(String username);
    
    
}
