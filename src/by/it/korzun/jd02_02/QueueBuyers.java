package by.it.korzun.jd02_02;

import java.util.ArrayDeque;

public class QueueBuyers {
    private final static ArrayDeque<Buyer> queue = new ArrayDeque<>();
    static void add(Buyer buyer){
        synchronized (queue) {
            queue.addLast(buyer);
        }
    }

    static boolean isPensionerLast(){
        synchronized (queue){
            return queue.getFirst().pensioner;
        }
    }

    static Buyer extract(){
        synchronized (queue){
            return queue.pollFirst();
        }
    }

    static Buyer extractPensioner(){
        synchronized (queue){
            return queue.poll();
        }
    }

    static int getCount(){
        synchronized (queue){
            return queue.size();
        }
    }
}
