package com.pojmovi_asocijacije;

import pojo.SinonimiB;


public interface SinonimiBDAO {
    
    public void persist(SinonimiB sinonimiB);
    public void remove(SinonimiB sinonimiB);
    public void merge(SinonimiB sinonimiB);

}
