package ucesnici;

import java.util.List;
import pojo.OdigranaIgraDana;
import pojo.Partija;
import pojo.User;

/**
 *
 * @author tijana
 */
public interface UcesnikDAO {

    public void persist(Partija partija);

    public User getById(final int id);

    public User getWithUsername(String username, String pass);

    public User getWithOnlyUsername(String username);

    public List<User> getStujardesa(String kompanija);

    public List<User> getPilot(String kompanija);

    public List<User> findAll();

    public List<User> findByNijePrihvacenZahtev();

    public List<User> findByPrihvacenZahtev();

    public List najboljiUcesniciNedelje();

    public List najboljiUcesniciMeseca();
    
    public List slobodnePartijeZaIgranje(String ucesnikUsername);
    
    public List potvrdiPartijeZaIgranje(String ucesnikUsername);
    
    public void remove(Partija partija);

    public void merge(Partija partija);
    
    

}
