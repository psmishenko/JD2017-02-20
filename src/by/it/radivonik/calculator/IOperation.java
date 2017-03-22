package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 13.03.2017.
 */
public interface IOperation {
    public enum OperationType {
        Add, Sub, Mul, Div, Save};
    Var add(Var op1, Var op2) throws MathException;
    Var sub(Var op1, Var op2) throws MathException;
    Var mul(Var op1, Var op2) throws MathException;
    Var div(Var op1, Var op2) throws MathException;
    void save(String name, Var op) throws MathException;
}
