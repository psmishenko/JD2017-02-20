package by.it.radivonik.calculator;

import java.io.*;
import java.util.*;

/**
 * Created by Radivonik on 18.03.2017.
 */
public class Calc {
    public static String calculate (String exp) {
        try {
            Operation op = new Operation();
            String[] aop = Parser.parse(exp);

            if (aop[0].equals("printvar")) {
                return Var.vars.toString();
            }
            else if (aop[0].equals("sortvar")) {
                SortedMap<String,Var> varsSorted = new TreeMap<>(Var.vars);
                return varsSorted.toString();
            }
            else if (aop[1].equals("+")) {
                return op.add(Parser.createVar(aop[0]),Parser.createVar(aop[2])).toString();
            }
            else if (aop[1].equals("-")) {
                return op.sub(Parser.createVar(aop[0]),Parser.createVar(aop[2])).toString();
            }
            else if (aop[1].equals("*")) {
                return op.mul(Parser.createVar(aop[0]),Parser.createVar(aop[2])).toString();
            }
            else if (aop[1].equals("/")) {
                return op.div(Parser.createVar(aop[0]),Parser.createVar(aop[2])).toString();
            }
            else if (aop[1].equals("=")) {
                Var v = Parser.createVar(aop[2]);
                op.save(aop[0],v);
                new Var().saveToFile();
                return v.toString();
            }
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

        return null;
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
