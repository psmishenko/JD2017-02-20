package by.it.korzun.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher extends Thread {
    static final Integer monitor = 0;
    static double countCompleteBuyers = 0;
    static double countBuyers = 0;
    static int plan = 10;
    static int iterNumber = 0;
    static int iterLimit = 0;
    static int backetsCount;
    static double profit = 0;
    static List<Thread> cashiers = new ArrayList<>();
    static String[] openedCashiers = {"Закрыта","Закрыта","Закрыта","Закрыта","Закрыта"};

    @Override
    public void run() {
        while (countCompleteBuyers < plan) {
            if (QueueBuyers.getCount() > cashiers.size() * 5 && cashiers.size() < 5) {
                Thread cashier = new Thread(new Cashier(cashiers.size() + 1));
                cashiers.add(cashier);
                cashier.start();
            }
        }
        Helper.sleep(1000, false);
    }

    static void createPlan(long startTime){
        long delta;
        boolean stop = false;
        if(((System.currentTimeMillis() - startTime)/1000) > 60){
            startTime = System.currentTimeMillis();
            iterNumber++;
            System.out.printf("\n///Пошла %d минута///////////////////////////////////////////////////////////////////\n",iterNumber);
            System.out.println("Число корзин: " + backetsCount);
            if(iterNumber == iterLimit){
                plan = 0;
                stop = true;
            }
        }
        if(!stop) {
            delta = (System.currentTimeMillis() - startTime) / 1000;
            if (delta < 30) {
                plan = Helper.getRandom((int) delta, (int) delta + 10);
                if(plan == 0){
                    plan++;
                }
            } else if (delta < 60) {
                plan = Helper.getRandom(40 + (30 - (int) delta) - 10, 40 + (30 - (int) delta));
                if(plan == 0){
                    plan++;
                }
            }
            System.out.printf("///Шла %2d секунда////////////////////////////////////////////\n", delta);
            System.out.printf("План: %2d: \n", plan);
        }
    }

    static void getStatus(){
        System.out.printf("\n%-7s | %-7s | %-7s | %-7s | %-7s | %-10s | %-7s\n","Касса №1","Касса №2","Касса №3","Касса №4",
                "Касса №5", "Длина очереди", "Прибыль");

        System.out.printf("%-7s  |  %-7s  |  %-7s |  %-7s  |  %-7s |  %-10d   |  %-4.2f р.\n\n",openedCashiers[0],openedCashiers[1],openedCashiers[2],
                openedCashiers[3],openedCashiers[4],QueueBuyers.getCount(),Dispatcher.profit);
    }

    static void setIterationLimit(int limit){
        iterLimit = limit;
    }

    static int getBasketsCount() {
        return backetsCount;
    }

    static void setBasketsCount(int count) {
        backetsCount = count;
    }

    static void removeBasket(){
        synchronized (monitor) {
            backetsCount--;
        }
    }

    static void addBasket(){
        synchronized (monitor) {
            backetsCount++;
        }
    }
}
