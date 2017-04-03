package by.it.kolenda.MatLab;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    static Var createVar(String part) {
        Var res = null;

        if (part.matches(Patterns.exMat)) {
            res = new VarM(part);
        } else if (part.matches(Patterns.exVec)) {
            res = new VarV(part);
        } else if (part.matches(Patterns.exVal)) {
            res = new VarF(part);
        } else res = null;
        return res;
    }

    static Var calc(String expression) {
        Var res = null;
        try{

        String operation="";
        String[] part = expression.split(Patterns.exOper);
        Pattern p = Pattern.compile(Patterns.exOper);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            operation = m.group();
        }
        Var one = createVar(part[0]);
        Var two = createVar(part[1]);

        if (operation.equals("=")) {
            two.save(part[0]);
            res = two;
        } else if (operation.equals("+")) {
            res = one.add(two);
        } else if (operation.equals("-")) {
            res = one.sub(two);
        } else if (operation.equals("*")) {
            res = one.mul(two);
        } else if (operation.equals("/")) {
            res = one.div(two);
        }
        }
        catch (Error e){
                System.out.println("Error"+e.getMessage());
        }
        return res;

    }
}


