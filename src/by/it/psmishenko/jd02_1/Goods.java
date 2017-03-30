package by.it.psmishenko.jd02_1;

import java.util.*;

/**
 * Created by user on 29.03.2017.
 */
public class Goods {
    private static Set<Good> listGoods = new HashSet<Good>(){
        {
            this.add(new Good("Молоко",1.0));
            this.add(new Good("Хлеб",2.0));
            this.add(new Good("Кофе",3.90));
            this.add(new Good("Чай",10.3));
            this.add(new Good("Кола",12.0));
        }
    };
    protected static Good getRandomGood(){
        List<Good> goods= new ArrayList<>(listGoods);
        int position = Helper.getRandom(goods.size()-1);
        Good good = goods.get(position);
        return good;
    }
    protected static double getPrice(Good good){
        return good.getPrice();
    }

    protected static double getPrice(String name){
        for (Good good:listGoods){
            if (good.getName().equals(name))
                return good.getPrice();
        }
        return -1;
    }
}
