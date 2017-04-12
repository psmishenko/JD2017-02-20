package by.it.zeynalov.jd02_01.ClassWork;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class QueueBuyers {
    private final static Deque<Buyer> queue=new ArrayDeque<>();
    static void add(Buyer buyer){
        synchronized (queue){
            queue.addLast(buyer);
        }
    }

    static Buyer extract(){
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