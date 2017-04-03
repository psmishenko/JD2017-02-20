package by.it.loktev.Calculator;

import java.io.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Log {

    static private String logFileName;

    static private int maxLogRecords=50;

    static {
        logFileName=System.getProperty("user.dir")+"/src/by/it/loktev/Calculator/log.txt";
    }

    static public void write(String s){

        LinkedList<String> logRecords=new LinkedList<>();

        try (
                FileReader fr = new FileReader(logFileName);
                BufferedReader br=new BufferedReader(fr);
        )
        {
            while (true){
                String line=br.readLine();
                if (line==null)
                    break;
                logRecords.add(line);
                if (logRecords.size()>=maxLogRecords)
                    logRecords.remove(logRecords.getFirst());
            }
        } catch (FileNotFoundException e) {
            // nothing to do
        } catch (IOException e) {
            e.printStackTrace();
        }

        logRecords.add(s);

        try (
                FileWriter fw = new FileWriter(logFileName);
                BufferedWriter bw=new BufferedWriter(fw);
        )
        {
            for ( String line : logRecords ){
                bw.write(line+"\n");
            }
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
