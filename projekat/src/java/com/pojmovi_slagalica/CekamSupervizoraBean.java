package com.pojmovi_slagalica;

import static com.proveri.jsf.naslovna.RegistracijaBean.sesija;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import supervizor.SupervizorOdobriDAO;
import supervizor.SupervizorOdobriDAOImpl;
import static util.SessionUtils.getSession;

@ManagedBean(name = "Supervizor")
@ViewScoped
public class CekamSupervizoraBean {

    int counter;
    String rec;
    String username;
    int vecObradjeno = 0;
    int odobreno;
    String recc;
   
    @PostConstruct
    public void dohvatiUsername() {

        
        

        HttpSession session = getSession();
        recc = (String) sesija.getAttribute("recZaSupervizora");
        username = (String) session.getAttribute("username");
        rec = " ... obrada u toku!";
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void odbrojavanje() throws IOException {
        counter += 1;
        if (counter == 60) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("istekloVreme.xhtml?faces-redirect=true");
            FacesContext.getCurrentInstance().responseComplete();
        }
    }

    public void odbrojavanjeMojBroj() throws IOException {
        counter += 1;
        if (counter == 60) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("istekloVremeMojBroj.xhtml?faces-redirect=true");
            FacesContext.getCurrentInstance().responseComplete();
        }
    }

    public void odbrojavanjeSpojnica() throws IOException {
        counter += 1;
        if (counter == 60) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("istekloVremeSpojnica.xhtml?faces-redirect=true");
            FacesContext.getCurrentInstance().responseComplete();
        }
    }

    public void odbrojavanjeAsocijacija() throws IOException {
        counter += 1;
        if (counter == 240) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("istekloVremeAsocijacija.xhtml?faces-redirect=true");
            FacesContext.getCurrentInstance().responseComplete();
        }
    }

    public void increment() {
        // counter += 2;
        //dohvatim neku vrednost iz baze
        // GramatikaDAO g = new GramatikaDAOImpl();
        // Gramatika pom = g.getById(1);
        // rec = pom.getIspravnaRec();
        
        SupervizorOdobriDAO g = new SupervizorOdobriDAOImpl();

        if (vecObradjeno == 0) {
            odobreno = 0;
            odobreno = g.dohvatiDaLiJeSupervizorOdobrioRec(username, recc);
        }

        if (odobreno == 0) {
            rec = " ... obrada u toku!";
            sesija.setAttribute("zavrseno", 0);
        } else if (odobreno == 1) {
            rec = "Odobreno!";
            vecObradjeno = 1;
            sesija.setAttribute("zavrseno", 1);

        } else if (odobreno == 2) {
            rec = "Odbijeno!";
            vecObradjeno = 1;
            sesija.setAttribute("zavrseno", 2);
        }

    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getVecObradjeno() {
        return vecObradjeno;
    }

    public void setVecObradjeno(int vecObradjeno) {
        this.vecObradjeno = vecObradjeno;
    }

    public int getOdobreno() {
        return odobreno;
    }

    public void setOdobreno(int odobreno) {
        this.odobreno = odobreno;
    }

}
