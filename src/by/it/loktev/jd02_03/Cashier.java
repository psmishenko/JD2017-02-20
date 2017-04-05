package by.it.loktev.jd02_03;

import java.util.Map;

public class Cashier implements Runnable {

    private String name;

    public Buyer currBuyer;

    public Cashier(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {

        currBuyer=null;
        System.out.println(this+" открыл кассу");
        while ( true ){
            currBuyer=BuyersQueue.extract();
            if ( currBuyer==null )
                break;
            System.out.println(this+" начал обслуживание "+currBuyer);

            for ( Map.Entry<Good,Double> goodEntry : currBuyer.getBucket() ){
                Helper.sleep(Helper.getRandom(200,500));
                Good good=goodEntry.getKey();
                Double quantity=goodEntry.getValue();
                System.out.println(this+" взял из корзины товар "+good.getName()+" ценой "+good.getPrice()+" "+quantity+" штук");
            }

            Helper.sleep(Helper.getRandom(500,1000));
            double backetPrice=currBuyer.getBacketPrice();
            Shop.totalPrice2 +=backetPrice;
            System.out.println(this+" закончил обслуживание "+currBuyer+", сумма чека "+backetPrice);
            synchronized (currBuyer){
                currBuyer.iWait=false;
                currBuyer.notify();
            }
            currBuyer=null;
        }
        System.out.println(this+" закрыл кассу");
        Dispatcher.removeCashier(this);

    }
}
