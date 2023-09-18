package admin;

import java.security.MessageDigest;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import static jdk.nashorn.tools.ShellFunctions.input;

@ManagedBean(name = "AdminBean")
@SessionScoped
public class AdminBean {

    private Date date;
    
//    
//    public String ubaciNovuPartiju() {
//        AdminDAO inserir = new AdminDAOImpl();
//        Partija usuario = new Partija();
//
//        usuario.setPlaviUsername(usernamePlavi);
//        usuario.setPlaviPassword(passwordPlavi);
//        usuario.setPotvrdionPlavi(potvrdioPlavi);
//        usuario.setPlaviPoeni(plaviPoeni);
//        
//        usuario.setCrveniUsername(usernameCrveni);
//        usuario.setCrveniPassword(passwordCrveni);
//        usuario.setCrveniPoeni(crveniPoeni);
//        usuario.setPotvrdioCrveni(potvrdioCrveni);
//        
//        //usuario.setIshod(ishod);
//        //usuario.setDatumIganja(new java.sql.Date(datumIgranja.getTime()));
//
//
//        inserir.persist(usuario);
//        clear();
//        return "/ucesnik/kreiranaPartija.xhtml?faces-redirect=true";
//
//    }

    public void clear() {
//        usernamePlavi = "";
//        usernameCrveni="";
//        passwordPlavi="";
//        passwordCrveni="";
//        datumIgranja = null;
    }

//    public String editAirline() {
//        UcesnikDAO inserir = new UcesnikDAOImpl();
//        User user = new User();
//        user = user1;
//        user.setAirline(airline);
//        inserir.merge(user);
//
//        return "/stujardesa/linkovi.xhtml?faces-redirect=true";
//    }

    // ******* getteri i setteri *******

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
   
}
