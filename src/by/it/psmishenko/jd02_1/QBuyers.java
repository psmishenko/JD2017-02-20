package by.it.psmishenko.jd02_1;

import java.util.ArrayDeque;


/**
 * Created by user on 31.03.2017.
 */
public class QBuyers {
    private final static ArrayDeque<Buyer> queue = new ArrayDeque<>();// priority q dlya pens

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

  static   int getCount(){
        synchronized (queue){
            return queue.size();
        }
    }



}
