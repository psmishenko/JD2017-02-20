package by.it.kolenda.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

//public class Runner {
//    public static void main(String[] args) {
//        new TaskA.MyThread("-First thread ").start();
//        new TaskA.MyThread("-Second thread ").start();
//        new TaskA.MyThread("-Third thread ").start();
//    }
//}
class Runner {
    static int countBuyers=0;

    public static void main(String[] args) throws InterruptedException {
        Queue<Buyer> queue=new ArrayDeque<>();
        while (countBuyers<10){Thread.sleep(1000);
        int count=Randoming.fromTo(0,2);
            for (int i = 0; i <=count; i++) {
                countBuyers++;
                if (countBuyers<11){
                    Buyer buyer = new Buyer(countBuyers);
                    queue.add(buyer);
                }
            }
        }
    }
}