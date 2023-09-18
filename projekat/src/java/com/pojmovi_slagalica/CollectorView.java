package com.pojmovi_slagalica;

import com.pojmovi_asocijacije.SinonimiADAO;
import com.pojmovi_asocijacije.SinonimiADAOImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.SessionScoped;
import pojo.Gramatika;
import pojo.SinonimiA;

@ManagedBean(name = "collector")
@SessionScoped
public class CollectorView implements Serializable {

    private String code;
//    private Word word ;
    private String rec="";
    private List<String> reci =new ArrayList<>();
    private List<Word> words;
    private Gramatika tt = new Gramatika();

//    @PostConstruct
//    public void init() {
//        word = new Word();
//        words = new ArrayList<Word>();
//
//    }
    
//    public CollectorView() {
//        word = new Word();
//        words = new ArrayList<Word>();
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

//    public Word getWord() {
//        return word;
//    }

//    public void setWord(Word word) {
//        this.word = word;
//    }
//
//    public List<Word> getWords() {
//        return words;
//    }

//    public void setWords(List<Word> words) {
//        this.words = words;
//    }

    public Gramatika getTt() {
        return tt;
    }

    public void setTt(Gramatika tt) {
        this.tt = tt;
    }

    public void createNew() {
        if (reci.contains(rec)) {
            FacesMessage msg = new FacesMessage("Dublicated", "This word has already been added");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            reci.add(rec);
            rec = "";
        }
    }

    public String reinit() {
      //  word = new Word();
        rec="";
        return rec;
     //   return null;
    }

//    public void obrisi() {
//        for (ListIterator<Word> iter = words.listIterator(); iter.hasNext();) {
//            Word a = iter.next();
//            String pom1 = a.getRec();
//            String pom2 = rec;
//            if (pom1.equals(pom2)) {
//                iter.remove();
//            }
//        }
//    }

    public String cadastrar() {

        for (String item : reci) {
            GramatikaDAO inserir = new GramatikaDAOImpl();
            Gramatika usuario = new Gramatika();
            usuario.setIspravnaRec(item);
            inserir.persist(usuario);
        }

        return "uspesanUnosPojmova";
    }
    
    
    
    

//    public String cadastrarSinonimiA() {
//
//        for (Word item : words) {
//            SinonimiADAO inserir = new SinonimiADAOImpl();
//            SinonimiA usuario = new SinonimiA();
//            usuario.setKolonaA(item.getRec());
//            usuario.setSifra(Integer.SIZE);
//            inserir.persist(usuario);
//        }
//        return "uspesanUnosPojmova";
//    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public List<String> getReci() {
        return reci;
    }

    public void setReci(List<String> reci) {
        this.reci = reci;
    }
    
    
}
