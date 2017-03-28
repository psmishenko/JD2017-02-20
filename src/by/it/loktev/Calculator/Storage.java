package by.it.loktev.Calculator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Storage {

    static private String fileName=System.getProperty("user.dir")+"/src/by/it/loktev/Calculator/vars.txt";

    static private HashMap<String,Var> vars=new HashMap<>();

    static public void store(String name, Var var){
        vars.put(name,var);
    }

    static public Var restore(String name){
        return vars.get(name);
    }

    static public boolean isExist(String name){
        return vars.containsKey(name);
    }

    static public void print(){
        System.out.println("Переменные в хранилище:");
        for (Map.Entry<String,Var> ME : vars.entrySet()){
            System.out.println(ME.getKey()+": "+ME.getValue());
        }
    }

    static public void printSort(){
        System.out.println("Переменные в хранилище по алфавиту:");
        TreeMap<String,Var> varsSort=new TreeMap<>(vars);
        for (Map.Entry<String,Var> ME : varsSort.entrySet()){
            System.out.println(ME.getKey()+": "+ME.getValue());
        }
    }

    static public void writeToFile(){

        try (
                FileWriter fw = new FileWriter(fileName);
                //ObjectOutputStream oos=new ObjectOutputStream(fw);
                BufferedWriter bw=new BufferedWriter(fw);
        )
        {
            for ( Map.Entry<String,Var> entry : vars.entrySet() ) {
                bw.write(entry.getKey()+" = "+entry.getValue().serialize()+"\n");
                //oos.writeObject(entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
