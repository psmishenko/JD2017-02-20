package by.it.radivonik.jd02_03;

import java.util.*;

/**
 * Created by Radivonik on 31.03.2017.
 * Класс, реализующий вспомогательные методы для получения случайных чисел и работы с потоками
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
        sleep(millis,1.0);
    }

    protected static void sleep(int millis, double mul) {
        try {
            Thread.sleep((int)(Math.round(millis) * mul));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
