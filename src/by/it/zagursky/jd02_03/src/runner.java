package by.it.zagursky.jd02_03.src;

import Rnd.helper;
import buyer.Buyer;
import buyer.Dispetcher;

public class runner {

    public static void main(String[] args) {
        new Dispetcher().start();
      int moment=0;
        while (Dispetcher.countBuyers.get() < Dispetcher.plan.get()) {
            int count=0;
            if (moment<30)
            {
                count=moment+10;
            } else {
                count=40 +(30-moment);
            }

            while (count > 0) {
                Dispetcher.countBuyers.getAndAdd(1);
                boolean chek_lvl=false;
                if (helper.getRandom(0,3)==3)
                {
                    chek_lvl=true;
                }
                Buyer buyer = new Buyer(  Dispetcher.countBuyers.get(),chek_lvl);
                buyer.start();
                count--;
                if (Dispetcher.countBuyers == Dispetcher.plan) {
                    break;
                }
            }
            helper.sleep(1000);



        }
        System.out.println("все вошли");
    }
}
