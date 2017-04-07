package by.it.tereshko.jd02_03;

public class Cashier implements Runnable {

    private String name;

    public Cashier(int number) {
        name = "Cashier # " + number;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        Buyer b;
        System.out.println(this + " opened the cash register.");
        while ((b = QueueBuyers.extract()) != null) {
            System.out.println(this + " being serviced " + b);
            int timeout = Helper.getRandom(2000, 5000);
            Helper.sleep(timeout);
            synchronized (b) {
                b.setiWait(false);
                b.notify();
            }
            System.out.println(this + " service finished for " + b);
        }
        System.out.println(this + " closed the cash register.");
        Dispatcher.cashiers.remove(Thread.currentThread());
        System.out.println(" cashiers left " + Dispatcher.cashiers.size());
    }
}
