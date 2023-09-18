/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.jsf.avion;

import com.proveri.jsf.naslovna.RegistracijaDAO;
import com.proveri.jsf.naslovna.RegistracijaDAOImpl;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author tijana
 */
@ManagedBean
@SessionScoped
public class UploadBean  implements Serializable{
    private UploadedFile file;
    private String model;
    
    
    

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    

   

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
    
    
    
    
    public void upload(){
        model = FacesContext.getCurrentInstance().
		getExternalContext().getRequestParameterMap().get("hidden1");
        
        
        
        try{
            if(file!=null){
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/let1?user=root&password=root");
            
            
            PreparedStatement st=cn.prepareStatement("INSERT INTO  imagen (img, identifikatorAviona) VALUES (?,?)");
            
            st.setBinaryStream(1, file.getInputstream());
            st.setString(2, model);
            st.executeUpdate();
            
            cn.close();
            
            FacesMessage message=new FacesMessage("Uspesno dodato!", file.getFileName()+ " file subido");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            
            }
        }catch(Exception e){
            FacesMessage message=new FacesMessage("Greska");
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        }
        
        
        
    }

   
    
}
