package by.it.psmishenko.jd02_3;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 29.03.2017.
 */
public class Buyer extends Thread implements IBuyer,Runnable,IUseBacket {
    int num ;
    boolean pensioneer;
    private boolean iWait;

    public void setiWait(boolean iWait) {
        this.iWait = iWait;
    }

    public Map<Integer,Good> backet = new HashMap<Integer, Good>(){
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            int k = 0;
            for (Entry me:backet.entrySet()){
                k++;
                sb.append(me.getValue());
               if(k<backet.entrySet().size()) sb.append(", ");
            }
            return sb.toString();
        }
    };
    private int mul(){
        return pensioneer? 2:1;
    }
    @Override
    public String toString() {
        return this.getName()+(pensioneer?"(Пенсионер)":"");
    }

    public Buyer(int num) {
        super("Покупатель №"+num);
        this.num = num;
        this.pensioneer = Helper.getRandom(0,3)==3;
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
        System.out.println(this+" зашёл в магазин ");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" вошёл в торговый зал");
        int max = Helper.getRandom(1,4);
        for (int i = 1; i <=max; i++) {
           int timeout = Helper.getRandom(500,2000)*mul();
            Helper.sleep(timeout);
            Good good = Goods.getRandomGood();
            System.out.println(String.format("%s выбрал товар %s (Цена: %s  рублей)",this,good.getName(),+good.getPrice()));
            putGoodsToBacket(i,good);
        }
        System.out.println(this+" в корзине: "+backet);
    }

    @Override
    public void gotoQueue() {
        System.out.println(this+" встал в очередь");
        QBuyers.add(this);
        synchronized (this){
            iWait = true;
            while (iWait){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }}
        System.out.println(this+" завершил обслуживание");
    }

    @Override
    public void goToOut() {
        System.out.println(this+" вышел из магазина");
        Dispatcher.countComplete.getAndAdd(1);
    }

    @Override
    public void takeBacket() {
        int timeout = Helper.getRandom(100,200)*mul();
        Helper.sleep(timeout);
        System.out.println(this+" взял корзину");
    }

    @Override
    public void putGoodsToBacket(int i,Good good) {
        int timeout = Helper.getRandom(100,200)*mul();
        Helper.sleep(timeout);
        backet.put(i,good);
        System.out.printf("%s положил в корзину: %s (Цена: %s  рублей)\n",this,good.getName(),good.getPrice());
    }

    @Override
    public void backBacket() {
        int timeout = Helper.getRandom(100,200)*mul();
        Helper.sleep(timeout);
        System.out.println(this+" забрал свои покупки из корзины и вернул корзину");
    }
}
