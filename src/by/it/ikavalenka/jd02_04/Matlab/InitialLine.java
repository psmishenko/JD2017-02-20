package by.it.ikavalenka.jd02_04.Matlab;

import java.io.IOException;


public class InitialLine {

    private static String line;

    public static String getLine() {
        return line;
    }

    public static String enterLine () throws IOException {

        line = UtilsMatlab.enterLine();
        return line;
    }
}
