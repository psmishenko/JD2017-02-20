package by.it.smirnov.project.java.log;

import java.io.*;
import java.text.SimpleDateFormat;

/**
 * Класс механизма логирования
 */
public class SingleLogger implements ILog {
    private static SingleLogger instance = null;
    //private static final String fileName = System.getProperty("user.dir") + "/src/by/it/smirnov/project/log.txt";
    private static final String fileName = "D:/log.txt";
    private static boolean isDebug;

    private SingleLogger() {
        this.isDebug = true;
    }

    static public SingleLogger getInstance() {
        if (instance==null){
            synchronized (SingleLogger.class){
                if(instance==null){
                    instance = new SingleLogger();
                }
            }
        }
        return instance;
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
        Mess(message, "DEBUG");

    }

    /**
     * Сохранение сообщения в логе
     * @param message сообщение
     * @param prefix префикс сообщения в лог-файле
     */
    private void Mess(String message, String prefix) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        synchronized (SingleLogger.class){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true))){
                bw.write(String.format("%s [%s] %s %n",sdf.format(System.currentTimeMillis()), prefix, message));
                bw.flush();
            } catch (IOException e) {
                SingleLogger.getInstance().error(e.toString());
            }
        }

    }

}
