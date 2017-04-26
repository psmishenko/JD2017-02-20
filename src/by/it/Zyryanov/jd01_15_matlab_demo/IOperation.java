package by.it.Zyryanov.jd01_15_matlab_demo;

public interface IOperation {
    Var add(Var var) throws MathExcepton;
    Var sub(Var var) throws MathExcepton;
    Var mul(Var var) throws MathExcepton;
    Var div(Var var) throws MathExcepton;
    void save(String name);
}
