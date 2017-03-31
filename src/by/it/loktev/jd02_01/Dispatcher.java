package by.it.loktev.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher extends Thread {

    List<Cashier> cashiers=new ArrayList<>();

    @Override
    public void run() {

        while ( true ){

            if (  BuyersQueue.getCount()>cashiers.size()*5 && cashiers.size()<5) {
                Cashier cashier=new Cashier("Кассир");
                Thread cashierThread = new Thread();
                cashierThread.start();
                cashiers.add(cashier);
                System.out.println("=== Кассир пришёл");
            }

            Helper.sleep(500);
        }


    }
}
