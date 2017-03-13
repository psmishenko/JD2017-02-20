package by.it.radivonik.jd01_08;

/**
 * Created by Radivonik on 10.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
        Player v = new VideoPlayer("Cometa");
        ITech iv = v;

        iv.play();
        iv.showState();
        //v.showState("Тест");
        iv.pause();
        iv.showState();
        iv.stop();
        iv.showState();

        System.out.println(v);
    }
}
