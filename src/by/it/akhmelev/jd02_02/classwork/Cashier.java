package by.it.akhmelev.jd02_02.classwork;

public class Cashier implements Runnable{

    private String name;

    public Cashier(int number) {
        name="Кассир №"+number+" ";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        Buyer b;
        System.out.println(this+" открыл кассу");
        while ((b=QueueBuyers.extract())!=null){
            System.out.println(this+" обслуживается "+b);
            int timeout=Helper.getRandom(200,500);
            Helper.sleep(timeout);
            synchronized (b){
                b.notify();
            }
            System.out.println(this+" завершил обслуживание для "+b);
        }
        System.out.println(this+" закрыл кассу");
        Dispatcher.cashiers.remove(Thread.currentThread());
        System.out.println("--------------Осталось кассиров: "+Dispatcher.cashiers.size());
    }
}
