package by.it.akhmelev.jd02_03.classwork;

import java.util.concurrent.ConcurrentLinkedDeque;

public class QueueBuyers {
    private final static ConcurrentLinkedDeque<Buyer> queue=new ConcurrentLinkedDeque<>();

    static void add(Buyer buyer){
        queue.addLast(buyer);
    }

    static Buyer extract(){
        return queue.pollFirst();
    }

    static int getCount(){
        return queue.size();
    }
}
