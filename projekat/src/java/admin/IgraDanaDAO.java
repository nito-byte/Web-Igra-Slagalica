package admin;

import java.util.Date;
import pojo.IgraDana;

/**
 *
 * @author tijana
 */
public interface IgraDanaDAO {
    
    

    public boolean vecPostojiIgra(Date when) ;
    public IgraDana getTodayIgraDana();
    public IgraDana getTodayIgraDanaPostoji();
    public IgraDana getIgraDanaPostojiINijeOdigrana();
    
    public void persist(IgraDana igraDana);
    public void remove(IgraDana igraDana);
    public void merge(IgraDana igraDana);
    
    public int dohvatiIdAsocijacijaZaIgruDana();
    public int dohvatiIdSpojnicaZaIgruDana();

    
    
}
