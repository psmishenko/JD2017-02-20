package by.it.prigozhanov.jd02_02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by v-omf on 3/29/2017.
 *
 * @author v-omf
 */
public class Goods {
    private static Set<Good> listGoods = new HashSet<Good>() {
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
        List<Good> goods = new ArrayList<>(listGoods);
        int position = Helper.getRandom(goods.size() - 1);
        Good good = goods.get(position);
        return good;
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
