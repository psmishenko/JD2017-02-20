package by.it.smirnov.jd02_01;

import java.util.*;

/**
 * Класс товаров
 */
public class Goods {
    private static Set<Good> listGoods=new HashSet<Good>() {
        {
            this.add(new Good("Молоко", 0.9));
            this.add(new Good("Хлеб", 1.2));
            this.add(new Good("Чай", 0.47));
            this.add(new Good("Кофе", 5.29));
            this.add(new Good("Напиток", 1.18));
        }
    };


    /**
     * Получение случайного товара
     * @return товар
     */
    protected static Good getRandom(){
        List<Good> goods=new ArrayList(listGoods);
        int position=Helper.getRandom(goods.size()-1);
        Good good=goods.get(position);
        return good;
    };

    /**
     * Получение цены товара
     * @param good товар
     * @return цена
     */
    protected static double getPrice(Good good){
        return good.getPrice();
    }
}
