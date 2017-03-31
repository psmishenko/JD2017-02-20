package by.it.psmishenko.jd02_1;

/**
 * Created by user on 31.03.2017.
 */
public class Cashier implements Runnable {
    private String name;
    public Cashier(int num) {
        name = "Кассир#"+num+"";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        Buyer buyer;
        System.out.println(this+"Кассир открыл кассу");
        while ((buyer=QBuyers.extract())!=null){
            System.out.println(this+" обслуживается -"+buyer);
            int timeout = Helper.getRandom(2000,5000);
            Helper.sleep(timeout);
            synchronized (buyer){
                buyer.notify();
            }
            System.out.println(this+" обслуживание завершил -"+buyer);
        }
        System.out.println(this+"Кассир закрыл кассу");
        Dispatcher.cashiers.remove(Thread.currentThread());
        System.out.println("Осталось кассиров:"+Dispatcher.cashiers.size());
    }
}
