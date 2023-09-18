package dvaIgraca;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import util.SessionUtils;

@ManagedBean(name = "DvaIgracaBean")
@SessionScoped
public class DvaIgracaBean {

    

    public String prebaci() {
        
        
        
        return "/igraSlagalica/igraSlagalicaDvaIgraca.xhtml?faces-redirect=true";

    }
    
    
    
    
   
   
    
  

}
