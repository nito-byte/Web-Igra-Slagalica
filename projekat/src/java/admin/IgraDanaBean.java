/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pojo.IgraDana;

@ManagedBean(name = "IgraDana")
@SessionScoped
public class IgraDanaBean implements Serializable {

    private Date start;
    private String poruka;
    private int prolaz;
    private List<IgraDana> lst = new ArrayList<IgraDana>();

    private int IDasocijacija;
    private int IDspojnica;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public int getProlaz() {
        return prolaz;
    }

    public void setProlaz(int prolaz) {
        this.prolaz = prolaz;
    }

    public List<IgraDana> getLst() {
        return lst;
    }

    public void setLst(List<IgraDana> lst) {
        this.lst = lst;
    }

    public int getIDasocijacija() {
        return IDasocijacija;
    }

    public void setIDasocijacija(int IDasocijacija) {
        this.IDasocijacija = IDasocijacija;
    }

    public int getIDspojnica() {
        return IDspojnica;
    }

    public void setIDspojnica(int IDspojnica) {
        this.IDspojnica = IDspojnica;
    }

    public void provera() {
        IgraDanaDAO dao = new IgraDanaDAOImpl();
        boolean pom = dao.vecPostojiIgra(start);

        if (pom) {
            poruka = "Vec rezervisan datum!";
            prolaz = 0;
        } else {
            poruka = "Ispravan datum!";
            prolaz = 1;
        }

    }

    public String cadastrar() {
        if (prolaz == 1) {
            IgraDanaDAO inserir = new IgraDanaDAOImpl();
            IgraDana usuario = new IgraDana();

            usuario.setStart(start);
            usuario.setIdasocijacija(IDasocijacija);
            usuario.setIdspojnice(IDspojnica);
            usuario.setOdigrano(0);

            inserir.persist(usuario);
            clear();
            return "/admin/igraDanaPotvrda.xhtml?faces-redirect=true";
        } else {
            return "/admin/igraDana.xhtml?faces-redirect=true";
        }

    }

    public String postojiIgraDanaINijeOdigrana() {
        IgraDanaDAO dao = new IgraDanaDAOImpl();
        IgraDana pom = dao.getIgraDanaPostojiINijeOdigrana();

        if (pom == null) {
            return "/admin/igraDanaNePostoji.xhtml?faces-redirect=true";
        } else {
            return "/admin/igraDanaAzuriraj.xhtml?faces-redirect=true";
//        int odigrana = pom.getOdigrano();
//        if(odigrana==0){
//            return "/admin/igraDanaAzuriraj.xhtml?faces-redirect=true";
//        }else if(odigrana==1){
//            return "/admin/igraDanaOdigrana.xhtml?faces-redirect=true"; 
//        }
        }

    }

    public String editIgraDana() {
        IgraDanaDAO dao = new IgraDanaDAOImpl();
        IgraDana pom = dao.getTodayIgraDana();

        int id = pom.getId();

        IgraDana igra = new IgraDana();
        igra.setId(id);
        igra.setStart(pom.getStart());
        igra.setIdasocijacija(IDasocijacija);
        igra.setIdspojnice(IDspojnica);
        igra.setOdigrano(0);
        dao.merge(igra);

        return "/admin/igraDanaPotvrdaAzuriraj.xhtml?faces-redirect=true";

    }

    public void clear() {
        start = null;
        poruka = "";
        prolaz = 0;
    }

//    public String getSayWelcome() {
//        if ("".equals(name) || name == null) {
//            return "Null Message";
//        } else {
//            String pattern = "MM/dd/yyyy HH:mm:ss";
//
//            DateFormat df = new SimpleDateFormat(pattern);
//            String t = df.format(name);
//            return "Ajax message : Welcome " + t;
//        }
//    }
}
