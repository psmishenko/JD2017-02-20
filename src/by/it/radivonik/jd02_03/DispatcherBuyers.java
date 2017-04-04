package by.it.radivonik.jd02_03;

import java.util.concurrent.atomic.*;

/**
 * Created by aleksandr.radivonik on 04.04.2017.
 * Класс, управляющий созданием потоков Buyer
 */
public class DispatcherBuyers extends Thread {
    private static final int planCountBuyers = 100; // количество моделируемых покупателей
    private static final int pensionerRate = 4;     // частота появления пенсионеров
    private static AtomicInteger countBuyers = new AtomicInteger(0);

    @Override
    public void run() {
        Buyer buyer;
        int countBuyersInMinute = 0;
        int numPensioner = 0;
        int sec = 0;

        while (countBuyers.get() < planCountBuyers) {
            // определение количества покупателей в секунду
            int delta = 1;
            int secInMinute = sec % 60;
            if ( secInMinute == 0) {      // в первую секунду около 10 покупателей
                countBuyersInMinute = 0;
                delta = 10;
            }
            else if (secInMinute > 30) {   // после 30-й секунды по хитрой формуле
                delta = 0;
                int t = 60 - secInMinute;
                if (countBuyersInMinute <= 40 + (30 - t))
                    delta = 1;
            }

            int count = Helper.getRandom(2*delta);
            while (count > 0) {
                if (countBuyers.get() % pensionerRate == 0)     // определение, кто будет пенсионером
                    numPensioner = Helper.getRandom(0,3);

                countBuyers.addAndGet(1);
                countBuyersInMinute++;

                buyer = new Buyer(countBuyers.get(),countBuyers.get() % pensionerRate == numPensioner);
                new Thread(buyer).start();

//                try {
//                    buyer.join();
//                }
//                catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                if (countBuyers.get() == planCountBuyers)
                    break;
                count--;
            }

            Helper.sleep(1000);
            sec++;
        }
    }

    static int getCountBuyers() {
        return countBuyers.get();
    }
}
