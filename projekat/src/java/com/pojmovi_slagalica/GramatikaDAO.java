package com.pojmovi_slagalica;

import java.util.List;
import pojo.Gramatika;

public interface GramatikaDAO {

    
    public void persist(Gramatika gramatika);

    public Gramatika getById(final int id);

    public List<Gramatika> findAll();

    public void remove(Gramatika gramatika);

    public void merge(Gramatika gramatika);
    
    


}
