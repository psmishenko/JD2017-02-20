package by.it.smirnov.jd01_13_matlab.Vars;

import by.it.smirnov.jd01_13_matlab.Error.MatLabException;
import by.it.smirnov.jd01_13_matlab.Parser.Patterns;

import java.util.regex.Pattern;

/**
 * Абстрактный класс переменной
 */
public abstract class Var implements IVariable, IOperation {
    public static Var getVar(String x) throws MatLabException{
        Pattern p = Pattern.compile(Patterns.exMat);
        if (p.matcher(x).matches()) {
            return new VarM(x);
        } else {
            p = Pattern.compile(Patterns.exVec);
            if (p.matcher(x).matches()) {
                return new VarV(x);
            } else {
                return new VarF(x);
            }
        }
    }

    @Override
    public Var add(Var var) throws MatLabException {
        throw new MatLabException("Операция add не реализована");
    }

    @Override
    public Var sub(Var var) throws MatLabException {
        throw new MatLabException("Операция sub не реализована");
    }

    @Override
    public Var mul(Var var) throws MatLabException {
        throw new MatLabException("Операция mul не реализована");
    }

    @Override
    public Var div(Var var) throws MatLabException {
        throw new MatLabException("Операция div не реализована");
    }
}
