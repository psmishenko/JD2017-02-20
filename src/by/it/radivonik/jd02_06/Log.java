package by.it.radivonik.jd02_06;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Radivonik on 12.04.2017.
 */
public class Log {
    private static Log log;
    private String filelog = "log.txt";
    private String filelogspec = System.getProperty("user.dir") + "/src/by/it/radivonik/jd02_06/" + filelog;

    private Log() {

    }

    public static Log getLog() {
        if (log == null)
            log = new Log();
        return log;
    }

    public void write(String message) {
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(filelogspec,true))) {
            fileWriter.println(getTime() + " " + message);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения файла " + filelog + " (" + e.getMessage() + ")");
            e.printStackTrace();
        }
    }

    public void write(Exception except)  {
        StringBuilder message = new StringBuilder(except.getClass().getName());
        message.append(": ").append(except.getMessage());
        for (StackTraceElement elemErr : except.getStackTrace())
            message.append("\n  " + elemErr.toString());
        write(message.toString());
    }

    public String getFilename() {
        return filelog;
    }

    private String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.S");
        return sdf.format(System.currentTimeMillis());
    }
}
