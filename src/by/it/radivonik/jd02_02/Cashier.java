package by.it.radivonik.jd02_02;

/**
 * Created by Radivonik on 31.03.2017.
 */
public class Cashier extends Thread{
    private String name;

    public Cashier(int num) {
        name = "Кассир № " + num;
    }

    @Override
    public void run() {
        Buyer b;
        System.out.println(this + " открыл кассу");
        while ((b = QueueBuyers.extract()) != null) {
            System.out.println(this + " обслуживает " + b);
            Helper.sleep(Helper.getRandom(2000,5000));
            synchronized (b) {
                b.notify();
            }
            System.out.println(this + " завершил обслуживание " + b);
        }
        System.out.println(this + " закрыл кассу");
    }

    @Override
    public String toString() {
        return name;
    }
}
