package by.it.prigozhanov.jd02_02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-omf on 3/31/2017.
 *
 * @author v-omf
 */
public class Dispatcher extends Thread{
    static final Integer monitorCounter = 0;
    static int countBuyers = 0;
    final static int plan = 200;
    static volatile int buckets = 100;
    static int currentBuyersCounterInStore = 0;
    static int countComplete = 0;
    static double earnings;

    static List<Cashier> cashiers = new ArrayList<>();

    @Override
    public void run() {
        while (countComplete < plan) {
            if (BuyersQueue.getSize() > cashiers.size() * 5 && cashiers.size() < 5) {
                Cashier cashier = new Cashier(cashiers.size()+1);
                cashiers.add(cashier);
                cashier.start();
            }
            Helper.sleep(1000);
        }

    }
}
