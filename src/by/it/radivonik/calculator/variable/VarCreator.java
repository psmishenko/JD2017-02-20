package by.it.radivonik.calculator.variable;

import by.it.radivonik.calculator.exception.ParseException;
import by.it.radivonik.calculator.parser.IPatterns;

/**
 * Created by Radivonik on 12.04.2017.
 */
public class VarCreator {
    private static VarCreator creator = new VarCreator();

    private VarCreator() {

    }

    public static VarCreator getCreator() {
        return creator;
    }

    public Var create(String str) throws ParseException {
        if (str == null)
            throw new ParseException("Пустая строка при создании пременной");
        Var res;
        if (str.matches(IPatterns.ExMatrix))
            res = new VarMatrix(str);
        else if (str.matches(IPatterns.ExVector))
            res = new VarVector(str);
        else if (str.matches(IPatterns.ExNumber))
            res = new VarFloat(str);
        else
            res = Var.getVar(str);
        return res;

    }
}
