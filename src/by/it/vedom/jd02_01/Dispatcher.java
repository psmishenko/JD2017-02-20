package by.it.vedom.jd02_01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher extends Thread {
    //static final Integer monitorCounter = 0;
    static AtomicInteger countBayers = new AtomicInteger(0); //потокобезопасные счетчики
    static AtomicInteger countCountComplete = new AtomicInteger(0);
    static final int plan = 10;
    static List<Thread> cashiers = new ArrayList<>();

    @Override
    public void run() {

        ExecutorService executorService = Executors.newFixedThreadPool(5); //пул потоков

        while (countCountComplete.get() < plan) {
            if (QueueBayers.getCount() > cashiers.size() * 5 && cashiers.size() < 5) {
                Thread cashier = new Thread(new Cashier(cashiers.size() + 1));
                cashiers.add(cashier);
                executorService.execute(cashier);
            }
            Helper.sleep(1000);
        }
        executorService.shutdown(); //завершаем принудительно, иначе программа не закончится

    }
}
