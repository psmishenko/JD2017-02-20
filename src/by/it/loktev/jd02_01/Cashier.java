package by.it.loktev.jd02_01;

public class Cashier implements Runnable {

    private String name;

    public Cashier(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {

        while ( true ){
            Buyer b=BuyersQueue.extract();
            if ( b==null )
                break;
            System.out.println(this+" обслуживает "+b);

            Helper.sleep(Helper.getRandom(2000,5000));
        }
    }
}
