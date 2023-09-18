package ucesnici;

import com.proveri.jsf.naslovna.RegistracijaBean;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import pojo.*;
import partija.*;
import util.SessionUtils;
import static util.SessionUtils.getSession;

@ManagedBean(name = "UcesnikBean")
@SessionScoped
public class UcesnikBean {

    private Date datumIgranja;
    private String ishod;

    private String usernamePlavi = "";
    private String passwordPlavi = "";
    private int potvrdioPlavi = 0;
    private int plaviPoeni = 0;

    private List listaTop10IgraDana = new ArrayList<>();
    private List lstMesec = new ArrayList<>();
    private List lstNedelja = new ArrayList<>();

    private List lstPartijeZaIgranje = new ArrayList<>();
    private List lstPotvrdiPartijeZaIgranje = new ArrayList<>();

    private String usernameCrveni = "";
    private String passwordCrveni = "";
    private int crveniPoeni = 0;
    private int potvrdioCrveni = 0;

    private String ucesnikUsername;
    
    @PostConstruct
    public void dohvati(){
        UcesnikDAO dao = new UcesnikDAOImpl();
        ucesnikUsername = (String) RegistracijaBean.sesija.getAttribute("username");
        lstPartijeZaIgranje = dao.slobodnePartijeZaIgranje(ucesnikUsername);
        lstPotvrdiPartijeZaIgranje=dao.potvrdiPartijeZaIgranje(ucesnikUsername);
        
        
    }
    
    
    public String prijavaNaKreiranu(){
        UcesnikDAO dao = new UcesnikDAOImpl();
        ucesnikUsername = (String) RegistracijaBean.sesija.getAttribute("username");
        lstPartijeZaIgranje = dao.slobodnePartijeZaIgranje(ucesnikUsername);
        return "prijavaNaKreiranuPartiju.xhtml";
        
    }
    
    
    public String potvrdiIgru(){
        UcesnikDAO dao = new UcesnikDAOImpl();
        ucesnikUsername = (String) RegistracijaBean.sesija.getAttribute("username");
        lstPotvrdiPartijeZaIgranje=dao.potvrdiPartijeZaIgranje(ucesnikUsername);
        return "potvrdiPozivNaIgru.xhtml";
        
    }
    
    

    public String ubaciNovuPartiju() {
        UcesnikDAO inserir = new UcesnikDAOImpl();
        Partija usuario = new Partija();

        ucesnikUsername = (String) RegistracijaBean.sesija.getAttribute("username");

        usuario.setPlaviUsername(ucesnikUsername);
        usuario.setPotvrdionPlavi(potvrdioPlavi);
        usuario.setPlaviPoeni(plaviPoeni);
        usuario.setAktivnaIgra(1);

        usuario.setCrveniUsername(usernameCrveni);
        usuario.setCrveniPoeni(crveniPoeni);
        usuario.setPotvrdioCrveni(potvrdioCrveni);

        //usuario.setIshod(ishod);
        Date date = new Date();
        usuario.setDatumIganja(date);

        inserir.persist(usuario);
        clear();
        return "/ucesnik/kreiranaPartija.xhtml?faces-redirect=true";

    }

