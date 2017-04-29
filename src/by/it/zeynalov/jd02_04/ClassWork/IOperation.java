package by.it.zeynalov.jd02_04.ClassWork;

public interface IOperation {
    Var add(Var var) throws MathExcepton;
    Var sub(Var var) throws MathExcepton;
    Var mul(Var var) throws MathExcepton;
    Var div(Var var) throws MathExcepton;
    void save(String name);
}
