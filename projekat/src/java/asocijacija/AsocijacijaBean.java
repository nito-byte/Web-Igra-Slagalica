package asocijacija;

import com.pojmovi_asocijacije.PojmoviAsocijacijeDAO;
import com.pojmovi_asocijacije.SinonimiADAO;
import com.pojmovi_asocijacije.SinonimiADAOImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import pojo.PojmoviAsocijacije;
import sinonimi.SinADAO;
import sinonimi.SinADAOImpl;
import sinonimi.SinBDAO;
import sinonimi.SinBDAOImpl;
import sinonimi.SinGDAO;
import sinonimi.SinGDAOImpl;
import sinonimi.SinKDAO;
import sinonimi.SinKDAOImpl;
import sinonimi.SinVDAO;
import sinonimi.SinVDAOImpl;
import static util.SessionUtils.getSession;

@ManagedBean(name = "AsocijacijaBean")
@SessionScoped
public class AsocijacijaBean {

    private ArrayList<String> kolonaA = new ArrayList<String>(4);
    private ArrayList<String> kolonaB = new ArrayList<String>(4);
    private ArrayList<String> kolonaV = new ArrayList<String>(4);
    private ArrayList<String> kolonaG = new ArrayList<String>(4);

    private int osvojeniBodovi;
    private PojmoviAsocijacije p;

    private String konacnoA;
    private String konacnoB;
    private String konacnoV;
    private String konacnoG;
    private String konacno;

    private boolean pogodjenoA = false;
    private boolean pogodjenoB = false;
    private boolean pogodjenoV = false;
    private boolean pogodjenoG = false;
    private boolean pogodjenoKonacno = false;

    private int A = 0;
    private int B = 0;
    private int V = 0;
    private int G = 0;

    private ArrayList<String> bojaA = new ArrayList<String>(5);
    private ArrayList<String> bojaB = new ArrayList<String>(5);
    private ArrayList<String> bojaV = new ArrayList<String>(5);
    private ArrayList<String> bojaG = new ArrayList<String>(5);
    private String bojaK;

    public String bojaA(int i) {
        return bojaA.get(i);
    }

    public String bojaB(int i) {
        return bojaB.get(i);
    }

    public String bojaV(int i) {
        return bojaV.get(i);
    }

    public String bojaG(int i) {
        return bojaG.get(i);
    }

    public String bojaK() {
        return bojaK;
    }

    private void dodeliBoje(List<String> bojaA, List<String> bojaB, List<String> bojaV, List<String> bojaG) {
        for (int i = 0; i < 5; i++) {
            bojaA.add(i, "lightgoldenrodyellow");
            bojaB.add(i, "lightgoldenrodyellow");
            bojaV.add(i, "lightgoldenrodyellow");
            bojaG.add(i, "lightgoldenrodyellow");

        }
        bojaK = "lightgoldenrodyellow";
    }

    private void dodeliBojePlavo(List<String> bojaA, List<String> bojaB, List<String> bojaV, List<String> bojaG) {
        for (int i = 0; i < 5; i++) {
            bojaA.add(i, "blue");
            bojaB.add(i, "blue");
            bojaV.add(i, "blue");
            bojaG.add(i, "blue");

        }
        bojaK = "blue";
    }

    @PostConstruct
    public void init() {
        HttpSession session = getSession();
        osvojeniBodovi = (int) session.getAttribute("bodovi");
        session.setAttribute("igraAsocijacija", 0);

        dodeliBoje(bojaA, bojaB, bojaV, bojaG);
        postaviInicijalnoKolone();
        PojmoviAsocijacijeDAO inserir = new com.pojmovi_asocijacije.PojmoviAsocijacijeDAOImpl();

        p = inserir.dohvatiAsocijaciju();

    }

