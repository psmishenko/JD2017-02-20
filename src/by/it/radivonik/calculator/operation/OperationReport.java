package by.it.radivonik.calculator.operation;

import by.it.radivonik.calculator.exception.*;
import by.it.radivonik.calculator.report.*;

import java.util.Deque;

/**
 * Created by Radivonik on 14.04.2017.
 */
public class OperationReport implements IOperationExecute {
    private static OperationReport operation = new OperationReport();

    public static OperationReport getOperation() {
        return operation;
    }

    @Override
    public String executeOperation(IOperation op, Deque<String> varQueue) throws MathException, ParseException {
        String res = null;
        switch (op.getOperator()) {
            case "reportlog":
                res = Report.report(new ReportLog());
                break;
            case "reportmini":
                res = Report.report(new ReportMini());
                break;
        }
        return res;
    }
}
