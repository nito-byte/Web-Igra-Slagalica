package com.flight.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.component.selectcheckboxmenu.SelectCheckboxMenu;

@FacesValidator("limitCheckboxMenuValidator")
public class LimitCheckboxMenuValidator implements Validator {

   public LimitCheckboxMenuValidator() {

   }

   @Override
   public void validate(FacesContext context, UIComponent component,
           Object value) throws ValidatorException { 
       //get limit
       Integer minLimit =    Integer.parseInt((String)component.getAttributes().get("minLimit"));
       Integer maxLimit =    Integer.parseInt((String)component.getAttributes().get("maxLimit"));
       SelectCheckboxMenu myComponent = (SelectCheckboxMenu)component;

       if ((((String[])myComponent.getSubmittedValue()).length < minLimit) ||(((String[])myComponent.getSubmittedValue()).length > maxLimit)) {
           FacesMessage msg
                   = new FacesMessage("Limit failed");
           msg.setSeverity(FacesMessage.SEVERITY_ERROR);
           throw new ValidatorException(msg);
       } 
   }
}