    public void proveriKonacno() {
        String a1 = p.getKonacno();
        String a2 = konacno;

        //dohvati i sinonime iz tabele SinonimiA za bas tu sifru 
        int id = p.getId();  //ovo je Id iz TabelaAsocijacija
        SinKDAO inserir1 = new SinKDAOImpl();
        List<String> s = inserir1.dohvati(id);
        int postojiSinonim = 0;
        if (s != null) {
            if (s.contains(a2)) {
                postojiSinonim = 1;
            }
        }

        if ((a1.equals(a2)) || (postojiSinonim == 1)) {

            //sva polja otvorim i obojim
            dodeliBojePlavo(bojaA, bojaB, bojaV, bojaG);
            for (int i = 0; i < 4; i++) {
                dohvatiKolonaA(i);
                dohvatiKolonaB(i);
                dohvatiKolonaV(i);
                dohvatiKolonaG(i);
            }

            PojmoviAsocijacijeDAO inserir = new com.pojmovi_asocijacije.PojmoviAsocijacijeDAOImpl();
            p = inserir.dohvatiAsocijaciju();
            konacnoA = p.getKolA();
            konacnoB = p.getKolB();
            konacnoV = p.getKolV();
            konacnoG = p.getKolG();

            pogodjenoA = true;
            pogodjenoB = true;
            pogodjenoV = true;
            pogodjenoG = true;

            HttpSession session = getSession();
            osvojeniBodovi = (int) session.getAttribute("bodovi");
            osvojeniBodovi += 10;
            int v = (int) session.getAttribute("igraAsocijacija");
            v += 10;
            session.setAttribute("igraAsocijacija", v);
            bojaK = "blue";
            pogodjenoKonacno = true;
            if (A == 0) {
                osvojeniBodovi += 5;
                int vv = (int) session.getAttribute("igraAsocijacija");
                vv += 5;
                session.setAttribute("igraAsocijacija", vv);
            }
            if (B == 0) {
                osvojeniBodovi += 5;
                int vv = (int) session.getAttribute("igraAsocijacija");
                vv += 5;
                session.setAttribute("igraAsocijacija", vv);
            }
            if (V == 0) {
                osvojeniBodovi += 5;
                int vv = (int) session.getAttribute("igraAsocijacija");
                vv += 5;
                session.setAttribute("igraAsocijacija", vv);
            }
            if (G == 0) {
                osvojeniBodovi += 5;
                int vv = (int) session.getAttribute("igraAsocijacija");
                vv += 5;
                session.setAttribute("igraAsocijacija", vv);
            }
            session.setAttribute("bodovi", osvojeniBodovi);
            pogodjenoA = true;
        }
    }

    public void proveriKolonuA() {
        String a1 = p.getKolA();
        String a2 = konacnoA;

        //dohvati i sinonime iz tabele SinonimiA za bas tu sifru 
        int id = p.getId();  //ovo je Id iz TabelaAsocijacija
        SinADAO inserir = new SinADAOImpl();
        List<String> s = inserir.dohvati(id);
        int postojiSinonim = 0;
        if (s != null) {
            if (s.contains(a2)) {
                postojiSinonim = 1;
            }
        }

        if ((a1.equals(a2)) || (postojiSinonim == 1)) {

            
            
            //OTVORI SVA POLJA TE KOLONE
            for (int i = 0; i < 5; i++) {
                bojaA.add(i, "blue");
            }
            for (int i = 0; i < 4; i++) {
                dohvatiKolonaA(i);
            }
            
            pogodjenoA = true;

            
            
            HttpSession session = getSession();
            osvojeniBodovi = (int) session.getAttribute("bodovi");
            osvojeniBodovi += 5;
            session.setAttribute("bodovi", osvojeniBodovi);

            int vv = (int) session.getAttribute("igraAsocijacija");
            vv += 5;
            session.setAttribute("igraAsocijacija", vv);

            pogodjenoA = true;
            bojaA.set(4, "blue");
            A = 1;
        }
    }

    public void proveriKolonuB() {
        String a1 = p.getKolB();
        String a2 = konacnoB;

        //dohvati i sinonime iz tabele SinonimiA za bas tu sifru 
        int id = p.getId();  //ovo je Id iz TabelaAsocijacija
        SinBDAO inserir = new SinBDAOImpl();
        List<String> s = inserir.dohvati(id);
        int postojiSinonim = 0;
        if (s != null) {
            if (s.contains(a2)) {
                postojiSinonim = 1;
            }
        }

        if ((a1.equals(a2)) || (postojiSinonim == 1)) {
            
            
            //OTVORI SVA POLJA TE KOLONE
            for (int i = 0; i < 5; i++) {
                bojaB.add(i, "blue");
            }
            for (int i = 0; i < 4; i++) {
                dohvatiKolonaB(i);
            }
            
            pogodjenoB = true;

            HttpSession session = getSession();
            osvojeniBodovi = (int) session.getAttribute("bodovi");
            osvojeniBodovi += 5;
            session.setAttribute("bodovi", osvojeniBodovi);

            int vv = (int) session.getAttribute("igraAsocijacija");
            vv += 5;
            session.setAttribute("igraAsocijacija", vv);

            pogodjenoB = true;
            bojaB.set(4, "blue");
            B = 1;
        }
    }

