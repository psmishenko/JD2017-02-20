package by.it.vedom.jd02_03;

import java.util.Random;

public class Helper {

    private Helper() {
    }

    private static Random random;
    static {
        long time = System.currentTimeMillis();
        random = new Random(time);
    }

    protected static int getRandom(int max) {
        return random.nextInt(max+1);
    }
    protected static int getRandom(int from, int to) {
        return random.nextInt(to-from+1);
    }

    protected static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
