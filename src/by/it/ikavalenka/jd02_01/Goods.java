package by.it.ikavalenka.jd02_01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Goods {

    private static Set<Good> listGoods=new HashSet<Good>(){
        {
            this.add(new Good("Sugar",1.9));
            this.add(new Good("Broot",3.5));
            this.add(new Good("Rice",6.3));
            this.add(new Good("Milk",3.0));
            this.add(new Good("Cheese",2.9));
            this.add(new Good("Meat",4.8));
            this.add(new Good("Bake",5.1));
            this.add(new Good("Pizza",13.1));

        }
    };

    static Good getRandomGood(){
        List<Good> goods=new ArrayList<>(listGoods);
        int position= Helper.getRandom(goods.size()-1);
        return goods.get(position);
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
