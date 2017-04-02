package by.it.smirnov.jd02_01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

/**
 * Класс очереди в кассу
 */
public class QueueBuyers {
    private final static Queue<Buyer> queue = new ArrayDeque<>();
    /**
     * Покупатель становится в очередь в кассу
     * @param buyer покупатель
     */
    static void add(Buyer buyer) {
        synchronized (queue) {
            queue.add(buyer);
        }
    }
    /**
     * Следующий покупатель в очереди
     * @return покупатель
     */
    static Buyer extract() {
        synchronized (queue) {
            if (queue.size() > 0) {
                Buyer[] buyerArray = new Buyer[queue.size()];
                queue.toArray(buyerArray);
                Arrays.sort(buyerArray, comparatorPensioneer);
                queue.remove(buyerArray[0]);
                return buyerArray[0];
            } else return null;
        }
    }
    /**
     * Размер очереди
     */
    static int getCount() {
        synchronized (queue) {
            return queue.size();
        }
    }

    static Comparator<Buyer> comparatorPensioneer = new Comparator<Buyer>() {
        @Override
        public int compare(Buyer o1, Buyer o2) {
            return (o2.isPensioneer() ? 1 : 0) - (o1.isPensioneer() ? 1 : 0);
        }
    };

}
