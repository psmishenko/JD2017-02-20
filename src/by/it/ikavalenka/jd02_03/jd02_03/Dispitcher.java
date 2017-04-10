package by.it.ikavalenka.jd02_03.jd02_03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 31.03.2017.
 */
public class Dispitcher extends Thread {
    public static  Integer monitorCount = 0;
     public static int plan = 10;
    public static int countComplete = 0;
     public static int countBuyers = 0;
  public   static List<Thread> cashierOne = new ArrayList<>();


    public static void addCountBuyersIn(){
        try {
            cashierOne.listIterator();
            countBuyers++;
        } finally {
            cashierOne.listIterator();
        }
    }
    public static void addCountBuyersOut(){
        try {
            cashierOne.listIterator();
            countBuyers++;
        } finally {
            cashierOne.listIterator();
        }
    }

    public static void addCountCashier(){
        try {
            cashierOne.listIterator();
            countBuyers++;
        } finally {
            cashierOne.listIterator();
        }
    }

    public static void reduceCountCashier(){
        try {
            cashierOne.listIterator();
            countBuyers--;
        } finally {
            cashierOne.listIterator();
        }
    }

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
