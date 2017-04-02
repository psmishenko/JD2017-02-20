package by.it.sorokoee.jd02_01;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {
    private final static Deque<Byer> queue=new ArrayDeque<>();
    static void add(Byer byer){
        synchronized (queue){
            queue.addLast(byer);
        }
    }

    static Byer extract(){
        synchronized (queue){
            return queue.pollFirst();
        }
    }

    static int getCount(){
        synchronized (queue){
            return queue.size();
        }
    }
}
