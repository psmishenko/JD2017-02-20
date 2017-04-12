package by.it.radivonik.jd02_06;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Radivonik on 12.04.2017.
 */
public class SingleLogger {
    private static SingleLogger instance;

    private SingleLogger() {

    }

    static SingleLogger getInstance() {
        if (instance == null)
            instance = new SingleLogger();
        return instance;
    }

    void log(String message) {
        String path = System.getProperty("user.dir") + "/src/by/it/radivonik/jd02_06";
        String filelog = path + "/log.txt";
        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        String line = df.format(d) + " " + message + "\n";
        try (BufferedWriter file = new BufferedWriter(new FileWriter(filelog,true))) {
            file.write(line);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
