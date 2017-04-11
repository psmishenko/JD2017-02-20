package by.it.ikavalenka.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by USER on 31.03.2017.
 */
public class Dispitcher extends Thread {
    public static  Integer monitorCount = 0;
    static final int plan = 10;
    static AtomicInteger countComplete = new AtomicInteger(0);
    static AtomicInteger countBuyers = new AtomicInteger(0);
    static List<Thread> cashiers = new ArrayList<>();


    public static void addCountBuyersIn(){
        try {
            countComplete.get();
            countBuyers.get();
        } finally {
            cashiers.size();
        }
    }
    public static void addCountBuyersOut(){
        try {
            countComplete.get();
            countBuyers.get();
        } finally {
            cashiers.size();
        }
    }

    public static void addCountCashier(){
        try {
            countComplete.get();
            countBuyers.get();
        } finally {
            cashiers.size();
        }
    }

    public static void reduceCountCashier(){
        try {
            countComplete.get();
            countBuyers.get();
        } finally {
            cashiers.size();
        }
    }

    @Override
    public void run() {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        while (countComplete.get() < plan) {
            if (BuyerQueue.getCount() > cashiers.size() * 5 && cashiers.size() < 5){
            Thread cashier = new Thread(new Cashier(cashiers.size() + 1));
                cashiers.add(cashier);
//            cashier.start();
                executorService.execute(cashier);
        }
        Helper.sleep(1000);

//        cashier.remove(this);
            executorService.shutdown();
    }
        }
}
