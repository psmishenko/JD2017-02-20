package by.it.radivonik.jd02_03;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Radivonik on 31.03.2017.
 * Класс, реализующий очередь в кассы
 */
public class QueueBuyers {
    private static AtomicInteger numQueue = new AtomicInteger(0);
    private final static PriorityBlockingQueue<Buyer> queue = new PriorityBlockingQueue<Buyer>(
            200,
            new Comparator<Buyer>() {
                @Override
                public int compare(Buyer o1, Buyer o2) {
                    int comp = -Boolean.compare(o1.isPensioner(),o2.isPensioner());
                    //int comp = o2.getNumQueue() - o1.getNumQueue();
                    return comp;
                }
            });

    static void add(Buyer buyer) {
        queue.add(buyer);
        buyer.setNumQueue(numQueue.addAndGet(1));
    }

    static Buyer extract() {
        return queue.poll();
    }

    static int getCount () {
        return queue.size();
    }

    static String queueToString() {
        return queue.toString();
    }
}
