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

}
