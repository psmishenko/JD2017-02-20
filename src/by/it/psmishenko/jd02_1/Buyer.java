package by.it.psmishenko.jd02_1;

/**
 * Created by user on 29.03.2017.
 */
public class Buyer extends Thread implements IBuyer,Runnable {
    int num ;

    @Override
    public String toString() {
        return this.getName();
    }

    public Buyer(int num) {
        super("Покупатель №"+num);
        this.num = num;
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" зашёл в зал ");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" вошёл в тз");
        int max = Helper.getRandom(1,4);
        for (int i = 1; i <=max; i++) {
           int timeout = Helper.getRandom(100,200);
            Helper.sleep(timeout);
            Good good = Goods.getRandomGood();
            System.out.println(String.format("%s выбрал товар %s (Цена: %s  рублей)",this,good.getName(),+good.getPrice()));
        }
        System.out.println(this+" выбрал товары");
    }

    @Override
    public void goToOut() {
        System.out.println(this+" вышел из магазина");
    }

}
