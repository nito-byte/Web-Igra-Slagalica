package com.pojmovi_asocijacije;

import pojo.SinonimiA;


public interface SinonimiADAO {
    
    public void persist(SinonimiA sinonimiA);
    public void remove(SinonimiA sinonimiA);
    public void merge(SinonimiA sinonimiA);

}
