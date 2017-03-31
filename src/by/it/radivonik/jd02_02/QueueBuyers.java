package by.it.radivonik.jd02_02;

import java.util.*;

/**
 * Created by Radivonik on 31.03.2017.
 */
public class QueueBuyers {
    private final static Deque<Buyer> queue = new ArrayDeque<>();

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
}
