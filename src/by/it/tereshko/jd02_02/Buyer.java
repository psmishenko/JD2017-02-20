package by.it.tereshko.jd02_02;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private int num;

    public Buyer(int num) {
        super("Buyer # " + num);
        this.num = num;
    }

    @Override
    public String toString() {
        return getName() + " ";
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered the store.");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " chose the shopping floor.");
        for (int i = 0; i < Helper.getRandom(1, 9); i++) {
            int timeout = Helper.getRandom(100, 200);
            Helper.sleep(timeout);
            Good good = Goods.getRandomGood();
            double price = Goods.getPrice(good);
            System.out.println(String.format("%s picked a product %s priced: %s roubles.", this, good.getName(), good.getPrice()));

        }
        System.out.println("Picking is over.");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " entered the queue.");
        QueueBuyers.add(this);
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " customer service is over.");

    }

    @Override
    public void goToOut() {
        System.out.println(this + " left the store.");
        synchronized (Dispatcher.monitorCounters) {
            Dispatcher.countComplete++;
        }
    }

    @Override
    public void takeBasket() {

    }

    @Override
    public void putGoodsIntoBasket() {

    }

    @Override
    public void backBasket() {

    }
}
