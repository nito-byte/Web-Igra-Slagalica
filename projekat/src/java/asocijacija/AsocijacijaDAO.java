package asocijacija;

import mojbroj.*;
import java.util.List;
import pojo.PojmoviSpojnice;

/**
 *
 * @author tijana
 */
public interface AsocijacijaDAO {
    
    public void persist(PojmoviSpojnice pojmoviSpojnice);

//    public User getById(final int id);
//    public User getWithUsername(String username,String pass);
//    public User getWithOnlyUsername(String username);
//    public List<User> getStujardesa(String kompanija);
//    public List<User> getPilot(String kompanija);
//
//    public List<User> findAll();
//    public List<User> findByNijePrihvacenZahtev();
//    public List<User> findByPrihvacenZahtev();
    

    public void remove(PojmoviSpojnice pojmoviSpojnice);
    public void merge(PojmoviSpojnice pojmoviSpojnice);
    public List<PojmoviSpojnice> findAll();
    
    public PojmoviSpojnice dohvatiSpojnicu();
    public Long dohvatiBrojSpojnicaUTabeli();
    
    
}