    public void proveriKolonuV() {
        String a1 = p.getKolV();
        String a2 = konacnoV;

        //dohvati i sinonime iz tabele SinonimiA za bas tu sifru 
        int id = p.getId();  //ovo je Id iz TabelaAsocijacija
        SinVDAO inserir = new SinVDAOImpl();
        List<String> s = inserir.dohvati(id);
        int postojiSinonim = 0;
        if (s != null) {
            if (s.contains(a2)) {
                postojiSinonim = 1;
            }
        }

        if ((a1.equals(a2)) || (postojiSinonim == 1)) {
            
            //OTVORI SVA POLJA TE KOLONE
            for (int i = 0; i < 5; i++) {
                bojaV.add(i, "blue");
            }
            for (int i = 0; i < 4; i++) {
                dohvatiKolonaV(i);
            }
            
            pogodjenoV = true;
            
            
            
            
            
            HttpSession session = getSession();
            osvojeniBodovi = (int) session.getAttribute("bodovi");
            osvojeniBodovi += 5;
            session.setAttribute("bodovi", osvojeniBodovi);

            int vv = (int) session.getAttribute("igraAsocijacija");
            vv += 5;
            session.setAttribute("igraAsocijacija", vv);

            pogodjenoV = true;
            bojaV.set(4, "blue");
            V = 1;
        }
    }

    public void proveriKolonuG() {
        String a1 = p.getKolG();
        String a2 = konacnoG;

        //dohvati i sinonime iz tabele SinonimiA za bas tu sifru 
        int id = p.getId();  //ovo je Id iz TabelaAsocijacija
        SinGDAO inserir = new SinGDAOImpl();
        List<String> s = inserir.dohvati(id);
        int postojiSinonim = 0;
        if (s != null) {
            if (s.contains(a2)) {
                postojiSinonim = 1;
            }
        }

        if ((a1.equals(a2)) || (postojiSinonim == 1)) {
            
            //OTVORI SVA POLJA TE KOLONE
            for (int i = 0; i < 5; i++) {
                bojaG.add(i, "blue");
            }
            for (int i = 0; i < 4; i++) {
                dohvatiKolonaG(i);
            }
            
            pogodjenoG = true;
            
            
            
            HttpSession session = getSession();
            osvojeniBodovi = (int) session.getAttribute("bodovi");
            osvojeniBodovi += 5;
            session.setAttribute("bodovi", osvojeniBodovi);

            int vv = (int) session.getAttribute("igraAsocijacija");
            vv += 5;
            session.setAttribute("igraAsocijacija", vv);

            pogodjenoG = true;
            bojaG.set(4, "blue");
            G = 1;
        }
    }

    public void dohvatiKolonaA(int i) {
        String vr = null;
        if (i == 0) {
            vr = p.getA1();
            bojaA.set(i, "blue");
        }
        if (i == 1) {
            vr = p.getA2();
            bojaA.set(i, "blue");
        }
        if (i == 2) {
            vr = p.getA3();
            bojaA.set(i, "blue");
        }
        if (i == 3) {
            vr = p.getA4();
            bojaA.set(i, "blue");
        }

        kolonaA.set(i, vr);
    }

    public void dohvatiKolonaB(int i) {
        String vr = null;
        if (i == 0) {
            vr = p.getB1();
            bojaB.set(i, "blue");
        }
        if (i == 1) {
            vr = p.getB2();
            bojaB.set(i, "blue");
        }
        if (i == 2) {
            vr = p.getB3();
            bojaB.set(i, "blue");
        }
        if (i == 3) {
            vr = p.getB4();
            bojaB.set(i, "blue");
        }

        kolonaB.set(i, vr);
    }

    public void dohvatiKolonaV(int i) {
        String vr = null;
        if (i == 0) {
            vr = p.getV1();
            bojaV.set(i, "blue");
        }
        if (i == 1) {
            vr = p.getV2();
            bojaV.set(i, "blue");
        }
        if (i == 2) {
            vr = p.getV3();
            bojaV.set(i, "blue");
        }
        if (i == 3) {
            vr = p.getV4();
            bojaV.set(i, "blue");
        }

        kolonaV.set(i, vr);
    }

    public void dohvatiKolonaG(int i) {
        String vr = null;
        if (i == 0) {
            vr = p.getG1();
            bojaG.set(i, "blue");
        }
        if (i == 1) {
            vr = p.getG2();
            bojaG.set(i, "blue");
        }
        if (i == 2) {
            vr = p.getG3();
            bojaG.set(i, "blue");
        }
        if (i == 3) {
            vr = p.getG4();
            bojaG.set(i, "blue");
        }

        kolonaG.set(i, vr);
    }

    public String kolonaA(int i) {
        return kolonaA.get(i);
    }

    public String kolonaB(int i) {
        return kolonaB.get(i);
    }

    public String kolonaV(int i) {
        return kolonaV.get(i);
    }

    public String kolonaG(int i) {
        return kolonaG.get(i);
    }

