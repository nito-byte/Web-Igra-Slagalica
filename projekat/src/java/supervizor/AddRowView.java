/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supervizor;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name="dtAddRowView")
@SessionScoped
public class AddRowView implements Serializable {
     
    private List<Car> cars1;
    private String rec;
 
    @ManagedProperty("#{carService}")
    private CarService service;
     
    @PostConstruct
    public void init() {
        cars1 = service.createCars(1);
    }
 
    public List<Car> getCars1() {
        return cars1;
    }
 
 
     
    public List<String> getColors() {
        return service.getColors();
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
     

 
    public void onAddNew() {
        // Add one new car to the table:
        rec=getRec();
        Car car2Add = service.createCarsDodaj(1,rec).get(0);
        
        cars1.add(car2Add);
        FacesMessage msg = new FacesMessage("Nova rec dodata", car2Add.getColor());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }
    
    
     
}