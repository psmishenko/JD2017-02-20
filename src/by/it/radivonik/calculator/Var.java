package by.it.radivonik.calculator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Radivonik on 13.03.2017.
 */
public class Var implements IOperation, IVariable {
    public static Map<String,Var> vars = new HashMap<>();

    @Override
    public Var add(Var var) {
        new Error("Операция сложения не реализована");
        return null;
    }

    @Override
    public Var sub(Var var) {
        new Error("Операция вычитания не реализована");
        return null;
    }

    @Override
    public Var mul(Var var) {
        new Error("Операция умножения не реализована");
        return null;
    }

    @Override
    public Var div(Var var) {
        new Error("Операция деления не реализована");
        return null;
    }

    @Override
    public void fromString(String value) {

    }

    @Override
    public void save(String name) {
        vars.put(name,this);
    }
}
