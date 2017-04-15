package by.it.prigozhanov.jd02_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by v-omf on 4/13/2017!
 */
public class Calculator {
    public Logger logger = Logger.getLogger();

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
            Var value = VarFactory.createVar(part[1]);
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
        Var first = VarFactory.createVar(part[0]);
        Var second = VarFactory.createVar(part[1]);
        try {
            res = defineOperation(first, second, op);
        } catch (MatlabException e) {
            System.out.println("Ошибка: " + e.getMessage());
            Logger.getLogger().logError(e, false);
        }
        return res;
    }
}
