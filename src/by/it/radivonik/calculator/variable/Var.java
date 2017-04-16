package by.it.radivonik.calculator.variable;

import by.it.radivonik.calculator.Calc;
import by.it.radivonik.calculator.log.Log;
import by.it.radivonik.calculator.exception.ParseException;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Created by Radivonik on 13.03.2017.
 */
public class Var implements IVariable {
   private static String filevar = "vars.txt";
    private static String filevarspec = System.getProperty("user.dir") + "/src/by/it/radivonik/calculator/" + filevar;
   private static boolean isLoadFile = false;
   private static Map<String,Var> vars = new HashMap<String,Var>(){
        @Override
        public String toString() {
            StringBuilder res = new StringBuilder("");
            for (Map.Entry<String,Var> v: this.entrySet()) {
                res.append(String.format("%s=%s\n",v.getKey(),v.getValue()));
            }
            return res.toString();
        }
    };

    {
        loadFromFile();
    }

    @Override
    public void fromString(String str) throws ParseException {

    }

    @Override
    public String toString() {
        return super.toString();
    }

    static Var getVar(String name) {
        return vars.get(name);
    }

    public static Var setVar(String name, String v) throws ParseException {
        Var res = null;
        if (v == null) {
            vars.remove(name);
        }
        else {
            res = VarCreator.getCreator().create(v);
            vars.put(name, res);
        }
        return res;
    }

    public static String getPrintVar() {
        return vars.toString();
    }

    public static String getSortVar() {
        SortedMap<String,Var> varsSorted = new TreeMap<String,Var>(vars) {
            @Override
            public String toString() {
                StringBuilder res = new StringBuilder("");
                for (Map.Entry<String,Var> v: this.entrySet()) {
                    res.append(String.format("%s=%s\n",v.getKey(),v.getValue()));
                }
                return res.toString();
            }

        };
        return varsSorted.toString();
    }

    public static void loadFromFile() {
        if (isLoadFile)
            return;

        vars.clear();
        isLoadFile = true;

        if (!Files.exists(Paths.get(filevarspec)))
            return;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filevarspec))) {
            String line;
            while ((line = fileReader.readLine()) != null)
                Calc.calculate(line);
        }
        catch (IOException e) {
            Log.getLog().write("Не прочитан файл с переменными (" + e.getMessage() + ")");
        }
}

    public static void saveToFile() {
        if (vars.size() == 0)
            return;

        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(filevarspec))) {
            fileWriter.print(vars);
        }
        catch (IOException e) {
            Log.getLog().write("Не сохранен файл с переменными (" + e.getMessage() + ")");
        }
    }
}
