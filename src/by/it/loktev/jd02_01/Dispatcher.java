package by.it.loktev.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher extends Thread {

    static List<Cashier> cashiers=new ArrayList<>();

    @Override
    public void run() {

        while ( true ){

            if (  BuyersQueue.getCount()>cashiers.size()*5 && cashiers.size()<5) {
                Cashier cashier=new Cashier("Кассир №"+Helper.getRandom(100,999));
                Thread cashierThread = new Thread(cashier);
                cashierThread.start();
                cashiers.add(cashier);
                //System.out.println("=== Кассир пришёл");
            }

            Helper.sleep(500);
        }


    }

    static public void removeCashier(Cashier cashier){
        cashiers.remove(cashier);
        System.out.println("=== осталось кассиров: "+cashiers.size());
    }
}
