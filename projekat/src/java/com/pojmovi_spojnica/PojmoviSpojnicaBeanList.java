package com.pojmovi_spojnica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.*;

@ManagedBean(name = "PojmoviSpojnicaBeanList")
@SessionScoped
public class PojmoviSpojnicaBeanList {

    private List<PojmoviSpojnice> lst = new ArrayList<PojmoviSpojnice>();

   

    public List<PojmoviSpojnice> getLst() {
        PojmoviSpojnicaDAO dao = new PojmoviSpojnicaDAOImpl();
        lst = dao.findAll();
        return lst;
    }

    public void setLst(List<PojmoviSpojnice> lst) {
        this.lst = lst;
    }

   
}
