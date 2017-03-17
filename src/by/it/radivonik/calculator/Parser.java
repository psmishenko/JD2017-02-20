package by.it.radivonik.calculator;

import java.util.regex.*;

/**
 * Created by Radivonik on 17.03.2017.
 */
public class Parser {
    static Var createVar(String part) {
        Var res;
        if (part.matches(IPatterns.exMat)) {
            res = new VarMatrix(part);
        }
        else if (part.matches(IPatterns.exVec)) {
            res = new VarVector(part);
        }
        else if (part.matches(IPatterns.exVal)) {
            res = new VarFloat(part);
        }
        else
            res = null;
        return res;
    }

    static Var calc (String exp) {
        Var res = null;

        String[] part = exp.split(IPatterns.exOper);
        Pattern p = Pattern.compile(IPatterns.exOper);
        Matcher m = p.matcher(exp);
        String op = "";
        if (m.find()) {
            op = m.group();
        }

        Var one = createVar(part[0]);
        Var two = createVar(part[1]);

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

        return res;
    }
}
