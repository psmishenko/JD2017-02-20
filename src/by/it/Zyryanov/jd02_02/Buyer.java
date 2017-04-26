package by.it.Zyryanov.jd02_02;


public class Buyer extends Thread implements IBuyer{

    private int num;
    public boolean pensioneer = false;
    public Basket basket;


    Buyer(int num){
        super("Покупатель №" + num);
        this.num = num;
    }

    @Override
    public String toString() {
        return getName() + " ";
    }

    @Override
    public void run() {
        enterTheShop();
        try {
            Dispatcher.semaphore.acquire();
            chooseGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Dispatcher.semaphore.release();
        }
        goToQueue();
        exitTheShop();
    }

    @Override
    public void enterTheShop() {
        Runner.inShopNow++;
        if (pensioneer) {
            System.out.println(this + " пенсионер");
        } else  {
        System.out.println(this + " вошёл в магазин");
        }
        System.out.println("---------------------     В магазине сейчас :" + Runner.inShopNow + " человек. ---------------------------");
    }



    @Override
    public void chooseGoods() {

        basket = new Basket();
        System.out.println(this + " вошёл в торговый зал");
        System.out.println(this + " взял корзинку ");
        basket.takeBasket();
        int max = Helper.getRandom(1, 4);
        System.out.println(this + " определил что хочет взять: " + max + "шт. разных товаров");
        for (int i = 1; i <= max ; i++) {
            int timeOut = Helper.getRandom(100, 200);
            if (pensioneer){
                timeOut = timeOut * 2;
            }
            Helper.sleep(timeOut);
            Good good = Goods.getRandomGood();
            System.out.println(
                    String.format("%s выбрал товар %s с ценой %s р.",
                            this,
                            good.getName(),
                            good.getPrice())
            );
            basket.putGoodsintoBasket(good);
            basket.sumOfGoods(good);
            //System.out.println("У " + this +" следующие товары в корзинке: " + basket.listOfGoodsInBasket.toString());
        }
        System.out.println(this + " выбор товаров завершил");
    }



    public void putGoodsintoBasket() {
        System.out.println(this + " кладёт товар в корзинку");
    }

    @Override
    public void goToQueue() {

        System.out.println(this + " встал в очередь");
        QueueBuyers.add(this);
        System.out.println("У " + this +" следующие товары в корзинке: " + basket.listOfGoodsInBasket);
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + " завершил в обслуживание");
        System.out.println();
        System.out.printf(" %s Получил чек \n ------------------ Сумма покупки : [%.2f] рублей ---------------- ", this, basket.getReceipt());
        System.out.println();
        //shop.calculateShopEarnings(basket.receipt);
    }

    @Override
    public void exitTheShop() {
        System.out.println(this + " вышел из магазина");
        synchronized (Dispatcher.monitorCounters) {
            Dispatcher.countComplete++;
        }
        Runner.inShopNow--;
    }
}
