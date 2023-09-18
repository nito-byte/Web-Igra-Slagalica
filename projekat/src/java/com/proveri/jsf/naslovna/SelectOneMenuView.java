package com.proveri.jsf.naslovna;

 
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
 
 
@ManagedBean
public class SelectOneMenuView {
     
  
 
    private String kompanija;  
    private Map<String,String> kompanije = new HashMap<String, String>();
  
    
   
     
    @PostConstruct
    public void init() {
        //cars
        SelectItemGroup g1 = new SelectItemGroup("German Cars");
        g1.setSelectItems(new SelectItem[] {new SelectItem("BMW", "BMW"), new SelectItem("Mercedes", "Mercedes"), new SelectItem("Volkswagen", "Volkswagen")});
         
        SelectItemGroup g2 = new SelectItemGroup("American Cars");
        g2.setSelectItems(new SelectItem[] {new SelectItem("Chrysler", "Chrysler"), new SelectItem("GM", "GM"), new SelectItem("Ford", "Ford")});
         
        
        
        
        
        //dohvati ovde avio kompanije iz baze
        //cities
        kompanije = new HashMap<String, String>();
        kompanije.put("New York", "New York");
        kompanije.put("London","London");
        kompanije.put("Paris","Paris");
        kompanije.put("Barcelona","Barcelona");
        kompanije.put("Istanbul","Istanbul");
        kompanije.put("Berlin","Berlin");
         
    
 
    }

    public String getKompanija() {
        return kompanija;
    }

    public void setKompanije(Map<String, String> cities) {
        this.kompanije = cities;
    }
    
    
    
    
 
    public void setKompanija(String city) {
        this.kompanija = city;
    }
 
   
 
    public Map<String, String> getKompanije() {
        return kompanije;
    }
 
       
}