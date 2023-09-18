package dvaIgraca;

import com.pojmovi_slagalica.*;
import com.proveri.jsf.naslovna.RegistracijaBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import pojo.Gramatika;
import pojo.OdigranaIgraDana;
import pojo.SupervizorOdobri;
import supervizor.SupervizorOdobriDAO;
import supervizor.SupervizorOdobriDAOImpl;
import util.SessionUtils;
import static util.SessionUtils.getSession;

@ManagedBean(name = "PojmoviSlagalicaDvaBean")
@ApplicationScoped
public class PojmoviSlagalicaDvaBean {

    private ArrayList<String> slova = new ArrayList<String>(12);
    private ArrayList<String> slova1 = new ArrayList<String>(12);
    private String rec;

    private boolean tacnoOne = false;
    private boolean tacnoTwo = false;

    private int bodovi = 0;

    private int secondsPassed = 0;
    private String usernameUlogovanog;

//    public PojmoviSlagalicaBean() {
//        start();
//    }
    @PostConstruct
    public void init() {

        generisiSlova();
        usernameUlogovanog = (String) RegistracijaBean.sesija.getAttribute("username");

        HttpSession sesija = SessionUtils.getSession();
        sesija.setAttribute("bodovi", 0);
        sesija.setAttribute("username", usernameUlogovanog);
        sesija.setAttribute("moguciBodovi", 0);
        sesija.setAttribute("zavrseno", 0);
        sesija.setAttribute("igraSlagalica", 0);

        java.util.Date date = new java.util.Date();
        sesija.setAttribute("datum", date);

//        HttpSession sesija = SessionUtils.getSession();
//        sesija.setAttribute("bodovi", 0);
    }

    public void generisiSlova() {
        Random rand = new Random();
        List<String> givenList = Arrays.asList("A", "B", "C", "Č", "Ć", "D", "Dž", "Đ", "E", "F", "G", "H", "I", "J", "K", "L", "Lj", "M", "N", "Nj", "O", "P", "R", "S", "Š", "T", "U", "V", "Z", "Ž");
        List<String> givenList1 = Arrays.asList("A", "E", "I", "O", "U");

        int numberOfElements = 10;
        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            String randomElement = givenList.get(randomIndex);
            slova.add(randomElement);
            slova1.add(randomElement);
        }

