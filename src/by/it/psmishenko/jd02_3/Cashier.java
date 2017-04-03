package by.it.psmishenko.jd02_3;

/**
 * Created by user on 31.03.2017.
 */
public class Cashier implements Runnable {
    private String name;
    public Cashier(int num) {
        name = "Кассир#"+num+"";
    }
    public Buyer buyer;
    @Override
    public String toString() {
        return name;
    }


    @Override
    public void run() {
        Buyer tbuyer;
        System.out.println(this+" открыл кассу!!!");
        while ((tbuyer=QBuyers.extract())!=null){
            buyer = tbuyer;
            System.out.println(this+" обслуживается -"+buyer);
            int timeout = Helper.getRandom(2000,5000);
            Helper.sleep(timeout);
            double bill = 0.0;
            synchronized (buyer){
                buyer.setiWait(false);
                buyer.notify();
                for (int i = 1; i <buyer.backet.size()+1 ; i++) {
                    Good g = buyer.backet.get(i);
                    System.out.println(this+" обслуживается -"+buyer+": пробиваем товар "+g);
                   bill += g.getPrice();
                }
                Dispatcher.totalSum+=bill;
                System.out.printf("%s - %s: чек: %s ,к оплате:%.2f\n",this,buyer,buyer.backet,bill);
                System.out.println(this+" завершил обслуживание "+buyer);
            }
        }
        System.out.println(this+" закрыл кассу");
        Dispatcher.cashiers.remove(Thread.currentThread());
        System.out.println("Осталось кассиров:"+Dispatcher.cashiers.size());
    }
}
