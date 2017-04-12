package by.it.loktev.jd02_06;

public class Client {

    public static void main(String[] args) {
        SingleLogger log=SingleLogger.getInstance();
        log.log("one1");
        log.log("one2");
        log.log("one3");
        SingleLogger log2=SingleLogger.getInstance();
        log2.log("one4");
        log2.log("one5");
        log2.log("one6");
    }

}
