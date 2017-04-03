package by.it.tereshko.matlab;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements IOperation, IVariable {

    static public Map<String, Var> vars = new HashMap<>();

    @Override
    public Var add(Var var) throws MathException {
        throw new MathException("Addition operation is impossible");
    }

    @Override
    public Var sub(Var var) throws MathException {
        throw new MathException("Subtraction operation is impossible");
    }

    @Override
    public Var mul(Var var) throws MathException {
        throw new MathException("Multiplication operation is impossible");
    }

    @Override
    public Var div(Var var) throws MathException {
        throw new MathException("Division operation is impossible");
    }

    @Override
    public void save(String name) {
        vars.put(name, this);
    }
}
