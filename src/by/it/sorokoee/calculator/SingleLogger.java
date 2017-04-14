package by.it.sorokoee.calculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.util.Date;

public class SingleLogger {
    private static SingleLogger instance;

    private SingleLogger() {
    }

    static SingleLogger getInstance() {
        if (instance == null) {
            instance = new SingleLogger();
        }
        return instance;
    }

    void log(String message) {
        String src = System.getProperty("user.dir") + "/src/by/it/sorokoee/";
        String fileLog = src + "calculator/log.txt";
        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        String line = df.format(d) + " " + message +"\n";
        try (BufferedWriter out=new BufferedWriter(new FileWriter(fileLog,true))){
            out.write(line);
        }
        catch(Exception e) {

        }
    }
}
