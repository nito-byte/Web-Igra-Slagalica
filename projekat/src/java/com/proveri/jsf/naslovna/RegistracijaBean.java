package com.proveri.jsf.naslovna;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import pojo.*;
import util.SessionUtils;

@ManagedBean(name = "RegistracijaBean")
@SessionScoped
public class RegistracijaBean {

    private String name;
    private String surname;
    private String email;
    private String job;

    private Date birthDay;
    private String username;
    private String password;
    private String password1;
    private String pol;
    private String tipKorisnika;

    private User aa = new User();
    
    public static HttpSession sesija;
    
  //  public HttpSession sesija;
    

    private User user1 = new User();
    
//    private List<Flight> f = new ArrayList<Flight>();
//    private List<String> s = new ArrayList<String>();
//    private List<Airline> lstAirline = new ArrayList<Airline>();
//
//    private Flight selectedFlight;

//    private void konvertuj(List<Flight> f) {
//        for (Flight f1 : f) {
//            s.add(f1.getBrojLeta());
//
//        }
//    }

//    public Flight getSelectedFlight() {
//        return selectedFlight;
//    }
//
//    public void setSelectedFlight(Flight selectedFlight) {
//        this.selectedFlight = selectedFlight;
//    }

    public User getAa() {
        return aa;
    }

    public void setAa(User aa) {
        this.aa = aa;
    }

    public boolean usernameUnique() {
        RegistracijaDAO inserir = new RegistracijaDAOImpl();
        User usuario = null;

        usuario = inserir.getWithOnlyUsername(username);
        if (usuario == null) {
            //ne postoji korisnik sa tim username-om
            clear();
            return true;
        } else {
            //znaci postoji taj username vec u bazi
            return false;

        }
    }
    
    

