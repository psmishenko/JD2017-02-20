package by.it.sorokoee.jd02_03;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class QueueBuyers {
    private final static ConcurrentLinkedDeque<Byer> queue=new ConcurrentLinkedDeque<>();
    static void add(Byer byer){

            queue.addLast(byer);

    }

    static Byer extract(){
            return queue.pollFirst();

    }

    static int getCount(){

            return queue.size();

    }
}
