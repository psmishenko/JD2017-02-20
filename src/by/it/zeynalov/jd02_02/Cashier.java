package by.it.zeynalov.jd02_02;

public class Cashier implements Runnable {

    private String name;
    private Buyer currentBuyer;

    public Buyer getCurrentBuyer() {
        return currentBuyer;
    }

    public Cashier(int number) {
        name = "Кассир №" + number + " ";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(this + " открыл кассу");
        while ((currentBuyer = QueueBuyers.extract()) != null) {
            Dispatcher.showInfo();
            System.out.println(this + " обслуживается " + currentBuyer );
            int timeout = Helper.getRandom(200, 500);
            Helper.sleep(timeout);
            synchronized (currentBuyer ) {
                currentBuyer .setiWait(false);
                currentBuyer .notify();
            }
            System.out.println(this + " завершил обслуживание для " + currentBuyer );
            currentBuyer = null;
            Dispatcher.showInfo();
        }
        System.out.println(this + " закрыл кассу");
        Dispatcher.cashiers.remove(Thread.currentThread());
        System.out.println("--------------Осталось кассиров: " + Dispatcher.cashiers.size());
    }
}