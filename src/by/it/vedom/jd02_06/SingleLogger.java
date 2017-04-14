package by.it.vedom.jd02_06;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class SingleLogger {

    private static SingleLogger instance;
    private SingleLogger() {
    }

    static SingleLogger getInstance() {
        if(instance == null) {
            instance = new SingleLogger();
        }
        return instance;
    }

    void log(String message) throws IOException {
        String scr = System.getProperty("user.dir") + "/src/by/it/vedom";
        String filelog = scr + "jd02_06/log.txt";
        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        String line = df.format(d) + " " + message + "\n";
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filelog, true))) {
            out.write(line);
        }
        catch (Exception e) {
            e.getMessage();
        }
    }
}
