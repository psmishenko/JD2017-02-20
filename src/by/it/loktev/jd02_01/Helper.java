package by.it.loktev.jd02_01;

import java.util.Random;

public class Helper {

    private Helper() {
    }

    static private Random random;

    static {
        long time=System.currentTimeMillis();
        random=new Random(time);
    }

    static protected int getRandom(int max){
        return random.nextInt(max+1);
    }

    static protected int getRandom(int min, int max){
        return random.nextInt(max-min+1)+min;
    }

    static protected void sleep(double ms){
        try {
            Thread.sleep((int)ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
