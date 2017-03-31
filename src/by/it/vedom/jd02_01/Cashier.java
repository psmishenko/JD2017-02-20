package by.it.vedom.jd02_01;

public class Cashier implements Runnable {
    private String name;

    public Cashier() {
    }

    public Cashier(int number) {
        name = "Кассир №" +number;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        Bayer b;
        System.out.println(this+ " открыл кассу");
        while((b = QueueBayers.extract())!=null) {
            System.out.println(this+" обслуживается "+b);
            int timeout = Helper.getRandom(2000, 5000);
            Helper.sleep(timeout);
            synchronized (b) {
                b.notify();
            }

            System.out.println(this+" завершил обслуживание для "+b);
        }
        System.out.println(this+ " закрыл кассу");
        Dispatcher.cashiers.remove(Thread.currentThread());
        System.out.println("Осталось кассиров: " +Dispatcher.cashiers.size());
    }
}
