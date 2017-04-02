package by.it.sorokoee.jd02_01;

public class Byer extends Thread implements IByer,IUseBascet {
    private int num;

    public Byer(int num) {
        super("Покупатель №" + num);
        this.num = num;
    }

    @Override
    public String toString() {
        return getName() + " ";
    }

    @Override
    public void gotoQueue() {
        System.out.println(this + " встал в очередь");
        QueueBuyers.add(this);
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " рассчитался за покупки");

    }

    @Override
    public void run() {
        enterToMarket();
        takeBascet();
        choseGoods();
        putGoods();
        gotoQueue();
        backBascet();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "Зашел в магазин");
    }

    @Override
    public void takeBascet() {
        System.out.println(this + " Взял корзину");
    }

    @Override
    public void choseGoods() {
        int max = Helper.getRandom(1, 4);
        for (int i = 1; i <= max; i++) {
            int timeout = Helper.getRandom(100, 200);
            Helper.sleep(timeout);
            Good good = Goods.getRandomGood();
            System.out.println(
                    String.format("%s выбрал товар %s  цена:%s р.",
                            this,
                            good.getName(),
                            good.getPrice())
            );
        }
    }

    @Override
    public void putGoods() {
        System.out.println(this + " Положил товары в корзину");
    }

    @Override
    public void backBascet() {
        System.out.println(this + "Возвратил корзину");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " Вышел из магазина");
        synchronized (Dispetcher.monitorCounters) {
            Dispetcher.countComplete++;
        }


    }
}
