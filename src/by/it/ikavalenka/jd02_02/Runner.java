package by.it.ikavalenka.jd02_02;

public class Runner {

//    private static final int plan = 10;
//    private static int countBuyers = 0;

    public static void main(String[] args) {
        Buyer buyer;
        new Dispitcher().start();
        Thread cashier=null;
        while (Dispitcher.countBuyers < Dispitcher.plan) {
            int count = Helper.getRandom(2);
            while (count > 0) {
                buyer = new Buyer(++Dispitcher.countBuyers);
                buyer.start();
                count--;
                if (Dispitcher.countBuyers == Dispitcher.plan) break;
            }
            Helper.sleep(1000);
//            if (BuyerQueue.getCount()>2&& cashier==null){
//                cashier=new Thread(new Cashier(1));
//                cashier.start();
//            }
        System.out.println("All in");
        }
//        System.out.println("All in");
    }
}
