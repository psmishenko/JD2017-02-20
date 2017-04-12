package by.it.loktev.jd02_06;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class SingleLogger {

    static private SingleLogger instance;

    private SingleLogger(){
    }

    public static SingleLogger getInstance(){
        if (instance==null){
            instance=new SingleLogger();
        }
        return instance;
    }

    void log(String message){
        String src=System.getProperty("user.dir")+"/src/by/it/loktev/";
        String fileLog=src+"jd02_06/log.txt";
        Date d=new Date();
        DateFormat df=DateFormat.getDateInstance(DateFormat.FULL);
        String line=df.format(d)+" "+message+"\n";
        try (
            BufferedWriter bw=new BufferedWriter(new FileWriter(fileLog,true))
        ) {
            bw.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
