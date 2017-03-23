package by.it.loktev.Calculator;

public interface IOperation {

    Var add(Var arg) throws CalculatorException;
    Var mul(Var arg) throws CalculatorException;
    Var div(Var arg) throws CalculatorException;
    Var sub(Var arg) throws CalculatorException;

    //Var assign(Var arg);

}
