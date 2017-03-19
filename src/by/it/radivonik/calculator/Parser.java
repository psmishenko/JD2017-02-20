package by.it.radivonik.calculator;

import java.util.regex.*;

/**
 * Created by Radivonik on 17.03.2017.
 */
public class Parser {
    public static String[] parse(String exp) {
        String[] res = new String[3];
        Pattern p = Pattern.compile(IPatterns.ExExp);
        Matcher m = p.matcher(exp);
        int i = 0;
        while (m.find() && i < res.length) {
            if (i == 1 && m.group().charAt(0) == '-' && m.group().length() > 1 ) {
                res[i] = "-";
                res[++i] =  m.group().substring(1);
            }
            else
                res[i] = m.group();
            i++;
        }
        return res;
    }

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
