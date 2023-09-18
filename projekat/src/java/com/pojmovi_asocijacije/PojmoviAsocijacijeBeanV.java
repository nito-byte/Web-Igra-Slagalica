package com.pojmovi_asocijacije;

import com.pojmovi_slagalica.Word;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import pojo.*;

@ManagedBean(name = "PojmoviAsocijacijeBeanV")
@SessionScoped
public class PojmoviAsocijacijeBeanV {

    private String code;
    private Word word;
    private List<Word> words;
    private Gramatika tt = new Gramatika();

    @PostConstruct
    public void init() {
        word = new Word();
        words = new ArrayList<Word>();

    }

    private String A1;
    private String A2;
    private String A3;
    private String A4;

    private String B1;
    private String B2;
    private String B3;
    private String B4;

    private String V1;
    private String V2;
    private String V3;
    private String V4;

    private String G1;
    private String G2;
    private String G3;
    private String G4;

    private String kolA;
    private String kolB;
    private String kolV;
    private String kolG;

    private List<PojmoviAsocijacije> lst = new ArrayList<PojmoviAsocijacije>();
    private String konacno;
    private int sifra;    //sifru koristim da bih znala da spojim sa sinonima

    public String cadastrar() {
        com.pojmovi_asocijacije.PojmoviAsocijacijeDAO inserir = new com.pojmovi_asocijacije.PojmoviAsocijacijeDAOImpl();
        PojmoviAsocijacije usuario = new PojmoviAsocijacije();

        usuario.setA1(A1);
        usuario.setA2(A2);
        usuario.setA3(A3);
        usuario.setA4(A4);

        usuario.setB1(B1);
        usuario.setB2(B2);
        usuario.setB3(B3);
        usuario.setB4(B4);

        usuario.setV1(V1);
        usuario.setV2(V2);
        usuario.setV3(V3);
        usuario.setV4(V4);

        usuario.setG1(G1);
        usuario.setG2(G2);
        usuario.setG3(G3);
        usuario.setG4(G4);

        usuario.setKolA(kolA);
        usuario.setKolB(kolB);
        usuario.setKolV(kolV);
        usuario.setKolG(kolG);
        usuario.setKonacno(konacno);

        //usuario.setIshod(ishod);
        //usuario.setDatumIganja(new java.sql.Date(datumIgranja.getTime()));
        //ovde cu sada da generisem kljuc za 
        inserir.persist(usuario);
        PojmoviAsocijacije p = inserir.getId(usuario); //dohvatim ID upravo ubacenog
        sifra = p.getId();
        clear();
        return "/supervizor/unosAsocijacijeSinonimiA.xhtml?faces-redirect=true";

    }

    public List<PojmoviAsocijacije> getLst() {
        PojmoviAsocijacijeDAO dao = new PojmoviAsocijacijeDAOImpl();
        lst = dao.findAll();
        return lst;
    }

    public void setLst(List<PojmoviAsocijacije> lst) {
        this.lst = lst;
    }

    public void clear() {
        A1 = A2 = A3 = A4 = "";

        B1 = B2 = B3 = B4 = "";

        V1 = V2 = V3 = V4 = "";

        G1 = G2 = G3 = G4 = "";

        kolA = kolB = kolV = kolG = "";

        konacno = "";
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
    public String getA1() {
        return A1;
    }

    public void setA1(String A1) {
        this.A1 = A1;
    }

    public String getA2() {
        return A2;
    }

    public void setA2(String A2) {
        this.A2 = A2;
    }

    public String getA3() {
        return A3;
    }

    public void setA3(String A3) {
        this.A3 = A3;
    }

    public String getA4() {
        return A4;
    }

    public void setA4(String A4) {
        this.A4 = A4;
    }

    public String getB1() {
        return B1;
    }

    public void setB1(String B1) {
        this.B1 = B1;
    }

    public String getB2() {
        return B2;
    }

    public void setB2(String B2) {
        this.B2 = B2;
    }

    public String getB3() {
        return B3;
    }

    public void setB3(String B3) {
        this.B3 = B3;
    }

    public String getB4() {
        return B4;
    }

    public void setB4(String B4) {
        this.B4 = B4;
    }

    public String getV1() {
        return V1;
    }

    public void setV1(String V1) {
        this.V1 = V1;
    }

    public String getV2() {
        return V2;
    }

    public void setV2(String V2) {
        this.V2 = V2;
    }

    public String getV3() {
        return V3;
    }

    public void setV3(String V3) {
        this.V3 = V3;
    }

    public String getV4() {
        return V4;
    }

    public void setV4(String V4) {
        this.V4 = V4;
    }

    public String getG1() {
        return G1;
    }

    public void setG1(String G1) {
        this.G1 = G1;
    }

    public String getG2() {
        return G2;
    }

    public void setG2(String G2) {
        this.G2 = G2;
    }

    public String getG3() {
        return G3;
    }

    public void setG3(String G3) {
        this.G3 = G3;
    }

    public String getG4() {
        return G4;
    }

    public void setG4(String G4) {
        this.G4 = G4;
    }

    public String getKolA() {
        return kolA;
    }

    public void setKolA(String kolA) {
        this.kolA = kolA;
    }

    public String getKolB() {
        return kolB;
    }

    public void setKolB(String kolB) {
        this.kolB = kolB;
    }

    public String getKolV() {
        return kolV;
    }

    public void setKolV(String kolV) {
        this.kolV = kolV;
    }

    public String getKolG() {
        return kolG;
    }

    public void setKolG(String kolG) {
        this.kolG = kolG;
    }

    public String getKonacno() {
        return konacno;
    }

    public void setKonacno(String konacno) {
        this.konacno = konacno;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public Gramatika getTt() {
        return tt;
    }

    public void setTt(Gramatika tt) {
        this.tt = tt;
    }

    public void createNew() {
        if (words.contains(word)) {
            FacesMessage msg = new FacesMessage("Dublicated", "This word has already been added");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            words.add(word);
            word = new Word();
        }
    }

    public String reinit() {
        word = new Word();

        return null;
    }

    public void obrisi() {
        for (ListIterator<Word> iter = words.listIterator(); iter.hasNext();) {
            Word a = iter.next();
            String pom1 = a.getRec();
            String pom2 = word.getRec();
            if (pom1.equals(pom2)) {
                iter.remove();
            }
        }
    }

    public String cadastrarSinonimiV() {

        for (Word item : words) {
            SinonimiVDAO inserir = new SinonimiVDAOImpl();
            SinonimiV usuario = new SinonimiV();
            usuario.setKolonaV(item.getRec());
            usuario.setSifra(PojmoviAsocijacijeBean.sifraTrenutne);
            inserir.persist(usuario);
            word = null;
            words = null;
        }
        return "/supervizor/unosAsocijacijeSinonimiG.xhtml?faces-redirect=true";
    }

}
