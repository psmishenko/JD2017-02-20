package by.it.prigozhanov.jd02_02;

import java.util.ArrayDeque;

/**
 * Created by v-omf on 3/31/2017.
 *
 * @author v-omf
 */
public class BuyersQueue {
    protected final static ArrayDeque<Buyer> queueBuyers = new ArrayDeque<>();

    static void add(Buyer buyer) {
        synchronized (queueBuyers) {
            if (buyer.isPensioneer()) {
                queueBuyers.addFirst(buyer);
            } else
            queueBuyers.addLast(buyer);
        }
    }

    static Buyer extract() {
        synchronized (queueBuyers) {
          return queueBuyers.pollFirst();
        }
    }

    static int getSize () {
        return queueBuyers.size();
    }

}
