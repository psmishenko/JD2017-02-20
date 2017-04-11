package by.it.ikavalenka.jd02_03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 31.03.2017.
 */
public class Dispitcher extends Thread {
    static final Integer monitorCount = 0;
     static final int plan = 10;
    static int countComplete = 0;
     static int countBuyers = 0;
    static List<Thread> cashierOne = new ArrayList<>();


    @Override
    public void run() {
        while (countBuyers < plan) {
            if (BuyerQueue.getCount() > cashierOne.size() * 5 && cashierOne.size() < 5){
            Thread cashier = new Thread(new Cashier(cashierOne.size() + 1));
                cashierOne.add(cashier);
            cashier.start();
        }
        Helper.sleep(1000);

//        cashier.remove(this);
    }
        }
}
