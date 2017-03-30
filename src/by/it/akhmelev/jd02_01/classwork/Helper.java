package by.it.akhmelev.jd02_01.classwork;

import java.util.Random;

class Helper {

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
