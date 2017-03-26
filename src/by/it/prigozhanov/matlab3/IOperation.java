package by.it.prigozhanov.matlab3;

public interface IOperation {
    Var add(Var var);
    Var sub(Var var);
    Var mul(Var var);
    Var div(Var var);
    void save(String name);
}
