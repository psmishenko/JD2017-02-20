package by.it.radivonik.jd02_02;

import java.util.*;

/**
 * Created by Radivonik on 31.03.2017.
 */
public class Dispatcher extends Thread{
    public final static Integer monitorCount = 0;
    public static int countBuyerComplet = 0;
    List<Cashier> cashiers = new ArrayList<>();

    @Override
    public void run() {
        while (QueueBuyers.getCount() > 0 || cashiers.size() == 0) {
            if (QueueBuyers.getCount() > cashiers.size() * 2 && cashiers.size() < 5) {
                Cashier cashier = new Cashier(cashiers.size() + 1);
                cashiers.add(cashier);
                cashier.start();
            }
        }
    }
}
