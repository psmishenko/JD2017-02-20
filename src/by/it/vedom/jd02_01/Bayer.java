package by.it.vedom.jd02_01;

public class Bayer extends Thread implements IBuyer, IUseBacket {
    private int num;


    public Bayer(int num) {
        super("Покупатель №"+num);
        this.num = num;
    }

    @Override
    public String toString() {
        return getName()+" ";
    }

    @Override
    public void run() {

        enterToMarket();
        chooseGoods();
        goToOut();

    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "вошел в зал");
        for (int i = 0; i <= Helper.getRandom(1,4); i++) {
            int timeout = Helper.getRandom(100,200);
            Helper.sleep(timeout);
            Good good = Goods.getRandomGood();
            System.out.println(String.format("%s выбрал товар %s цена: %s р.",
                    this,
                    good.getName() ,
                    good.getPrice() ));
        }
        System.out.println("\n" + this+"Выбор товаров завершил." + "\n");
    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public void takeBacket() {

    }

    @Override
    public void putsGoodsToBacket() {

    }

    @Override
    public void backBacket() {

    }
}
