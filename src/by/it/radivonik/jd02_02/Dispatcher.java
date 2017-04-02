package by.it.radivonik.jd02_02;

import java.util.*;

/**
 * Created by Radivonik on 31.03.2017.
 */
public class Dispatcher implements Runnable {
    public final static Integer monitorDisp = 0;
    private static int countBuyerComplet = 0;
    private static double sumItogo = 0;
    private static int sizeBuyersToCashier = 5; // Количество покупателей на одну кассу
    private static int sizeMaxCahiers = 5;      // Максимальное число кассиров
    private List<Cashier> cashiers = new ArrayList<>();
    private static boolean isStop = false;

    @Override
    public void run() {
        while (! isStop) {
            if (cashiers.size() < sizeMaxCahiers && isCashierNeedStart(cashiers.size())) {
                // Создание потока кассира при необходимости
                Cashier cashier = new Cashier(cashiers.size() + 1);
                cashiers.add(cashier);
                cashier.start();
            }
            for (int i = 0; i < cashiers.size(); i++) {
                if (cashiers.get(i).getState() == Thread.State.TERMINATED && isCashierNeedStart(i+1)) {
                    // Пересоздание потока кассира при необходимости
                    Cashier cashier = new Cashier(i+1);
                    cashiers.set(i,cashier);
                    cashier.start();
                }
            }
        }
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
        synchronized (monitorDisp) {
            countBuyerComplet += count;
        }
    }

    static int getCountBuyerComplet() {
        synchronized (monitorDisp) {
            return countBuyerComplet;
        }
    }

    static double getSumItogo() {
        synchronized (monitorDisp) {
            return sumItogo;
        }
    }
}
