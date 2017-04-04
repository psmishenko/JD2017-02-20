package by.it.korzun.jd02_02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Goods {
    private static Set<Good> listGoods = new HashSet<Good>(){
        {
            this.add(new Good("Молоко", 1.0));
            this.add(new Good("Хлеб", 0.5));
            this.add(new Good("Кофе", 6.3));
            this.add(new Good("Чай", 3.2));
            this.add(new Good("Кока-кола", 2.1));
        }
    };

    static Good getRandomGood(){
        List<Good> goods = new ArrayList<>(listGoods);
        int position = Helper.getRandom(goods.size() - 1);
        return goods.get(position);
    }

}
