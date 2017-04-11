package by.it.sorokoee.jd02_03;

public class Main {

    public static void main(String[] args) {
        Byer buyer;
        new Dispetcher().start();
        while (Dispetcher.countBuyers.get() < Dispetcher.plan) {
            int count = Helper.getRandom(2);
            while (count > 0) {
                buyer = new Byer(Dispetcher.countBuyers.addAndGet(1));
                buyer.start();
                count--;
                if (Dispetcher.countBuyers.get() == Dispetcher.plan) break;
            }
            Helper.sleep(100);
        }
        System.out.println("Все вошли");
    }
    }

