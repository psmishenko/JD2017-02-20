package by.it.psmishenko.matlab;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
        String path = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\matlab\\newLog.txt";
        Date d = new Date();
        DateFormat df =  DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat dft = DateFormat.getTimeInstance();
        String line =  df.format(d)+" "+dft.format(d)+"   "+message+"\n";
        try  (BufferedWriter out = new BufferedWriter(new FileWriter(path,true))){
           out.write(line);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
