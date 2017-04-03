package by.it.psmishenko.jd02_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
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
    public volatile static double totalSum = 0.0;
    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        while (countComplete.get() < plan) {
            if (QBuyers.getCount() > cashiers.size() * 5 && cashiers.size() < 5) {
                Cashier cashier = new Cashier(cashiers.size() + 1);
                Thread ct = new Thread(cashier);
                ct.start();
                cashiers.add(cashier);
                executorService.execute(cashier);
            }
            Helper.sleep(1000);
            stat();
        }
        executorService.shutdown();
    }
    void stat(){
        String tableheader = "";
        String tabled = "";
        String delimiter = "-";
        for (int i = 0; i <155 ; i++) {
            delimiter+="-";
        }
        synchronized (cashiers) {
            for (Cashier c:cashiers) {
                tableheader += String.format("%-26s",c);
                tabled += String.format("%-26s",c.buyer);
            }
            for (int i = cashiers.size(); i <5 ; i++) {
                tableheader += String.format("%-26s","закрыто");
                tabled += String.format("%-26s","");
            }
            tableheader+= String.format("%-16s","размер очереди");
            tabled += String.format("%-16d",QBuyers.getCount());
            tableheader+= String.format("%-14s","выручка");
            tabled += String.format("%-14.2f",totalSum);
            System.out.println(delimiter+"\n"+tableheader+"\n"+tabled+"\n"+delimiter);
        }
    }

}