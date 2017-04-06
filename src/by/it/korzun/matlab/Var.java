package by.it.korzun.matlab;

import java.io.*;
import java.util.*;

public abstract class Var implements IOperation, IVariable{
    static String path = System.getProperty("user.dir") + "/src/by/it/korzun/matlab/";
    private static File file = new File(path + "vars.txt");
    static private Map<String, Var> vars = new HashMap<>();

    static Map<String, Var> getVars() {
        return vars;
    }

    static Map<String, Var> sortVars(){
        Map sortedmap = new TreeMap(vars);
        System.out.println("");
        vars = new HashMap<>(sortedmap);
        return vars;
    }

    static void load() throws MathException{
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            System.out.println("Раннее созданные переменные:");
            Parser parser = new Parser();
            String newVar;
            while ((newVar = br.readLine()) != null) {
                parser.parseString(newVar,true);
            }
            System.out.println(Var.getVars());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    static void saveOnExit(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            Iterator it = vars.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry pair = (Map.Entry)it.next();
                bw.write(pair.getKey() + "=" + pair.getValue());
                bw.newLine();
            }
        }catch (IOException ignored){

        }
    }

    @Override
    public void save(String name) {
        vars.put(name, this);
    }

    @Override
    public String toString() {
        return vars.toString();
    }

    @Override
    public Var add(Var var) throws MathException{
        throw new MathException("Операция сложения невозможна:");
    }

    @Override
    public Var sub(Var var) throws MathException{
        throw new MathException("Операция разности невозможна:");
    }

    @Override
    public Var mul(Var var) throws MathException{
        throw new MathException("Операция умножения невозможна:");
    }

    @Override
    public Var div(Var var) throws MathException{
        throw new MathException("Операция деления невозможна:");
    }
}
