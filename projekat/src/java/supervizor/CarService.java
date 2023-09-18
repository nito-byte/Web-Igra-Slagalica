/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supervizor;

import com.pojmovi_slagalica.GramatikaDAO;
import com.pojmovi_slagalica.GramatikaDAOImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import pojo.Gramatika;

@ManagedBean(name = "carService")
@ApplicationScoped
public class CarService {

    private final static String[] colors;

    static {
        colors = new String[10];
        colors[0] = "Black";
        colors[1] = "White";
        colors[2] = "Green";
        colors[3] = "Red";
        colors[4] = "Blue";
        colors[5] = "Orange";
        colors[6] = "Silver";
        colors[7] = "Yellow";
        colors[8] = "Brown";
        colors[9] = "Maroon";

    }

    public List<Car> createCarsDodaj(int size, String s) {
        List<Car> list = new ArrayList<Car>();
        for (int i = 0; i < size; i++) {
            list.add(new Car(s));
        }

        //ovde treba da dodam u gramatiku novi red
        GramatikaDAO inserir = new GramatikaDAOImpl();
        Gramatika usuario = new Gramatika();
        usuario.setIspravnaRec(s);
        inserir.persist(usuario);

        return list;
    }

    public List<Car> createCars(int size) {
        List<Car> list = new ArrayList<Car>();
        for (int i = 0; i < size; i++) {
            list.add(new Car());
        }

        return list;
    }

    public List<String> getColors() {
        return Arrays.asList(colors);
    }

}
