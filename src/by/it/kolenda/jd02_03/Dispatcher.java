package by.it.kolenda.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher extends Thread {
//    static final Integer monitorCounters = 0;
    static final int plan = 100;
    static AtomicInteger countComplete = new AtomicInteger(0);
    static AtomicInteger countBuyers = new AtomicInteger(0);
    static List<Thread> cashiers = new ArrayList<>();

    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(0);
        while (countComplete.get() < plan) {
            if (QueueBuyers.getCount() > cashiers.size() * 5 && cashiers.size() < 5) {
                Thread cashier = new Thread(new Cashier(cashiers.size() + 1));
                cashiers.add(cashier);
                executorService.execute(cashier);
                //cashier.start();
            }
            Helper.sleep(1000);
        }
        executorService.shutdown();
    }
}
