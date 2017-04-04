package by.it.prigozhanov.jd02_03;

import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by v-omf on 3/31/2017.
 *
 * @author v-omf
 */
public class BuyersQueue {
    protected final static ConcurrentLinkedDeque<Buyer> queueBuyers = new ConcurrentLinkedDeque<Buyer>();

    static void add(Buyer buyer) {
            if (buyer.isPensioneer()) {
                queueBuyers.addFirst(buyer);
            } else
            queueBuyers.addLast(buyer);
    }

    static Buyer extract() {
          return queueBuyers.pollFirst();
    }

    static int getSize () {
        return queueBuyers.size();
    }

}
