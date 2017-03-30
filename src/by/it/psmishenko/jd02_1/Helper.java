package by.it.psmishenko.jd02_1;

import java.util.Random;

/**
 * Created by user on 29.03.2017.
 */
public class Helper {
    private Helper() {
    }

    private static Random random;
    static {
        long time = System.currentTimeMillis();
        random = new Random(time);
    }

    static protected int getRandom(int max){
        return random.nextInt(max+1);
    }
    static protected int getRandom(int from,int to){
        return from+ random.nextInt(to-from+1);
    }
    protected static void sleep(int mil){
        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
