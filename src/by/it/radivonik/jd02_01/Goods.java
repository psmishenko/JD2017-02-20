package by.it.radivonik.jd02_01;

import java.util.*;

/**
 * Created by Radivonik on 29.03.2017.
 */
public class Goods {
    private static Set<Good> list = new HashSet<Good>() {
        {
            this.add(new Good("Молоко",0.5));
            this.add(new Good("Хлеб",0.4));
            this.add(new Good("Колбаса",10.4));
            this.add(new Good("Чай",2.3));
            this.add(new Good("Кофе",1.5));
            this.add(new Good("Кефир",0.6));
            this.add(new Good("Сметана",1.0));
            this.add(new Good("Сахар",1.6));
        }
    };

    protected static Good getRandomGood() {
        List<Good> names = new ArrayList<>(list);
        int pos = Helper.getRandom(names.size()-1);
        return names.get(pos);
    }
}
