package by.it.radivonik.calculator;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Created by Radivonik on 13.03.2017.
 */
public class Var implements IVariable {
    public static Map<String,Var> vars = new HashMap<String,Var>(){
        @Override
        public String toString() {
            StringBuilder res = new StringBuilder("");
            for (Map.Entry<String,Var> v: this.entrySet()) {
                res.append(String.format("%s=%s\n",v.getKey(),v.getValue()));
            }
            return res.toString();
        }
    };

    private static String fileVars = System.getProperty("user.dir") + "/src/by/it/radivonik/calculator/vars.txt";
    private static boolean isLoadFile = false;

    @Override
    public void fromString(String str) throws ParseException {

    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void loadFromFile() throws ParseException {
        if (isLoadFile)
            return;

        vars.clear();
        isLoadFile = true;

        if (!Files.exists(Paths.get(fileVars)))
            return;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileVars))) {
            String line;
            while ((line = fileReader.readLine()) != null)
                Calc.calculate(line);
        }
        catch (IOException e) {
            throw new ParseException("Не прочитан файл с переменными (" + e.getMessage() + ")");
        }
    }

    @Override
    public void saveToFile() throws ParseException {
        if (vars.size() == 0)
            return;

        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(fileVars))) {
            fileWriter.print(vars);
        }
        catch (IOException e) {
            throw new ParseException("Не сохранен файл с переменными (" + e.getMessage() + ")");
        }
    }
}
