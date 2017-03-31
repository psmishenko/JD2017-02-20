package by.it.loktev.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private int num;

    private boolean isPensioner;
    private double timeMul; // коэффициент увеличения времени на все операции

    private Map<Good,Double> backet;

    public Buyer(int num) {
        super("Покупатель №"+num);
        this.num = num;
        this.isPensioner=(Helper.getRandom(3)==0);
        this.timeMul=this.isPensioner?1.5:1;
        backet=new HashMap<>();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" зашёл в магазин");
        Helper.sleep(Helper.getRandom(400,700)*timeMul);
    }

    @Override
    public void goToOut() {
        Helper.sleep(Helper.getRandom(400,700)*timeMul);
        System.out.println(this+" вышел из магазина");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" вошёл в зал");
        int goodsCount=Helper.getRandom(1,4);
        for (int g=1; g<=goodsCount; g++){
            Helper.sleep(Helper.getRandom(400,700)*timeMul);
            Good good=Goods.getRandomGood();
            double quantity=Helper.getRandom(1,3);
            putGoodToBacket(good,quantity);
            System.out.println(this+" выбрал товар "+good.getName()+" ценой "+good.getPrice()+" "+quantity+" штук");
        }
        Helper.sleep(Helper.getRandom(400,700)*timeMul);
        double backetPrice= getBacketPrice();
        Shop.totalPrice+=backetPrice;
        System.out.println(this+" пошёл на кассу, оплатил "+backetPrice);
    }

    @Override
    public void takeBacket() {
        Helper.sleep(Helper.getRandom(100,200)*timeMul);
        System.out.println(this+" взял корзину");
    }

    @Override
    public void backBacket() {
        Helper.sleep(Helper.getRandom(100,200)*timeMul);
        System.out.println(this+" вернул корзину");
    }

    @Override
    public void putGoodToBacket(Good good, double quantity) {
        if ( backet.containsKey(good) ){
            quantity+=backet.get(good);
        }
        backet.put(good,quantity);
    }

    @Override
    public double getBacketPrice() {
        double price=0;
        /*Set<Good,Double> backet=*/ //backet.entrySet().iterator();
        for ( Map.Entry<Good,Double> goodEntry : backet.entrySet() ){
           price+=goodEntry.getKey().getPrice()*goodEntry.getValue();
        }
        return price;
    }

    @Override
    public void run() {
        Shop.buyersCount++;
        enterToMarket();
        takeBacket();
        chooseGoods();
        backBacket();
        goToOut();
        Shop.buyersCount--;
    }

    @Override
    public String toString() {
        return "Покупатель №"+num+(isPensioner?" (пенсионер)":"");
    }
}
