package by.it.ikavalenka.jd02_01;

/**
 * Created by USER on 03.04.2017.
 */
public class Backet implements IUseBacket {
    int basketGoods = 0;
    @Override
    public void takeBacket() {
        int timeout = Helper.getRandom(100, 200);
        Helper.sleep(timeout);
        System.out.println(this + " customer #" + basketGoods + "take the basket");
    }

    @Override
    public void putGoodsToBucket() {
        int timeout = Helper.getRandom(100, 200);
        Helper.sleep(timeout);
        System.out.println("goods in the basket");
    }

    @Override
    public void backBacket() {
        int timeout = Helper.getRandom(100, 200);
        Helper.sleep(timeout);
        System.out.println("Basket is empty");
    }
}
