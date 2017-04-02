package by.it.radivonik.jd02_01;

/**
 * Created by Radivonik on 29.03.2017.
 * Класс, реализующий поведение покупателя в магазине
 */
public class Buyer extends Thread implements IBuyer, IUseBasket {
    private int num;
    private boolean pensioner;

    Buyer(int num, boolean pensioner) {
        super("Покупатель № " + num + (pensioner ? " (пенсионер)" : ""));
        this.num = num;
        this.pensioner = pensioner;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        backBasket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " зашел в магазин");
    }

    @Override
    public void takeBasket() {
        Helper.sleep(Helper.getRandom(100,200),mul());
        System.out.println(this + " взял корзину");
    }

    @Override
    public void putGoodsToBasket() {
        Helper.sleep(Helper.getRandom(100,200),mul());
        System.out.println(this + " положил товар в корзину");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " вошел в торговый зал");
        int countGood = Helper.getRandom(1,4); // от 1 до 4-х продуктов
        for (int i = 0; i < countGood; i++) {
            Helper.sleep(Helper.getRandom(500,2000),mul());
            Good good = Goods.getRandomGood();
            System.out.printf("%s выбрал товар %s с ценой %s\n",this,good.getName(),good.getPrice());
        }
        System.out.println(this + " завершил выбор товаров");
    }

   @Override
    public void backBasket() {
        Helper.sleep(Helper.getRandom(100,200),mul());
        System.out.println(this + " вернул корзину");
    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина");
    }

    // Множитель длительности операций для определенных категорий покупателей
    // для пенсионеров = 1.5
    private double mul() {
        return pensioner ? 1.5 : 1.0;
    }
}
