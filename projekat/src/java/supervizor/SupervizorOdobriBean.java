package supervizor;

import com.proveri.jsf.naslovna.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;

/**
 *
 * @author tijana
 */
@ManagedBean(name = "SupervizorOdobriBean")
@SessionScoped
public class SupervizorOdobriBean implements Serializable {

    private List<SupervizorOdobri> lst = new ArrayList<SupervizorOdobri>();

    @PostConstruct
    public void init() {
        SupervizorOdobriDAO dao = new SupervizorOdobriDAOImpl();
        lst = dao.findByNijePrihvacenZahtev();
    }

    public List<SupervizorOdobri> getLst() {
        SupervizorOdobriDAO dao = new SupervizorOdobriDAOImpl();
        lst = dao.findByNijePrihvacenZahtev();
        return lst;
    }

    public void setLst(List<SupervizorOdobri> lst) {
        this.lst = lst;
    }

    public String edit(SupervizorOdobri u1) {
        SupervizorOdobriDAO inserir = new SupervizorOdobriDAOImpl();
        SupervizorOdobri u = new SupervizorOdobri();
        u = u1;
        u.setOdobreno(1);
        inserir.merge(u);

        return "/supervizor/listOdobriRec.xhtml?faces-redirect=true";
    }

    public void remove(SupervizorOdobri u1) {
       SupervizorOdobriDAO inserir = new SupervizorOdobriDAOImpl();
        SupervizorOdobri u = new SupervizorOdobri();
        u = u1;
        u.setOdobreno(2);
        inserir.merge(u); 
    }

}
