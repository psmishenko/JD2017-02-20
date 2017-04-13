package by.it.korzun.jd02_06A;

public class Client {
    public static void main(String[] args) {
        SingleLogger log = SingleLogger.getInstance();
        log.log("one");
        SingleLogger log2 = SingleLogger.getInstance();
        log2.log("two");
    }

}
