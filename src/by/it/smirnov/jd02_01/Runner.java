package by.it.smirnov.jd02_01;

/**
 * Класс запуска
 */
public class Runner {
    public static int countSeconds = 360;
    public static int chancePensioneer = 4;

    public static void main(String[] args) {
        int numPension = 0;
        int countBuyers = 0;
        int currSecond = 0;
        int maxBuyer = 0;
        Thread cashier = null;
        new Dispatcher().start();
        boolean pensioneer = false;
        while (countSeconds > 0) {
            currSecond = (currSecond == 60)? 0 : currSecond;
            currSecond++;

            int count = 0;
            int currCountBuyers = Dispatcher.countBuyers;
            if (currSecond == 1) count = Helper.getRandom(2*10);  // около 10 человек в первую секунду минуты
            else if (currSecond <= 30) count = (currSecond + 10) - currCountBuyers; // t+10 человек в 2-30 секунду минуты
            else count = 40 + (30 - currSecond) - currCountBuyers; // 40+(30-t) человек в 31-60 секунду минуты
            System.out.println(String.format("%d секунда. В магазине %d покупателей. Запускаем еще %d покупателей.", currSecond, currCountBuyers, (count>0) ? count : 0));

            while (count > 0) {
                synchronized (Dispatcher.monitorBuyers) {
                    Dispatcher.countBuyers++;
                }
                countBuyers++;
                if ((countBuyers-1)%chancePensioneer == 0)
                    numPension = Helper.getRandom(4);
                pensioneer = (countBuyers%chancePensioneer==numPension);

                Buyer buyer = new Buyer(countBuyers, pensioneer);
                buyer.start();
                count--;
            }
            Helper.sleep(1000);
            countSeconds--;
        }
    }
}
