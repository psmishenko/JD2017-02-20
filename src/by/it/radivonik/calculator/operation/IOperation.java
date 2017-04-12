package by.it.radivonik.calculator.operation;

import by.it.radivonik.calculator.exception.MathException;
import by.it.radivonik.calculator.exception.ParseException;

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