    public String cadastrar() {
        try {
            RegistracijaDAO inserir = new RegistracijaDAOImpl();
            User usuario = new User();
            String pass = Sha1.sha1(password);
            
            usuario.setName(name);
            usuario.setSurname(surname);
            usuario.setEmail(email);
            usuario.setJob(job);
            usuario.setUsername(username);
            usuario.setPassword(pass);
            usuario.setPol(pol);
            usuario.setBirthDay(new java.sql.Date(birthDay.getTime()));
            usuario.setTipKorisnika("ucesnik");
            
            
            usuario.setPrihvacenZahtev("false");
            aa.setUsername(username);
            
            inserir.persist(usuario);
            clear();
            
        } catch (Exception ex) {
            Logger.getLogger(RegistracijaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/pocetak/addSlika.xhtml?faces-redirect=true";

    }

    public String promenaLozinke() {
        try {
            RegistracijaDAO inserir = new RegistracijaDAOImpl();
            User usuario = new User();
            
            String pass = Sha1.sha1(password);
            
            usuario = inserir.getWithUsername(username, pass);
            if (usuario == null) {
                clear();
                return "/pocetak/promenaLozinkeError.xhtml?faces-redirect=true";
            } else {
                String pass1 = Sha1.sha1(password1);
                usuario.setPassword(pass1);
                inserir.merge(usuario);
                clear();
                return "/pocetak/prijava.xhtml?faces-redirect=true";
            }
        } catch (Exception ex) {
            Logger.getLogger(RegistracijaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    public String prijavi() {
        try {
            RegistracijaDAO inserir = new RegistracijaDAOImpl();
            User usuario = new User();
            
            sesija = SessionUtils.getSession();
            sesija.setAttribute("username", username);
            
            String pass = Sha1.sha1(password);
            
            usuario = inserir.getWithUsername(username, pass);
            user1 = usuario;
            if (usuario == null) {
                //ako ne postoji korisnik koji sa tim username i password
                clear();
                return "/pocetak/prijavaError.xhtml?faces-redirect=true";
            } else {
                //ako postoji korisnik sa tim username i password
                //onda proverim koja je vrsta korisnika i odem na
                //odgovarajucu stranicu
//            NewAirlineDAO a = new NewAirlineDAOImpl();
//            lstAirline = a.findAll();
                
                String pom = usuario.getTipKorisnika();
                if (pom.equals("ucesnik")) {
                    //clear();
                    return "/ucesnik/linkovi.xhtml?faces-redirect=true";
                }
                
                if (pom.equals("admin")) {
                    //  clear();
                    return "/admin/linkovi.xhtml?faces-redirect=true";
                }
                
                if (pom.equals("supervizor")) {
                    // clear();
                    return "/supervizor/linkovi.xhtml?faces-redirect=true";
                }
                
                
                
            }
        } catch (Exception ex) {
            Logger.getLogger(RegistracijaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "/pocetak/prijava.xhtml?faces-redirect=true";
    }

    public String logar() {
        return "/registrovano.xhtml?faces-redirect=true";
    }

    public void clear() {
        name = "";
        email = "";
        username = "";
        password = "";
        password1 = "";
        job = "";
        pol = "";
        tipKorisnika = "";
        birthDay = null;
    }

//    public String editAirline() {
//        RegistracijaDAO inserir = new RegistracijaDAOImpl();
//        User user = new User();
//        user = user1;
//        user.setAirline(airline);
//        inserir.merge(user);
//
//        return "/stujardesa/linkovi.xhtml?faces-redirect=true";
//    }

//    public String editAirline1() {
//        RegistracijaDAO inserir = new RegistracijaDAOImpl();
//        User user = new User();
//        user = user1;
//        user.setAirline(airline);
//        inserir.merge(user);
//
//        return "/pilot/linkovi.xhtml?faces-redirect=true";
//    }

//    public String arhivaS() {
//        // prvo pretrazi tabelu posada
//        PosadaDAO inserir = new PosadaDAOImpl();
//        FlightDAO fl = new FlightDAOImpl();
//        List<Posada> usuario = new ArrayList<Posada>();
//
//        String pom = new String();
//
//        usuario = inserir.getWithUsername(username);
//        if (usuario == null) {
//            clear();
//            return "Error.xhtml?faces-redirect=true";
//        } else {
//            //znaci postoji taj clan u posadi
//            //treba da dohvatim 
//            List<Flight> f1 = new ArrayList<Flight>();
//            for (Posada p : usuario) {
//                //idem do tabele Flights i trazim let sa istim brojem leta 
//                //i treba da proverim kada se dogodio. Vracam samo one letove koji su 
//                //odgovarajuci
//
//                pom = p.getBrojLeta();
//                Flight q = new Flight();
//                q = fl.findArchiveS(pom);
//                if (q != null) {
//                    f1.add(q);
//                }
//
//            }
//            konvertuj(f1);
//            f = f1;
//            return "/stujardesa/arhivaLetova.xhtml?faces-redirect=true";
//
//        }
//    }

//    public String buduciS() {
//        // prvo pretrazi tabelu posada
//        PosadaDAO inserir = new PosadaDAOImpl();
//        FlightDAO fl = new FlightDAOImpl();
//        List<Posada> usuario = new ArrayList<Posada>();
//
//        String pom = new String();
//
//        usuario = inserir.getWithUsername(username);
//        if (usuario == null) {
//            clear();
//            return "Error.xhtml?faces-redirect=true";
//        } else {
//            //znaci postoji taj clan u posadi
//            //treba da dohvatim 
//            List<Flight> f1 = new ArrayList<Flight>();
//            for (Posada p : usuario) {
//                //idem do tabele Flights i trazim let sa istim brojem leta 
//                //i treba da proverim kada se dogodio. Vracam samo one letove koji su 
//                //odgovarajuci
//
//                pom = p.getBrojLeta();
//                Flight q = new Flight();
//                q = fl.findBuduciS(pom);
//                if (q != null) {
//                    f1.add(q);
//                }
//
//            }
//            konvertuj(f1);
//            f = f1;
//            return "/stujardesa/buduciLetovi.xhtml?faces-redirect=true";
//
//        }
//    }

    // ******* getteri i setteri *******


    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public String getTipKorisnika() {
        return tipKorisnika;
    }

    public void setTipKorisnika(String tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
    }


    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    
    
    
    // remove method
    public String removeRegistracija() {
        RegistracijaDAO dao = new RegistracijaDAOImpl();
        String username = aa.getUsername();
        dao.remove(username);
    
        return "/pocetak/prijava.xhtml?faces-redirect=true";
    }

    public HttpSession getSesija() {
        return sesija;
    }

    public void setSesija(HttpSession sesija) {
        this.sesija = sesija;
    }

    
    
}
