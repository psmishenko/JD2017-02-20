package by.it.prigozhanov.my_matlab;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by v-omf on 4/13/2017!
 */
public class Calculator {
    public Logger logger = Logger.getLogger();

    protected static Var defineVar(String part) {
        Var res;
        if (part.matches(Expressions.MATRIX)) {
            res = new VarMatrix(part);
        } else if (part.matches(Expressions.VALUE)) {
            res = new VarValue(part);
        } else if (part.matches(Expressions.VECTOR)) {
            res = new VarVector(part);
        } else if (part.matches(Expressions.VARIABLE)) {
            if (ValueSaver.loadedMap.size()==0) {
                ValueSaver.uploadFromFile();
            }
           res = ValueSaver.loadedMap.get(part);
        } else res = null;
        return res;
    }

    private static Var defineOperation(Var first, Var second, String operation) throws MatlabException {
        Var res;
        if (operation.equals("+")) {
            res = first.add(second);
        } else if (operation.equals("-")) {
            res = first.sub(second);
        } else if (operation.equals("*")) {
            res = first.mul(second);
        } else if (operation.equals("/")) {
            res = first.div(second);
        } else res = null;
        return res;
    }

    private static void defineOperation(String expression) {
        String op = "";
        String[] part = expression.split(Expressions.OPERATION);
        Pattern p = Pattern.compile(Expressions.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            op = m.group();
        }
        if (op.equals("=")) {
            Var value = defineVar(part[1]);
            value.save(part[0], value);
        }

    }

    protected static Var calculate(String expression) {
        defineOperation(expression);
        Var res = null;
        String op = "";
        String[] part = expression.split(Expressions.OPERATION);
        Pattern p = Pattern.compile(Expressions.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            op = m.group();
        }
        Var first = defineVar(part[0]);
        Var second = defineVar(part[1]);
        try {
            res = defineOperation(first, second, op);
        } catch (MatlabException e) {
            Logger.getLogger().logError(e.getMessage(), e, false);
            System.out.println("Ошибка: " + e.getMessage());
        }
        return res;
    }
}
