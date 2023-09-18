package partija;

import ucesnici.*;
import java.util.List;
import pojo.Partija;
import pojo.User;

/**
 *
 * @author tijana
 */
public interface PartijaDAO {

    public void persist(Partija partija);

    public Partija getById(final int id);

    public void remove(Partija partija);

    public void merge(Partija partija);

}
