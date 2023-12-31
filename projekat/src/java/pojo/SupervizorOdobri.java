package pojo;
// Generated Jul 6, 2019 6:11:43 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SupervizorOdobri generated by hbm2java
 */
@Entity
@Table(name="SupervizorOdobri"
    ,catalog="let1"
)
public class SupervizorOdobri  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String rec;
     private Integer odobreno;

    public SupervizorOdobri() {
    }

    public SupervizorOdobri(String username, String rec, Integer odobreno) {
       this.username = username;
       this.rec = rec;
       this.odobreno = odobreno;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="username", length=45)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="rec", length=45)
    public String getRec() {
        return this.rec;
    }
    
    public void setRec(String rec) {
        this.rec = rec;
    }

    
    @Column(name="odobreno")
    public Integer getOdobreno() {
        return this.odobreno;
    }
    
    public void setOdobreno(Integer odobreno) {
        this.odobreno = odobreno;
    }




}


