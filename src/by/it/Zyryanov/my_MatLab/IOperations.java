package by.it.Zyryanov.my_MatLab;


public interface IOperations {

    Var add(Var var);
    Var sub(Var var); //subtraction
    Var mul(Var var);
    Var div(Var var);
    void save(String name); // HashMap

}
