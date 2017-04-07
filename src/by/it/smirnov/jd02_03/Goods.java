package by.it.smirnov.jd02_03;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Класс товаров
 */
public class Goods {
    private static final List<Good> listGoods=new CopyOnWriteArrayList<Good>() {
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
        return listGoods.get(Helper.getRandom(listGoods.size()-1));
    };

    /**
     * Добавление / изменение цены товара
     * @param good товар
     */
    protected static void add(Good good) {
        synchronized (listGoods) {
            for (Good element : listGoods) {
                if (element.getName().equals(good.getName())) {
                    element.setPrice(good.getPrice());
                    return;
                }
            }
            listGoods.add(good);
        }
    }

    /**
     * Получение цены товара
     * @param good товар
     * @return цена
     */
    protected static double getPrice(Good good){
        return good.getPrice();
    }
}
