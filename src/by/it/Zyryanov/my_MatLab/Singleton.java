package by.it.Zyryanov.my_MatLab;


import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    static Singleton getInstance() {
        if (instance == null)
        instance = new Singleton();
        return instance;
    }


    void errorLogger(String s) {
        try {
            s = s + " время проишествия ошибки: ";
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by/it/Zyryanov/my_MatLab/log.txt", true);
            String s1 = "\n=============================================================================================================\n";
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


