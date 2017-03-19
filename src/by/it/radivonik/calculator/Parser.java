package by.it.radivonik.calculator;

import java.util.regex.*;

/**
 * Created by Radivonik on 17.03.2017.
 */
public class Parser {
    public static Var createVar(String part) {
        Var res = null;
        if (part.matches(IPatterns.ExNumber)) {
            res = new VarFloat(part);
        }
        else if (part.matches(IPatterns.ExVector)) {
            res = new VarVector(part);
        }
        else if (part.matches(IPatterns.exMatrix)) {
            res = new VarMatrix(part);
        };
        return res;
    }

    static Var calc (String exp) {
        Var res = null;

        String[] part = exp.split(IPatterns.ExOper);
        Pattern p = Pattern.compile(IPatterns.ExOper);
        Matcher m = p.matcher(exp);
        String op = "";
        if (m.find()) {
            op = m.group();
        }

        Var one = createVar(part[0]);
        Var two = createVar(part[1]);
/*
        if (op.equals("=")) {
            two.save(part[0]);
            res = two;
        }
        else if (op.equals("+")) {
            res = one.add(two);
        }
        else if (op.equals("-")) {
            res = one.sub(two);
        }
        else if (op.equals("*")) {
            res = one.mul(two);
        }
        else if (op.equals("/")) {
            res = one.div(two);
        }
*/
        return res;
    }
}
