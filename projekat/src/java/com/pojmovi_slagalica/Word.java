package com.pojmovi_slagalica;

 
import java.io.Serializable;
import pojo.*;
 
public class Word implements Serializable {
     
  
    private String rec="";
    



    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Word))
            return false;
         
        Word book = (Word) obj;
         
        return (book.getRec() != null && book.getRec().equals(rec));
    }
 
    @Override
    public int hashCode() {
        int hash = 1;
        if(rec != null)
            hash = hash * 31 + rec.hashCode();
 
        return hash;
    }
    
     
    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    
}