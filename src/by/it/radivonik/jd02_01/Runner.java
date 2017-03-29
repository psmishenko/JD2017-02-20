package by.it.radivonik.jd02_01;

/**
 * Created by Radivonik on 29.03.2017.
 */
public class Runner {
    public static int countBuyer = 0;
    public static int plan = 10;

    public static void main(String[] args) {
        Buyer buyer;
        while (countBuyer < plan) {
            int count = Helper.getRandom(2);
            while (count > 0) {
                buyer = new Buyer(++countBuyer);
                buyer.start();
                count--;
                if (countBuyer == plan)
                    break;
            }
            Helper.sleep(1000);
        }

        System.out.println("Завершено");
    }
}
