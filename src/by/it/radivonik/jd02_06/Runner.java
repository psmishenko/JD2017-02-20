package by.it.radivonik.jd02_06;

/**
 * Created by Radivonik on 12.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        SingleLogger log = SingleLogger.getInstance();
        log.log("one");
        log.log("two");
        log.log("three");
    }
}
