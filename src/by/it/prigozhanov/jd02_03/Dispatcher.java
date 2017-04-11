package by.it.prigozhanov.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by v-omf on 3/31/2017.
 *
 * @author v-omf
 */
public class Dispatcher extends Thread{
    // static final Integer monitorCounter = 0;
    static AtomicInteger countBuyers = new AtomicInteger(0);
    final static int plan = 200;
    static AtomicInteger buckets = new AtomicInteger(100);
    static AtomicInteger currentBuyersCounterInMarket = new AtomicInteger(0);
    static AtomicInteger currentBuyersCounterInStore = new AtomicInteger(0);
    static AtomicInteger countComplete = new AtomicInteger(0);
    static double earnings;
    protected static Semaphore semaphore = new Semaphore(10);

    static List<Cashier> cashiers = new ArrayList<>();

    @Override
    public void run() {
        while (countComplete.get() < plan) {
            if (BuyersQueue.getSize() > cashiers.size() * 5 && cashiers.size() < 5) {
                Cashier cashier = new Cashier(cashiers.size()+1);
                cashiers.add(cashier);
                cashier.start();
            }
            Helper.sleep(1000);
        }

    }
}
