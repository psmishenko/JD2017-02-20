package by.it.radivonik.calculator.operation;

import by.it.radivonik.calculator.exception.MathException;
import by.it.radivonik.calculator.exception.ParseException;
import by.it.radivonik.calculator.variable.Var;
import by.it.radivonik.calculator.variable.VarCreator;

import java.util.Deque;

/**
 * Created by Radivonik on 13.04.2017.
 */
public class OperationStore implements IOperationExecute {
    private static OperationStore operation = new OperationStore();

    public static OperationStore getOperation() {
        return operation;
    }

    @Override
    public String executeOperation(IOperation op, Deque<String> varQueue) throws MathException, ParseException {
        String res = null;
        switch (op.getOperator()) {
            case "=":
                String v2 = varQueue.removeLast();
                String v1 = varQueue.removeLast();
                res = Var.setVar(v1,v2).toString();
                break;
            case "printvar":
                res = Var.getPrintVar();
                break;
            case "sortvar":
                res = Var.getSortVar();
                break;
        }
        return res;
    }
}
