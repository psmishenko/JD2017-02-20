package by.it.Zyryanov.jd02_03;


public class Timer extends Thread {


    @Override
    public void run() {
        secondsCounter();
    }

    static int second = 0;


    public static int secondsCounter(){
        for (int i = 0; i < 60; i++) {
            second++;
            Helper.sleep(1000);
        }
        return second;
    }
}
