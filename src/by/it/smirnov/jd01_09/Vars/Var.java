package by.it.smirnov.jd01_09.Vars;

import by.it.smirnov.jd01_09.Error.Error;
import by.it.smirnov.jd01_09.Parser.Patterns;

import java.util.regex.Pattern;

/**
 * Created by aleksey.smirnov on 13.03.2017.
 */
public abstract class Var implements IVariable, IOperation {
    public static Var getVar(String x) {
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
    public Var add(Var var) {
        new Error("Операция add не реализована");
        return null;
    }

    @Override
    public Var sub(Var var) {
        new Error("Операция sub не реализована");
        return null;
    }

    @Override
    public Var mul(Var var) {
        new Error("Операция mul не реализована");
        return null;
    }

    @Override
    public Var div(Var var) {
        new Error("Операция div не реализована");
        return null;
    }
}
