package by.it.ikavalenka.jd02_03;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by USER on 11.04.2017.
 */
public class Profit {
    private static Map<Integer,Integer> sumCashier = new ConcurrentHashMap<>();
    private static int allProfit;
    private final static Lock lockProfit = new ReentrantLock();

    public static int getAllProfit(){
        return allProfit;
    }
    public static Map<Integer,Integer> getSumCashier(){
        return sumCashier;
    }
    public static void addCashierProfit(int cashierNumber,int profit){
        int newProfit = sumCashier.containsKey(cashierNumber)?profit + sumCashier.get(cashierNumber):profit;
        sumCashier.put(cashierNumber,newProfit);
    }
    public static void addSumProfit(int allProfit){
        try{
            lockProfit.lock();
            allProfit=+allProfit;
        } finally {
            lockProfit.unlock();
        }
    }
}
