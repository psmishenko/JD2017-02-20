package by.it.smirnov.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс диспетчера
 */
public class Dispatcher implements Runnable {
    //static final List<Thread> cashiers = new ArrayList<>();
    static final Cashier[] cashiers = new Cashier[5];

    static AtomicInteger countBuyers = new AtomicInteger(0);
    static AtomicInteger countComplete = new AtomicInteger(0);

    static Double receipts = 0d;
    static final Integer monitorReceipts = 0;

    public static ExecutorService serviceCashiers = Executors.newFixedThreadPool(5);

    /**
     * Кол-во работающих касс
     * @return кол-во работающих касс
     */
    static int getCountCashier(){
        int result = 0;
        synchronized (cashiers) {
            for (int i = 0; i < cashiers.length; i++) {
                if (cashiers[i]!=null) result++;
            }
        }
        return result;
    }

    @Override
    public void run() {
        while (true) {
            int countCashier = getCountCashier();
            if (QueueBuyers.getCount() > countCashier * 5 && countCashier < 5) {
                synchronized (cashiers) {
                    for (int i = 0; i < cashiers.length; i++) {
                        if (cashiers[i]==null) {
                            cashiers[i] = new Cashier(i + 1);
                            serviceCashiers.execute(cashiers[i]);
                            break;
                        }
                    }
                }
            }
            System.out.println(getStatusCashiers());
            if (countBuyers.get()==0 && countComplete.get()>0) break;
            Helper.sleep(1000);
        }
        serviceCashiers.shutdown();
        System.out.println("Все вышли. Кол-во касс: " + getCountCashier());
    }

    /**
     * Прекращение работы кассира
     * @param cashier кассир
     */
    public static void stopCashier(Cashier cashier) {
        System.out.println(cashier + " закончил работу");
        synchronized (cashiers) {
            for (int i = 0; i < cashiers.length; i++) {
                if (cashiers[i]==cashier) cashiers[i]=null;
            }
        }
    }

    /**
     * Формирование отчета о состоянии касс, очередей и выручки магазина
     * @return отчет
     */
    String getStatusCashiers() {
        StringBuilder sb = new StringBuilder();
        sb.append("СОСТОЯНИЕ КАСС:\n");
        sb.append("╔═════════════════╦═════════════════╦═════════════════╦═════════════════╦═════════════════╦════════════════╦════════════════════════╦══════════════════╗\n");
        sb.append("║     КАССА 1     ║     КАССА 2     ║     КАССА 3     ║     КАССА 4     ║     КАССА 5     ║ РАЗМЕР ОЧЕРЕДИ ║ КОЛИЧЕСТВО ПОКУПАТЕЛЕЙ ║ ВЫРУЧКА МАГАЗИНА ║\n");
        sb.append("╠═════════════════╬═════════════════╬═════════════════╬═════════════════╬═════════════════╬════════════════╬════════════════════════╬══════════════════╣\n");

        synchronized (cashiers) {
        sb.append(String.format("║ %15s ║ %15s ║ %15s ║ %15s ║ %15s ║ %14d ║ %22d ║ %16.2f ║\n",
                cashiers[0] == null ? "-" : cashiers[0].getBuyerName(),
                cashiers[1] == null ? "-" : cashiers[1].getBuyerName(),
                cashiers[2] == null ? "-" : cashiers[2].getBuyerName(),
                cashiers[3] == null ? "-" : cashiers[3].getBuyerName(),
                cashiers[4] == null ? "-" : cashiers[4].getBuyerName(),
                QueueBuyers.getCount(), Dispatcher.countBuyers.get(), Dispatcher.receipts));
        }

        sb.append("╚═════════════════╩═════════════════╩═════════════════╩═════════════════╩═════════════════╩════════════════╩════════════════════════╩══════════════════╝\n");
        return sb.toString();
    }

}