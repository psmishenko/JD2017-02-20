package by.it.radivonik.jd02_06;

/**
 * Created by Radivonik on 12.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        Log log = Log.getLog();
        try {
            log.write("Событие 1");
            Thread.sleep(200);
            log.write("Событие 2");
            Thread.sleep(500);
            log.write("Событие 3");
        }
        catch (InterruptedException e) {
            log.write(e);
        }

        try {
            Thread.sleep(100);
            int x = 2 / 0;
        }
        catch (Exception e) {
            log.write(e);
        }

        try {
            Thread.sleep(300);
            String[] a = {"1", "2"};
            System.out.println(a[2]);
        }
        catch (Exception e) {
            log.write(e);
        }

        System.out.println("См. файл " + log.getFilename());
    }
}
