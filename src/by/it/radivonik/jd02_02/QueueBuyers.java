package by.it.radivonik.jd02_02;

import java.util.*;

/**
 * Created by Radivonik on 31.03.2017.
 * Класс, реализующий очередь в кассы
 */
public class QueueBuyers {
    private final static PriorityQueue<Buyer> queue = new PriorityQueue<Buyer>(
            200,
            new Comparator<Buyer>() {
                @Override
                public int compare(Buyer o1, Buyer o2) {
                    return Boolean.compare(o2.isPensioner(),o1.isPensioner());
                }
            });

    static void add(Buyer buyer) {
        synchronized (queue) {
            queue.add(buyer);
        }
    }

    static Buyer extract() {
        synchronized (queue) {
            return queue.poll();
        }
    }

    static int getCount () {
        synchronized (queue) {
            return queue.size();
        }
    }

    public static String queueToString() {
        return queue.toString();
    }
}
