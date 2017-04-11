package by.it.smirnov.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Класс запуска
 */
public class Runner {
    public static int countSeconds = 60;
    public static int chancePensioneer = 4;
    public static ExecutorService serviceBuyers = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {
        int numPension = 0;
        int countBuyers = 0;
        int currSecond = 0;
        Thread dispatcherThread = new Thread(new Dispatcher());
        dispatcherThread.start();
        boolean pensioneer = false;
        while (countSeconds > 0) {
            currSecond = (currSecond == 60)? 0 : currSecond;
            currSecond++;

            int count = 0;
            int currCountBuyers = Dispatcher.countBuyers.get();
            if (currSecond == 1) count = Helper.getRandom(2*10);  // около 10 человек в первую секунду минуты
            else if (currSecond <= 30) count = (currSecond + 10) - currCountBuyers; // t+10 человек в 2-30 секунду минуты
            else count = 40 + (30 - currSecond) - currCountBuyers; // 40+(30-t) человек в 31-60 секунду минуты
            System.out.println(String.format("%d секунда. В магазине %d покупателей. Запускаем еще %d покупателей.", currSecond, currCountBuyers, (count>0) ? count : 0));

            while (count > 0) {
                Dispatcher.countBuyers.getAndAdd(1);
                countBuyers++;
                if ((countBuyers-1)%chancePensioneer == 0)
                    numPension = Helper.getRandom(4);
                pensioneer = (countBuyers%chancePensioneer==numPension);

                Buyer buyer = new Buyer(countBuyers, pensioneer);
                serviceBuyers.execute(buyer);
                //buyer.start();
                count--;
            }
            if (currSecond==35) {
                System.out.println("Подвезли батон");
                Goods.add(new Good("Батон", 1.2));
            }
            Helper.sleep(1000);
            countSeconds--;
        }
        serviceBuyers.shutdown();
    }
}
