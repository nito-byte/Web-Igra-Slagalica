package igraDanaLista;

import gostListe.*;
import ucesnici.*;
import java.util.List;
import pojo.OdigranaIgraDana;
import pojo.Partija;
import pojo.User;

/**
 *
 * @author tijana
 */
public interface IgraDanaListDAO {

    
    public List  najboljiIgraDana();
    
    public List  najboljiIgraDanaUsername();
    
    public int dohvatiBodove(String username);
    

}
