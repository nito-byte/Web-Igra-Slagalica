package skocko;

import java.util.ArrayList;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import static util.SessionUtils.getSession;

@ManagedBean(name = "SkockoBean")
@SessionScoped
public class SkockoBean {

    //String string="/resources/skocko/sova.png" ;
    //znaci: 0-pik
    //       1-tref
    //       2-herc
    //       3-karo
    //       4-zvezda
    //       5-skocko
    private ArrayList<String> znaci = new ArrayList<String>(6);
    private String odgovori[][] = new String[6][4];
    private String tacanOdgovor[] = new String[4];
    private String resenja[][] = new String[6][4];

    String[][] rezultat = new String[8][4];
    String[] resenje = new String[4];
    String[] ponuda = new String[]{"herc", "pik", "karo", "tref", "skocko", "zvezda"};

    String[][] polja = new String[6][4];

    public static int i = 0;
    public static int j = 0;

    private int osvojeniBodovi;
    private int bodovi;

    @PostConstruct
    public void init() {

        HttpSession session = getSession();
        bodovi = (int) session.getAttribute("bodovi");
        session.setAttribute("igraSkocko", 0);
        osvojeniBodovi = bodovi;

        postaviZnake();
        postaviOdgovoreNaPrazno();
        postaviTacneOdgovore();
        postaviRezultatNaPrazno();
        izracunajResenje();

    }

    public void izracunajResenje() {
        for (int i = 0; i < resenje.length; i++) {
            resenje[i] = dajZnak();
        }
    }

    String dajZnak() {
        Random r = new Random();
        switch (r.nextInt(6)) {
            case 0:
                return "herc";
            case 1:
                return "pik";
            case 2:
                return "karo";
            case 3:
                return "tref";
            case 4:
                return "skocko";
            case 5:
                return "zvezda";
            default:
                return "";
        }
    }

