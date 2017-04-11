package by.it.radivonik.jd02_03;

import java.util.*;

/**
 * Created by Radivonik on 31.03.2017.
 * Основная программа
 */
public class Runner {
    public static void main(String[] args) {
        DispatcherBuyers dispBuy = new DispatcherBuyers();
        DispatcherCashiers dispCash = new DispatcherCashiers();

        dispBuy.start();
        dispCash.start();

        try {
            // Присоединение к потокам для ожидания их завершения
            dispCash.join();
            dispBuy.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf(
            "---\n--- Завершено, покупателей всего: %d, обслужено: %d, в очереди %d, выручка %-7.2f\n---\n",
            DispatcherBuyers.getCountBuyers(),DispatcherCashiers.getCountBuyersComplet(),QueueBuyers.getCount(),DispatcherCashiers.getSumItogo());
    }
}
