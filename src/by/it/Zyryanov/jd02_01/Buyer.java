package by.it.Zyryanov.jd02_01;


public class Buyer extends Thread implements IBuyer{

    private int num;
    public boolean pensioneer = false;


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
        chooseGoods();
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

        Basket basket = new Basket();
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
            System.out.println("У " + this +" следующие товары в корзинке: " + basket.listOfGoodsInBasket.toString());
        }
        System.out.println(this + " выбор товаров завершил");
    }



    public void putGoodsintoBasket() {
        System.out.println(this + " кладёт товар в корзинку");
    }


    @Override
    public void exitTheShop() {
        System.out.println(this + " вышел из магазина");
        Runner.inShopNow--;
    }
}
