package by.it.tereshko.jd02_03;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class Goods {

    private static CopyOnWriteArrayList<Good> listGoods = new CopyOnWriteArrayList<Good>() {
        {
            this.add(new Good("Milk", 0.9));
            this.add(new Good("Bread", 0.5));
            this.add(new Good("Coffee", 6.3));
            this.add(new Good("Tea", 3.2));
            this.add(new Good("Coke", 2.1));
        }
    };

    protected static Good getRandomGood() {
//        CopyOnWriteArrayList<Good> goods = new CopyOnWriteArrayList<>(listGoods);
        int position = Helper.getRandom(listGoods.size() - 1);
        return listGoods.get(position);
    }

    static synchronized void add(Good good) {
        for (Good g: listGoods) {
            if (g.getName().equals(good.getName())){
                g.setPrice(good.getPrice());
                return;
            }
        }
        listGoods.add(good);
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
