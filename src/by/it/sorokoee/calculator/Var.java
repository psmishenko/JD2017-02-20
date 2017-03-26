package by.it.sorokoee.calculator;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements IOperation,IVariable {
    static public Map<String,Var> vars=new HashMap<>();

    @Override
    public void save(String name) {
        vars.put(name,this);
    }

    @Override
    public Var add(Var var) throws MathException {
        throw
        new MathException("Операция сложения невозможна");

    }

    @Override
    public Var sub(Var var)throws MathException {
        throw new MathException("Операция вычитания невозможна");

    }

    @Override
    public Var mul(Var var)throws MathException {
        throw new MathException("Операция умножения невозможна");

    }

    @Override
    public Var div(Var var)throws MathException {
         throw new MathException("Операция деления невозможна");

    }
}
