package by.it.zagursky.jd02_03.src.buyer;

import Rnd.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dzenyaa on 31.03.2017.
 */
public class Dispetcher extends Thread{
    //public final static Integer chek_s=0;
    public static Semaphore semaphore=new Semaphore(10);
    public static AtomicInteger countcompleateBuyers=new AtomicInteger(0);
   public static AtomicInteger countBuyers=new AtomicInteger(0);
    public static AtomicInteger plan=new AtomicInteger(100);

   static List<Thread> cashiers= new ArrayList<>();
   @Override
    public void run()
   {
       ExecutorService executorService= Executors.newFixedThreadPool(5);


       while(countcompleateBuyers.get()<plan.get()) {
       if (que_Buyer.get_count() > cashiers.size() * 5 && cashiers.size() < 5) {
           Thread cashier = new Thread(new Cashier(cashiers.size() + 1));
           cashiers.add(cashier);
           executorService.execute(cashier);


       }

       helper.sleep(1000);
   }
   executorService.shutdown();
   }

}
