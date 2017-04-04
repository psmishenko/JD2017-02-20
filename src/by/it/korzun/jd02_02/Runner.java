package by.it.korzun.jd02_02;

public class Runner {

    public static void main(String[] args) {
        Buyer buyer;
        Dispatcher.setBasketsCount(100);
        Dispatcher.setIterationLimit(1);
        System.out.println("Число корзин: " + Dispatcher.getBasketsCount());

        long startTime = System.currentTimeMillis();
        int count;
        int buyersNumber = 1;
        new Dispatcher().start();
        while (Dispatcher.iterNumber != Dispatcher.iterLimit) {
            Dispatcher.createPlan(startTime);

            while (Dispatcher.countBuyers < Dispatcher.plan) {
                count = Helper.getRandom(2);
                while (count > 0) {
                    Dispatcher.countBuyers++;
                    if ((buyersNumber % 4) == 0) {
                        buyer = new Buyer(buyersNumber++, true);
                    } else {
                        buyer = new Buyer(buyersNumber++, false);
                    }
                    buyer.start();
                    count--;
                    if (Dispatcher.countBuyers == Dispatcher.plan) {
                        break;
                    }
                }
                Helper.sleep(1000, false);
            }
            Dispatcher.countBuyers = 0;
        }
    }
}
