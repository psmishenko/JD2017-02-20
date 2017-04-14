package by.it.vedom.jd02_03;

public class Runner {


    public static void main(String[] args) {
        Bayer bayer;
        Thread cashier = null;
        while(Dispatcher.countBayers.get() < Dispatcher.plan) {
            int count = Helper.getRandom(2);
            while(count > 0) {
                bayer = new Bayer(Dispatcher.countBayers.addAndGet(1));
                bayer.start();
                count--;
                if (Dispatcher.countBayers.get() == Dispatcher.plan) break;
            }
            Helper.sleep(1000);
            if (QueueBayers.getCount() > 2 && cashier == null) {
                cashier = new Thread(new Cashier(1));
                cashier.start();
            }
        }
        System.out.println("--------------------------------");
        System.out.println("Все вошли");
        System.out.println("--------------------------------");

    }
}
