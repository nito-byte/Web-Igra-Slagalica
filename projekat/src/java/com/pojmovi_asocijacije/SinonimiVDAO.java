package com.pojmovi_asocijacije;

import pojo.SinonimiV;


public interface SinonimiVDAO {
    
    public void persist(SinonimiV sinonimiV);
    public void remove(SinonimiV sinonimiV);
    public void merge(SinonimiV sinonimiV);

}
