package com.pojmovi_asocijacije;

import pojo.SinonimiG;


public interface SinonimiGDAO {
    
    public void persist(SinonimiG sinonimiG);
    public void remove(SinonimiG sinonimiG);
    public void merge(SinonimiG sinonimiG);

}
