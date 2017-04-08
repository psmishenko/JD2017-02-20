package by.it.radivonik.calculator;

import java.io.*;
import java.util.*;

/**
 * Created by Radivonik on 18.03.2017.
 */
public class Calc {
    public static String calculate (String exp) {
        String res = null;
        try {
            res = (new Parser()).parse(exp);
        }
        catch (MathException e) {
            System.out.println("Ошибка математическая: " + e.getMessage());
            saveLog(e);
        }
        catch (ParseException e) {
            System.out.println("Ошибка преобразования: " + e.getMessage());
            saveLog(e);
        }
        catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            saveLog(e);
        }

        return res;
    }

    private static String fileLog = System.getProperty("user.dir") + "/src/by/it/radivonik/calculator/log.txt";

    private static void saveLog(Exception except)  {
        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(fileLog,true))) {
            fileWriter.println(except.getMessage());
            except.printStackTrace(fileWriter);
        }
        catch (IOException e) {
            System.out.println("Ошибка сохранения файла log.txt (" + e.getMessage() + ")");
        }
    }
}
