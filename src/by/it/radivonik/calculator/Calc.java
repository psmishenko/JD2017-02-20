package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 18.03.2017.
 */
public class Calc {
    public static Var calculate (String exp) {
        Var res = null;
        Operation op = new Operation();
        String[] aop = Parser.parse(exp);

        if (aop[1].equals("+")) {
            res = op.add(Parser.createVar(aop[0]),Parser.createVar(aop[2]));
        }
        else if (aop[1].equals("-")) {
            res = op.sub(Parser.createVar(aop[0]),Parser.createVar(aop[2]));
        }
        else if (aop[1].equals("*")) {
            res = op.mul(Parser.createVar(aop[0]),Parser.createVar(aop[2]));
        }
        else if (aop[1].equals("/")) {
            res = op.div(Parser.createVar(aop[0]),Parser.createVar(aop[2]));
        }
        else if (aop[1].equals("=")) {
            op.save(aop[0],Parser.createVar(aop[2]));
        }

        return res;
    }
}
