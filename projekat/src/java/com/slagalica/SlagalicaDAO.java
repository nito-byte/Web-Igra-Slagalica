package com.slagalica;

import ucesnici.*;
import java.util.List;
import pojo.Partija;
import pojo.PojmoviAsocijacije;
import pojo.User;

/**
 *
 * @author tijana
 */
public interface SlagalicaDAO {
    
    public void persist(PojmoviAsocijacije pojmoviAsocijacije);

//    public User getById(final int id);
//    public User getWithUsername(String username,String pass);
//    public User getWithOnlyUsername(String username);
//    public List<User> getStujardesa(String kompanija);
//    public List<User> getPilot(String kompanija);
//
//    public List<User> findAll();
//    public List<User> findByNijePrihvacenZahtev();
//    public List<User> findByPrihvacenZahtev();
    

    public void remove(PojmoviAsocijacije pojmoviAsocijacije);
    public void merge(PojmoviAsocijacije pojmoviAsocijacije);
    
    
}
