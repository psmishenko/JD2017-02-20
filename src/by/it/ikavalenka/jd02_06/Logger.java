package by.it.ikavalenka.jd02_06;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by USER on 12.04.2017.
 */
public class Logger {
    private static Logger instance;


    private Logger() {
    }

    static Logger getInstance() {
        if (instance==null){
            instance=new Logger();
        }
        return instance;
    }
    void  log(String message){
        String path = System.getProperty("user.dir")+"/src/by/it/ikavalenka";  //SET correct directory
        String fileLog = path + "jd02_06/log.txt";
        Date d =new Date();
        DateFormat df=DateFormat.getDateInstance(DateFormat.FULL);
        String line=df.format(d)+" "+message + "\n";
        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileLog,true))){
                out.write(line);
        }
        catch (Exception e){

        }
    }

}
