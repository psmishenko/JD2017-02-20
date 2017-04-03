package by.it.radivonik.jd02_03;

import java.util.*;

/**
 * Created by Radivonik on 31.03.2017.
 * Класс, реализующий поведение покупателя в магазине
 */
public class Buyer extends Thread implements IBuyer, IUseBasket{
    private int num;
    private boolean pensioner;
    private boolean iWait;
    private int numQueue;
    public List<Good> goods = new ArrayList<>();

    Buyer(int num, boolean pensioner) {
        super("Покупатель № " + num + (pensioner ? " (пенсионер)" : ""));
        this.num = num;
        this.pensioner = pensioner;
    }

    @Override
    public String toString() {
        return getName() + "(" + numQueue + ")";
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        backBasket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
//        System.out.println(this + " зашел в магазин");
    }

    @Override
    public void takeBasket() {
        Helper.sleep(Helper.getRandom(100,200),mul());
//        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBasket() {
        Helper.sleep(Helper.getRandom(100,200),mul());
//        System.out.println(this + " положил товар в корзину");
    }

    @Override
    public void chooseGoods() {
//        System.out.println(this + " вошел в торговый зал");
        int countGood = Helper.getRandom(1,4); // от 1 до 4-х продуктов
        for (int i = 0; i < countGood; i++) {
            int timeout = Helper.getRandom(500,2000);
            Helper.sleep(timeout,mul());
            Good good = Goods.getRandomGood();
            goods.add(good);
//            System.out.printf("%s выбрал товар %s с ценой %s\n",this,good.getName(),good.getPrice());
        }
//        System.out.println(this + " завершил выбор товаров");
    }

    @Override
    public void goToQueue() {
        QueueBuyers.add(this);
        System.out.println("->" + this + " встал в очередь: " + QueueBuyers.queueToString());
        synchronized (this) {
            try {
                iWait = true;
                this.wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(this + " завершил обслуживание");
    }

    @Override
    public void backBasket() {
        Helper.sleep(Helper.getRandom(100,200),mul());
//        System.out.println(this + " вернул корзину");
    }

    @Override
    public void goToOut() {
//        System.out.println("<-" + this + " вышел из магазина");
        Dispatcher.addCountBuyerCoplete(1);
    }

    // Множитель длительности операций для определенных категорий покупателей
    // для пенсионеров = 1.5
    private double mul() {
        return pensioner ? 1.5 : 1.0;
    }

    public boolean isPensioner() {
        return pensioner;
    }

    public void setiWait(boolean iWait) {
        this.iWait = iWait;
    }

    public int getNumQueue() {
        return numQueue;
    }

    public void setNumQueue(int numQueue) {
        this.numQueue = numQueue;
    }
}
