package by.it.Zyryanov.matLab2;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements IOperation, IVariable {

    static Map<String, Var> vars = new HashMap<>();

    @Override
    public Var add(Var var) {
        new Error("Операция сложения невозможна");
        return null;
    }

    @Override
    public Var sub(Var var) {
        new Error("Операция вычитания невозможна");
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

    @Override
    public void save(String name) {
        vars.put(name, this);
    }
}
