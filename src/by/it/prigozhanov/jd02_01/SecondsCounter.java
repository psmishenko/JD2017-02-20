package by.it.prigozhanov.jd02_01;

/**
 * Created by v-omf on 3/29/2017.
 *
 * @author v-omf
 */
public class SecondsCounter extends Thread {
    protected int second=0;
    protected int minutes=0;

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 60; i++) {
                Helper.sleep(1000);
                second++;
            }
            minutes++;
            second=0;
        }
    }

    @Override
    public String toString() {
        return "second=" + second;
    }
}
