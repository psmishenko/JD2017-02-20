package by.it.korzun.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket{
    private double num;
    private static int backetsCount;
    private boolean pensioneer;

    Buyer(double num, boolean isPensioneer) {
        super("Покупатель № " + (int)num);
        this.num = num;
        this.pensioneer = isPensioneer;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        backBacket();
        goToOut();
    }

    public static int getBacketsCount() {
        return backetsCount;
    }

    static void setBacketsCount(int count) {
        backetsCount = count;
    }

    @Override
    public String toString() {
        return getName() + " ";
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "зашёл в магазин");
    }

    @Override
    public void takeBacket() {
         while (true) {
             if(backetsCount != 0) {
                 backetsCount--;
                 System.out.println(this + "взял корзину");
                 Helper.sleep(Helper.getRandom(100, 200), this.pensioneer);
                 break;
             }
             System.out.println(this + "ждёт корзину");
             Helper.sleep(2000, this.pensioneer);
         }
    }

    @Override
    public void putGoodsToBacket() {
        Helper.sleep(Helper.getRandom(100,200), this.pensioneer);
        System.out.println(this + "положил продукты в корзину");

    }

    @Override
    public void backBacket() {
        Helper.sleep(Helper.getRandom(100,200), this.pensioneer);
        backetsCount++;
        System.out.println(this + "вернул корзину");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "начал набирать товары");
        for (int i = 1; i <= Helper.getRandom(1, 4); i++) {
            int timeout = Helper.getRandom(100, 200);
            Helper.sleep(timeout, this.pensioneer);
            Good good = Goods.getRandomGood();
            System.out.println(String.format("%sвыбрал товар %s за %s рублей",this, good.getName(), good.getPrice()));
        }
        System.out.println(this + "выбор товаров завершил");

    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина");

    }
}
