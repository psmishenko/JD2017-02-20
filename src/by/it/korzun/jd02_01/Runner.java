package by.it.korzun.jd02_01;

public class Runner {

    private static double countBuyers = 0;
    private static int plan = 10;

    public static void main(String[] args) {
        Buyer buyer;
        Buyer.setBacketsCount(4);
        System.out.println("Число корзин: " + Buyer.getBacketsCount());

        long startTime = System.currentTimeMillis();
        long delta;
        int count;
        int buyersNumber = 1;
        while (true) {
            delta = (System.currentTimeMillis() - startTime)/1000;
            if(delta < 30){
                plan = (int)delta + 10;
            }else if(delta < 60){
                plan = 40 + (30 - (int)delta);
            }else{
                startTime = System.currentTimeMillis();
                System.out.println("///Новая минута: ///////////////////////////////////////////\n ");
                continue;
            }
            System.out.printf("///Шла %2d секунда////////////////////////////////////////////\n",delta);
            System.out.printf("План: %2d: \n",plan);
            while (countBuyers < plan) {
                count = Helper.getRandom(2);
                while (count > 0) {
                    countBuyers++;
                    if ((buyersNumber % 4) == 0) {
                        buyer = new Buyer(buyersNumber++, true);
                    } else {
                        buyer = new Buyer(buyersNumber++, false);
                    }
                    buyer.start();
                    count--;
                    if (countBuyers == plan) {
                        break;
                    }
                }
                Helper.sleep(1000, false);
            }
            countBuyers = 0;
        }
    }
}
