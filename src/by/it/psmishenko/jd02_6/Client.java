package by.it.psmishenko.jd02_6;

/**
 * Created by user on 12.04.2017.
 */
public class Client {
    public static void main(String[] args) {
        SingleLogger log = SingleLogger.getInstance();
        log.log("one");
        log.log("two");
        log.log("three");
        SingleLogger log2 = SingleLogger.getInstance();
        log2.log("one");
        log2.log("two");
        log2.log("three");
    }
}
