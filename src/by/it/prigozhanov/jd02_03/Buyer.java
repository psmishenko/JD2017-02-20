package by.it.prigozhanov.jd02_03;

/**
 * Created by v-omf on 3/29/2017.
 *
 * @author v-omf
 */
public class Buyer extends Thread implements IBuyer, IUseBucket {
    private int num;
    private boolean pensioneer;
    protected double check=0;
    protected Basket basket = null;
    private boolean iWait;

    public Buyer(int num, boolean pensioneer) {
            super("( Покупатель № " + num +" ) ");
        if (pensioneer) System.out.print("Пенсионер!");
        this.num = num;
        this.pensioneer = pensioneer;
    }

    public boolean isPensioneer() {
        return pensioneer;
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
        goToQueue();
        putBucket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        Dispatcher.currentBuyersCounterInStore.addAndGet(1);
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
    public void goToQueue() {
        BuyersQueue.add(this);
        System.out.println(this + "подошёл на кассу");
        synchronized (this) {
            iWait = true;
            while (iWait)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + "покинул кассу");
    }

    @Override
    public void goToOut() {
        Dispatcher.currentBuyersCounterInStore.addAndGet(-1);
        Dispatcher.countComplete.getAndAdd(1);
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public void takeBucket() {
        Dispatcher.buckets.getAndAdd(-1);
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
        Dispatcher.buckets.getAndAdd(1);
        if (pensioneer) Helper.sleep((int) (Helper.getRandom(100, 200) * 1.5));
        else Helper.sleep(Helper.getRandom(100, 200));
        System.out.println(this + "положил корзинку");
        System.out.println(basket);
    }

    public void setiWait(boolean iWait) {
        this.iWait = iWait;
    }
}
