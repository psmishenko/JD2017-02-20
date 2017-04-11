package by.it.radivonik.calculator;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Radivonik on 09.04.2017.
 */
public class Log {
    private static Log log = null;
    private final int maxLogMesages = 50;
    private String filelogShort = "log.txt";
    private String filelog = System.getProperty("user.dir") + "/src/by/it/radivonik/calculator/" + filelogShort;
    private Deque<String> logList = new LinkedList<>();

    private Log() {
        load();
    }

    private static Log getLog() {
        if (log == null)
            log = new Log();
        return log;
    }

    static void log(String message) {
        getLog().logList.addLast(getLog().getTime() + " " + message);
        while (getLog().logList.size() > getLog().maxLogMesages)
            getLog().logList.removeFirst();
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(getLog().filelog,false))) {
            int c = 0;
            for (String m : getLog().logList)
                fileWriter.println("[" + (++c) + "] " + m);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения файла " + getLog().filelogShort + " (" + e.getMessage() + ")");
        }
    }

    static void log(Exception except)  {
        String m = except.getMessage();
        if (m == null)
            m = except.getClass().toString();
        StringBuilder message = new StringBuilder(m);
        for (StackTraceElement elemErr : except.getStackTrace())
            message.append("\n  " + elemErr.toString());
        log(message.toString());
    }

    private void load() {
        String patternNum = "^\\[\\d+\\] ";
        String patternLog = "\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}\\:\\d{2}\\:\\d{2}.*";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filelog))) {
            StringBuilder message = new StringBuilder("");
            while (true) {
                String line = fileReader.readLine();
                if (line != null)
                    line = line.replaceFirst(patternNum,"");
                if ((line == null || line.matches(patternLog) || line.matches(patternNum+patternLog)) && message.toString().length() > 0 ) {
                    logList.add(message.toString().trim());
                    message = new StringBuilder("");
                }
                if(line == null)
                    break;
                message.append(line+"\n");
            }
        }
        catch (IOException e) {
                System.out.println("Ошибка чтения файла " + filelogShort + " (" + e.getMessage() + ")");
        }
    }

    private String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return sdf.format(System.currentTimeMillis());
    }
}
