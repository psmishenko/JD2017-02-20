package by.it.psmishenko.jd02_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 31.03.2017.
 */
public class Dispatcher extends Thread {
    static final Integer monitorCounters = 0;
    public static int countBuyers = 0;
    public static int countComplete = 0;
    public static int plan = 10;
   static List<Thread> cashiers = new ArrayList<>();

    @Override
    public void run() {
        while (countComplete < plan) {
            if (QBuyers.getCount() > cashiers.size() * 5 && cashiers.size() < 5) {
                Thread cashier = new Thread(new Cashier(cashiers.size() + 1));
                cashiers.add(cashier);
                cashier.start();
            }
            Helper.sleep(1000);
        }

    }
}