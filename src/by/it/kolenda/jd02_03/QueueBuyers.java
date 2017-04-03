package by.it.kolenda.jd02_03;

import java.util.concurrent.ConcurrentLinkedDeque;

public class QueueBuyers {
    private final static ConcurrentLinkedDeque <Buyer> queue=new ConcurrentLinkedDeque<>();
    static void add(Buyer buyer){
//        synchronized (queue){
        queue.addLast(buyer);

    }

    static Buyer extract(){
//        synchronized (queue){
          return queue.pollFirst();

    }

    static int getCount(){

            return queue.size();
     }
}
