package dvaIgraca;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import util.SessionUtils;

@ManagedBean(name = "DvaIgracaBeanPlavi")
@SessionScoped
public class DvaIgracaBeanPlavi {

    private int plavi=0;
    
    private int fleg1=0;
    String user;

    public String prebaci() {
        
        
        
        return "/igraSlagalica/igraSlagalicaDvaIgraca.xhtml?faces-redirect=true";

    }
    
    @PostConstruct
    public void pocetak(){
        plavi=0;
        fleg1=0;
    }
    
    
    public String potvrdiPlavi(){
        HttpSession sesija = SessionUtils.getSession();
        String p = (String) sesija.getAttribute("plaviUsername");


        if ((StringUtils.isEmpty(p)) == false) {
            if (p.equals(user)) {
                plavi=1;
                fleg1=1;
            }
        }
        return "/igraSpojnica/igraSpojnicaDva";
    }
    
    
   
    
    
    
//    @PostConstruct
//    public void dodaj(){
//        HttpSession sesija = SessionUtils.getSession();
//        String u = (String) sesija.getAttribute("username");
//        plavi = (String) sesija.getAttribute("plaviUsername");
//        crveni = (String) sesija.getAttribute("crveniUsername");
//        
//        PredjiDaljeDAO inserir = new PredjiDaljeDAOImpl();
//        PredjiDalje d= new PredjiDalje();
//        d.setPlavi(plavi);
//        d.setCrveni(crveni);
//        inserir.persist(d);
//        
//    }
    
//    public void potvrdiPlavi(){
//        HttpSession sesija = SessionUtils.getSession();
//        String u = (String) sesija.getAttribute("username");
//        plavi = (String) sesija.getAttribute("plaviUsername");
//        
//        PredjiDaljeDAO inserir = new PredjiDaljeDAOImpl();
//        PredjiDalje d= new PredjiDalje();
//        d.setPlavi(plavi);
//        
//        
//        if ((StringUtils.isEmpty(plavi))==false ) {
//            if  (plavi.equals(u)) {
//                // postavi u bazi da si potvrdio
//            }
//        }
//    }

  

    public void setPlavi(int plavi) {
        this.plavi = plavi;
    }

   
    
    public int getPlavi() {
        return plavi;
    }

   

    public int getFleg1() {
        return fleg1;
    }

    public void setFleg1(int fleg1) {
        this.fleg1 = fleg1;
    }

    

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

   
    
  

}