    public void postaviOdgovoreNaPrazno() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                odgovori[i][j] = "/resources/skocko/baza.png";
            }
        }
    }

    public void postaviTacneOdgovore() {
        for (int jj = 0; jj < 4; jj++) {
            tacanOdgovor[jj] = "/resources/skocko/baza.png";
        }
    }

    public void postaviRezultatNaPrazno() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                rezultat[i][j] = "/resources/skocko/baza1.png";
            }
        }
    }

    public String znaci(int i) {
        return znaci.get(i);
    }

    public void postaviZnake() {
        for (int i = 0; i < 12; i++) {
            znaci.add("anything");
        }
    }

    //imacu neku promenljivu i koju cu da inkrementiram 
    //da bih znala u kom sam redu
    public void dohvati(String ii) {
        String s = "";

        //dohvatim na koji sam znak kliknula
        if (ii.equals("tref")) {
            s = "/resources/skocko/tref.png";
            polja[i][j] = "tref";
        } else if (ii.equals("zvezda")) {
            s = "/resources/skocko/zvijezda.png";
            polja[i][j] = "zvezda";
        } else if (ii.equals("pik")) {
            s = "/resources/skocko/pik.png";
            polja[i][j] = "pik";
        } else if (ii.equals("karo")) {
            s = "/resources/skocko/karo.png";
            polja[i][j] = "karo";
        } else if (ii.equals("herc")) {
            s = "/resources/skocko/herc.png";
            polja[i][j] = "herc";
        } else if (ii.equals("sova")) {
            s = "/resources/skocko/sova.png";
            polja[i][j] = "skocko";
        }

        //postavim tu sliku na taj niz, i taj element u nizu
        odgovori[i][j] = s;
        j++;
        if (j == 4) {
            //prelazim na novi red u odgovorima
            oceni(i);
            i++;
            j = 0;
        }

    }

    private void oceni(int red) {
        boolean kraj = false;
        int crvene = 0;
        int zute = 0;
        int[][] pom = new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}};

        for (int ii = 0; ii < 4; ii++) {
            if (polja[red][ii].equals(resenje[ii])) {
                pom[0][ii] = 0;
                pom[1][ii] = 0;
                crvene++;

            }
        }
        for (int ii = 0; ii < 4; ii++) {
            if (pom[1][ii] == 1) {
                for (int j = 0; j < 4; j++) {
                    if (pom[0][j] == 1 && polja[red][ii].equals(resenje[j])) {
                        pom[0][j] = 0;
                        pom[1][ii] = 0;
                        zute++;
                        break;
                    }
                }
            }
        }

        if (crvene == 4 || red == 5) {
            kraj = true;
        }
        int k = 0;
        for (int ii = 0; ii < 4; ii++) {
            if (crvene > 0) {
                //"/resources/skocko/sova.png";
                rezultat[red][ii] = "/resources/skocko/crvena.png";
                crvene--;
                k++;
            } else if (zute > 0) {
                rezultat[red][ii] = "/resources/skocko/zuta.png";
                zute--;
            } else {
                rezultat[red][ii] = "/resources/skocko/belo.png";
            }
        }
        if (k == 4) {
            i = 100;   // ovo bi trebalo da spreci unos????????????????????????????????????????????????/
            j = 100;
            HttpSession session = getSession();
            int b = (int) session.getAttribute("bodovi");
            b+=10;
            session.setAttribute("bodovi", b);
            
            session.setAttribute("igraSkocko", 10);
        }

        if (red == 5 && k != 4) {
            //nisam uspela da pogodim tacno resenje i treba da prikazem tacan odg
            prikaziResenje();
        }

    }

    public void prikaziResenje() {

       // String[] resenje = new String[4];
        // String[] ponuda = new String[]{"herc", "pik", "karo", "tref", "skocko", "zvezda"};
        for (int t = 0; t < 4; t++) {
            String pom = resenje[t];
            if (pom.equals("herc")) {
                tacanOdgovor[t] = "/resources/skocko/herc.png";
            } else if (pom.equals("pik")) {
                tacanOdgovor[t] = "/resources/skocko/pik.png";
            } else if (pom.equals("karo")) {
                tacanOdgovor[t] = "/resources/skocko/karo.png";
            } else if (pom.equals("tref")) {
                tacanOdgovor[t] = "/resources/skocko/tref.png";
            } else if (pom.equals("skocko")) {
                tacanOdgovor[t] = "/resources/skocko/sova.png";
            } else if (pom.equals("zvezda")) {
                tacanOdgovor[t] = "/resources/skocko/zvijezda.png";
            }

        }
    }

    // ******** GETTERI I SETTERI ******************
    public ArrayList<String> getZnaci() {
        return znaci;
    }

    public void setZnaci(ArrayList<String> znaci) {
        this.znaci = znaci;
    }

    public String[][] getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(String[][] odgovori) {
        this.odgovori = odgovori;
    }

    public String[][] getResenja() {
        return resenja;
    }

    public void setResenja(String[][] resenja) {
        this.resenja = resenja;
    }

    public String[][] getRezultat() {
        return rezultat;
    }

    public void setRezultat(String[][] rezultat) {
        this.rezultat = rezultat;
    }

    public String[] getResenje() {
        return resenje;
    }

    public void setResenje(String[] resenje) {
        this.resenje = resenje;
    }

    public String[] getPonuda() {
        return ponuda;
    }

    public void setPonuda(String[] ponuda) {
        this.ponuda = ponuda;
    }

    public String[][] getPolja() {
        return polja;
    }

    public void setPolja(String[][] polja) {
        this.polja = polja;
    }

    public String[] getTacanOdgovor() {
        return tacanOdgovor;
    }

    public void setTacanOdgovor(String[] tacanOdgovor) {
        this.tacanOdgovor = tacanOdgovor;
    }

    public int getOsvojeniBodovi() {
        return osvojeniBodovi;
    }

    public void setOsvojeniBodovi(int osvojeniBodovi) {
        this.osvojeniBodovi = osvojeniBodovi;
    }

    public int getBodovi() {
        return bodovi;
    }

    public void setBodovi(int bodovi) {
        this.bodovi = bodovi;
    }
    
    

}
