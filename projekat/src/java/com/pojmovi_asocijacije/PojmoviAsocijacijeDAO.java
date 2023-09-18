package com.pojmovi_asocijacije;

import ucesnici.*;
import java.util.List;
import pojo.Partija;
import pojo.PojmoviAsocijacije;
import pojo.PojmoviSpojnice;
import pojo.User;

/**
 *
 * @author tijana
 */
public interface PojmoviAsocijacijeDAO {
    
    public void persist(PojmoviAsocijacije pojmoviAsocijacije);

    public void remove(PojmoviAsocijacije pojmoviAsocijacije);
    public void merge(PojmoviAsocijacije pojmoviAsocijacije);
    public List<PojmoviAsocijacije> findAll();
    public PojmoviAsocijacije getId(PojmoviAsocijacije pojmoviAsocijacije);
    
    public PojmoviAsocijacije dohvatiAsocijaciju();
    public Long dohvatiBrojAsocijacijaUTabeli();
}
