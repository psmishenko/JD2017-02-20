package by.it.radivonik.calculator.parser;

import by.it.radivonik.calculator.exception.MathException;
import by.it.radivonik.calculator.exception.ParseException;
import by.it.radivonik.calculator.operation.IOperation;
import by.it.radivonik.calculator.operation.Operation;
import by.it.radivonik.calculator.operation.Operations;

import java.util.*;
import java.util.regex.*;

/**
 * Created by Radivonik on 17.03.2017.
 */
public class Parser {
    public String parseCalc(String exp) throws MathException, ParseException {
        Deque<String> varList = new LinkedList<>(); //
        Deque<Operation> opList = new LinkedList<>(); //

        Pattern p = Pattern.compile(Operations.getPattern());
        Matcher m = p.matcher(exp);

        int pos = 0;
        while (m.find()) {
            int s = m.start();
            if (s > pos) {
                String var = exp.substring(pos, s);
                varList.add(var);
            }
            pos = s + m.group().length();

            Operation operation = Operations.getOperation(m.group());
            if (operation.getType() == IOperation.Type.BracketLeft) {
                opList.add(operation);
            }
            else if (operation.getType() == IOperation.Type.BracketRight) {
                while (opList.getLast().getType() != IOperation.Type.BracketLeft)
                    parseCalcProccess(varList, opList.removeLast());
                opList.removeLast();
            }
            else {
                while (!opList.isEmpty() && opList.getLast().getPriority() > 0 && opList.getLast().getPriority() >= operation.getPriority())
                    parseCalcProccess(varList, opList.removeLast());
                opList.add(operation);
            }
        }

        if (pos > 0 && pos < exp.length()) {
            String var = exp.substring(pos, exp.length());
            varList.add(var);
        }

        while (!opList.isEmpty())
            parseCalcProccess(varList, opList.removeLast());

        return varList.getLast();
    }

    private void parseCalcProccess(Deque<String> varList, Operation op) throws MathException, ParseException {
       switch(op.getType()) {
            case NoArg:
                varList.add(op.calc());
                break;
            case TwoArg:
                String v2 = varList.removeLast();
                String v1 = varList.removeLast();
                varList.add(op.calc(v1, v2));
                break;
        }
    }
}
