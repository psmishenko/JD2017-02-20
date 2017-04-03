package by.it.radivonik.jd02_03;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Radivonik on 31.03.2017.
 */
public class Dispatcher implements Runnable {
    public final static Integer monitorDisp = 0;
    static AtomicInteger countBuyerComplet = new AtomicInteger(0);
    static double sumItogo = 0;
    private static final int sizeBuyersToCashier = 5; // Количество покупателей на одну кассу
    private static final int sizeMaxCahiers = 5;      // Максимальное число кассиров
    private List<Cashier> cashiers = new ArrayList<>();
    private static boolean isStop = false;

    @Override
    public void run() {
        ExecutorService execServ = Executors.newFixedThreadPool(5);
        while (! isStop) {
            if (cashiers.size() < sizeMaxCahiers && isCashierNeedStart(cashiers.size())) {
                // Создание потока кассира при необходимости
                Cashier cashier = new Cashier(cashiers.size() + 1);
                cashiers.add(cashier);
                execServ.execute(cashier);
//                cashier.start();
            }
//            for (int i = 0; i < cashiers.size(); i++) {
//                if (cashiers.get(i).getState() == Thread.State.TERMINATED && isCashierNeedStart(i+1)) {
//                    // Пересоздание потока кассира при необходимости
//                    Cashier cashier = new Cashier(i+1);
//                    cashiers.set(i,cashier);
//                    cashier.start();
//                }
//            }
        }
        execServ.shutdown();
    }

    private static boolean isCashierNeedStart (int size) {
        return QueueBuyers.getCount() > sizeBuyersToCashier * size;
    }

    static boolean isCashierCanBuyer (Cashier cashier) {
        return isCashierNeedStart(cashier.getNum()-1);
    }

    static void setStop(boolean stop) {
        isStop = stop;
    }

    static void addSumItogo(double sum) {
        synchronized (monitorDisp) {
            sumItogo += sum;
        }
    }

    static void addCountBuyerCoplete(int count) {
        countBuyerComplet.addAndGet(count);
    }

    static int getCountBuyerComplet() {
        return countBuyerComplet.get();
    }

    static double getSumItogo() {
        synchronized (monitorDisp) {
            return sumItogo;
        }
    }
}
