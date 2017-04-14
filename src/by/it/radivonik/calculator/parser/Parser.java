package by.it.radivonik.calculator.parser;

import by.it.radivonik.calculator.exception.MathException;
import by.it.radivonik.calculator.exception.ParseException;
import by.it.radivonik.calculator.operation.IOperation;
import by.it.radivonik.calculator.operation.ListOperations;

import java.util.*;
import java.util.regex.*;

/**
 * Created by Radivonik on 17.03.2017.
 */
public class Parser {
    public String parseCalc(String exp) throws MathException, ParseException {
        Deque<String> varList = new LinkedList<>(); //
        Deque<String> opList = new LinkedList<>(); //

        Pattern p = Pattern.compile(ListOperations.getPattern());
        Matcher m = p.matcher(exp);

        int pos = 0;
        while (m.find()) {
            int s = m.start();
            if (s > pos) {
                String var = exp.substring(pos, s);
                varList.add(var);
            }
            pos = s + m.group().length();

            if (m.group().equals(ListOperations.getBracketLeft())) {
                opList.addLast(m.group());
            }
            else if (m.group().equals(ListOperations.getBracketRight())) {
                while (!opList.getLast().equals(ListOperations.getBracketLeft()))
                    parseCalcExecute(opList.removeLast(),varList);
                opList.removeLast();
            }
            else {
                IOperation operation = ListOperations.getOperation(m.group());
                while (!opList.isEmpty() &&
                        ListOperations.getPriority(opList.getLast()) > 0 &&
                        ListOperations.getPriority(opList.getLast()) >= operation.getPriority())
                    parseCalcExecute(opList.removeLast(),varList);
                opList.add(m.group());
            }
        }

        if (pos > 0 && pos < exp.length()) {
            String var = exp.substring(pos, exp.length());
            varList.add(var);
        }

        while (!opList.isEmpty())
            parseCalcExecute(opList.removeLast(),varList);

        return varList.getLast();
    }

    private void parceBrackets (String exp) throws MathException, ParseException {
        Pattern p = Pattern.compile(ListOperations.getPatternBrackets());
        Matcher m = p.matcher(exp);

        while (m.find()) {
            String expInBrackets;
            if (m.group().length() > 2) {
                expInBrackets = exp.substring(m.start() + 1, m.start() + m.group().length());
                expInBrackets = parseCalc(expInBrackets);
                //exp.r
            }
        }
    }

    private void parseCalcExecute(String op, Deque<String> varList) throws MathException, ParseException {
        IOperation operation = ListOperations.getOperation(op);
        varList.add(operation.execute(varList));
    }
}
