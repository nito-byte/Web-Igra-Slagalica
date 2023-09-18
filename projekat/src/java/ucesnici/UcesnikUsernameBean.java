package ucesnici;

import com.proveri.jsf.naslovna.RegistracijaBean;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;
import partija.*;

@ManagedBean(name = "UcesnikUsernameBean")
@SessionScoped
public class UcesnikUsernameBean {

    
    
    private String ucesnikUsername;

    
    @PostConstruct
    public void dohvatiUsername() {
      //  ucesnikUsername =  (String)RegistracijaBean.sesija.getAttribute("username");
        
    }

    public String getUcesnikUsername() {
        return ucesnikUsername;
    }

    public void setUcesnikUsername(String ucesnikUsername) {
        this.ucesnikUsername = ucesnikUsername;
    }
    
    
    
    
    
   
    
}