        numberOfElements = 2;
        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList1.size());
            String randomElement = givenList1.get(randomIndex);
            slova.add(randomElement);
            slova1.add(randomElement);
        }

        // zabelezi da korisnik trenutno igra igru  dana ( jer sme da je odigra samo jednom)
        PojmoviSlagalicaDAO inserir = new PojmoviSlagalicaDAOImpl();
        OdigranaIgraDana o = new OdigranaIgraDana();
        java.util.Date date = new java.util.Date();
        o.setDatum(date);
        o.setOdigrano(0);
        o.setUsername((String) RegistracijaBean.sesija.getAttribute("username"));
        inserir.zapoceoIgruDana(o);

    }

    public void updateText(ValueChangeEvent event) {
        rec = event.getNewValue().toString();
    }

    public String proveriIgraDanaOdigrana() {

        HttpSession session = getSession();
        String user = (String) session.getAttribute("username");
        Date datum = (Date) session.getAttribute("datum");

        PojmoviSlagalicaDAO inserir = new PojmoviSlagalicaDAOImpl();
        OdigranaIgraDana o = new OdigranaIgraDana();
        java.util.Date date = new java.util.Date();
        OdigranaIgraDana oo = inserir.proveraIgraDana(date, user);
        if (oo != null) {
            return "/ucesnik/porukaOdigranaIgraDana.xhtml";
        }

        return "/igraSlagalica/igraDanaSlagalica.xhtml";

    }

    public String proveri() {

        // 1) da li se sastoji od datih slova
        String pom = rec;

        HttpSession sesija = SessionUtils.getSession();
        sesija.setAttribute("recZaSupervizora", rec);
        sesija.setAttribute("bodovi", bodovi);
        sesija.setAttribute("username", usernameUlogovanog);

        // KOJI SAM JA IGRAC
      //  String u = (String) sesija.getAttribute("username");
        String plavi = (String) sesija.getAttribute("plaviUsername");
        String crveni = (String) sesija.getAttribute("crveniUsername");

        //AKO SAM JA PLAVI IGRAC
        if ((StringUtils.isEmpty(plavi))==false ) {
         //   if  (plavi.equals(u)) {

                boolean ans = true;

                for (int i = 0; i < rec.length(); i++) {
                    char c = rec.charAt(i);
                    String s = String.valueOf(c);
                    ans = slova1.contains(s);
                    if (ans == false) {
                        tacnoOne = false;
                        break;
                    } else {
                        int j;
                        j = slova1.indexOf(s);
                        slova1.remove(j);
                    }
                }

                if (ans == true) {
                    tacnoOne = true;
                }

                // 2) da li se nalazi u bazi dozvoljenih reci
                if (tacnoOne == true) {
                    PojmoviSlagalicaDAO inserir = new PojmoviSlagalicaDAOImpl();
                    Gramatika g = null;
                    g = inserir.postojiUGramatici(rec);

                    if (g == null) {    //ne postoji u gramatici
                        tacnoTwo = false;
                        bodovi = 0;
                        sesija.setAttribute("bodoviPlavi", bodovi);
                        sesija.setAttribute("igraSlagalicaPlavi", bodovi);
                        sesija.setAttribute("zavrsenoPlavi", 1);
                        sesija.setAttribute("moguciBodoviPlavi", 0);

                    } else {
                        tacnoTwo = true;
                        int br = rec.length();   //postavim bodove
                        bodovi += br * 2;
                        sesija.setAttribute("bodovi", bodovi);
                        sesija.setAttribute("igraSlagalicaPlavi", bodovi);
                        sesija.setAttribute("moguciBodovi", 3);
                        sesija.setAttribute("zavrsenoPlavi", 1);
                        return "predjiNaMojBrojPlavi.xhtml?faces-redirect=true";
                    }
                } else {
                    //ovo znaci da rec nije sastavljna od slova koja su zadata
                    bodovi = 0;
                    sesija.setAttribute("bodoviPlavi", bodovi);
                    sesija.setAttribute("igraSlagalicaPlavi", bodovi);
                    sesija.setAttribute("zavrsenoPlavi", 1);
                    sesija.setAttribute("moguciBodoviPlavi", 0);
                    return "predjiNaMojBrojPlavi.xhtml?faces-redirect=true";
                }

          //  }

            // 3) da li supervizor dozvoljava ovu rec
            if (tacnoOne == true && tacnoTwo == false) {

                int br = rec.length();
                br *= 2;
                sesija.setAttribute("moguciBodoviPlavi", br);
                sesija.setAttribute("bodoviPlavi", bodovi);
                sesija.setAttribute("igraSlagalicaPlavi", bodovi);
                sesija.setAttribute("zavrsenoPlavi", 0);

                SupervizorOdobriDAO inserir = new SupervizorOdobriDAOImpl();
                SupervizorOdobri usuario = new SupervizorOdobri();
                usuario.setOdobreno(0);
                usuario.setUsername(usernameUlogovanog);
                usuario.setRec(rec);
                inserir.merge(usuario);

                return "cekamSupervizoraDva.xhtml?faces-redirect=true";
            }
            return "predjiNaMojBrojPlavi.xhtml?faces-redirect=true";

        }
        
        
        //AKO SAM CRVENI IGRAC
        if ((StringUtils.isEmpty(crveni))==false ) {
        //    if  (crveni.equals(u)) {
            boolean ans = true;

            for (int i = 0; i < rec.length(); i++) {
                char c = rec.charAt(i);
                String s = String.valueOf(c);
                ans = slova1.contains(s);
                if (ans == false) {
                    tacnoOne = false;
                    break;
                } else {
                    int j;
                    j = slova1.indexOf(s);
                    slova1.remove(j);
                }
            }

            if (ans == true) {
                tacnoOne = true;
            }

            // 2) da li se nalazi u bazi dozvoljenih reci
            if (tacnoOne == true) {
                PojmoviSlagalicaDAO inserir = new PojmoviSlagalicaDAOImpl();
                Gramatika g = null;
                g = inserir.postojiUGramatici(rec);

                if (g == null) {    //ne postoji u gramatici
                    tacnoTwo = false;
                    bodovi = 0;
                    sesija.setAttribute("bodoviCrveni", bodovi);
                    sesija.setAttribute("igraSlagalicaCrveni", bodovi);
                    sesija.setAttribute("zavrsenoCrveni", 1);
                    sesija.setAttribute("moguciBodoviCrveni", 0);

                } else {
                    tacnoTwo = true;
                    int br = rec.length();   //postavim bodove
                    bodovi += br * 2;
                    sesija.setAttribute("bodoviCrveni", bodovi);
                    sesija.setAttribute("igraSlagalicaCrveni", bodovi);
                    sesija.setAttribute("moguciBodoviCrveni", 3);
                    sesija.setAttribute("zavrsenoCrveni", 1);
                    return "predjiNaMojBrojCrveni.xhtml?faces-redirect=true";
                }
            } else {
                //ovo znaci da rec nije sastavljna od slova koja su zadata
                bodovi = 0;
                sesija.setAttribute("bodoviCrveni", bodovi);
                sesija.setAttribute("igraSlagalicaCrveni", bodovi);
                sesija.setAttribute("zavrsenoCrveni", 1);
                sesija.setAttribute("moguciBodoviCrveni", 0);

                return "predjiNaMojBrojCrveni.xhtml?faces-redirect=true";
            }

            // 3) da li supervizor dozvoljava ovu rec
            if (tacnoOne == true && tacnoTwo == false) {

                int br = rec.length();
                br *= 2;
                sesija.setAttribute("moguciBodoviCrveni", br);
                sesija.setAttribute("bodoviCrveni", bodovi);
                sesija.setAttribute("igraSlagalicaCrveni", bodovi);
                sesija.setAttribute("zavrsenoCrveni", 0);

                SupervizorOdobriDAO inserir = new SupervizorOdobriDAOImpl();
                SupervizorOdobri usuario = new SupervizorOdobri();
                usuario.setOdobreno(0);
                usuario.setUsername(usernameUlogovanog);
                usuario.setRec(rec);
                inserir.merge(usuario);

                return "cekamSupervizoraDva.xhtml?faces-redirect=true";
            }
            return "predjiNaMojBrojCrveni.xhtml?faces-redirect=true";
       // }
        }
        return "predjiNaMojBrojCrveni.xhtml?faces-redirect=true";

    }

    public String cadastrar() {
        return "/supervizor/unosAsocijacijeSinonimiA.xhtml?faces-redirect=true";

    }

