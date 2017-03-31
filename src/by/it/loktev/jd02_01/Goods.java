package by.it.loktev.jd02_01;

import java.util.*;

public class Goods {

    private static Set<Good> list=new HashSet<Good>(){
        {
            this.add(new Good("молоко",1.0));
            this.add(new Good("хлеб",0.5));
            this.add(new Good("кофе",3.0));
            this.add(new Good("чай",2.0));
            this.add(new Good("кока-кола",1.5));
        }
    };

    protected static Good getRandomGood(){
      List<Good> goods=new ArrayList(list);
      int pos=Helper.getRandom(goods.size()-1);
      Good good=goods.get(pos);
      return good;
    };

    /*
    protected static double getPrice(String goodName){
        return list.get(goodName);
    }
    */
}
