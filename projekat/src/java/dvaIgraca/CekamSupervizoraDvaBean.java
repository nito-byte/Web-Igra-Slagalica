package dvaIgraca;

import static com.proveri.jsf.naslovna.RegistracijaBean.sesija;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import supervizor.SupervizorOdobriDAO;
import supervizor.SupervizorOdobriDAOImpl;
import util.SessionUtils;
import static util.SessionUtils.getSession;

@ManagedBean(name = "SupervizorDva")
@SessionScoped
public class CekamSupervizoraDvaBean {

    int counter;
    String rec;
    String username;
    
    int counterMojbroj;
    int counterSpojnica;
    int counterAsocijacija;
    

    @PostConstruct
    public void dohvatiUsername() {
        
        counterMojbroj=0;
        counterSpojnica=0;
        counterAsocijacija=0;

        HttpSession session = getSession();
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
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ucesnik/istekloVreme.xhtml");
            FacesContext.getCurrentInstance().responseComplete();
        }
    }

    public void odbrojavanjeMojBroj() throws IOException {
        counterMojbroj += 1;
        if (counterMojbroj == 60) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ucesnik/istekloVremeMojBroj.xhtml");
            FacesContext.getCurrentInstance().responseComplete();
        }
    }

    public void odbrojavanjeSpojnica() throws IOException {
        counterSpojnica += 1;
        if (counterSpojnica == 60) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ucesnik/istekloVremeSpojnica.xhtml");
            FacesContext.getCurrentInstance().responseComplete();
        }
    }

    public void odbrojavanjeAsocijacija() throws IOException {
        counterAsocijacija += 1;
        if (counterAsocijacija == 240) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ucesnik/istekloVremeAsocijacija.xhtml");
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
        String recc = (String) sesija.getAttribute("recZaSupervizora");
        String usernamee = (String) sesija.getAttribute("username");
        int odobreno = 0;

        odobreno = g.dohvatiDaLiJeSupervizorOdobrioRec(usernamee, recc);

        // KOJI SAM JA IGRAC
        HttpSession sesija = SessionUtils.getSession();
        String u = (String) sesija.getAttribute("username");
        String plavi = (String) sesija.getAttribute("plaviUsername");
        String crveni = (String) sesija.getAttribute("crveniUsername");

        if ((StringUtils.isEmpty(plavi)) == false) {
            if (plavi.equals(u)) {
                if (odobreno == 0) {
                    rec = " ... obrada u toku!";
                    sesija.setAttribute("zavrsenoPlavi", 0);
                } else {
                    rec = "Odobreno!";
                    sesija.setAttribute("zavrsenoPlavi", 1);

                }
            }
        }
        
        if ((StringUtils.isEmpty(crveni)) == false) {
            if (crveni.equals(u)) {
                if (odobreno == 0) {
                    rec = " ... obrada u toku!";
                    sesija.setAttribute("zavrsenoCrveni", 0);
                } else {
                    rec = "Odobreno!";
                    sesija.setAttribute("zavrsenoCrveni", 1);

                }
            }
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

    public int getCounterMojbroj() {
        return counterMojbroj;
    }

    public void setCounterMojbroj(int counterMojbroj) {
        this.counterMojbroj = counterMojbroj;
    }

    public int getCounterSpojnica() {
        return counterSpojnica;
    }

    public void setCounterSpojnica(int counterSpojnica) {
        this.counterSpojnica = counterSpojnica;
    }

    public int getCounterAsocijacija() {
        return counterAsocijacija;
    }

    public void setCounterAsocijacija(int counterAsocijacija) {
        this.counterAsocijacija = counterAsocijacija;
    }
    
    
    

}
