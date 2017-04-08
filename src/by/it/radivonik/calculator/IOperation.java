package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 13.03.2017.
 */
public interface IOperation {
    enum Type {BracketLeft, BracketRight, NoArg, OneArg, TwoArg};
    String getOperator();
    Type getType();
    int getPriority();
    String calc(String... args) throws MathException, ParseException;
}
