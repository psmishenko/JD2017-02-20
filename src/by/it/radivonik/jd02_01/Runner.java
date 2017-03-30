package by.it.radivonik.jd02_01;

import java.util.*;

/**
 * Created by Radivonik on 29.03.2017.
 */
public class Runner {
    private static int countBuyer = 0;
    private static int plan = 10;
    private static int pensioneerRate = 4;

    public static void main(String[] args) {
        List<Buyer> buyerList = new ArrayList<>();
        Buyer buyer;
        int numPensioneer = 0;

        while (countBuyer < plan) {
            int count = Helper.getRandom(2);
            while (count > 0) {
                if (countBuyer % pensioneerRate == 0)
                    numPensioneer = Helper.getRandom(0,3);
                countBuyer++;

                buyer = new Buyer(countBuyer,countBuyer % pensioneerRate == numPensioneer);
                buyerList.add(buyer);
                buyer.start();

                count--;
                if (countBuyer == plan)
                    break;
            }
            Helper.sleep(1000);
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
}

