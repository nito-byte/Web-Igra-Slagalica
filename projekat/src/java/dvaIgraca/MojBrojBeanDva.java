package dvaIgraca;

import static com.proveri.jsf.naslovna.RegistracijaBean.sesija;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import util.SessionUtils;
import static util.SessionUtils.getSession;

@ManagedBean(name = "MojBrojBeanDva")
@ApplicationScoped
public class MojBrojBeanDva {

    private ArrayList<String> jednocifreni = new ArrayList<String>(4);
    private String trazeniBroj, ponudjeniBroj, dvocifreni, trocifreni, operacija;
    private String resenje = "";
    private double izracunato = 0;
    private boolean ceoBroj = false;
    private boolean potvrdjeno = false;

    private Stack stack = new Stack();

    // znaci: 4  elementa su za jednocifrene
    //        5. element za dvocifreni
    //        6. element za trocifreni
    //        7-12 elementi za operatore
    private ArrayList<String> znaci = new ArrayList<String>(12);

    private int bodovi;
    private int moguciBodovi;
    private int zavrseno;

    private int osvojeniBodovi;

    @PostConstruct
    public void init() {

        HttpSession session = getSession();
        bodovi = (int) session.getAttribute("bodovi");
        moguciBodovi = (int) session.getAttribute("moguciBodovi");
        zavrseno = (int) session.getAttribute("zavrseno");

        dodeliBodove(bodovi, moguciBodovi, zavrseno);

        postaviZnake();
        generisiTrazeniBroj();

        generisiJednocifrene();
        generisiDvocifreni();
        generisiTrocifreni();

    }

    public String znaci(int i) {
        return znaci.get(i);
    }

    public void postaviZnake() {
        for (int i = 0; i < 12; i++) {
            znaci.add("anything");
        }
    }

    /////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////
    // metode koje se koriste ***************************************
    public void generisiTrazeniBroj() {
        int max = 1000;
        int min = 1;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        trazeniBroj = Integer.toString(randomNum);
    }

