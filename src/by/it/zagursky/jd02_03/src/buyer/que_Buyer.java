package by.it.zagursky.jd02_03.src.buyer;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by dzenyaa on 31.03.2017.
 */
public class que_Buyer {
    public static Comparator<Buyer> comparator=new Comparator<Buyer>() {
        @Override
        public int compare(Buyer o1, Buyer o2) {
            return o1.hashCode()-o2.hashCode();
        }
    };
    private  final static PriorityBlockingQueue<Buyer> queue=new PriorityBlockingQueue<Buyer>(50,comparator);

    static void add(Buyer buyer)
    {
    queue.add(buyer);


    }
    static Buyer extract()
    {

        return queue.poll();


    }
    public static int get_count()
    {
    return queue.size();
    }
}
