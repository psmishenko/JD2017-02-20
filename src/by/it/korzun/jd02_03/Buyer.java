package by.it.korzun.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    double num;
    boolean pensioner;
    private boolean iWait;
    List<Good> listOfGoods = new ArrayList<>();
    private static Semaphore semaphore = new Semaphore(10);

    Buyer(double num, boolean isPensioner) {
        super("Покупатель № " + (int)num);
        this.num = num;
        this.pensioner = isPensioner;
    }

    public void setiWait(boolean iWait) {
        this.iWait = iWait;
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
        synchronized (this){
            System.out.println(this + "встал в очередь");
            QueueBuyers.add(this);
            iWait = true;
            while (iWait) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
             if(Dispatcher.backetsCount.get() != 0) {
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

    }

    @Override
    public void backBasket() {
        Helper.sleep(Helper.getRandom(100,200), this.pensioner);
        Dispatcher.addBasket();
        System.out.println(this + "вернул корзину");

    }

    @Override
    public void chooseGoods() {
        System.out.printf("Ждут вход в зал %d человек(а)\n",semaphore.getQueueLength());
        try {
            semaphore.acquire();
            System.out.println(this + "начал набирать товары");
            int timeout = Helper.getRandom(1000, 1200);
            Helper.sleep(timeout, this.pensioner);
            for (int i = 1; i <= Helper.getRandom(1, 4); i++) {
                putGoodsToBasket(Goods.getRandomGood());
            }
            System.out.println(this + "выбор товаров завершил");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }

    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина");
        Dispatcher.countCompleteBuyers.addAndGet(1);

    }


}
