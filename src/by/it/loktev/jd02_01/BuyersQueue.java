package by.it.loktev.jd02_01;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuyersQueue {

    static private int queueNum; // для поддержания очереди в порядке

    //static private int pensCount=0;

    //private final static Queue<Buyer> queue=new ArrayDeque<>();

    /*
    public class buyersComparator implements Comparable{

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
    */
    static Comparator<Buyer> buyersComparator=new Comparator<Buyer>() {
        @Override
        public int compare(Buyer b1, Buyer b2) {
            return (b2.isPensioner?100000:0+b2.queueNum)-(b1.isPensioner?100000:0+b1.queueNum);
        }
    };

    private final static PriorityQueue<Buyer> queue=new PriorityQueue<Buyer>(buyersComparator);

    static void add(Buyer buyer){
        synchronized (queue) {
            queue.add(buyer);
            buyer.queueNum=++queueNum;
            //if ( buyer.isPensioner )
            //    pensCount++;
        }
    }

    static Buyer extract(){
        synchronized (queue) {
            /*
            Buyer buyer=null;
            if ( pensCount>0 ){

                pensCount--;
            }
            else
              buyer=queue.poll();
            return buyer;
            */
            return queue.poll();
        }
    }

    static int getCount(){
        synchronized (queue){
            return queue.size();
        }
    }
}