    public void clear() {
        usernamePlavi = "";
        usernameCrveni = "";
        passwordPlavi = "";
        passwordCrveni = "";
        datumIgranja = null;
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
    public Date getDatumIgranja() {
        return datumIgranja;
    }

    public void setDatumIgranja(Date datumIgranja) {
        this.datumIgranja = datumIgranja;
    }

    public String getUsernamePlavi() {
        return usernamePlavi;
    }

    public void setUsernamePlavi(String usernamePlavi) {
        this.usernamePlavi = usernamePlavi;
    }

    public String getUsernameCrveni() {
        return usernameCrveni;
    }

    public void setUsernameCrveni(String usernameCrveni) {
        this.usernameCrveni = usernameCrveni;
    }

    public String getPasswordPlavi() {
        return passwordPlavi;
    }

    public void setPasswordPlavi(String passwordPlavi) {
        this.passwordPlavi = passwordPlavi;
    }

    public String getPasswordCrveni() {
        return passwordCrveni;
    }

    public void setPasswordCrveni(String passwordCrveni) {
        this.passwordCrveni = passwordCrveni;
    }

    public String getIshod() {
        return ishod;
    }

    public void setIshod(String ishod) {
        this.ishod = ishod;
    }

    public int getPotvrdioPlavi() {
        return potvrdioPlavi;
    }

    public void setPotvrdioPlavi(int potvrdioPlavi) {
        this.potvrdioPlavi = potvrdioPlavi;
    }

    public int getPlaviPoeni() {
        return plaviPoeni;
    }

    public void setPlaviPoeni(int plaviPoeni) {
        this.plaviPoeni = plaviPoeni;
    }

    public int getCrveniPoeni() {
        return crveniPoeni;
    }

    public void setCrveniPoeni(int crveniPoeni) {
        this.crveniPoeni = crveniPoeni;
    }

    public int getPotvrdioCrveni() {
        return potvrdioCrveni;
    }

    public void setPotvrdioCrveni(int potvrdioCrveni) {
        this.potvrdioCrveni = potvrdioCrveni;
    }

    public List<Pobednici> getLstMesec() {
        UcesnikDAO dao = new UcesnikDAOImpl();
        lstMesec = dao.najboljiUcesniciMeseca();
        return lstMesec;
    }

    public void setLstMesec(List<Pobednici> lstMesec) {
        this.lstMesec = lstMesec;
    }

    public List getLstNedelja() {
        UcesnikDAO dao = new UcesnikDAOImpl();
        lstNedelja = dao.najboljiUcesniciNedelje();
        return lstNedelja;
    }

    public List getLstPartijeZaIgranje() {
        UcesnikDAO dao = new UcesnikDAOImpl();
        lstPartijeZaIgranje = dao.slobodnePartijeZaIgranje(ucesnikUsername);
        return lstPartijeZaIgranje;
    }

    public void setLstPartijeZaIgranje(List lstPartijeZaIgranje) {
        this.lstPartijeZaIgranje = lstPartijeZaIgranje;
    }

    public List getLstPotvrdiPartijeZaIgranje() {
        return lstPotvrdiPartijeZaIgranje;
    }

    public void setLstPotvrdiPartijeZaIgranje(List lstPotvrdiPartijeZaIgranje) {
        UcesnikDAO dao = new UcesnikDAOImpl();
        lstPartijeZaIgranje = dao.potvrdiPartijeZaIgranje(ucesnikUsername);
        
    }
    
    
    
    

    public void setLstNedelja(List lstNedelja) {
        this.lstNedelja = lstNedelja;
    }

    public String getUcesnikUsername() {
        return ucesnikUsername;
    }

    public void setUcesnikUsername(String ucesnikUsername) {
        this.ucesnikUsername = ucesnikUsername;
    }

    public String edit(int id) {
        
        HttpSession session = getSession();
        session.setAttribute("idPartije", id);
        String s= (String) session.getAttribute("username");
        session.setAttribute("crveniUsername",s );
        
        PartijaDAO inserir = new PartijaDAOImpl();
        Partija partija = new Partija();

        //najpre treba da dohvatim partiju iz baze koja ima taj id
        partija = inserir.getById(id);
        

        partija.setCrveniUsername(ucesnikUsername);
        partija.setAktivnaIgra(0);
        partija.setPotvrdioCrveni(1);
        inserir.merge(partija);

        return "/poveziDva/cekamPlavog.xhtml?faces-redirect=true";
    }
    
    public String editPotvrdi(int id) {
        
        HttpSession session = getSession();
        session.setAttribute("idPartije", id);
        String s= (String) session.getAttribute("username");
        session.setAttribute("plaviUsername",s );
        
        PartijaDAO inserir = new PartijaDAOImpl();
        Partija partija = new Partija();

        //najpre treba da dohvatim partiju iz baze koja ima taj id
        partija = inserir.getById(id);
        
        //String s = (String) RegistracijaBean.sesija.getAttribute("username");
        //partija.setCrveniUsername(s);
        partija.setAktivnaIgra(0);
        partija.setPotvrdionPlavi(1);
        inserir.merge(partija);

        return "/poveziDva/dobrodosli?faces-redirect=true";
    }

    public String logout() {
        HttpSession sesija = SessionUtils.getSession();
        sesija.invalidate();
        return "/pocetak/prijava.xhtml?faces-redirect=true";
    }

    

}
