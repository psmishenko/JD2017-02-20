package by.it.radivonik.jd02_01;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * Created by Radivonik on 29.03.2017.
 */
public class Buyer extends Thread implements IBuyer, IUseBacket {
    private int num;

    Buyer(int num) {
        super("Покупатель № " + num);
        this.num = num;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " зашел в магазин");
    }

    @Override
    public void takeBacket() {
    }

    @Override
    public void putGoodsToBacket() {

    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " вошел в торговый зал");
        int countGood = Helper.getRandom(1,4);
        for (int i = 0; i < countGood; i++) {
            int timeout = Helper.getRandom(400,700);
            Helper.sleep(timeout);
            Good good = Goods.getRandomGood();
            System.out.printf("%s выбрал товар %s с ценой %s\n",this,good.getName(),good.getPrice());
        }
        System.out.println(this + " завершил выбор товаров");
    }

    @Override
    public void backBacket() {

    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина");
    }
}
