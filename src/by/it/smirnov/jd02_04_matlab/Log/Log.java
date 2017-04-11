package by.it.smirnov.jd02_04_matlab.Log;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Класс механизма логирования
 */
public class Log implements ILog {
    private boolean isDebug;
    private LinkedList<String> listLog;
    private String fileName;

    public Log(String fileName, boolean isDebug){
        this.isDebug = isDebug;
        this.fileName = fileName;
        listLog = new LinkedList<>();
    }

    /**
     * Вычитывание лога в память
     */
    public void load(){
        if (new File(fileName).exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
                String line;
                while((line = br.readLine())!=null) listLog.addLast(line);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Сохранение ошибки
     * @param message сообщение
     */
    @Override
    public void error(String message) {
        Mess(message, "ERROR");
    }

    /**
     * Сохранение предупреждение
     * @param message сообщение
     */
    @Override
    public void warn(String message) {
        Mess(message, "WARNING");
    }

    /**
     * Сохранение информации
     * @param message сообщение
     */
    @Override
    public void info(String message) {
        Mess(message, "INFO");
    }

    /**
     * Сохранение информации для DEBUG
     * @param message сообщение
     */
    @Override
    public void debug(String message) {
        if (isDebug) Mess(message, "DEBUG");

    }

    /**
     * Сохранение сообщения в логе
     * @param message сообщение
     * @param prefix префикс сообщения в лог-файле
     */
    private void Mess(String message, String prefix) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        listLog.addLast(String.format("%s [%s] %s",sdf.format(System.currentTimeMillis()), prefix, message));

        while (listLog.size()>50) listLog.removeFirst();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            Iterator<String> it = listLog.iterator();
            while (it.hasNext()) bw.write(it.next()+"\n");
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
