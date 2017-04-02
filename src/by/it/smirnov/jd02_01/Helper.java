package by.it.smirnov.jd02_01;

import java.util.Random;

/**
 * Класс вспомогательных инструментов
 */
public class Helper {
    public Helper() {
    }

    static private Random random;
    static {
        long time = System.currentTimeMillis();
        random = new Random(time);
    }

    /**
     * Генерация случайного целочисленного значения от 0 до max
     * @param max максимальное значение
     */
    protected  static int getRandom(int max) {
        return random.nextInt(max+1);
    }
    /**
     * Генерация случайного целочисленного значения от from до to
     * @param from минимальное значение
     * @param from максимальное значение
     */
    protected  static int getRandom(int from, int to) {
        return from + random.nextInt(to - from + 1);
    }
    /**
     * Функция засыпания текущего потока
     * @param sleepTime период сна в милисекундах
     */
    protected static void sleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
