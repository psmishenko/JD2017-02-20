package by.it.akhmelev.jd02_04.matlab_classwork;

public interface IOperation {
    Var add(Var var) throws MathExcepton;
    Var sub(Var var) throws MathExcepton;
    Var mul(Var var) throws MathExcepton;
    Var div(Var var) throws MathExcepton;
    void save(String name);
}
