package by.it.loktev.jd02_01;

import java.util.Map;

public class Cashier implements Runnable {

    private String name;

    public Cashier(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {

        System.out.println(this+" открыл кассу");
        while ( true ){
            Buyer b=BuyersQueue.extract();
            if ( b==null )
                break;
            System.out.println(this+" начал обслуживание "+b);

            for ( Map.Entry<Good,Double> goodEntry : b.getBucket() ){
                Helper.sleep(Helper.getRandom(200,500));
                Good good=goodEntry.getKey();
                Double quantity=goodEntry.getValue();
                System.out.println(this+" взял из корзины товар "+good.getName()+" ценой "+good.getPrice()+" "+quantity+" штук");
            }

            Helper.sleep(Helper.getRandom(500,1000));
            System.out.println(this+" закончил обслуживание "+b+", сумма чека "+b.getBacketPrice());
            synchronized (b){
                b.notify();
            }
        }
        System.out.println(this+" закрыл кассу");
        Dispatcher.removeCashier(this);

    }
}
