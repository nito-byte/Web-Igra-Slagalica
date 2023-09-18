package skocko;

import mojbroj.*;
import java.util.List;
import pojo.PojmoviSpojnice;

/**
 *
 * @author tijana
 */
public interface SkockoDAO {
    
    public void persist(PojmoviSpojnice pojmoviSpojnice);  

    public void remove(PojmoviSpojnice pojmoviSpojnice);
    public void merge(PojmoviSpojnice pojmoviSpojnice);
    public List<PojmoviSpojnice> findAll();
    
    public PojmoviSpojnice dohvatiSpojnicu();
    public Long dohvatiBrojSpojnicaUTabeli();
    
    
}
