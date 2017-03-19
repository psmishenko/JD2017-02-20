package by.it.smirnov.jd01_09.Vars;

import by.it.smirnov.jd01_09.Vars.Var;

/**
 * Created by aleksey.smirnov on 13.03.2017.
 */
public interface IOperation {
    Var add(Var var);
    Var sub(Var var);
    Var mul(Var var);
    Var div(Var var);
}
