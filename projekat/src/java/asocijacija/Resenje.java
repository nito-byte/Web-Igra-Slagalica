package asocijacija;

import admin.IgraDanaDAO;
import admin.IgraDanaDAOImpl;
import com.pojmovi_asocijacije.PojmoviAsocijacijeDAO;
import com.pojmovi_slagalica.PojmoviSlagalicaDAO;
import com.pojmovi_slagalica.PojmoviSlagalicaDAOImpl;
import com.proveri.jsf.naslovna.RegistracijaBean;
import java.util.ArrayList;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import pojo.IgraDana;
import pojo.OdigranaIgraDana;
import pojo.PojmoviAsocijacije;
import static util.SessionUtils.getSession;

@ManagedBean(name = "Resenje")
@SessionScoped
public class Resenje {

    private int slagalicaBodovi;
    private int mojBrojBodovi;
    private int skocko;
    private int spojnicaBodovi;
    private int asaocijacijaBodovi;
    private int ukupno;

    @PostConstruct
    public void init() {
        HttpSession session = getSession();
        slagalicaBodovi = (int) session.getAttribute("igraSlagalica");
        mojBrojBodovi = (int) session.getAttribute("igraMojbroj");
        skocko = (int) session.getAttribute("igraSkocko");
        spojnicaBodovi = (int) session.getAttribute("igraSpojnica");
        asaocijacijaBodovi = (int) session.getAttribute("igraAsocijacija");
        ukupno = (int) session.getAttribute("bodovi");

    }

    public String zavrsi() {
        HttpSession session = getSession();
        String user = (String) session.getAttribute("username");
     //   Date datum = (Date)session.getAttribute("datum");
        
        PojmoviSlagalicaDAO inserir = new PojmoviSlagalicaDAOImpl();
        OdigranaIgraDana o = new OdigranaIgraDana();
        java.util.Date date=new java.util.Date(); 
        OdigranaIgraDana oo=inserir.getIgraDana(date, user);
        
        oo.setOdigrano(1);
        oo.setBodovi(ukupno);
        inserir.odigranaIgraDana(oo);
        
        
        
        //dodaj ovde da i u igru dana postavi da je odigrana to mi treba zbog admina
        IgraDanaDAO inserir1 = new IgraDanaDAOImpl();
        IgraDana o1 = inserir1.getTodayIgraDanaPostoji();
        o1.setOdigrano(1);
        inserir1.merge(o1);
        
        
        
        
        return "/ucesnik/linkovi";
    }

    public int getUkupno() {
        return ukupno;
    }

    public void setUkupno(int ukupno) {
        this.ukupno = ukupno;
    }

    public int getSlagalicaBodovi() {
        return slagalicaBodovi;
    }

    public void setSlagalicaBodovi(int slagalicaBodovi) {
        this.slagalicaBodovi = slagalicaBodovi;
    }

    public int getMojBrojBodovi() {
        return mojBrojBodovi;
    }

    public void setMojBrojBodovi(int mojBrojBodovi) {
        this.mojBrojBodovi = mojBrojBodovi;
    }

    public int getSpojnicaBodovi() {
        return spojnicaBodovi;
    }

    public void setSpojnicaBodovi(int spojnicaBodovi) {
        this.spojnicaBodovi = spojnicaBodovi;
    }

    public int getAsaocijacijaBodovi() {
        return asaocijacijaBodovi;
    }

    public void setAsaocijacijaBodovi(int asaocijacijaBodovi) {
        this.asaocijacijaBodovi = asaocijacijaBodovi;
    }

    public int getSkocko() {
        return skocko;
    }

    public void setSkocko(int skocko) {
        this.skocko = skocko;
    }
    
    

}
