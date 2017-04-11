package by.it.ikavalenka.jd02_03;

import java.util.Map;

/**
 * Created by USER on 31.03.2017.
 */
public class Cashier implements Runnable,ICashier{
        private String name;
        private Buyer buyer;
        private int sin;
        private int bill =0;


    public Cashier(int number) {
        name ="Cashier #"+number+" ";
    }

    @Override
    public String toString() {
        return name;
    }
//    public int getBill() {
//        return bill;
//    }

//
//    public int getNum() {
//        return sin;
//    }

    @Override
    public void run() {
        Buyer b;
        System.out.println(this+"Select case");
        while ((b=BuyerQueue.extract())!=null){

            System.out.println(this+"Start of service"+b);
            int timeout  = Helper.getRandom(2000, 5000);
            Helper.sleep(timeout);
            synchronized (b){
                b.notify();
            }
            System.out.println(this+"Complete service for customer"+b);
        }
        System.out.println(this+"closed case");
        Dispitcher.cashiers.remove(Thread.currentThread());
        System.out.println("Leaved cashier"+Dispitcher.cashiers.size());

    }

    @Override
    public void takeBuyerFromQueue() {
        this.buyer = BuyerQueue.extract();
        if (this.buyer!=null){
            Dispitcher.addCountBuyersIn();
            Dispitcher.addCountBuyersOut();
            System.out.println(buyer + " went to Cashier.");
        }
        else {
            Helper.getRandom(100);
            takeBuyerFromQueue();
        }
    }



    @Override
    public void accountCashier() {
        int timeout  = Helper.getRandom(2000, 5000);
        Helper.sleep(timeout);
        String str = this.buyer + "status of buying:";
        StringBuilder buyerBill = new StringBuilder(str);
        for (Map.Entry<String, Integer>entry : this.buyer.getBacket().entrySet()){
            String good = entry.getKey();
            Integer price = entry.getValue();
            String  item = good + " " + price + " ";
            buyerBill.append(item);
            this.bill =+price;
        }
        String finalBill = "Total pay value" + this.bill + " ";
        buyerBill.append(finalBill);
        System.out.println(buyerBill);
    }

    @Override
    public void clientMayExit() {
        synchronized (this.buyer){
            this.buyer.setWiatInTheBuyerQueue(false);
            this.buyer.notifyAll();
        }

    }

    @Override
    public void calculateProfit() {
        Profit.addCashierProfit(this.sin,this.bill);
        Profit.addSumProfit(this.bill);
        System.out.println(this);
        this.bill=0;
    }
}
