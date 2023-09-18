package com.pojmovi_spojnica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import org.primefaces.component.inputtext.InputText;
import pojo.*;
import static util.SessionUtils.getSession;

@ManagedBean(name = "PojmoviSpojnicaBean")
@SessionScoped
public class PojmoviSpojnicaBean {

    private List<PojmoviSpojnice> lst = new ArrayList<PojmoviSpojnice>();

    private ArrayList<String> bojaR = new ArrayList<String>(10);
    private ArrayList<String> bojaL = new ArrayList<String>(10);

    private ArrayList<String> mylist1 = new ArrayList<String>();
    private ArrayList<String> mylist1_Origin = new ArrayList<String>();

    private ArrayList<String> mylist2 = new ArrayList<String>();
    private ArrayList<String> mylist2_Origin = new ArrayList<String>();

    private int brojac = 0;
    private InputText tekuciElem;

    private String polje11, polje12, polje21, polje22, polje31, polje32, polje41, polje42, polje51, polje52, polje61, polje62, polje71, polje72, polje81, polje82, polje91, polje92, polje101, polje102;

    public String bojaR(int i) {
        return bojaR.get(i);
    }

    public String bojaL(int i) {
        return bojaL.get(i);
    }

    public void clear() {
        polje11 = polje12 = polje21 = polje22 = polje31 = polje32 = "";
        polje41 = polje42 = polje51 = polje52 = polje61 = polje62 = "";
        polje71 = polje72 = polje81 = polje82 = polje91 = polje92 = "";
        polje101 = polje102 = "";

        dodeliBoje(bojaL, bojaR);

    }

    private int bodovi;
    private int osvojeniBodovi;

    @PostConstruct
    public void dohvatiSpojicu() {

        HttpSession session = getSession();
        bodovi = (int) session.getAttribute("bodovi");
        session.setAttribute("igraSpojnica", 0);
        osvojeniBodovi = bodovi;

        dodeliBoje(bojaL, bojaR);

        PojmoviSpojnicaDAO inserir = new com.pojmovi_spojnica.PojmoviSpojnicaDAOImpl();
        PojmoviSpojnice p = inserir.dohvatiSpojnicu();

        mylist1.add(p.getPolje11());
        mylist1.add(p.getPolje21());
        mylist1.add(p.getPolje31());
        mylist1.add(p.getPolje41());
        mylist1.add(p.getPolje51());
        mylist1.add(p.getPolje61());
        mylist1.add(p.getPolje71());
        mylist1.add(p.getPolje81());
        mylist1.add(p.getPolje91());
        mylist1.add(p.getPolje101());

        mylist1_Origin = (ArrayList<String>) mylist1.clone();
        Collections.shuffle(mylist1);
        //trebalo bi sada da ovo postavim u bazu da bi i drugi igrac mogao da vidi

        mylist2.add(p.getPolje12());
        mylist2.add(p.getPolje22());
        mylist2.add(p.getPolje32());
        mylist2.add(p.getPolje42());
        mylist2.add(p.getPolje52());
        mylist2.add(p.getPolje62());
        mylist2.add(p.getPolje72());
        mylist2.add(p.getPolje82());
        mylist2.add(p.getPolje92());
        mylist2.add(p.getPolje102());

        mylist2_Origin = (ArrayList<String>) mylist2.clone();
        Collections.shuffle(mylist2);
        //mislim da bi i ovo sada trebalo da postavim u bazu zbog drugog igraca

        polje11 = p.getPolje11();
        polje12 = p.getPolje12();
        polje21 = p.getPolje21();
        polje22 = p.getPolje22();
        polje31 = p.getPolje31();
        polje32 = p.getPolje32();
        polje41 = p.getPolje41();
        polje42 = p.getPolje42();
        polje51 = p.getPolje51();
        polje52 = p.getPolje52();
        polje61 = p.getPolje61();
        polje62 = p.getPolje62();
        polje71 = p.getPolje71();
        polje72 = p.getPolje72();
        polje81 = p.getPolje81();
        polje82 = p.getPolje82();
        polje91 = p.getPolje91();
        polje92 = p.getPolje92();
        polje101 = p.getPolje101();
        polje102 = p.getPolje102();

        bojaL.set(0, "yellow");

    }

