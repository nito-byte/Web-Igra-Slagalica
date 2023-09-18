package com.pojmovi_slagalica;

import java.util.Date;
import pojo.Gramatika;
import pojo.OdigranaIgraDana;

/**
 *
 * @author tijana
 */
public interface PojmoviSlagalicaDAO {
    
    //OVO CE MORATI DA SE MENJA
    
    public Gramatika postojiUGramatici(String rec);
    
    public void zapoceoIgruDana(OdigranaIgraDana o);
    
    public void odigranaIgraDana(OdigranaIgraDana o);

    public OdigranaIgraDana getIgraDana(Date date, String user);
    
    public OdigranaIgraDana proveraIgraDana(Date date, String user);
    
}
