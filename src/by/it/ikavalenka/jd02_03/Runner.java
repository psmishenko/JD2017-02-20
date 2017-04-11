package by.it.ikavalenka.jd02_03;

public class Runner {

    private static final int plan = 100;
    private static int countBuyers = 0;

    public static void main(String[] args) throws InterruptedException{
        Buyer buyer;
        while (countBuyers < plan) {
            int count = Helper.getRandom(2);
            while (count > 0) {
                buyer = new Buyer(++countBuyers,true);
                buyer.start();
                count--;
                if (countBuyers == plan) break;
            }
            Helper.sleep(25000);
        }
        System.out.println("All in");
    }
}
