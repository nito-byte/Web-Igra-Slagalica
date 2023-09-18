package igraDanaLista;

import gostListe.*;
import ucesnici.*;
import java.util.ArrayList;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import pojo.*;
import util.SessionUtils;

@ManagedBean(name = "IgraDanaListBean")
@SessionScoped
public class IgraDanaListBean {

//    private List lstMesec = new ArrayList<>();
//    private List lstNedelja = new ArrayList<>();
    private List lstIgraDana = new ArrayList<>();
    private List list = new ArrayList<>();

    @PostConstruct
    public void dohvati() {

        IgraDanaListDAO dao = new IgraDanaListDAOImpl();
        lstIgraDana = dao.najboljiIgraDana();

        int ii = lstIgraDana.size();
        ii -= 1;
        for (int i = ii; i > 9; i--) {
            lstIgraDana.remove(i);
        }

    }
    
    public String igraciDohvati(){
        IgraDanaListDAO dao = new IgraDanaListDAOImpl();
        lstIgraDana = dao.najboljiIgraDana();
         return "igraciTekucegDana?faces-redirect=true.xhtml";
    }

//    public void postoji(List lstIgraDana) {
//        //dohvatim prvih 10 username-a
//        HttpSession sesija = SessionUtils.getSession();
//        String s = (String) sesija.getAttribute("username");
//        
//        IgraDanaListDAO dao = new IgraDanaListDAOImpl();
//        List<String> lista = dao.najboljiIgraDanaUsername();
//        
//        if(!(lista.contains(s))){
//            //ako ne sadrzi, odem i pronadjem ga
//            //dohvatim mu bodove
//            int bodovi = dao.dohvatiBodove(s);
//            
//            Object o = new Object();
//            o.se
//            lstIgraDana.add(new Object());
//            
//        }
//
//        //proverim da li je tu i moje ime
//        //ako nije dodam ga na kraj
//    }

    public List getLstIgraDana() {
      //  IgraDanaListDAO dao= new IgraDanaListDAOImpl();
        //  lstIgraDana = dao.najboljiIgraDana();
        return lstIgraDana;
    }

    public void setLstIgraDana(List lstIgraDana) {
        this.lstIgraDana = lstIgraDana;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

}
