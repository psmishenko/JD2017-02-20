package by.it.loktev.Calculator;

public interface IVariable {

    String toString();

    void fromString(String str) throws CalculatorException;

    String serialize();
    void unserialize(String s) throws CalculatorException;

}
