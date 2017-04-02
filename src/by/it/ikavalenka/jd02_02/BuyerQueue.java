package by.it.ikavalenka.jd02_02;

import java.util.ArrayDeque;

/**
 * Created by USER on 31.03.2017.
 */
public  class BuyerQueue {
    private final static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    static void add(Buyer buyer) {               //critical section
        synchronized (queue) {

            queue.add(buyer);               //critical section
        }
    }
    static Buyer extract(){
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
