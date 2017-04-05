package by.it.zagursky.jd02_03.src.buyer;

import Rnd.helper;

/**
 * Created by dzenyaa on 31.03.2017.
 */
public class Cashier implements Runnable {
   String name;
    public Cashier(int name) {
        this.name="Кассир №"+name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        Buyer b;
            System.out.println(this+"открыл кассу");
            while((b=que_Buyer.extract())!=null)
            {

                System.out.println(this+" обслуживается "+b);
                int timeout= helper.getRandom(2000,5000);
                if (b.chek_lvl)
                {
                    timeout*=1.5;
                }
                Backet backet=b.getBacket();
                double chek=0;
                while(backet.get_count()>0)
                {
                   Good good= backet.exist_g();
                   chek+=good.getPrice();
                    System.out.println(
                            "выбрал товар "+b
                                    +"продукт:"+good.getName()
                                    +" "+good.getPrice());
                }
                helper.sleep(timeout);
                synchronized (b)
                {
                    b.notify();
                }

                System.out.println(this+" Закончил обслуживание  "+b+" сумма чека="+chek);

            }
        System.out.println(this+"закрыл кассу");
            Dispetcher.cashiers.remove(Thread.currentThread());

    }
}
