package by.it.akhmelev.jd02_03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

public class th3_01_FutureTask {

    public static void main(String[] args) {

        Callable<Integer> callTh = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                sleep(5000);
                return 5000;
            }
        };

        FutureTask<Integer> task = new FutureTask<>(callTh);
        task.run();
        try {
            System.out.println("Result:"+task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


}
