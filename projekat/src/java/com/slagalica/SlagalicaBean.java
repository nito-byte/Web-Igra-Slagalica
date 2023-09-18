package com.slagalica;

import ucesnici.*;
import com.proveri.jsf.naslovna.*;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;

@ManagedBean(name = "SlagalicaBean")
@SessionScoped
public class SlagalicaBean {

    private String P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12;
    
    
   
    
    
    
    
    

    
    
//    public String ubaciNovuPartiju() {
//        SupervizorDAO inserir = new SupervizorDAOImpl();
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
        P1=P2=P3=P4=P5=P6=P7=P8=P9=P10=P11=P12="";
        
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

    public String getP1() {
        return P1;
    }

    public void setP1(String P1) {
        this.P1 = P1;
    }

    public String getP2() {
        return P2;
    }

    public void setP2(String P2) {
        this.P2 = P2;
    }

    public String getP3() {
        return P3;
    }

    public void setP3(String P3) {
        this.P3 = P3;
    }

    public String getP4() {
        return P4;
    }

    public void setP4(String P4) {
        this.P4 = P4;
    }

    public String getP5() {
        return P5;
    }

    public void setP5(String P5) {
        this.P5 = P5;
    }

    public String getP6() {
        return P6;
    }

    public void setP6(String P6) {
        this.P6 = P6;
    }

    public String getP7() {
        return P7;
    }

    public void setP7(String P7) {
        this.P7 = P7;
    }

    public String getP8() {
        return P8;
    }

    public void setP8(String P8) {
        this.P8 = P8;
    }

    public String getP9() {
        return P9;
    }

    public void setP9(String P9) {
        this.P9 = P9;
    }

    public String getP10() {
        return P10;
    }

    public void setP10(String P10) {
        this.P10 = P10;
    }

    public String getP11() {
        return P11;
    }

    public void setP11(String P11) {
        this.P11 = P11;
    }

    public String getP12() {
        return P12;
    }

    public void setP12(String P12) {
        this.P12 = P12;
    }

    
}
