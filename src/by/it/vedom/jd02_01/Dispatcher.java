package by.it.vedom.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher extends Thread {
    static final Integer monitorCounter = 0;
    static int countBayers = 0;
    static int countCountComplete = 0;
    static final int plan = 10;
    static List<Thread> cashiers = new ArrayList<>();

    @Override
    public void run() {
        while (countCountComplete < plan) {
            if (QueueBayers.getCount() > cashiers.size() * 5 && cashiers.size() < 5) {
                Thread cashier = new Thread(new Cashier(cashiers.size() + 1));
                cashiers.add(cashier);
                cashier.start();
            }
            Helper.sleep(1000);
        }

    }
}
