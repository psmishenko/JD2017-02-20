package by.it.tereshko.jd02_03;

public class Runner {

    public static int countBuyers = 0;
    public static int plan = 10;

    public static void main(String[] args) {
        Buyer buyer;
        new Dispatcher().start();
        while (Dispatcher.countBuyers.get() < Dispatcher.plan) {
            int count = Helper.getRandom(2);
            while (count > 0) {
                buyer = new Buyer(Dispatcher.countBuyers.addAndGet(1));
                buyer.start();
                count--;
                if (Dispatcher.countBuyers.get() == plan) break;
            }
            Helper.sleep(100);
        }
        System.out.println("All entered");
    }
}