package by.it.radivonik.calculator.log;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Radivonik on 09.04.2017.
 */
public class Log {
    private static Log log = new Log();
    private final int maxLogMesages = 50;
    private String filelog = "log.txt";
    private String filelogspec = System.getProperty("user.dir") + "/src/by/it/radivonik/calculator/" + filelog;
    private Deque<String> logList = new LinkedList<>();

    private Log() {
        load();
    }

    public static Log getLog() {
        return log;
    }

    public void write(String message) {
        logList.addLast(getTime() + " " + message);
        while (logList.size() > maxLogMesages)
            logList.removeFirst();
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(filelogspec,false))) {
            int c = 0;
            for (String m : logList)
                fileWriter.println("[" + (++c) + "] " + m);
        } catch (IOException e) {
            System.out.println("Ошибка сохранения файла " + filelog + " (" + e.getMessage() + ")");
        }
    }

    public void write(Exception except)  {
        StringBuilder message = new StringBuilder(except.getClass().getName());
        message.append(": ").append(except.getMessage());
        for (StackTraceElement elemErr : except.getStackTrace())
            message.append("\n  " + elemErr.toString());
        write(message.toString());
    }

    private void load() {
        String patternNum = "^\\[\\d+\\] ";
        String patternLog = "\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}\\:\\d{2}\\:\\d{2}.*";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filelogspec))) {
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
                System.out.println("Ошибка чтения файла " + filelog + " (" + e.getMessage() + ")");
        }
    }

    private String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return sdf.format(System.currentTimeMillis());
    }
}
