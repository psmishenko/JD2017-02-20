package by.it.smirnov.jd02_03;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Класс очереди в кассу
 */
public class QueueBuyers {
    private final static Queue<Buyer> queue = new ConcurrentLinkedDeque<>();
    /**
     * Покупатель становится в очередь в кассу
     * @param buyer покупатель
     */
    static void add(Buyer buyer) {
            queue.add(buyer);
    }
    /**
     * Следующий покупатель в очереди
     * @return покупатель
     */
    static synchronized Buyer extract() {
        if (queue.size() > 0) {
            Buyer[] buyerArray = new Buyer[queue.size()];
            queue.toArray(buyerArray);
            Arrays.sort(buyerArray, comparatorPensioneer);
            queue.remove(buyerArray[0]);
            return buyerArray[0];
        } else return null;
    }
    /**
     * Размер очереди
     */
    static int getCount() {
            return queue.size();
    }

    static Comparator<Buyer> comparatorPensioneer = new Comparator<Buyer>() {
        @Override
        public int compare(Buyer o1, Buyer o2) {
            return (o2.isPensioneer() ? 1 : 0) - (o1.isPensioneer() ? 1 : 0);
        }
    };

}
