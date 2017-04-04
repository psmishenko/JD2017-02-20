package by.it.prigozhanov.jd02_03;

/**
 * Created by v-omf on 3/29/2017.
 *
 * @author v-omf
 */
public class Runner {

    public static void main(String[] args) {
        Buyer buyer;
        Timer timer = new Timer(1, true);
        timer.setDaemon(true);
        timer.start();
        new Dispatcher().start();
        while (Dispatcher.countBuyers.get() < Dispatcher.plan) {
            int count = Helper.getRandom(2);
            while (count > 0 && Dispatcher.currentBuyersCounterInStore.get() <timer.second+10 && timer.second<=30 && Dispatcher.buckets.get() >0) {
                buyer = new Buyer(Dispatcher.countBuyers.getAndAdd(1), Helper.getRandomBuyer());
                buyer.start();
                count--;
                if (Dispatcher.countBuyers.get() == Dispatcher.plan) break;
            }
            while (count > 0 && Dispatcher.currentBuyersCounterInStore.get() <=40+(30-timer.second) && timer.second>30 && Dispatcher.buckets.get() >0) {
                buyer = new Buyer(Dispatcher.countBuyers.getAndAdd(1), Helper.getRandomBuyer());
                buyer.start();
                count--;
                if (Dispatcher.countBuyers.get() == Dispatcher.plan) break;
            }
            Helper.sleep(100);
        }
        System.out.println("План в " + Dispatcher.plan + " посетителей выполнен, вход в магазин закрыт!");
    }
}