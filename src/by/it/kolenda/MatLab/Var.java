package by.it.kolenda.MatLab;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements IOperation, IVariable {

    static private Map<String, Var> vars=new HashMap<>();


    @Override
    public Var add(Var var) throws Error{
        throw new Error("Операция сложения невозможна");
        return null;
    }

    @Override
    public Var sub(Var var) throws Error{
        throw new Error("Операция вычитания невозможна");
        return null;
    }

    @Override
    public Var mul(Var var) throws Error{
        throw new Error("Операция умножения невозможна");
        return null;
    }

    @Override
    public Var div(Var var) throws Error{
        throw new Error("Операция деления невозможна");
        return null;
    }

    @Override
    public void save(String name) {
        vars.put(name, this);
    }
}
