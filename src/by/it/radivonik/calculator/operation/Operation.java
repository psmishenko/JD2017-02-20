package by.it.radivonik.calculator.operation;

import by.it.radivonik.calculator.exception.MathException;
import by.it.radivonik.calculator.exception.ParseException;

import java.util.Deque;

/**
 * Created by Radivonik on 18.03.2017.
 */
public class Operation implements IOperation {
    private String operator;
    private String pattern;
    private int priority;
    private IOperationExecute executor;

    public Operation(String operator, String pattern, int priority, IOperationExecute executor) {
        this.operator = operator;
        this.pattern = pattern;
        this.priority = priority;
        this.executor = executor;
    }

    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public String getPattern() {
        return pattern;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String execute(Deque<String> varQueue) throws MathException, ParseException {
        return executor.executeOperation(this,varQueue);
    }
}
