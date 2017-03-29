package by.it.tereshko.jd02_01;

import java.util.*;

public class Goods {

    private static Set<Good> listGoods = new HashSet<Good>() {
        {
            this.add(new Good("Milk", 0.9));
            this.add(new Good("Bread", 0.5));
            this.add(new Good("Coffee", 6.3));
            this.add(new Good("Tea", 3.2));
            this.add(new Good("Coke", 2.1));
        }
    };

    protected static Good getRandomGood() {
        List<Good> goods = new ArrayList(listGoods);
        int position = Helper.getRandom(goods.size() - 1);
        Good good = goods.get(position);
        return good;
    }

    protected static double getPrice(Good good) {
        return good.getPrice();
    }

    protected static double getPrice(String name) {
        for (Good good : listGoods) {
            if (good.getName().equals(name))
                return good.getPrice();
        }
        return -1;
    }

}
