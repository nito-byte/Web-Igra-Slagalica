package com.slagalica;

import ucesnici.*;
import com.proveri.jsf.naslovna.*;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;

@ManagedBean(name = "IstekloVremeBean")
@SessionScoped
public class IstekloVremeBean {

    public String dalje(){
        return "/igraMojbroj/igraDanaMojbroj";
    }
    
    public String daljeMojBroj(){
        return "/igraSkocko/igraSkocko";
    }
    
    public String daljeSpojnica(){
        return "/igraAsocijacije/igraDanaAsocijacija";
    }
    
    public String daljeAsocijacija(){
        return "/igraAsocijacije/ispisResenja.xhtml";
    }
    
}
