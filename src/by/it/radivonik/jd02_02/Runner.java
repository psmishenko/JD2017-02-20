package by.it.radivonik.jd02_02;

import java.util.*;

/**
 * Created by Radivonik on 31.03.2017.
 */
public class Runner {
    private static int countBuyer = 0;
    private static int planTimeSec = 10;
    private static int pensionerRate = 4;
    private static List<Buyer> buyerList = new ArrayList<>();

    public static void main(String[] args) {
        Buyer buyer;
        int numPensioneer = 0;
        int sec = 0;

        new Dispatcher().start();

        while (sec < planTimeSec) {
            int count = Helper.getRandom(2);
            while (count > 0) {
                if (countBuyer % pensionerRate == 0)
                    numPensioneer = Helper.getRandom(0,3);
                countBuyer++;

                buyer = new Buyer(countBuyer,countBuyer % pensionerRate == numPensioneer);
                buyerList.add(buyer);
                buyer.start();

                count--;
//                if (countBuyer == plan)
//                    break;
            }

            Helper.sleep(1000);

//            if (QueueBuyers.getCount() > 2 && cashier == null) {
//                cashier = new Cashier(1);
//                new Thread(cashier).start();
//            }

            sec++;
            if (sec % 10 == 0)
                System.out.printf("---\n---Прошло %d секунд, покупателей в магазине - %d\n---\n",sec,countBuyerActive());
        }

        try {
            for (Buyer b : buyerList)
                b.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Завершено");
    }

    private static int countBuyerActive() {
        int c = 0;
        for (Buyer b : buyerList) {
            if (b.getState() != Thread.State.TERMINATED)
                c++;
        }
        return c;
    }
}
