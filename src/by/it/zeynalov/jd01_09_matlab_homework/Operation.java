package by.it.zeynalov.jd01_09_matlab_homework;

public interface Operation {
    Var add(Var var) throws MathException;

    Var mul(Var var) throws MathException;

    Var div(Var var) throws MathException;

    Var sub(Var var) throws MathException;
}
