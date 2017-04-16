package by.it.tereshko.jd02_06;

public class Client {
    public static void main(String[] args) {

        SingleLogger log = SingleLogger.getInstance();
        log.log("one");

        ///...

        SingleLogger log2 = SingleLogger.getInstance();
        log2.log("two");

    }

}