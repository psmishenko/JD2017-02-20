package by.it.vedom.jd02_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bayer extends Thread implements IBuyer, IUseBacket {
    private int num;
//    public static ArrayList<String> basket = new ArrayList<>();
    private Map<Good,Double> backet;

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
        takeBacket();
        chooseGoods();
        gotoQueue();
        backBacket();
        goToOut();

    }


    @Override
    public void enterToMarket() {
        System.out.println(this + "зашел в магазин.");
    }

    @Override
    public void chooseGoods() {
        float price = 0;
        System.out.println(this + "вошел в зал");
        HashMap<Good, Double> basket = new HashMap<Good, Double>();
        for (int i = 0; i <= Helper.getRandom(1,4); i++) {
            int timeout = Helper.getRandom(100,200);
            Helper.sleep(timeout);
            Good good = Goods.getRandomGood();
            System.out.println(String.format("%s выбрал товар %s цена: %s р.",
                    this,
                    good.getName() ,
                    good.getPrice() ));
            Helper.sleep(timeout);
            System.out.printf("%s положил товар %s ценой %s р. в корзину"+"\n",
                    this,
                    good.getName(),
                    good.getPrice());
            basket.put(good, good.getPrice());
            Set<Map.Entry<Good, Double>> set = basket.entrySet();
            System.out.println(this+ " имеет в корзине: ");
            for (Map.Entry<Good, Double> me: set) {
                System.out.println(me.getKey().getName().toString()+": "+me.getValue());
                price += me.getValue();
                //price+=me.getKey().getPrice()*me.getValue();
            }
            //Выводит нередсказуемые значения, не могу понять почему.
            System.out.println(this+ " набрал товаров на сумму: "+price);
            //Возможно, из-за того, что не чищу коллекцию, см.ниже (выпадают ошибки).

//            Iterator<Good> it = (Iterator<Good>) basket.keySet();
//            while (it.hasNext()) {
//                it.remove();
//            }

        }
        System.out.println("\n" + this+"Выбор товаров завершил." + "\n");

    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина.");
        synchronized (Dispatcher.monitorCounter){
            Dispatcher.countCountComplete++;
        }
    }

    @Override
    public void gotoQueue() {
        System.out.println(this + "встал в очередь.");
        QueueBayers.add(this);
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this + "завершил обслуживание.");
    }

    @Override
    public void takeBacket() {
        int timeout = Helper.getRandom(100, 200);
        Helper.sleep(timeout);
        System.out.println(this + "взял корзину.");
    }

    @Override
    public void putsGoodsToBacket() {

    }

    @Override
    public void backBacket() {
        int timeout = Helper.getRandom(100, 200);
        Helper.sleep(timeout);
        System.out.println(this + "положил корзину на место.");
    }
}
