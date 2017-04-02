package by.it.vedom.jd02_01;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBayers {
    private final static Deque<Bayer> queue = new ArrayDeque<>(); //final - гарантия, что данные не изменятся в памяти для синхронизации

    static void add(Bayer bayer) {
        synchronized (queue) {//захватили монитор объекта
            queue.addLast(bayer);
        }//отдали монитор
    }

    static Bayer extract() {
        synchronized (queue) {
            return queue.pollFirst();
        }
    }

    static int getCount() {
        synchronized (queue) {
            return queue.size();
        }
    }

}