    private void dodeliBoje(List<String> bojaL, List<String> bojaR) {
        for (int i = 0; i < 10; i++) {
            bojaL.add(i, "lightgoldenrodyellow");
            bojaR.add(i, "lightgoldenrodyellow");
        }
    }

    public String cadastrar() {
        PojmoviSpojnicaDAO inserir = new com.pojmovi_spojnica.PojmoviSpojnicaDAOImpl();
        PojmoviSpojnice usuario = new PojmoviSpojnice();

        usuario.setPolje11(polje11);
        usuario.setPolje12(polje12);

        usuario.setPolje21(polje21);
        usuario.setPolje22(polje22);

        usuario.setPolje31(polje31);
        usuario.setPolje32(polje32);

        usuario.setPolje41(polje41);
        usuario.setPolje42(polje42);

        usuario.setPolje51(polje51);
        usuario.setPolje52(polje52);

        usuario.setPolje61(polje61);
        usuario.setPolje62(polje62);

        usuario.setPolje71(polje71);
        usuario.setPolje72(polje72);

        usuario.setPolje81(polje81);
        usuario.setPolje82(polje82);

        usuario.setPolje91(polje91);
        usuario.setPolje92(polje92);

        usuario.setPolje101(polje101);
        usuario.setPolje102(polje102);

        inserir.persist(usuario);
        clear();

        return "/supervizor/uspesanUnosPojmova.xhtml?faces-redirect=true";
    }

    public void comparisonItems(int id) {

        // 1) dohvati kliknuta polja
//        int left = brojac;
//        int right= id;
        String left = mylist1.get(brojac);
        String right = mylist2.get(id);

        String par1 = null;
        String par2 = null;

        // 2) dohvati tacan par
        for (int i = 0; i < mylist1_Origin.size(); i++) {
            if (left.equals(mylist1_Origin.get(i))) {
                par1 = left;
                par2 = new String(mylist2_Origin.get(i));
            } //ako je promaseno zapamti indekse u niz promasenih!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        }

        // 3) proveri da li su kliknuti i tacan jednaki 
        if (par1.equals(left) && par2.equals(right)) {
            bojaR.set(id, "blue");
            bojaL.set(brojac, "blue");

            HttpSession session = getSession();
            bodovi = (int) session.getAttribute("bodovi");
            osvojeniBodovi = bodovi + 1;
            session.setAttribute("bodovi", osvojeniBodovi);

            int v = (int) session.getAttribute("igraSpojnica");
            v++;
            session.setAttribute("igraSpojnica", v);

        }

        // 4) dodaj ovde poene igracu !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (brojac == 9) {
            resetujBrojac(id, brojac);
        } else {

            brojac++;
            bojaL.set(brojac, "yellow");

        }

    }

    public void resetujBrojac(int id, int brojac) {
        String r = bojaR.get(id);
        String l = bojaL.get(brojac);
        bojaR.set(id, r);
        bojaL.set(brojac, l);
    }

    public List<PojmoviSpojnice> getLst() {
        PojmoviSpojnicaDAO dao = new PojmoviSpojnicaDAOImpl();
        lst = dao.findAll();
        return lst;
    }

    public void setLst(List<PojmoviSpojnice> lst) {
        this.lst = lst;
    }

    // ******* getteri i setteri *******
    public String getPolje11() {
        return polje11;
    }

    public void setPolje11(String polje11) {
        this.polje11 = polje11;
    }

    public String getPolje12() {
        return polje12;
    }

    public void setPolje12(String polje12) {
        this.polje12 = polje12;
    }

    public String getPolje21() {
        return polje21;
    }

    public void setPolje21(String polje21) {
        this.polje21 = polje21;
    }

    public String getPolje22() {
        return polje22;
    }

    public void setPolje22(String polje22) {
        this.polje22 = polje22;
    }

