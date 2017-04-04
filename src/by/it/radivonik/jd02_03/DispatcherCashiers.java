package by.it.radivonik.jd02_03;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Radivonik on 31.03.2017.
 * Класс, управляющий созданием потоков Cashier
 */
public class DispatcherCashiers extends Thread {
    private static final int sizeBuyersToCashier = 5; // Количество покупателей на одну кассу
    private static final int maxCahiers = 5;      // Максимальное число кассиров
    public final static Integer monitorDispCash = 0;
    static AtomicInteger countBuyerComplet = new AtomicInteger(0); // Количество обслуженных покупателей
    static double sumItogo = 0;                                    // Общая выручка
    private List<Cashier> cashiers = new ArrayList<>();
    private static boolean isStop = false;

    @Override
    public void run() {
        ExecutorService execServ = Executors.newFixedThreadPool(maxCahiers);
        while (! isStop) {
            if (cashiers.size() < maxCahiers && isCashierNeedStart(cashiers.size())) {
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
        synchronized (monitorDispCash) {
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
        synchronized (monitorDispCash) {
            return sumItogo;
        }
    }
}
