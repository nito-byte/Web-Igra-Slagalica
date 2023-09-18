/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proveri.jsf.naslovna;

import manegedBean.*;
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
@ManagedBean(name = "RegistracijaListBean")
@SessionScoped
public class RegistracijaListBean implements Serializable {

    private String licenca;
    private List<User> lst = new ArrayList<User>();
    private List<User> lst1 = new ArrayList<User>();
    private String username;
    private String name;
    private String surname;
    private String email;
    private String airline;
    private User user1 = new User();

    

    

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    

    public String getLicenca() {
        return licenca;
    }

    public void setLicenca(String licenca) {
        this.licenca = licenca;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<User> getLst() {
        RegistracijaDAO dao = new RegistracijaDAOImpl();
        lst = dao.findByNijePrihvacenZahtev();
        return lst;
    }

    public void setLst(List<User> lst) {
        this.lst = lst;
    }

    public List<User> getLst1() {
        RegistracijaDAO dao = new RegistracijaDAOImpl();
        lst1 = dao.findByPrihvacenZahtev();
        return lst1;
    }

    public void setLst1(List<User> lst1) {
        this.lst1 = lst1;
    }

    public String edit(User user1) {
        RegistracijaDAO inserir = new RegistracijaDAOImpl();
        User user = new User();
        user = user1;
        user.setPrihvacenZahtev("true");
        inserir.merge(user);

        return "/admin/listRegistracija.xhtml?faces-redirect=true";
    }


    // remove method
    public void remove(User user) {
        RegistracijaDAO dao = new RegistracijaDAOImpl();
        dao.remove(user);
    }

    

}
