package by.it.sorokoee.jd02_03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class Goods {
    private  static CopyOnWriteArrayList<Good> listGoods=new CopyOnWriteArrayList<Good>(){
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

        int position= Helper.getRandom(listGoods.size()-1);
        Good good=listGoods.get(position);
        return good;
    };
    static synchronized void add(Good good){
        for (Good g:listGoods) {
            if (g.getName().equals(good.getName())){
                g.setPrice(good.getPrice());
                return;
            }

        }
        listGoods.add(good);
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
