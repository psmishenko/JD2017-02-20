package by.it.prigozhanov.jd02_01;

/**
 * Created by v-omf on 3/29/2017.
 *
 * @author v-omf
 */
public class Timer extends Thread {
    protected int second=0;
    protected int minute=0;
    private int set;
    private boolean showInfo;

    /**
     * set - введённое количество минут в конструкторе
     * @param minutes - задаёт колличество минут для таймера.
     */
    public Timer(int minutes, boolean showInfo) {
        this.set = minutes;
        this.showInfo = showInfo;
    }


    @Override
    public void run() {
        while (minute < set) {
            for (int i = 0; i < 60; i++) {
                if (showInfo) {
                    System.out.println("-----------------INFO-----------------");
                    System.out.println("Время: " + minute + " минут " + second + " секунд");
                    System.out.println("Корзинок осталось: " + Runner.buckets);
                    System.out.println("Покупателей в зале: " + Runner.currentBuyersCounter);
                    System.out.println("--------------------------------------");
                }
                Helper.sleep(1000);
                second++;
            }
            minute++;
            second=0;
        }
    }

    @Override
    public String toString() {
        return "second=" + second;
    }
}
