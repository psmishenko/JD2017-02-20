package by.it.korzun.jd02_06A;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class SingleLogger {

    private static SingleLogger instance;

    private SingleLogger() {
    }

    static SingleLogger getInstance(){
        if(instance == null){
            instance = new SingleLogger();
        }
        return instance;
    }

    void log(String message){
        String src = System.getProperty("user.dir") + "/src/by/it/korzun/jd02_06A/";
        String fileLog = src + "log.txt";
        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        String line = df.format(date) + " " + message + "\n";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileLog, true))){
            bw.write(line);
        }catch (IOException e){

        }


    }
}
