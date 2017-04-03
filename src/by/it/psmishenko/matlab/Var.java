package by.it.psmishenko.matlab;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class Var implements IOperation,IVariable {
    static public Map<String,Var> vars = new HashMap<>();

    @Override
    public void save(String name) {
        vars.put(name,this);
        try {
            IOData.saveVarInTxt(name,vars.get(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Var add(Var var) throws MathException {
        new MathException("Операция сложения невозможна");
        return null;
    }

    @Override
    public Var sub(Var var) throws MathException {
        new MathException("Операция вычитания невозможна");
        return null;
    }

    @Override
    public Var mul(Var var) throws MathException {
        new MathException("Операция умножения невозможна");
        return null;
    }

    @Override
    public Var div(Var var) throws MathException {
        new MathException("Операция деления невозможна");
        return null;
    }

}
