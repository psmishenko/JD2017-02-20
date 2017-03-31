package by.it.radivonik.jd02_01;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * Created by Radivonik on 29.03.2017.
 */
public class Buyer extends Thread implements IBuyer, IUseBacket {
    private int num;
    private boolean pensioner;

    Buyer(int num, boolean pensioner) {
        super("Покупатель № " + num + (pensioner ? " (пенсионер)" : ""));
        this.num = num;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        backBacket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " зашел в магазин");
    }

    @Override
    public void takeBacket() {
        Helper.sleep(Helper.getRandom(100,200),mul());
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBacket() {
        Helper.sleep(Helper.getRandom(100,200),mul());
        System.out.println(this + " положил товар в корзину");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " вошел в торговый зал");
        int countGood = Helper.getRandom(1,4);
        for (int i = 0; i < countGood; i++) {
            int timeout = Helper.getRandom(500,2000);
            Helper.sleep(timeout,mul());
            Good good = Goods.getRandomGood();
            System.out.printf("%s выбрал товар %s с ценой %s\n",this,good.getName(),good.getPrice());
        }
        System.out.println(this + " завершил выбор товаров");
    }

    @Override
    public void backBacket() {
        Helper.sleep(Helper.getRandom(100,200),mul());
        System.out.println(this + " вернул корзину");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина");
    }

    private double mul() {
        return pensioner ? 1.5 : 1.0;
    }
}
