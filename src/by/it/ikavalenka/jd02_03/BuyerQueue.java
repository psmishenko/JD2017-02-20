package by.it.ikavalenka.jd02_03;

import java.util.ArrayDeque;

/**
 * Created by USER on 31.03.2017.
 */
public  class BuyerQueue {
    private final static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    static void add(Buyer buyer) {//critical section
        if (buyer.RetiredIn()) {
            queue.addFirst(buyer);
        }
        else {
            queue.add(buyer);
        }

//            queue.add(buyer);               //critical section
        }
   public static synchronized Buyer extract(){
        if (queue.isEmpty()) return null;
        else  return queue.remove();
        }

    static int getCount(){
        synchronized (queue){
            return queue.size();
        }
    }



}
