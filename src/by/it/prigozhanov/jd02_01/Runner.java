package by.it.prigozhanov.jd02_01;

/**
 * Created by v-omf on 3/29/2017.
 *
 * @author v-omf
 */
public class Runner {
    public static int countBuyers = 0;
    public static int plan = 300;
    public static int buckets = 100;
    public static int currentBuyersCounter=0;

    public static void main(String[] args) {
        Buyer buyer;
        Timer timer = new Timer(2, true);
        timer.setDaemon(true);
        timer.start();
        while (countBuyers < plan) {
            int count = Helper.getRandom(2);
            while (count > 0 && currentBuyersCounter<timer.second+10 && timer.second<=30 && buckets>0) {
                buyer = new Buyer(++countBuyers, Helper.getRandomBuyer());
                buyer.start();
                count--;
                if (countBuyers == plan) break;
            }
            while (count > 0 && currentBuyersCounter<=40+(30-timer.second) && timer.second>30 && buckets>0) {
                buyer = new Buyer(++countBuyers, Helper.getRandomBuyer());
                buyer.start();
                count--;
                if (countBuyers == plan) break;
            }
            Helper.sleep(100);
        }
        System.out.println("План в " + plan + " посетителей выполнен, вход в магазин закрыт!");
    }
}