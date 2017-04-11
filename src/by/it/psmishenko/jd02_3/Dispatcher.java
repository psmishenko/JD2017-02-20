package by.it.psmishenko.jd02_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by user on 31.03.2017.
 */
public class Dispatcher extends Thread {
   // static final Integer monitorCounters = 0;
   public static AtomicInteger countBuyers = new AtomicInteger(0);
    public static AtomicInteger countComplete = new AtomicInteger(0);
    public static int plan = 100;
   static List<Cashier> cashiers = new ArrayList<>();
   static double totalSum = 0.0;
    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        while (countComplete.get() < plan) {
            if (QBuyers.getCount() > cashiers.size() * 5 && cashiers.size() < 5) {
                Cashier cashier = new Cashier(cashiers.size() + 1);
                cashiers.add(cashier);
                //cashier.start();
                executorService.execute(cashier);
            }
            Helper.sleep(1000);
        }
        executorService.shutdown();
    }
    }
