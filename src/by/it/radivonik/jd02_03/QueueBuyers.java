package by.it.radivonik.jd02_03;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Radivonik on 31.03.2017.
 * Класс, реализующий очередь в кассы
 */
public class QueueBuyers {
    private final static BlockingQueue<Buyer> queue = new PriorityBlockingQueue<Buyer>(40);
    private static AtomicInteger numQueue = new AtomicInteger(0);

    static void add(Buyer buyer) {
        queue.add(buyer);
    }

    static Buyer extract() {
        return queue.poll();
    }

    static int getCount() {
        return queue.size();
    }

    static int getNumNext() {
        return numQueue.addAndGet(1);
    }
}
