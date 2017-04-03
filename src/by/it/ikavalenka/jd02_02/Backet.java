package by.it.ikavalenka.jd02_02;

import java.util.ArrayList;

/**
 * Created by USER on 03.04.2017.
 */
public class Backet  {

        ArrayList<String> staff;

    public Backet() {
        this.staff = new ArrayList<String>();
    }

    public void putProduct(String product) {
        this.staff.add(product);
    }
}