// ******* getteri i setteri *******
    public ArrayList<String> getSlova() {
        return slova;
    }

    public void setSlova(ArrayList<String> slova) {
        this.slova = slova;
    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public boolean isTacnoOne() {
        return tacnoOne;
    }

    public void setTacnoOne(boolean tacnoOne) {
        this.tacnoOne = tacnoOne;
    }

    public boolean isTacnoTwo() {
        return tacnoTwo;
    }

    public void setTacnoTwo(boolean tacnoTwo) {
        this.tacnoTwo = tacnoTwo;
    }

    public int getBodovi() {
        return bodovi;
    }

    public void setBodovi(int bodovi) {
        this.bodovi = bodovi;
    }

    public ArrayList<String> getSlova1() {
        return slova1;
    }

    public void setSlova1(ArrayList<String> slova1) {
        this.slova1 = slova1;
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }

    public void setSecondsPassed(int secondsPassed) {
        this.secondsPassed = secondsPassed;
    }

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            secondsPassed++;
            System.out.println(secondsPassed);
            if (secondsPassed >= 30) {
                timer.cancel();
            }
            return;
        }
    };

    public void start() {
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public String getUsernameUlogovanog() {
        return usernameUlogovanog;
    }

    public void setUsernameUlogovanog(String usernameUlogovanog) {
        this.usernameUlogovanog = usernameUlogovanog;
    }

}
