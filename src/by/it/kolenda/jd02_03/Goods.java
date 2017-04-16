package by.it.kolenda.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

class Goods {

    private static CopyOnWriteArraySet<Good> listGoods=new CopyOnWriteArraySet<Good>(){
        {
            this.add(new Good("Молоко",0.9));
            this.add(new Good("Хлеб",0.5));
            this.add(new Good("Кофе",6.3));
            this.add(new Good("Чай",3.2));
            this.add(new Good("Кока-кола",2.1));
        }
    };

    static Good getRandomGood(){
        List<Good> goods=new ArrayList<>(listGoods);
        int position= Helper.getRandom(goods.size()-1);
        return goods.get(position);
    }

    static void add(Good good){
        for(Good g:listGoods){
            if (g.getName().equals(good.getName())){
                g.setPrice(good.getPrice());
                return;
            }
        }
        listGoods.add(good);
    }


    static double getPrice(Good good){
        return good.getPrice();
    }

    static double getPrice(String name){
        for (Good good:listGoods){
            if (good.getName().equals(name))
                return good.getPrice();
        }
        return -1;
    }

}
