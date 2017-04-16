package by.it.radivonik.calculator.operation;

import by.it.radivonik.calculator.exception.MathException;
import by.it.radivonik.calculator.exception.ParseException;

import java.util.Deque;

/**
 * Created by Radivonik on 13.03.2017.
 */
public interface IOperation {
    String getOperator();
    String getPattern();
    int getPriority();
    String execute(Deque<String> varQueue) throws MathException, ParseException;
}
