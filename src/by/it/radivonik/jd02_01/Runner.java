package by.it.radivonik.jd02_01;

import java.util.*;

/**
 * Created by Radivonik on 29.03.2017.
 */
public class Runner {
    private static int countBuyer = 0;
    private static int planTimeSec = 60;
    private static int pensioneerRate = 4;
    private static List<Buyer> buyerList = new ArrayList<>();

    public static void main(String[] args) {
        Buyer buyer;
        int numPensioneer = 0;
        int sec = 0;

        while (sec < planTimeSec) {
            int count = Helper.getRandom(2);
            while (count > 0) {
                if (countBuyer % pensioneerRate == 0)
                    numPensioneer = Helper.getRandom(0,3);
                countBuyer++;

                buyer = new Buyer(countBuyer,countBuyer % pensioneerRate == numPensioneer);
                buyerList.add(buyer);
                buyer.start();

                count--;
//                if (countBuyer == plan)
//                    break;
            }

            Helper.sleep(1000);
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

