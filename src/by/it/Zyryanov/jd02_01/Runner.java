package by.it.Zyryanov.jd02_01;

/**
 * Created by georgijzyranov on 01.04.17.
 */
public class Runner {

    private static final int plan = 100;
    private static int countBuyers = 0;
    public static int numberOfBaskets = 10;
    public static int inShopNow = 0;



    public static void main(String[] args) {
        Buyer buyer;
        Timer timer = new Timer();
        timer.start();
        while (countBuyers < plan) {
               int count = Helper.getRandom(2);
            while (count > 0) {
                buyer = new Buyer(++countBuyers);
                if (countBuyers % 4 == 0){
                    buyer.pensioneer = true;
                }
                buyer.start();
                count--;
                if (countBuyers == plan) break;
            }
            Helper.sleep(1000);
        }
        System.out.println("Все вошли");
    }
}