    /////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////
    // metode koje se koriste ***************************************
    public void postaviInicijalnoKolone() {
        kolonaA.add(0, "A1");
        kolonaA.add(1, "A2");
        kolonaA.add(2, "A3");
        kolonaA.add(3, "A4");

        kolonaB.add(0, "B1");
        kolonaB.add(1, "B2");
        kolonaB.add(2, "B3");
        kolonaB.add(3, "B4");

        kolonaV.add(0, "V1");
        kolonaV.add(1, "V2");
        kolonaV.add(2, "V3");
        kolonaV.add(3, "V4");

        kolonaG.add(0, "G1");
        kolonaG.add(1, "G2");
        kolonaG.add(2, "G3");
        kolonaG.add(3, "G4");

    }

    /////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////
    // getteri i setteri ********************************************
    public ArrayList<String> getKolonaA() {
        return kolonaA;
    }

    public void setKolonaA(ArrayList<String> kolonaA) {
        this.kolonaA = kolonaA;
    }

    public ArrayList<String> getKolonaB() {
        return kolonaB;
    }

    public void setKolonaB(ArrayList<String> kolonaB) {
        this.kolonaB = kolonaB;
    }

    public ArrayList<String> getKolonaV() {
        return kolonaV;
    }

    public void setKolonaV(ArrayList<String> kolonaV) {
        this.kolonaV = kolonaV;
    }

    public ArrayList<String> getKolonaG() {
        return kolonaG;
    }

    public void setKolonaG(ArrayList<String> kolonaG) {
        this.kolonaG = kolonaG;
    }

    public int getOsvojeniBodovi() {
        return osvojeniBodovi;
    }

    public void setOsvojeniBodovi(int osvojeniBodovi) {
        this.osvojeniBodovi = osvojeniBodovi;
    }

    public PojmoviAsocijacije getP() {
        return p;
    }

    public void setP(PojmoviAsocijacije p) {
        this.p = p;
    }

    public String getKonacnoA() {
        return konacnoA;
    }

    public void setKonacnoA(String konacnoA) {
        this.konacnoA = konacnoA;
    }

    public String getKonacnoB() {
        return konacnoB;
    }

    public void setKonacnoB(String konacnoB) {
        this.konacnoB = konacnoB;
    }

    public String getKonacnoV() {
        return konacnoV;
    }

    public void setKonacnoV(String konacnoV) {
        this.konacnoV = konacnoV;
    }

    public String getKonacnoG() {
        return konacnoG;
    }

    public void setKonacnoG(String konacnoG) {
        this.konacnoG = konacnoG;
    }

    public boolean isPogodjenoA() {
        return pogodjenoA;
    }

    public void setPogodjenoA(boolean pogodjenoA) {
        this.pogodjenoA = pogodjenoA;
    }

    public boolean isPogodjenoB() {
        return pogodjenoB;
    }

    public void setPogodjenoB(boolean pogodjenoB) {
        this.pogodjenoB = pogodjenoB;
    }

    public boolean isPogodjenoV() {
        return pogodjenoV;
    }

    public void setPogodjenoV(boolean pogodjenoV) {
        this.pogodjenoV = pogodjenoV;
    }

    public boolean isPogodjenoG() {
        return pogodjenoG;
    }

    public void setPogodjenoG(boolean pogodjenoG) {
        this.pogodjenoG = pogodjenoG;
    }

    public String getKonacno() {
        return konacno;
    }

    public void setKonacno(String konacno) {
        this.konacno = konacno;
    }

    public boolean isPogodjenoKonacno() {
        return pogodjenoKonacno;
    }

    public void setPogodjenoKonacno(boolean pogodjenoKonacno) {
        this.pogodjenoKonacno = pogodjenoKonacno;
    }

    public int getA() {
        return A;
    }

    public void setA(int A) {
        this.A = A;
    }

    public int getB() {
        return B;
    }

    public void setB(int B) {
        this.B = B;
    }

    public int getV() {
        return V;
    }

    public void setV(int V) {
        this.V = V;
    }

    public int getG() {
        return G;
    }

    public void setG(int G) {
        this.G = G;
    }

    public ArrayList<String> getBojaA() {
        return bojaA;
    }

    public void setBojaA(ArrayList<String> bojaA) {
        this.bojaA = bojaA;
    }

    public ArrayList<String> getBojaB() {
        return bojaB;
    }

    public void setBojaB(ArrayList<String> bojaB) {
        this.bojaB = bojaB;
    }

    public ArrayList<String> getBojaV() {
        return bojaV;
    }

    public void setBojaV(ArrayList<String> bojaV) {
        this.bojaV = bojaV;
    }

    public ArrayList<String> getBojaG() {
        return bojaG;
    }

    public void setBojaG(ArrayList<String> bojaG) {
        this.bojaG = bojaG;
    }

    public String getBojaK() {
        return bojaK;
    }

    public void setBojaK(String bojaK) {
        this.bojaK = bojaK;
    }

}
