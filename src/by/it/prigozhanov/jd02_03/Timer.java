package by.it.prigozhanov.jd02_03;

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
                    System.out.println("План: " + Dispatcher.plan);
                    System.out.println("Время: " + minute + " минут " + second + " секунд");
                    System.out.println("Корзинок осталось: " + Dispatcher.buckets);
                    System.out.println("Покупателей в зале: " + Dispatcher.currentBuyersCounterInStore);
                    System.out.println("Покупателей обслужено: " + Dispatcher.countComplete);
                    System.out.println("Людей в очереди: " + BuyersQueue.queueBuyers.size());
                    System.out.println("Открыто касс: " + Dispatcher.cashiers.size());
                    System.out.println("Общий доход магазина: " + Dispatcher.earnings+"$");
                    System.out.println("-----------------____-----------------");
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
