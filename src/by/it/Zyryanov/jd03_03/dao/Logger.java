package by.it.Zyryanov.jd03_03.dao;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Logger {

    private static Logger instance;

    private Logger() {

    }

    static Logger getInstance() {
        if (instance == null)
            instance = new Logger();
        return instance;
    }


    void errorLogger(String s) {
        try {
            s = s + " время ошибки: ";
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by/it/Zyryanov/jd03_03/logger/log.txt", true);
            String s1 = "\n ----------------------------------------";
            Date now = new Date();
            fileOutputStream.write(s1.getBytes());
            fileOutputStream.write(s.getBytes());
            fileOutputStream.write(now.toString().getBytes());
            fileOutputStream.write(s1.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
