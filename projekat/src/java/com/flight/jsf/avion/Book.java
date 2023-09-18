package com.flight.jsf.avion;

 
import java.io.Serializable;
import pojo.*;
 
public class Book implements Serializable {
     
    private String terminal;
    private String gejt;
    private String airport;

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }
    
    

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getGejt() {
        return gejt;
    }

    public void setGejt(String gejt) {
        this.gejt = gejt;
    }
 
   
 
   
 
    @Override
    public int hashCode() {
        int hash = 1;
        if(terminal != null)
            hash = hash * 31 + terminal.hashCode();
         
        if(gejt != null)
            hash = hash * 29 + gejt.hashCode();
 
        return hash;
    }

    
}