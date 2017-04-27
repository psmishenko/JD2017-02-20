package by.it.Zyryanov.jd02_02;


public class Runner {

    private static final int plan = 100;
    private static int countBuyers = 0;
    public static int numberOfBaskets = 100;
    public static int inShopNow = 0;



    public static void main(String[] args) {
        Buyer buyer;
        Cashier cashier;
        Timer timer = new Timer();
        timer.start();
        new Dispatcher().start();
        while (Dispatcher.countBuyers < Dispatcher.plan) {
               int count = Helper.getRandom(2);
            while (count > 0) {
                buyer = new Buyer(++Dispatcher.countBuyers);
                if (countBuyers % 4 == 0){
                    buyer.pensioneer = true;
                }
                buyer.start();
                count--;
                if (Dispatcher.countBuyers == Dispatcher.plan) break;
            }
            Helper.sleep(1000);
            //if (QueueBuyers.getCount() > 2)
        }
        System.out.println("Все вошли");
       // System.out.printf("\n Общая выручка магазина \n ------------------ Сумма : [%.2f] рублей ---------------- ", Shop.shopEarnings);
    }
}
