package by.it.sorokoee.jd02_01;

public class Cashier implements Runnable {
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
        Byer b;
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
        Dispetcher.cashiers.remove(Thread.currentThread());
        System.out.println("--------------Осталось кассиров: "+Dispetcher.cashiers.size());
    }
}
