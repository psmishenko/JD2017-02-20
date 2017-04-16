package by.it.kolenda.jd02_06;

public class Client {
    public static void main(String[] args) {
        SingleLogger log = SingleLogger.getInstance();
        log.log("one");
        log.log("two");
    }
}
