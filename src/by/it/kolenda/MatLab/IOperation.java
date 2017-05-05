package by.it.kolenda.MatLab;


public interface IOperation {
    Var add(Var var) throws Error;
    Var sub(Var var) throws Error;
    Var mul(Var var) throws Error;
    Var div(Var var) throws Error;
    void save(String name);
}
