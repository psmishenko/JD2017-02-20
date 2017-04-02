package by.it.sorokoee.jd02_01;

import java.util.*;

public class Goods {
    private  static Set<Good> listGoods=new HashSet<Good>(){
        {



            this.add(new Good("Молоко", 0.9));
            this.add(new Good("Сыр", 7.9));
            this.add(new Good("Масло", 3.9));
            this.add(new Good("Хлеб", 1.9));
            this.add(new Good("Чай", 7.9));
            this.add(new Good("Вода", 0.9));
        }
    };
    protected static Good getRandomGood(){
        List<Good> goods=new ArrayList(listGoods);
        int position=Helper.getRandom(goods.size()-1);
        Good good=goods.get(position);
        return good;
    };

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
