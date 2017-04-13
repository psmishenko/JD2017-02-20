package by.it.zeynalov.jd02_02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher extends Thread {
    //static final Integer monitorCounters = 0;
    static final int plan = 10;
    static AtomicInteger countComplete = new AtomicInteger(0);
    static AtomicInteger countBuyers = new AtomicInteger(0);
    static List<Cashier> cashiers = new ArrayList<>();
    static Object infoMonitor = new Object();

    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        while (countComplete.get() < plan) {
            if (QueueBuyers.getCount() > cashiers.size() * 5 && cashiers.size() < 5) {
                Cashier cashier = new Cashier(cashiers.size() + 1);
                Thread tcashier = new Thread(cashier);
                cashiers.add(cashier);
                executorService.execute(cashier);
            }
            Helper.sleep(1000);
        }
        executorService.shutdown();
    }

    public static void showInfo() {
        synchronized (infoMonitor) {
            System.out.println(String.format("\nИнформация: \n" +
                            "%18s %18s %18s %18s %18s %18s %18s\n" +
                            "------------------------------------------------------------------------------------------------------------------------------------\n" +
                            "%18s %18s %18s %18s %18s %18d %18d\n",
                    "Касса 1", "Касса 2", "Касса 3", "Касса 4", "Касса 5", "Размер очереди", "Выручка магазина",
                    getCashierStatus(1),
                    getCashierStatus(2),
                    getCashierStatus(3),
                    getCashierStatus(4),
                    getCashierStatus(5),
                    QueueBuyers.getCount(), 100
            ));
        }
    }

    public static String getCashierStatus(int n) {
        if (cashiers.size() < n) {
            return "закрыта";
        } else {
            if (cashiers.get(n - 1).getCurrentBuyer() != null) {
                return cashiers.get(n - 1).getCurrentBuyer().getName();
            } else
                return "свободна";
        }
    }
}
