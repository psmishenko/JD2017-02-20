package by.it.Zyryanov.my_MatLab;


import java.util.HashMap;
import java.util.Map;

public abstract class Var implements IOperations, IVar{

    static public Map<String, Var> varMap = new HashMap<>();


    @Override
    public void save(String name) {
        varMap.put(name, this);
    }

    @Override
    public Var add(Var var) {
        return null;
    }

    @Override
    public Var sub(Var var) {
        return null;
    }

    @Override
    public Var mul(Var var) {
        return null;
    }

    @Override
    public Var div(Var var) {
        return null;
    }
}
