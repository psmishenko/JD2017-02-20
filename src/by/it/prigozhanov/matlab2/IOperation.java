package by.it.prigozhanov.matlab2;

public interface IOperation {
    Var add(Var var) throws MathExeption;
    Var sub(Var var) throws MathExeption;
    Var mul(Var var) throws MathExeption;
    Var div(Var var) throws MathExeption;
}
