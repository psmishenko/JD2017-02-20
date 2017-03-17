package by.it.korzun.matlab;

import java.util.*;

public abstract class Var implements IOperation, IVariable{
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

    @Override
    public void save(String name) {
        vars.put(name, this);
    }

    @Override
    public String toString() {
        return vars.toString();
    }

    @Override
    public Var add(Var var) {
        new Error("Операция сложения невозможна");
        return null;
    }

    @Override
    public Var sub(Var var) {
        new Error("Операция разности невозможна");
        return null;
    }

    @Override
    public Var mul(Var var) {
        new Error("Операция умножения невозможна");
        return null;
    }

    @Override
    public Var div(Var var) {
        new Error("Операция деления невозможна");
        return null;
    }
}
