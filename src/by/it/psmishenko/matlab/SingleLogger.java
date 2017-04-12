package by.it.psmishenko.matlab;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by user on 12.04.2017.
 */
public class SingleLogger {
    private static SingleLogger instance;
    private SingleLogger(){

    }
    static SingleLogger getInstance(){
        if(instance==null) instance = new SingleLogger();
        return  instance;
    }
    void log(String message){
        String path = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_6\\log.txt";
        Date d = new Date();
        DateFormat df =  DateFormat.getDateInstance(DateFormat.FULL);
        String line =  df.format(d)+" "+message+"\n";
        try  (BufferedWriter out = new BufferedWriter(new FileWriter(path,true))){
           out.write(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
