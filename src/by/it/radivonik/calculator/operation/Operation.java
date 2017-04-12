package by.it.radivonik.calculator.operation;

import by.it.radivonik.calculator.exception.MathException;
import by.it.radivonik.calculator.exception.ParseException;

/**
 * Created by Radivonik on 18.03.2017.
 */
public class Operation implements IOperation {
    private String operator;
    private IOperation.Type type;
    private int priority;

    public Operation(String operator, Type type, int priority) {
        this.operator = operator;
        this.type = type;
        this.priority = priority;
    }

    @Override
    public String getOperator() {
        return operator;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String calc(String... args) throws MathException, ParseException {
        return Operations.calc(this,args);
    }
}
