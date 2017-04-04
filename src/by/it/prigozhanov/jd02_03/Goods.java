package by.it.prigozhanov.jd02_03;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by v-omf on 3/29/2017.
 *
 * @author v-omf
 */
public class Goods {
    private static CopyOnWriteArrayList<Good> listGoods = new CopyOnWriteArrayList<Good>() {
        {
            this.add(new Good("Хлеб", 1.99));
            this.add(new Good("Молоко", 2.99));
            this.add(new Good("Чай", 3.99));
            this.add(new Good("Кофе", 4.99));
            this.add(new Good("Вода", 0.99));
            this.add(new Good("Конфеты", 5.99));
        }
    };

    protected static Good getRandomGood() {
        //List<Good> goods = new ArrayList<>(listGoods);
        int position = Helper.getRandom(listGoods.size() - 1);
        return listGoods.get(position);
    }

    static synchronized void add(Good good) {
        for (Good g : listGoods) {
            if (g.getName().equals(good.getName())) {
                g.setPrice(good.getPrice());
                return;
            }

        }
        listGoods.add(good);
    }

    protected static double getGoodPrice(Good good) {
        return good.getPrice();
    }

    protected static double getGoodPrice(String name) {
        for (Good good : listGoods) {
            if (good.equals(name)) return good.getPrice();
        }
        return -1;

    }
}
