package by.it.loktev.project.java.controller;

import java.io.*;


public class Log {

    static private String logFileName="D:\\_log.log";

    static public void write(String s){

        try (
                FileWriter fw = new FileWriter(logFileName,true);
                BufferedWriter bw=new BufferedWriter(fw);
        )
        {
            bw.write(s+"\n");
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
