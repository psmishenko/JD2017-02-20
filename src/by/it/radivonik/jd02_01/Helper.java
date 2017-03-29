package by.it.radivonik.jd02_01;

import java.util.Random;

/**
 * Created by Radivonik on 29.03.2017.
 */
public class Helper {
    private static Random random;

    private Helper () {
    }

    static {
        long time = System.currentTimeMillis();
        random = new Random(time);
    }

    protected static int getRandom(int max) {
        return random.nextInt(max+1);
    }

    protected static int getRandom(int from, int to) {
        return from + random.nextInt(to-from+1);
    }

    protected static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
