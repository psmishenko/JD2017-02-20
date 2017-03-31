package by.it.radivonik.jd02_01;

import java.util.*;

/**
 * Created by Radivonik on 29.03.2017.
 * Основная программа
 */
public class Runner {
    private final static int planTimeSec = 120; // моделирование процесса покупок в течениие 120 секунд
    private final static int pensionerRate = 4; // частота встиречаемости пенсионеров
    private static List<Buyer> buyerList = new ArrayList<>(); // список покупателей

    public static void main(String[] args) {
        Buyer buyer;
        int countBuyer = 0;
        int numPensioner = 0;
        int sec = 0;
        int countBuyerInMinute = 0;

        while (sec < planTimeSec) {
            // определение количества покупателей в секунду
            int delta = 1;
            int secInMinute = sec % 60;
            if ( secInMinute == 0) {      // в первую секунду около 10 покупателей
                countBuyerInMinute = 0;
                delta = 10;
            }
            else if (secInMinute > 30) {   // после 30-й секунды по хитрой формуле
                delta = 0;
                int t = 60 - secInMinute;
                if (countBuyerInMinute <= 40 + (30 - t))
                    delta = 1;
            }

            int count = Helper.getRandom(2*delta);
            while (count > 0) {
                if (countBuyer % pensionerRate == 0)     // определение, кто будет пенсионером
                    numPensioner = Helper.getRandom(0,3);

                countBuyer++;
                countBuyerInMinute++;

                buyer = new Buyer(countBuyer,countBuyer % pensionerRate == numPensioner);
                buyerList.add(buyer);
                buyer.start();

                count--;
            }

            Helper.sleep(1000);
            sec++;
            // Вывод дополнительной информации
            if (sec % 10 == 0)
                System.out.printf("---\n---Прошло %d секунд, покупателей всего: %d, в магазине: %d\n---\n",sec,countBuyer,countBuyerActive());
        }

        try {
            for (Buyer b : buyerList)
                b.join();  // присоединение к потокам для ожидания их завершения
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("---\n---Завершено, покупателей всего: %d, в магазине: %d\n---\n",countBuyer,countBuyerActive());
    }

    // Определение количества активных покупателей (находящихся в магазине)
    private static int countBuyerActive() {
        int c = 0;
        for (Buyer b : buyerList) {
            if (b.getState() != Thread.State.TERMINATED)
                c++;
        }
        return c;
    }
}

