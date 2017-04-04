package by.it.prigozhanov.jd02_02;

/**
 * Created by v-omf on 3/29/2017.
 *
 * @author v-omf
 */

import java.util.Random;

public class Helper {

    private Helper(){
    }

    private static Random random;
    static {
        long time=System.currentTimeMillis();
        random=new Random(time);
    }

    protected static int getRandom(int max){
        return random.nextInt(max+1);
    }

    protected static boolean getRandomBuyer(){
        int pensioneer;
        pensioneer = Helper.getRandom(1, 4);
        if (pensioneer <= 3) {
            return false;
        } else
        return true;
    }

    protected static int getRandom(int from,int to){
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