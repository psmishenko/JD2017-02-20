package by.it.smirnov.jd02_04_matlab.Vars;

import by.it.smirnov.jd02_04_matlab.Error.MatLabException;
import by.it.smirnov.jd02_04_matlab.Parser.Patterns;

import java.util.regex.Pattern;

/**
 * Абстрактный класс переменной
 */
public abstract class Var implements IVariable, IOperation {
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
