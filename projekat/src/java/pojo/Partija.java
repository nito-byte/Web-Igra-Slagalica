package pojo;
// Generated Jul 6, 2019 6:11:43 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Partija generated by hbm2java
 */
@Entity
@Table(name="Partija"
    ,catalog="let1"
)
public class Partija  implements java.io.Serializable {


     private Integer id;
     private String plaviUsername;
     private Integer plaviPoeni;
     private String crveniUsername;
     private Integer crveniPoeni;
     private String ishod;
     private Date datumIganja;
     private Integer potvrdioCrveni;
     private Integer potvrdionPlavi;
     private Integer aktivnaIgra;

    public Partija() {
    }

    public Partija(String plaviUsername, Integer plaviPoeni, String crveniUsername, Integer crveniPoeni, String ishod, Date datumIganja, Integer potvrdioCrveni, Integer potvrdionPlavi, Integer aktivnaIgra) {
       this.plaviUsername = plaviUsername;
       this.plaviPoeni = plaviPoeni;
       this.crveniUsername = crveniUsername;
       this.crveniPoeni = crveniPoeni;
       this.ishod = ishod;
       this.datumIganja = datumIganja;
       this.potvrdioCrveni = potvrdioCrveni;
       this.potvrdionPlavi = potvrdionPlavi;
       this.aktivnaIgra = aktivnaIgra;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="plaviUsername", length=35)
    public String getPlaviUsername() {
        return this.plaviUsername;
    }
    
    public void setPlaviUsername(String plaviUsername) {
        this.plaviUsername = plaviUsername;
    }

    
    @Column(name="plaviPoeni")
    public Integer getPlaviPoeni() {
        return this.plaviPoeni;
    }
    
    public void setPlaviPoeni(Integer plaviPoeni) {
        this.plaviPoeni = plaviPoeni;
    }

    
    @Column(name="crveniUsername", length=35)
    public String getCrveniUsername() {
        return this.crveniUsername;
    }
    
    public void setCrveniUsername(String crveniUsername) {
        this.crveniUsername = crveniUsername;
    }

    
    @Column(name="crveniPoeni")
    public Integer getCrveniPoeni() {
        return this.crveniPoeni;
    }
    
    public void setCrveniPoeni(Integer crveniPoeni) {
        this.crveniPoeni = crveniPoeni;
    }

    
    @Column(name="Ishod", length=35)
    public String getIshod() {
        return this.ishod;
    }
    
    public void setIshod(String ishod) {
        this.ishod = ishod;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="datumIganja", length=0)
    public Date getDatumIganja() {
        return this.datumIganja;
    }
    
    public void setDatumIganja(Date datumIganja) {
        this.datumIganja = datumIganja;
    }

    
    @Column(name="potvrdioCrveni")
    public Integer getPotvrdioCrveni() {
        return this.potvrdioCrveni;
    }
    
    public void setPotvrdioCrveni(Integer potvrdioCrveni) {
        this.potvrdioCrveni = potvrdioCrveni;
    }

    
    @Column(name="potvrdionPlavi")
    public Integer getPotvrdionPlavi() {
        return this.potvrdionPlavi;
    }
    
    public void setPotvrdionPlavi(Integer potvrdionPlavi) {
        this.potvrdionPlavi = potvrdionPlavi;
    }

    
    @Column(name="aktivnaIgra")
    public Integer getAktivnaIgra() {
        return this.aktivnaIgra;
    }
    
    public void setAktivnaIgra(Integer aktivnaIgra) {
        this.aktivnaIgra = aktivnaIgra;
    }




}

