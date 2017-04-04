package by.it.prigozhanov.Bank;

/**
 * Created by v-omf on 4/1/2017.
 *
 * @author v-omf
 */
public class Inform extends Thread {
    protected static int second = 0;
    protected static int minute = 0;
    private int set;

    public Inform(int set) {
        this.set = set;
    }

    @Override
    public void run() {
        while (set<minute) {
            for (int i = 0; i < 60; i++) {
                System.out.println("Секунда: " + second + "Минута: " + minute);
                Helper.sleep(1000);
                second++;
            }
            minute++;
        }
    }
}
