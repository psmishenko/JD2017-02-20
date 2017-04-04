package by.it.Zyryanov.jd02_02;


import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {

    private final static Deque<Buyer> queue = new ArrayDeque<>();


    static void add (Buyer buyer){
        synchronized (queue){
            queue.addLast(buyer); // добавляет элемент в конец очереди
        }
    }

    static Buyer extract(){
        synchronized (queue){
            return queue.pollFirst(); // возвращает с удалением элемент из начала очереди, если очередь пуста, возвращает null
        }
    }

    static int getCount(){
        synchronized (queue){
            return queue.size();
        }
    }


}
