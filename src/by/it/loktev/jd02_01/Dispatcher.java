package by.it.loktev.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher extends Thread {

    static List<Cashier> cashiers=new ArrayList<>();
    private static final int maxCashiers=5;

    @Override
    public void run() {

        while ( Shop.opened ){

            synchronized (cashiers) {
                if (BuyersQueue.getCount() > cashiers.size() * 5 && cashiers.size() < maxCashiers) {
                    Cashier cashier = new Cashier("Кассир №" + Helper.getRandom(100, 999));
                    Thread cashierThread = new Thread(cashier);
                    cashierThread.start();
                    cashiers.add(cashier);
                    //System.out.println("=== Кассир пришёл");
                }
            }

            Helper.sleep(1000);

            showStatistics();

        }


    }

    static private void showStatistics(){
        String info0 = "+-";
        String info1 = "| ";
        String info2 = "| ";
        synchronized (cashiers) {
            for (Cashier cashier : cashiers) {
                info0 += "-----------------+-";
                info1 += String.format("%16s", cashier) + " | ";
                info2 += String.format("%16s", cashier.currBuyer) + " | ";
            }
            for ( int i=cashiers.size(); i<maxCashiers; i++){
                info0 += "-----------------+-";
                info1 += "                 | ";
                info2 += "                 | ";
            }
            info0 += "-----------------+-";
            info1 += " размер очереди  | ";
            info2 += "    "+String.format("%7d",BuyersQueue.getCount())+"      | ";
            info0 += "-----------+";
            info1 += "  выручка  |";
            info2 += " "+String.format("%9.1f",Shop.totalPrice2)+" |";
        }
        System.out.println(info0+"\n"+info1+"\n"+info2+"\n"+info0);
    }

    static public void removeCashier(Cashier cashier){
        cashiers.remove(cashier);
        System.out.println("=== осталось кассиров: "+cashiers.size());
    }
}
