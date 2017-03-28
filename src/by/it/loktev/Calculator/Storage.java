package by.it.loktev.Calculator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Storage {

    static private String fileName;

    static private HashMap<String,Var> vars;

    static {
        fileName=System.getProperty("user.dir")+"/src/by/it/loktev/Calculator/vars.txt";
        vars=new HashMap<>();
        loadFromFile();
    }

    static public void store(String name, Var var){
        vars.put(name,var);
        writeToFile();
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

    static private void writeToFile(){

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

    static private void loadFromFile(){

        try (
                FileReader fr = new FileReader(fileName);
                BufferedReader br=new BufferedReader(fr);
        )
        {
            vars.clear();

            String varAndValueRE="^ *("+Parser.varNameRE+") *= *(.+) *$";
            Pattern varAndValuePatt=Pattern.compile(varAndValueRE);
            while (true){
                String line=br.readLine();
                if (line==null)
                  break;
                Matcher varAndValueMatcher=varAndValuePatt.matcher(line);
                if ( varAndValueMatcher.matches() ){
                    //System.out.println(varAndValueMatcher.group(1)+" / "+varAndValueMatcher.group(2));
                    String varName=varAndValueMatcher.group(1);
                    String varStringValue=varAndValueMatcher.group(2);
                    Var newVar= null;
                    try {
                        newVar = Parser.parseAndCalc(varStringValue,false);
                    } catch (CalculatorException e) {
                        System.out.println("Из файла прочитана строка: '"+line+"', разобрать не удалось, проигнорирована");
                    }
                    //System.out.println("прочитана "+varName+" равная "+newVar);
                    vars.put(varName,newVar);
                }
                else
                    System.out.println("Из файла прочитана строка: '"+line+"', разобрать не удалось, проигнорирована");

                //System.out.println("прочитано: "+line);

            }


        } catch (FileNotFoundException e) {
            System.out.println("Файл с переменными не найден - хранилище переменных оставлено пустым");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
