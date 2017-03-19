package by.it.radivonik.calculator;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Radivonik on 18.03.2017.
 */
public class Calc {
    public static String calculate (String exp) {
        Operation op = new Operation();
        String[] aop = Parser.parse(exp);

        if (aop[0].equals("printvar")) {
            return Var.vars.toString();
        }
        else if (aop[0].equals("sortvar")) {
            SortedMap<String,Var> varsSorted = new TreeMap<>(Var.vars);
            return varsSorted.toString();
        }
        else if (aop[1].equals("+")) {
            return op.add(Parser.createVar(aop[0]),Parser.createVar(aop[2])).toString();
        }
        else if (aop[1].equals("-")) {
            return op.sub(Parser.createVar(aop[0]),Parser.createVar(aop[2])).toString();
        }
        else if (aop[1].equals("*")) {
            return op.mul(Parser.createVar(aop[0]),Parser.createVar(aop[2])).toString();
        }
        else if (aop[1].equals("/")) {
            return op.div(Parser.createVar(aop[0]),Parser.createVar(aop[2])).toString();
        }
        else if (aop[1].equals("=")) {
            Var v = Parser.createVar(aop[2]);
            op.save(aop[0],v);
            return v.toString();
        }

        return null;
    }
}
