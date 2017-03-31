package by.it.akhmelev.jd02_02.classwork;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private int num;

    Buyer(int num) {
        super("Покупатель № " + num);
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
        gotoQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " вошел в торговый зал");
        int max = Helper.getRandom(1, 4);
        System.out.println(this + "  запланировал выбрать товаров: " + max + " шт.");
        for (int i = 1; i <= max; i++) {
            int timeout = Helper.getRandom(10, 20);
            Helper.sleep(timeout);
            Good good = Goods.getRandomGood();
            System.out.println(
                    String.format("%s   выбрал товар %s  цена:%s р.",
                            this,
                            good.getName(),
                            good.getPrice())
            );
        }
        System.out.println(this + "  выбор товаров завершил");
    }

    @Override
    public void gotoQueue() {
        System.out.println(this+" встал в очередь");
        QueueBuyers.add(this);
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this+" завершил обслуживание");
    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина");
        synchronized (Dispatcher.monitorCounters){
        Dispatcher.countComplete++;
        }
    }

    @Override
    public void takeBacket() {

    }

    @Override
    public void putGoodsToBucket() {

    }

    @Override
    public void backBacket() {

    }
}
