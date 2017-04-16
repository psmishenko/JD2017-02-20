package by.it.vedom.jd02_06.classwork;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        SingleLogger singleLogger = SingleLogger.getInstance();
        singleLogger.log("one");
        //------------------
        SingleLogger singleLogger1 = SingleLogger.getInstance();
        singleLogger1.log("two");
    }
}
