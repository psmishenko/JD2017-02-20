package by.it.radivonik.jd01_08;

/**
 * Created by Radivonik on 10.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
        Player v = new VideoPlayer("Cometa");
        v.play();
        v.showState();
        v.showState("Тест");
        v.pause();
        v.showState();
        v.stop();
        v.showState();
    }
}
