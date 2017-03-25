package by.it.vedom.Calculator;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements IOperation, IVariable {

    static public Map<String,Var> vars=new HashMap<>();

    @Override
    public Var div(Var arg) throws MathExeption {
        throw new MathExeption("Операция деления невозможна");
    }

    @Override
    public Var mul(Var arg) throws MathExeption {
        throw new MathExeption("Операция умножения невозможна");
    }

    @Override
    public Var sub(Var arg) throws MathExeption {
        throw new MathExeption("Операция вычитания невозможна");
    }

    @Override
    public Var add(Var arg) throws MathExeption{
        throw new MathExeption("Операция сложения невозможна");
    }

    @Override
    public void save(String name) {
        vars.put(name,this);
    }
}
