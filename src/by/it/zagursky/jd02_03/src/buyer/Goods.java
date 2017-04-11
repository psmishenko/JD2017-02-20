package by.it.zagursky.jd02_03.src.buyer;



import by.it.vedom.jd02_01.Helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dzenyaa on 29.03.2017.
 */
public class Goods {
    private static Set<Good> ListGoods= new HashSet<Good>() {
        {
            this.add(new Good("молоко", 0.9));
            this.add(new Good("хлеб", 1.2));
            this.add(new Good("яблоки", 2.1));
            this.add(new Good("рис", 2.1));
            this.add(new Good("мука", 0.9));

        }
    };
     static  Good getRandomGoods()
     {
         List<Good> goods= new ArrayList(ListGoods);
         int position= Hel.getRandom(goods.size()-1);
         Good good=goods.get(position);
         return good;
     }

    public static double getPrice(Good good) {
         return good.getPrice();
    }
    public static double getPrice(String name) {
        for ( Good good:ListGoods)
        {
            if (good.getName().equals(name)) { return good.getPrice();}
        }
        return  -1;
    }

}
