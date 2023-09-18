
package com.flight.jsf.validator;

import com.proveri.jsf.naslovna.RegistracijaDAO;
import com.proveri.jsf.naslovna.RegistracijaDAOImpl;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import static org.jboss.logging.NDC.clear;
import pojo.User;

public class UsernameValidator implements Validator {
    
    
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String username = (String) o;
        
        RegistracijaDAO inserir = new RegistracijaDAOImpl();
        User usuario = null;
        boolean rez=false;

        usuario = inserir.getWithOnlyUsername(username);
        if (usuario == null) {
            //ne postoji korisnik sa tim username-om
           // clear();
            rez=false;
        } else {
            //znaci postoji taj username vec u bazi
            rez=true;
        }
        
        if (rez==true ){
            FacesMessage message = new FacesMessage();
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
    
}
