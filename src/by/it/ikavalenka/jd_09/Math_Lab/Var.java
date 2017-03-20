package by.it.ikavalenka.jd_09.Math_Lab;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by USER on 13.03.2017.
 */
public abstract class Var implements IOperation,IVariable {
     static public Map<String,Var> vars = new HashMap<>();
//    static private Map<String,Var> vars = new HashMap<>();

    @Override
    public Var div (Var var) {
        new Error("Operation div imposible");
        return null;
    }

    @Override
    public Var add(Var var) {
        new Error("Operation add imposible");
        return null;
    }

    @Override
    public Var sub(Var var) {
        new Error("Operation sub imposible");
        return null;
    }

    @Override
    public Var mul(Var var) {
        new Error("Operation mul imposible");
        return null;
    }



    @Override
    public void save(String name) {
        vars.put(name,this);
    }
}
