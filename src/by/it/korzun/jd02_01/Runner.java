package by.it.korzun.jd02_01;

public class Runner {

    private static double countBuyers = 0;
    private static int plan = 10;

    public static void main(String[] args) {
        Buyer buyer;
        Buyer.setBacketsCount(1);
        while (countBuyers < plan) {
            int count = Helper.getRandom(2);
            while (count > 0) {
                countBuyers++;
                if ((countBuyers % 4) == 0) {
                    buyer = new Buyer(countBuyers, true);
                } else {
                    buyer = new Buyer(countBuyers, false);
                }
                buyer.start();
                count--;
                if (countBuyers == plan) {
                    break;
                }
            }
            Helper.sleep(1000, false);
        }
        System.out.println("Никто не доволен");
        //System.out.println("Все довольны");
    }
}
