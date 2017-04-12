package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 12.04.2017.
 */
public class VarCreator {
    private static VarCreator instance;

    private VarCreator() {

    }

    static VarCreator getInstance() {
        if (instance == null)
            instance = new VarCreator();
        return instance;
    }

    Var create(String str) throws ParseException {
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
