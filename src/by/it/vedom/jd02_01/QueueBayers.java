package by.it.vedom.jd02_01;

import java.util.concurrent.ConcurrentLinkedDeque;

public class QueueBayers {
    //блокирующая очередь
    private final static ConcurrentLinkedDeque<Bayer> queue = new ConcurrentLinkedDeque<Bayer>();
    //final - гарантия, что данные не изменятся в памяти для синхронизации

    static void add(Bayer bayer) {
        queue.addLast(bayer);
        //synchronized (queue) {//захватили монитор объекта
            //queue.addLast(bayer);
        //}//отдали монитор
    }

    static Bayer extract() {
        return queue.pollFirst();
       // synchronized (queue) {
           // return queue.pollFirst();
        //}
    }

    static int getCount() {
        return queue.size();
//        synchronized (queue) {
//            return queue.size();
//        }
    }

}
