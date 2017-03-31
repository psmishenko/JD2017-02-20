package by.it.loktev.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class BuyersQueue {

    private final static Queue<Buyer> queue=new ArrayDeque<>();

    static void add(Buyer buyer){
        synchronized (queue) {
            queue.add(buyer);
        }
    }

    static Buyer extract(){
        synchronized (queue) {
            return queue.poll();
        }
    }

    static int getCount(){
        synchronized (queue){
            return queue.size();
        }
    }
}
