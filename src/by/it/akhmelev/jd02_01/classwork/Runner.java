package by.it.akhmelev.jd02_01.classwork;

public class Runner {

    public static int countBuyers = 0;
    public static int plan = 10;

    public static void main(String[] args) {
        Buyer buyer;
        while (countBuyers < plan) {
            int count = Helper.getRandom(2);
            while (count > 0) {
                buyer = new Buyer(++countBuyers);
                buyer.start();
                count--;
                if (countBuyers == plan) break;
            }
            Helper.sleep(1000);
        }
        System.out.println("Все вошли");
    }
}
