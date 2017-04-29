package by.it.zeynalov.jd02_06.TaskB;

public interface Operation {
    Var add(Var var) throws MathException;

    Var mul(Var var) throws MathException;

    Var div(Var var) throws MathException;

    Var sub(Var var) throws MathException;
}
