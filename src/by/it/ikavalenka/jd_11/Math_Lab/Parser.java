package by.it.ikavalenka.jd_11.Math_Lab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by USER on 17.03.2017.
 */
public class Parser {

    static Var createVar(String par) {
        Var res;
        if (par.matches(Patterns.exMat)) {
            res = new VarM(par);
        } else if (par.matches(Patterns.exVec)) {
            res = new VarV(par);
        } else if (par.matches(Patterns.exVal)) {
            res = new VarF(par);
        } else
            res = null;
        return res;
    }

    static Var cals(String expression) {
        Var res = null;
        String[] part = expression.split(Patterns.exOper);
        Pattern p = Pattern.compile(Patterns.exOper);
        Matcher m = p.matcher(expression);
        String op = "";
        if (m.find()) {
            op = m.group();
        }
        Var one = createVar(part[0]);
        Var two = createVar(part[1]);
        // execution of one operation
        if (op.equals("=")) {
            two.save(part[0]);
            res = two;

        } else if (op.equals("+")) {
            res = one.add(two);
        } else if (op.equals("-")) {
            res = one.sub(two);
        } else if (op.equals("*")) {
            res = one.mul(two);
        } else if (op.equals("/")) {
            res = one.div(two);
        }
        return res;
    }
}

