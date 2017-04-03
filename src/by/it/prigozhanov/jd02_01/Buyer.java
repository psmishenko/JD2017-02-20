package by.it.prigozhanov.jd02_01;

import java.util.*;

/**
 * Created by v-omf on 3/29/2017.
 *
 * @author v-omf
 */
public class Buyer extends Thread implements IBuyer, IUseBucket {
    private int num;
    private boolean pensioneer;

    public Buyer(int num, boolean pensioneer) {
            super("( Покупатель № " + num +" ) ");
        if (pensioneer) System.out.print("Пенсионер!");
        this.num = num;
        this.pensioneer = pensioneer;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        putBucket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        Runner.currentBuyersCounter++;
        System.out.println(this + "зашёл в магазин");
    }

    @Override
    public void chooseGoods() {
        Double check = 0.0;
        List<Good> bucketList = takeBucket();
        System.out.println(this + "выбирает продукты");
        int max = Helper.getRandom(1, 5);
        for (int i = 1; i <= max; i++) {
            if (pensioneer) Helper.sleep((int) (Helper.getRandom(500, 2000) * 1.5));
            else Helper.sleep(Helper.getRandom(500, 2000));
            Good good = Goods.getRandomGood();
            System.out.printf("%sвыбрал товар (%s). Цена: %s$\n", this, good.getName(), good.getPrice());

            putGoodsToBucket(bucketList, good);
        }
        for (Good good : bucketList) {
            check+=good.getPrice();
        }
        System.out.println(this + "оплатил товары: " + bucketList);
        System.out.println(this + "получил чек на " + check + "$");
    }

    @Override
    public void goToOut() {
        Runner.currentBuyersCounter--;
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public List<Good> takeBucket() {
        Runner.buckets--;
        if (pensioneer) Helper.sleep((int) (Helper.getRandom(100, 200) * 1.5));
        else Helper.sleep(Helper.getRandom(100, 200));
        List<Good> bucketGoods = new ArrayList<>();
        System.out.println(this + "взял корзинку");
        return bucketGoods;
    }

    @Override
    public void putGoodsToBucket(List<Good> bucketGoods, Good good) {
        if (pensioneer) Helper.sleep((int) (Helper.getRandom(100, 200) * 1.5));
        else Helper.sleep(Helper.getRandom(100, 200));

        bucketGoods.add(good);
        System.out.printf("%sположил товар %s ценой %s$ в корзинку\n", this, good.getName(), good.getPrice());
    }

    @Override
    public void putBucket() {
        Runner.buckets++;
        if (pensioneer) Helper.sleep((int) (Helper.getRandom(100, 200) * 1.5));
        else Helper.sleep(Helper.getRandom(100, 200));
        System.out.println(this + "положил корзинку");
    }
}
