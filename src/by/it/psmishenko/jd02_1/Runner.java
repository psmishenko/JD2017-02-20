package by.it.psmishenko.jd02_1;

/**
 * Created by user on 29.03.2017.
 */
public class Runner {

    public static void main(String[] args) {
        Buyer buyer;
        new Dispatcher().start();

        while(Dispatcher.countBuyers<Dispatcher.plan) {
            int count = Helper.getRandom(2);
            while (count>0) {
                buyer = new Buyer(++Dispatcher.countBuyers);
                buyer.start();
                count--;
                if (Dispatcher.countBuyers == Dispatcher.plan) break;
            }
               Helper.sleep(1000);
                if(Dispatcher.countBuyers==Dispatcher.plan) break;
            }

        System.out.println("---Больше в магазин не запускаем!!!---");
    }
}
