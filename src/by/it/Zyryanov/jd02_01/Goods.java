package by.it.Zyryanov.jd02_01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Goods {

    private static Set<Good> listOfGoods = new HashSet<Good>(){
        {
            this.add(new Good("Молоко", 0.43));
            this.add(new Good("Водка", 4.45));
            this.add(new Good("Пиво", 2.43));
            this.add(new Good("Колбаса", 4.53));
            this.add(new Good("Вода", 0.43));
        }
    };

    static Good getRandomGood(){
        List<Good> goods=new ArrayList<>(listOfGoods);
        int position=Helper.getRandom(goods.size()-1);
        return goods.get(position);
    }

    static double getPrice(Good good) {
        return good.getPrice();
    }

    static String getName(Good good){
        return good.getName();
    }

    static double getPrice(String name){
        for (Good good: listOfGoods){
            if (good.getName().equals(name))
                return good.getPrice();
        }
        return -1;
    }

}
