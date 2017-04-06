package by.it.korzun.jd02_03;

import java.util.concurrent.ConcurrentLinkedDeque;

public class QueueBuyers {
    private final static ConcurrentLinkedDeque<Buyer> queue = new ConcurrentLinkedDeque<>();

    static void add(Buyer buyer){
        if(buyer.pensioner){
            queue.addFirst(buyer);
            System.out.printf("Пропустили пенсионера под номером %d в начало очереди\n",(int) buyer.num);
        }else {
            queue.addLast(buyer);
        }
        System.out.println(Helper.sep + "\n" + "Очередь: " + queue + "\n" + Helper.sep);
    }

    static Buyer extract(){
        return queue.pollFirst();
    }


    static int getCount(){
        return queue.size();
    }

}
