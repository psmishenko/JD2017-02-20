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
    private Basket basket = null;

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
        takeBucket();
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
        System.out.println(this + "выбирает продукты");
        int max = Helper.getRandom(1, 5);
        for (int i = 1; i <= max; i++) {
            if (pensioneer) Helper.sleep((int) (Helper.getRandom(500, 2000) * 1.5));
            else Helper.sleep(Helper.getRandom(500, 2000));
            Good good = Goods.getRandomGood();
            System.out.printf("%sвыбрал товар (%s). Цена: %s$\n", this, good.getName(), good.getPrice());
            putGoodsToBucket(good);
        }

    }

    @Override
    public void goToOut() {
        Runner.currentBuyersCounter--;
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public void takeBucket() {
        if (pensioneer) Helper.sleep((int) (Helper.getRandom(100, 200) * 1.5));
        else Helper.sleep(Helper.getRandom(100, 200));
        Basket basket = new Basket(num);
        this.basket = basket;
        System.out.println(this + "взял корзинку");
    }

    @Override
    public void putGoodsToBucket(Good good) {
        if (pensioneer) Helper.sleep((int) (Helper.getRandom(100, 200) * 1.5));
        else Helper.sleep(Helper.getRandom(100, 200));
        if (basket == null) {
            System.out.println(this+ "не взял корзинку, операция не возможна");
        } else
        this.basket.putGoodToBucket(good);
    }

    @Override
    public void putBucket() {
        Runner.buckets++;
        if (pensioneer) Helper.sleep((int) (Helper.getRandom(100, 200) * 1.5));
        else Helper.sleep(Helper.getRandom(100, 200));
        System.out.println(this + "положил корзинку");
        System.out.println(basket);
    }
}
