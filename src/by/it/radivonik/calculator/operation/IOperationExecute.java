package by.it.radivonik.calculator.operation;

import by.it.radivonik.calculator.exception.MathException;
import by.it.radivonik.calculator.exception.ParseException;

import java.util.Deque;

/**
 * Created by Radivonik on 13.04.2017.
 */
public interface IOperationExecute {
    String executeOperation(IOperation op, Deque<String> varQueue) throws MathException, ParseException;
}
