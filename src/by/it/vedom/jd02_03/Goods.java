package by.it.vedom.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Goods { //т.к static, то проблем с потокобезобасностью не будет

    private static CopyOnWriteArrayList<Good> listGoods = new CopyOnWriteArrayList<Good>(){
        {   //анонимный класс
            this.add(new Good("Молоко", 0.9));
            this.add(new Good("Хлеб", 0.5));
            this.add(new Good("Кофе", 6.3));
            this.add(new Good("Чай", 3.2));
            this.add(new Good("Кока-кола", 2.1));
        }
    };

    protected static Good getRandomGood() {
        //CopyOnWriteArrayList<Good> goods = new CopyOnWriteArrayList<>(listGoods);
        int position = Helper.getRandom(listGoods.size()-1);
        Good good = listGoods.get(position);
        return  good;
    }

    static void add(Good good) {
        for (Good i: listGoods) {
            if(i.getName() == good.getName()) {
                i.setPrice(good.getPrice());
                return;
            }
        }
        listGoods.add(good);
    }

    protected static double getPrice(String name) {
        List<Good> goods = new ArrayList(listGoods);
        for(Good good:listGoods){
            if(good.getName().equals(name))
                return good.getPrice();
        }
        return -1;
    }



}
