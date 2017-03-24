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
    public Var add(Var var) throws MathException{
        throw new MathException("Операция сложения невозможна");
    }

    @Override
    public Var sub(Var var) throws MathException{
        throw new MathException("Операция разности невозможна");
    }

    @Override
    public Var mul(Var var) throws MathException{
        throw new MathException("Операция умножения невозможна");
    }

    @Override
    public Var div(Var var) throws MathException{
        throw new MathException("Операция деления невозможна");
    }
}