    public void generisiJednocifrene() {
        Random rand = new Random();
        List<String> givenList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

        int numberOfElements = 4;
        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            String randomElement = givenList.get(randomIndex);
            jednocifreni.add(randomElement);
        }

    }

    public void generisiDvocifreni() {
        Random rand = new Random();
        List<String> givenList = Arrays.asList("10", "15", "20");

        int randomIndex = rand.nextInt(givenList.size());
        dvocifreni = givenList.get(randomIndex);
    }

    public void generisiTrocifreni() {
        Random rand = new Random();
        List<String> givenList = Arrays.asList("25", "50", "75", "100");

        int randomIndex = rand.nextInt(givenList.size());
        trocifreni = givenList.get(randomIndex);
    }

    public void dohvatiJednocifreni(int i) {
        if (!"".equals(jednocifreni.get(i))) {   //samo ako nije kliknut broj
            String broj = jednocifreni.get(i);
            jednocifreni.set(i, "");

            dodajUResenje(broj);
            onemoguciOstale(1);
        }
    }

    public void dohvatiDvocifreni() {
        if (!"".equals(dvocifreni)) {   //samo ako nije kliknut broj
            String broj = dvocifreni;
            dvocifreni = "";

            dodajUResenje(broj);
            onemoguciOstale(2);
        }
    }

    public void dohvatiTrocifreni() {
        if (!"".equals(trocifreni)) {   //samo ako nije kliknut broj
            String broj = trocifreni;
            trocifreni = "";

            dodajUResenje(broj);
            onemoguciOstale(3);
        }
    }

    public void dohvatiOperaciju(String op) {  //samo ako nije kliknut broj
        String broj = op;
        if (!"".equals("(")) {
            stack.push("1");
        }

        if (!"".equals(")")) {
            stack.pop();
        }

        dodajUResenje(broj);
        onemoguciOstale(4);

        //proveri da li je u pitanju zagrada jer onda treba da stavljas na stek
    }

    public void dodajUResenje(String s) {
        resenje += s;
    }

    public void onemoguciOstale(int i) {
        if (i == 1) { //znaci da je kliknut jednocifren
            postaviZnakeOne();

        } else if (i == 2) { //znaci da je kliknut dvocifren
            postaviZnakeOne();

        } else if (i == 3) { //znaci da je kliknut trocifren
            postaviZnakeOne();

        } else { //znaci da je kliknut operator
            postaviZnakeTwo();
        }
    }

    public void postaviZnakeOne() {
        //blokiram brojeve odblokiram operande
        for (int j = 0; j < 6; j++) {
            znaci.add(j, "none");
        }
        for (int j = 6; j < 10; j++) {
            znaci.add(j, "anything");
        }
        for (int j = 10; j < 12; j++) {  //zabranim da je ispred zagrade broj, mora operand pa zagrada
            znaci.add(j, "none");
        }
    }

    public void postaviZnakeTwo() {
        //blokiram brojeve odblokiram operande
        for (int j = 0; j < 6; j++) {
            znaci.add(j, "anything");
        }
        for (int j = 6; j < 10; j++) {
            znaci.add(j, "none");
        }
        for (int j = 10; j < 12; j++) {
            znaci.add(j, "anything");
        }
    }

    public String izracunajResenje() {

        //dohvatim vrednost unetog polja
        potvrdjeno = true;

        //onda dohvatim da li sam plavi ili sam crveni
        String plavi = (String) sesija.getAttribute("plaviUsername");
        String crveni = (String) sesija.getAttribute("crveniUsername");

        //AKO SAM JA PLAVI IGRAC
        if ((StringUtils.isEmpty(plavi)) == false) {
            
            izracunato = eval(resenje);
            ceoBroj = proveraCeoBroj(izracunato);

            if (ceoBroj) {
                //da li je taj broj isti kao uneti
                int i = (int) izracunato;
                if ((Integer.parseInt(ponudjeniBroj)) == i) {
                    HttpSession session = getSession();
                    bodovi = (int) session.getAttribute("bodovi");
                    bodovi += 5;
                    session.setAttribute("bodovi", bodovi);
                    session.setAttribute("igraMojbroj", 5);
                    return "/igraSpojnica/igraSpojnicaPlavi";
                } else {
                    HttpSession session = getSession();
                    bodovi = (int) session.getAttribute("bodovi");
                    bodovi += 0;
                    session.setAttribute("bodovi", bodovi);
                    session.setAttribute("igraMojbroj", 0);
                    return "/igraSpojnica/igraSpojnicaPlavi";
                }
            } else {
                HttpSession session = getSession();
                bodovi = (int) session.getAttribute("bodovi");
                bodovi += 0;
                session.setAttribute("bodovi", bodovi);
                return "/igraSpojnica/igraSpojnicaPlavi";
            }

        }
        
        
        if ((StringUtils.isEmpty(crveni)) == false) {
            
            izracunato = eval(resenje);
            ceoBroj = proveraCeoBroj(izracunato);

            if (ceoBroj) {
                //da li je taj broj isti kao uneti
                int i = (int) izracunato;
                if ((Integer.parseInt(ponudjeniBroj)) == i) {
                    HttpSession session = getSession();
                    bodovi = (int) session.getAttribute("bodovi");
                    bodovi += 5;
                    session.setAttribute("bodovi", bodovi);
                    session.setAttribute("igraMojbroj", 5);
                    return "/igraSpojnica/igraSpojnicaCrveni";
                } else {
                    HttpSession session = getSession();
                    bodovi = (int) session.getAttribute("bodovi");
                    bodovi += 0;
                    session.setAttribute("bodovi", bodovi);
                    session.setAttribute("igraMojbroj", 0);
                    return "/igraSpojnica/igraSpojnicaCrveni";
                }
            } else {
                HttpSession session = getSession();
                bodovi = (int) session.getAttribute("bodovi");
                bodovi += 0;
                session.setAttribute("bodovi", bodovi);
                return "/igraSpojnica/igraSpojnicaCrveni";
            }

        }
        
        
        
        

        //izracunam ove bodove i na kraju se redirektujem na stranicu za
        //plavog ili crvenog kao za ulaz u ovu igru
        izracunato = eval(resenje);
        ceoBroj = proveraCeoBroj(izracunato);

        if (ceoBroj) {
            //da li je taj broj isti kao uneti
            int i = (int) izracunato;
            if ((Integer.parseInt(ponudjeniBroj)) == i) {
                HttpSession session = getSession();
                bodovi = (int) session.getAttribute("bodovi");
                bodovi += 5;
                session.setAttribute("bodovi", bodovi);
                session.setAttribute("igraMojbroj", 5);
                return "/igraSpojnica/igraSpojnica";
            } else {
                HttpSession session = getSession();
                bodovi = (int) session.getAttribute("bodovi");
                bodovi += 0;
                session.setAttribute("bodovi", bodovi);
                session.setAttribute("igraMojbroj", 0);
                return "/igraSpojnica/igraSpojnica";
            }
        } else {
            HttpSession session = getSession();
            bodovi = (int) session.getAttribute("bodovi");
            bodovi += 0;
            session.setAttribute("bodovi", bodovi);
            return "/igraSpojnica/igraSpojnica";
        }

    }

    public boolean proveraCeoBroj(double d) {
        if ((d == Math.floor(d)) && !Double.isInfinite(d)) {
            return true;
        }
        return false;
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') {
                    nextChar();
                }
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) {
                        x += parseTerm(); // addition
                    } else if (eat('-')) {
                        x -= parseTerm(); // subtraction
                    } else {
                        return x;
                    }
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) {
                        x *= parseFactor(); // multiplication
                    } else if (eat('/')) {
                        x /= parseFactor(); // division
                    } else {
                        return x;
                    }
                }
            }

            double parseFactor() {
                if (eat('+')) {
                    return parseFactor(); // unary plus
                }
                if (eat('-')) {
                    return -parseFactor(); // unary minus
                }
                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') {
                        nextChar();
                    }
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') {
                        nextChar();
                    }
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) {
                        x = Math.sqrt(x);
                    } else if (func.equals("sin")) {
                        x = Math.sin(Math.toRadians(x));
                    } else if (func.equals("cos")) {
                        x = Math.cos(Math.toRadians(x));
                    } else if (func.equals("tan")) {
                        x = Math.tan(Math.toRadians(x));
                    } else {
                        throw new RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) {
                    x = Math.pow(x, parseFactor()); // exponentiation
                }
                return x;
            }
        }.parse();
    }

    /////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////
    // getteri i setteri ********************************************
    public ArrayList<String> getJednocifreni() {
        return jednocifreni;
    }

    public boolean isPotvrdjeno() {
        return potvrdjeno;
    }

    public void setPotvrdjeno(boolean potvrdjeno) {
        this.potvrdjeno = potvrdjeno;
    }

    public void setJednocifreni(ArrayList<String> jednocifreni) {
        this.jednocifreni = jednocifreni;
    }

    public String getDvocifreni() {
        return dvocifreni;
    }

    public String getPonudjeniBroj() {
        return ponudjeniBroj;
    }

    public void setPonudjeniBroj(String ponudjeniBroj) {
        this.ponudjeniBroj = ponudjeniBroj;
    }

    public void setDvocifreni(String dvocifreni) {
        this.dvocifreni = dvocifreni;
    }

    public String getTrocifreni() {
        return trocifreni;
    }

    public void setTrocifreni(String trocifreni) {
        this.trocifreni = trocifreni;
    }

    public String getTrazeniBroj() {
        return trazeniBroj;
    }

    public boolean isCeoBroj() {
        return ceoBroj;
    }

    public void setCeoBroj(boolean ceoBroj) {
        this.ceoBroj = ceoBroj;
    }

    public int getBodovi() {
        return bodovi;
    }

    public void setBodovi(int bodovi) {
        this.bodovi = bodovi;
    }

    public int getMoguciBodovi() {
        return moguciBodovi;
    }

    public void setMoguciBodovi(int moguciBodovi) {
        this.moguciBodovi = moguciBodovi;
    }

    public int getZavrseno() {
        return zavrseno;
    }

    public void setZavrseno(int zavrseno) {
        this.zavrseno = zavrseno;
    }

    public int getOsvojeniBodovi() {
        return osvojeniBodovi;
    }

    public void setOsvojeniBodovi(int osvojeniBodovi) {
        this.osvojeniBodovi = osvojeniBodovi;
    }

    public void setTrazeniBroj(String trazeniBroj) {
        this.trazeniBroj = trazeniBroj;
    }

    public String getOperacija() {
        return operacija;
    }

    public void setOperacija(String operacija) {
        this.operacija = operacija;
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    public String getResenje() {
        return resenje;
    }

    public void setResenje(String resenje) {
        this.resenje = resenje;
    }

    public ArrayList<String> getZnaci() {
        return znaci;
    }

    public void setZnaci(ArrayList<String> znaci) {
        this.znaci = znaci;
    }

    public double getIzracunato() {
        return izracunato;
    }

    public void setIzracunato(double izracunato) {
        this.izracunato = izracunato;
    }

    private void dodeliBodove(int bodovi, int moguciBodovi, int zavrseno) {
        if (zavrseno == 0) {
            osvojeniBodovi = bodovi;
            sesija.setAttribute("igraSlagalica", osvojeniBodovi);
        } else {
            osvojeniBodovi = moguciBodovi;
            sesija.setAttribute("igraSlagalica", osvojeniBodovi);
        }
    }

    public void potvrdi() {
        potvrdjeno = true;
    }

}
