package by.it.Zyryanov.jd02_02;

import java.util.Random;

/**
 * Created by georgijzyranov on 01.04.17.
 */
public class Helper {

    private Helper(){
    }

    private static Random random;
    static {
        long time=System.currentTimeMillis();
        random=new Random(time);
    }

    static int getRandom(int max){
        return random.nextInt(max+1);
    }

    static int getRandom(int from, int to){
        return from+random.nextInt(to-from+1);
    }


    protected static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
