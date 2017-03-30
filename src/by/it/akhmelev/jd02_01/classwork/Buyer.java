package by.it.akhmelev.jd02_01.classwork;

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
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "вошел в торговый зал");
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
        System.out.println(this + "Выбор товаров завершил");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина");
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
