package by.it.psmishenko.jd02_1;

/**
 * Created by user on 29.03.2017.
 */
public class Runner {
    public static int countBuyers = 0;
    public static   int plan = 10;
    public static void main(String[] args) {
        Buyer buyer;
        while(countBuyers<plan) {
            int count = Helper.getRandom(2);
            while (count>0) {
                buyer = new Buyer(++countBuyers);
                buyer.start();
                count--;
                if (countBuyers == plan) break;
            }
               Helper.sleep(1000);
        }
        System.out.println("---Больше в магазин не запускаем!!!---");
    }
}
