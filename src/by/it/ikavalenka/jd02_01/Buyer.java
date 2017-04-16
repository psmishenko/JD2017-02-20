package by.it.ikavalenka.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private int sin;

    Buyer(int sin) {
        super("Customer # " + sin);
        this.sin = sin;
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
        takeBacket();
        putGoodsToBucket();
        backBacket();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "entered in market");
    }


//    @Override
//    public void takeBacket() {
//        int timeout = Helper.getRandom(100, 200);
//        Helper.sleep(timeout);
//        System.out.println(this + " customer #" + sin + "take the basket");
//
//    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " entered in the shooping mall");
        int max = Helper.getRandom(1, 9);
        System.out.println(this + "  want to choose: " + max + " ex.");
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
        }
        System.out.println(this + "  choosing goods was completed");
    }

    @Override
    public void putGoodsToBucket() {
        int timeout = Helper.getRandom(100, 200);
        Helper.sleep(timeout);
        System.out.println("basket is full" + this );            //как добавить список товара

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
    public void takeBacket() {
        int timeout = Helper.getRandom(100, 200);
        Helper.sleep(timeout);
        System.out.println(this + " customer #" + sin + "take the basket");

    }

}
