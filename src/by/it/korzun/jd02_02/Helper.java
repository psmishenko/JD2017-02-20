package by.it.korzun.jd02_02;

import java.util.Random;

class Helper {
    private Helper(){

    }

    static String sep = "///////////////////////////////////////////////////////////////////////";

    private static Random random;
    static {
        long time = System.currentTimeMillis();
        random = new Random(time);
    }

    static int getRandom(int max){
        return random.nextInt(max + 1);
    }

    static int getRandom(int from, int to){
        return from + random.nextInt(to - from + 1);
    }

    static void sleep(int millis, boolean pensioneer){
        try {
            if(pensioneer){
                Thread.sleep(millis + millis/2);
            }else {
                Thread.sleep(millis);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
