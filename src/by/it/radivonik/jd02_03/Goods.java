package by.it.radivonik.jd02_03;

import java.util.*;

/**
 * Created by Radivonik on 31.03.2017.
 * Класс, реализующий хранение списка продуктов и случайный выбор из списка
 */
public class Goods {
    private static Set<Good> goods = new HashSet<Good>() {
        {
            this.add(new Good("Молоко",0.5));
            this.add(new Good("Хлеб",0.4));
            this.add(new Good("Колбаса",10.4));
            this.add(new Good("Чай",2.3));
            this.add(new Good("Кофе",1.5));
            this.add(new Good("Кефир",0.6));
            this.add(new Good("Сметана",1.0));
            this.add(new Good("Сахар",1.6));
            this.add(new Good("Батон",0.6));
            this.add(new Good("Сосиски",7.74));
            this.add(new Good("Горбуша",6.4));
            this.add(new Good("Шпроты",2.35));
            this.add(new Good("Соль",0.9));
            this.add(new Good("Чипсы",1.65));
            this.add(new Good("Пиво",4.35));
            this.add(new Good("Сок",1.6));
            this.add(new Good("Вода",0.2));
            this.add(new Good("Свинина",9.48));
            this.add(new Good("Шоколад",1.25));
            this.add(new Good("Арахис",0.9));
        }
    };

    protected static Good getRandomGood() {
        List<Good> goodList = new ArrayList<>(goods);
        int pos = Helper.getRandom(goodList.size()-1);
        return goodList.get(pos);
    }
}
