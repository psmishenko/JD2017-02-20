package by.it.tereshko.jd02_01;

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
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " entered the store");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " chose the shopping floor");
        for (int i = 0; i < Helper.getRandom(1, 4); i++) {
            int timeout = Helper.getRandom(100, 200);
            Helper.sleep(timeout);
            Good good = Goods.getRandomGood();
            double price = Goods.getPrice(good);
            System.out.println(String.format("%s picked a product %s priced: %s roubles.", this, good.getName(), good.getPrice()));

        }
        System.out.println("Picking is over");

//        Helper.sleep(Helper.getRandom(1000, 800));
//        try {
//            sleep((int)(Math.random()*3000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + " left the store");

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
