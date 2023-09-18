package poveziDva;

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

@ManagedBean(name = "PoveziDvaBean")
@ViewScoped
public class PoveziDvaBean {

    int counter;
    String rec;
    String username;

    @PostConstruct
    public void dohvatiUsername() {

        HttpSession session = getSession();
        username = (String) session.getAttribute("username");
        session.setAttribute("crveniUsername", username);
        rec = " ... ceka se plavi igrac da prihvati zahtev!";
    }

    

    public void increment() {
        // counter += 2;
        //dohvatim neku vrednost iz baze
        // GramatikaDAO g = new GramatikaDAOImpl();
        // Gramatika pom = g.getById(1);
        // rec = pom.getIspravnaRec();

        SupervizorOdobriDAO g = new SupervizorOdobriDAOImpl();
        String usernamee = (String) sesija.getAttribute("username");
        int odobreno = 0;
        
        HttpSession session = getSession();
        int idPartije = (int) session.getAttribute("idPartije");

        odobreno = g.dohvatiDaLiJePlaviPrihvationIgru(usernamee, idPartije);

        if (odobreno == 0) {
            rec = " ... ceka se plavi igrac da prihvati zahtev!";
           // sesija.setAttribute("prihvatio", 0);
        } else {
            rec = "Pocni igru!";
           // sesija.setAttribute("zavrseno", 1);

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
    
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    

}
