package by.it.korzun.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    double num;
    boolean pensioner;
    List<Good> listOfGoods = new ArrayList<>();

    Buyer(double num, boolean isPensioner) {
        super("Покупатель № " + (int)num);
        this.num = num;
        this.pensioner = isPensioner;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        gotoQueue();
        backBasket();
        goToOut();
    }

    @Override
    public void gotoQueue() {
        System.out.println(this + "встал в очередь");
        QueueBuyers.add(this);
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " вышел из очереди");
    }

    @Override
    public String toString() {
        return getName() + " ";
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "зашёл в магазин");
    }

    @Override
    public void takeBasket() {
         while (true) {
             if(Dispatcher.backetsCount != 0) {
                 Dispatcher.removeBasket();
                 System.out.println(this + "взял корзину");
                 Helper.sleep(Helper.getRandom(100, 200), this.pensioner);
                 break;
             }
             System.out.println(this + "ждёт корзину");
             Helper.sleep(2000, this.pensioner);
         }
    }

    @Override
    public void putGoodsToBasket(Good good) {
        this.listOfGoods.add(good);
        Helper.sleep(Helper.getRandom(100,200), this.pensioner);
        //System.out.println(String.format("%s выбрал товар %s за %s рублей",this, good.getName(), good.getPrice()));

    }

    @Override
    public void backBasket() {
        Helper.sleep(Helper.getRandom(100,200), this.pensioner);
        Dispatcher.addBasket();
        System.out.println(this + "вернул корзину");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "начал набирать товары");
        for (int i = 1; i <= Helper.getRandom(1, 4); i++) {
            int timeout = Helper.getRandom(100, 200);
            Helper.sleep(timeout, this.pensioner);
            putGoodsToBasket(Goods.getRandomGood());
        }
        System.out.println(this + "выбор товаров завершил");

    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина");
        synchronized (Dispatcher.monitor) {
            Dispatcher.countCompleteBuyers++;
        }

    }
}
