package gost;


 
import javax.faces.bean.ManagedBean;
import org.apache.commons.lang.RandomStringUtils;
 
@ManagedBean
public class KartaView {
     
    private String text1=RandomStringUtils.randomAlphanumeric(8); 

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }
    

   
   
    
 
   
}