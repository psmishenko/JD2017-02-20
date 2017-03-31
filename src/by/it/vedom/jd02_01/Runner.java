package by.it.vedom.jd02_01;

public class Runner {


    public static void main(String[] args) {
        Bayer bayer;
        Thread cashier = null;
        while(Dispatcher.countBayers < Dispatcher.plan) {
            int count = Helper.getRandom(2);
            while(count > 0) {
                bayer = new Bayer(++Dispatcher.countBayers);
                bayer.start();
                count--;
                if (Dispatcher.countBayers == Dispatcher.plan) break;
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
