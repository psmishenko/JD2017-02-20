package by.it.ikavalenka.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBacket,Runnable {

    private int sin;
    private Backet backet;
    private boolean retired = true;
    private boolean wiatInTheBuyerQueue = true;

    Buyer(int sin,boolean retired) {
        Dispitcher.addCountBuyersIn();
//        super("Customer # " + sin);
        this.sin = sin;
        this.retired = retired;
        this.setName("Buyer " + sin + " ");
        start();
    }
    public boolean RetiredIn(){
        return retired;
    }
    public int getSin(){
        return sin;
    }
    public void setWiatInTheBuyerQueue(boolean wait){
        this.wiatInTheBuyerQueue = wait;
    }

    public Map<String, Integer> getBacket(){
        return backet.getProduct();
    }
    @Override
    public String toString() {
        return getName() + " ";
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        takeBacket();
        putGoodsToBucket();

        try{
            goToQueue();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        backBacket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "entered in market");
    }

    @Override
    public void takeBacket() {
        int timeout = Helper.getRandom(100, 200);
        Helper.sleep(timeout);
        System.out.println(this + " customer #" + sin + "take the basket");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " entered in the shooping mall");
        Map<String,Integer> buyerFullBasket = new HashMap<>();
        int max = Helper.getRandom(1, 9);
        System.out.println(this.getName() + "  want to choose: " + max + " ex.");
        for (int i = 1; i <= max; i++) {
            int timeout = Helper.getRandom(150, 200);
            Helper.sleep(timeout);
            Good good = Goods.getRandomGood();
            System.out.println(
                    String.format("%s   choose good %s  price:%s r.",
                            this,
                            good.getName(),
                            good.getPrice())
            );
            backet = new Backet(buyerFullBasket,this.sin);
        }
        System.out.println(this + "  choosing goods was completed");
        System.out.println(backet);
    }

    @Override
    public void putGoodsToBucket() {
        int timeout = retired? Helper.getRandom(100, 200):Helper.getRandom(300, 400);
        Good good = Goods.getRandomGood();
        Helper.sleep(timeout);

        System.out.println(this + "basket is full"+ good.getName()+good.getPrice());            //как добавить список товара

    }

    @Override
    public void backBacket() {
        int timeout = Helper.getRandom(100, 200);
        Helper.sleep(timeout);
        System.out.println(this + "basket is empty");
    }

    @Override
    public void goToOut() {
        System.out.println(this + "out from market");
    }

    @Override
    public void goToQueue() throws InterruptedException{
        synchronized (this){
            BuyerQueue.add(this);
            System.out.println(this + " customers in the queue");
            while (wiatInTheBuyerQueue){
                this.wait();
            }
        }

    }

}
