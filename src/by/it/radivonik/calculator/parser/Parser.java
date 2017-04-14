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
        String expCalc = parceBrackets(exp);

        Pattern p = Pattern.compile(ListOperations.getPattern());
        Matcher m = p.matcher(expCalc);

        int pos = 0;
        while (m.find()) {
            int s = m.start();
            if (s > pos) {
                String var = expCalc.substring(pos, s);
                varList.add(var);
            }
            pos = s + m.group().length();

            String strOp = m.group();
            IOperation operation = ListOperations.getOperation(strOp);
            while (!opList.isEmpty() &&
                    ListOperations.getPriority(opList.getLast()) > 0 &&
                    ListOperations.getPriority(opList.getLast()) >= operation.getPriority())
                parseCalcExecute(opList.removeLast(),varList);
            opList.add(strOp);
        }

        if (pos > 0 && pos < expCalc.length()) {
            String var = expCalc.substring(pos);
            varList.add(var);
        }

        while (!opList.isEmpty())
            parseCalcExecute(opList.removeLast(),varList);

        return varList.getLast();
    }

    private String parceBrackets(String exp) throws MathException, ParseException {
        StringBuilder res = new StringBuilder(exp);
        Pattern p = Pattern.compile(ListOperations.getPatternBrackets());

        while (true) {
            Matcher m = p.matcher(res);
            if (m.find()) {
                String strFound = m.group();
                String strReplace = "";
                if (strFound.length() > 2)
                    strReplace = parseCalc(res.substring(m.start() + 1, m.start() + strFound.length() - 1));
                res = new StringBuilder(res.substring(0,m.start()) + strReplace + res.substring(m.start() + strFound.length()));
            }
            else
                break;
        }
        return res.toString();
    }

    private void parseCalcExecute(String op, Deque<String> varList) throws MathException, ParseException {
        IOperation operation = ListOperations.getOperation(op);
        varList.add(operation.execute(varList));
    }
}
