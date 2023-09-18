package igraPoslDesetDana;

import java.util.ArrayList;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import util.SessionUtils;

@ManagedBean(name = "IgraPoslDesetDanaBean")
@SessionScoped
public class IgraPoslDesetDanaBean {

    private List lst = new ArrayList<>();

    @PostConstruct
    public void dohvati() {

        HttpSession sesija = SessionUtils.getSession();
        String u = (String) sesija.getAttribute("username");

        IgraPoslDesetDanaDAO dao = new IgraPoslDesetDanaDAOImpl();
        lst = dao.mojePartijePrethodnihDesetDana(u);

    }

    public List getLst() {
        return lst;
    }

    public void setLst(List lst) {
        this.lst = lst;
    }

}
