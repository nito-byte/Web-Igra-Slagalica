package supervizor;

import java.util.List;
import pojo.Gramatika;
import pojo.SupervizorOdobri;
import pojo.User;

public interface SupervizorOdobriDAO {

    
    public void persist(SupervizorOdobri supervizorOdobri);

    public SupervizorOdobri getById(final int id);

    public List<SupervizorOdobri> findAll();

    public void remove(SupervizorOdobri supervizorOdobri);

    public void merge(SupervizorOdobri supervizorOdobri);
    
    public List<SupervizorOdobri> findByNijePrihvacenZahtev();

    public int dohvatiDaLiJeSupervizorOdobrioRec(String username, String rec);
    
    public int dohvatiDaLiJePlaviPrihvationIgru(String username, int idPartije);
    
    


}
