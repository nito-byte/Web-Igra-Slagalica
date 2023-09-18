package admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;




@FacesValidator("calendarValidator")
public class CalendarValidator implements Validator{
    
    List<Date> dates = new ArrayList<>();
    

    @Override  
    public void validate(FacesContext context, UIComponent component, Object value) {
        java.util.Date date2 = (java.util.Date) value;

        try {
            if (validateDate(date2)) {
                throw new ValidatorException(new FacesMessage("A valid date"));
            } else {
                throw new ValidatorException(new FacesMessage("date dont figure in the database"));
            } 
        } catch(Exception e) {
            e.printStackTrace();
        }   
    }
    
    public void insertDate(Date d){
        dates.add(d);
    }
    
    public boolean validateDate(Date d){
        
        if(dates.contains(d))return false;
        else return true;
    }
}