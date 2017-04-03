package by.it.vedom.Calculator;

public interface IOperation {
    Var add(Var arg) throws  MathExeption;
    Var sub(Var arg) throws  MathExeption;
    Var mul(Var arg) throws  MathExeption;
    Var div(Var arg) throws  MathExeption;
    void save(String name);
}