    public String getPolje31() {
        return polje31;
    }

    public void setPolje31(String polje31) {
        this.polje31 = polje31;
    }

    public String getPolje32() {
        return polje32;
    }

    public void setPolje32(String polje32) {
        this.polje32 = polje32;
    }

    public String getPolje41() {
        return polje41;
    }

    public void setPolje41(String polje41) {
        this.polje41 = polje41;
    }

    public String getPolje42() {
        return polje42;
    }

    public void setPolje42(String polje42) {
        this.polje42 = polje42;
    }

    public String getPolje51() {
        return polje51;
    }

    public void setPolje51(String polje51) {
        this.polje51 = polje51;
    }

    public String getPolje52() {
        return polje52;
    }

    public void setPolje52(String polje52) {
        this.polje52 = polje52;
    }

    public String getPolje61() {
        return polje61;
    }

    public void setPolje61(String polje61) {
        this.polje61 = polje61;
    }

    public String getPolje62() {
        return polje62;
    }

    public void setPolje62(String polje62) {
        this.polje62 = polje62;
    }

    public String getPolje71() {
        return polje71;
    }

    public void setPolje71(String polje71) {
        this.polje71 = polje71;
    }

    public String getPolje72() {
        return polje72;
    }

    public void setPolje72(String polje72) {
        this.polje72 = polje72;
    }

    public String getPolje81() {
        return polje81;
    }

    public void setPolje81(String polje81) {
        this.polje81 = polje81;
    }

    public String getPolje82() {
        return polje82;
    }

    public void setPolje82(String polje82) {
        this.polje82 = polje82;
    }

    public String getPolje91() {
        return polje91;
    }

    public void setPolje91(String polje91) {
        this.polje91 = polje91;
    }

    public String getPolje92() {
        return polje92;
    }

    public void setPolje92(String polje92) {
        this.polje92 = polje92;
    }

    public String getPolje101() {
        return polje101;
    }

    public void setPolje101(String polje101) {
        this.polje101 = polje101;
    }

    public String getPolje102() {
        return polje102;
    }

    public void setPolje102(String polje102) {
        this.polje102 = polje102;
    }

    public ArrayList<String> getMylist1() {
        return mylist1;
    }

    public void setMylist1(ArrayList<String> mylist1) {
        this.mylist1 = mylist1;
    }

    public ArrayList<String> getMylist2() {
        return mylist2;
    }

    public void setMylist2(ArrayList<String> mylist2) {
        this.mylist2 = mylist2;
    }

    public int getBrojac() {
        return brojac;
    }

    public void setBrojac(int brojac) {
        this.brojac = brojac;
    }

    public InputText getTekuciElem() {
        return tekuciElem;
    }

    public void setTekuciElem(InputText tekuciElem) {
        this.tekuciElem = tekuciElem;
    }

    public ArrayList<String> getMylist1_Origin() {
        return mylist1_Origin;
    }

    public void setMylist1_Origin(ArrayList<String> mylist1_Origin) {
        this.mylist1_Origin = mylist1_Origin;
    }

    public ArrayList<String> getMylist2_Origin() {
        return mylist2_Origin;
    }

    public void setMylist2_Origin(ArrayList<String> mylist2_Origin) {
        this.mylist2_Origin = mylist2_Origin;
    }

    public ArrayList<String> getBojaR() {
        return bojaR;
    }

    public void setBojaR(ArrayList<String> bojaR) {
        this.bojaR = bojaR;
    }

    public ArrayList<String> getBojaL() {
        return bojaL;
    }

    public void setBojaL(ArrayList<String> bojaL) {
        this.bojaL = bojaL;
    }

    public int getBodovi() {
        return bodovi;
    }

    public void setBodovi(int bodovi) {
        this.bodovi = bodovi;
    }

    public int getOsvojeniBodovi() {
        return osvojeniBodovi;
    }

    public void setOsvojeniBodovi(int osvojeniBodovi) {
        this.osvojeniBodovi = osvojeniBodovi;
    }

}
