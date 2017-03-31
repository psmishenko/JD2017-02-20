package by.it.akhmelev.jd02_02.classwork;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher extends Thread {
    static final Integer monitorCounters = 0;
    static final int plan = 100;
    static int countComplete = 0;
    static int countBuyers = 0;
    static List<Thread> cashiers = new ArrayList<>();

    @Override
    public void run() {
        while (countComplete < plan) {
            if (QueueBuyers.getCount() > cashiers.size() * 5 && cashiers.size() < 5) {
                Thread cashier = new Thread(new Cashier(cashiers.size() + 1));
                cashiers.add(cashier);
                cashier.start();
            }
            Helper.sleep(1000);
        }
    }
}
