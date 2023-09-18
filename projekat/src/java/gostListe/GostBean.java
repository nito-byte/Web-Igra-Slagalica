package gostListe;

import ucesnici.*;
import java.util.ArrayList;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;

@ManagedBean(name = "GostBean")
@SessionScoped
public class GostBean {

    
    private List lstMesec = new ArrayList<>();
    private List lstNedelja = new ArrayList<>();

   
    
    @PostConstruct
    public void dohvati(){
       
        
        
        GostDAO dao1 = new GostDAOImpl();
        lstNedelja = dao1.najboljiUcesniciNedelje();
        
        GostDAO dao = new GostDAOImpl();
        lstMesec = dao.najboljiUcesniciMeseca();
        
        
        
    }
    
    


    public List<Pobednici> getLstMesec() {
        GostDAO dao = new GostDAOImpl();
        lstMesec = dao.najboljiUcesniciMeseca();
        return lstMesec;
    }

    public void setLstMesec(List<Pobednici> lstMesec) {
        this.lstMesec = lstMesec;
    }

    public List getLstNedelja() {
        GostDAO dao = new GostDAOImpl();
        lstNedelja = dao.najboljiUcesniciNedelje();
        return lstNedelja;
    }

   

    public void setLstNedelja(List lstNedelja) {
        this.lstNedelja = lstNedelja;
    }

  

    

}
