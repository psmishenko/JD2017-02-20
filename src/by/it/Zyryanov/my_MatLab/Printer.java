package by.it.Zyryanov.my_MatLab;


import java.io.*;

import java.util.Map;


public class Printer {

    public static void print2(Map<String, Var> map) {
        try {
            FileOutputStream writer = new FileOutputStream("/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by/it/Zyryanov/my_MatLab/vars2.txt");
            for (Map.Entry<String, Var> pair : Var.varMap.entrySet()) {
                String key = pair.getKey();
                Var value = pair.getValue();
                String s = " = " + value.toString() + "\n";
                writer.write(key.getBytes());
                writer.write(s.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
