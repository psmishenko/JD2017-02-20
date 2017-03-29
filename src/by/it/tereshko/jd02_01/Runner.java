package by.it.tereshko.jd02_01;

public class Runner {

    public static int countBuyers = 0;
    public static int plan = 10;


    public static void main(String[] args) {
        Buyer buyer;
        while (countBuyers < plan) {
//            int count = (int) (Math.random() * 3);
            int count = Helper.getRandom(100, 200);

            while (count > 0) {
                buyer = new Buyer(++countBuyers);
                buyer.start();
                count--;
                if (countBuyers == plan) break;
            }

            Helper.sleep(1000);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("All entered");

//        Buyer buyer = new Buyer(1);
//        new Buyer(2).start();
//        new Buyer(3).start();
//        new Buyer(4).start();
//        buyer.start();
//        try {
//            buyer.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Completed");
    }
}
