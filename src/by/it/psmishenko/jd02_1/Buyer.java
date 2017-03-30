package by.it.psmishenko.jd02_1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 29.03.2017.
 */
public class Buyer extends Thread implements IBuyer,Runnable,IUseBacket {
    int num ;
    boolean pensioneer;
    private Map<Integer,Good> backet = new HashMap<Integer, Good>(){
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("( ");
            int k = 0;
            for (Map.Entry me:backet.entrySet()){
                k++;
                sb.append(me.getValue());
               if(k<backet.entrySet().size()) sb.append(", ");
            }
            sb.append(" )");
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
        this.pensioneer = (num%4)==0;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
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
            putGoodsToBacket(good.getName(),good.getPrice());
            backet.put(i,good);
        }
        System.out.println(this+" купил товары: "+backet);
    }

    @Override
    public void goToOut() {
        System.out.println(this+" вышел из магазина");
    }

    @Override
    public void takeBacket() {
        int timeout = Helper.getRandom(100,200)*mul();
        Helper.sleep(timeout);
        System.out.println(this+" взял корзину");
    }

    @Override
    public void putGoodsToBacket(String name, Double price) {
        int timeout = Helper.getRandom(100,200)*mul();
        Helper.sleep(timeout);
        System.out.printf("%s положил в корзину: %s (Цена: %s  рублей)\n",this,name,price);
    }

    @Override
    public void backBacket() {
        int timeout = Helper.getRandom(100,200)*mul();
        Helper.sleep(timeout);
        System.out.println(this+" забрал свои покупки из корзины и вернул корзину");
    }
}
