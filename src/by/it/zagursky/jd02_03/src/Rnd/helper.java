package by.it.zagursky.jd02_03.src.Rnd;

import java.util.Random;

public class helper {
    private static Random random;
    static{
        long time=System.currentTimeMillis();
        random=new Random(time);
    }
    public static int getRandom(int max)
    {
        return random.nextInt(max);
    }

    private helper() {
    }

    public static int getRandom(int from, int to)
    {
        return  from+ random.nextInt(to-from+1);

    }
    public static void sleep(int time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
