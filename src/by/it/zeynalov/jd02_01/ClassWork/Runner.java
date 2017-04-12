package by.it.zeynalov.jd02_01.ClassWork;

public class Runner {

    public static void main(String[] args) {
        Buyer buyer;
        new Dispatcher().start();
        while (Dispatcher.countBuyers < Dispatcher.plan) {
            int count = Helper.getRandom(2);
            while (count > 0) {
                buyer = new Buyer(++Dispatcher.countBuyers);
                buyer.start();
                count--;
                if (Dispatcher.countBuyers == Dispatcher.plan) break;
            }
            Helper.sleep(100);
        }
        System.out.println("Все вошли");
    }
}

