package by.it.akhmelev.jd02_03.classwork;

import java.util.concurrent.CopyOnWriteArrayList;

class Goods {

    private static CopyOnWriteArrayList<Good> listGoods = new CopyOnWriteArrayList<Good>() {
        {
            this.add(new Good("Молоко", 0.9));
            this.add(new Good("Хлеб", 0.5));
            this.add(new Good("Кофе", 6.3));
            this.add(new Good("Чай", 3.2));
            this.add(new Good("Кока-кола", 2.1));
        }
    };

    static Good getRandomGood() {
        //CopyOnWriteArrayList<Good> goods=new CopyOnWriteArrayList<>(listGoods);
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

    static double getPrice(Good good) {
        return good.getPrice();
    }

    static double getPrice(String name) {
        for (Good good : listGoods) {
            if (good.getName().equals(name))
                return good.getPrice();
        }
        return -1;
    }

}
