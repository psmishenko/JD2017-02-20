package by.it.radivonik.jd02_03;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by Radivonik on 31.03.2017.
 * Класс, управляющий созданием потоков Cashier
 */
public class DispatcherCashiers extends Thread {
    private static final int sizeBuyersToCashier = 5; // количество покупателей на одну кассу
    private static final int maxCahiers = 5;          // максимальное число кассиров
    public final static Integer monitorDispCash = 0;  // монитор
    static AtomicInteger countBuyersComplet = new AtomicInteger(0); // количество обслуженных покупателей
    static double sumItogo = 0;                                     // общая выручка
    private static AtomicIntegerArray cashStates = new AtomicIntegerArray(maxCahiers); // массив работающих касс

    @Override
    public void run() {
        for (int i = 0; i < cashStates.length(); i++)
            cashStates.set(i,0);
        ExecutorService execServ = Executors.newFixedThreadPool(maxCahiers);
        while (! DispatcherBuyers.isEndProcess() &&
                ( DispatcherCashiers.getCountBuyersComplet() == 0 ||
                  DispatcherCashiers.getCountBuyersComplet() < DispatcherBuyers.getCountBuyers() ) ){
            if (isCashierCanWork(null)) {
                // Создание потока кассира при необходимости
                int numCashier = getNextCashierFree();
                if (numCashier > 0) {
                    Cashier cashier = new Cashier(numCashier);
                    execServ.execute(cashier);
                }
            }
        }
        execServ.shutdown();
    }

    // Определение номера следующей открывающейся кассы
    private int getNextCashierFree() {
        int res = 0;
        for (int i = 0; i < cashStates.length(); i++) {
            if (cashStates.get(i) == 0) {
                cashStates.set(i,1);
                res = i + 1;
                break;
            }
        }
        return res;
    }

    // Количество работающих касс
    static int getCountCashiersWork() {
        int res = 0;
        for (int i = 0; i < cashStates.length(); i++)
            res += cashStates.get(i);
        return  res;
    }

    // Определение необходимости продолжения работы кассы
    static boolean isCashierCanWork(Cashier cashier) {
        int numAdd = cashier == null ? 0 : 1;
        return QueueBuyers.getCount() >= sizeBuyersToCashier * ( getCountCashiersWork() - numAdd );
    }

    // Освобождение кассы
    static void freeCashier(Cashier cashier) {
        cashStates.set(cashier.getNum()-1,0);
    }

    static int getCountBuyersComplet() {
        return countBuyersComplet.get();
    }

    static void addCountBuyersCoplete(int count) {
        countBuyersComplet.addAndGet(count);
    }

    static double getSumItogo() {
        synchronized (monitorDispCash) {
            return sumItogo;
        }
    }

    static void addSumItogo(double sum) {
        synchronized (monitorDispCash) {
            sumItogo += sum;
        }
    }
}
