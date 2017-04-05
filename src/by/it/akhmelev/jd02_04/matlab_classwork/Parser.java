package by.it.akhmelev.jd02_04.matlab_classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


    private static final List<String> priority = new ArrayList<>(Arrays.asList("=,+,-,*,/".split(",")));
    private List<String> operation = new ArrayList<>();
    private List<String> operand;

    int getPosOperation() {
        int level = -1;
        int pos = -1;
        int i = 0;
        for (String op : operation) {
            int currentLevel = priority.indexOf(op);
            if (level < currentLevel) {
                level = currentLevel;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    Var oneOperationCalc(String v1, String op, String v2) throws MathExcepton {
        //            //выполним одну операцию
        Var res = null;
        Var one = createVar(v1);
        if (one == null && (!op.equals("=")))
            throw new MathExcepton("Неизвеcтное значение " + v1);
        Var two = createVar(v2);
        if (two == null)
            throw new MathExcepton("Неизвеcтное значение " + v2);
        if (op.equals("=")) {
            two.save(v1);
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

    Var createVar(String part) {
        Var res;
        if (part.matches(Patterns.exMat)) {
            res = new VarM(part);
        } else if (part.matches(Patterns.exVec)) {
            res = new VarV(part);
        } else if (part.matches(Patterns.exVal)) {
            res = new VarF(part);
        } else
            res = Var.vars.get(part);
        return res;
    }

    private void debug() {
        StringBuilder sb = new StringBuilder(operand.get(0));
        for (int i = 0; i < operation.size(); i++) {
            sb.append(operation.get(i)).append(operand.get(i + 1));
        }
        System.out.println(sb.toString());
    }

    Var calc(String expression) {
        Var res = null;
        try {
            String[] part = expression.split(Patterns.exOper);
            operand = new ArrayList<>(Arrays.asList(part));
            Pattern p = Pattern.compile(Patterns.exOper);
            Matcher m = p.matcher(expression);
            while (m.find()) {
                operation.add(m.group());
            }

//            System.out.println(expression);
//            System.out.println(operand);
//            System.out.println(operation);

            while (operation.size() > 0) {
                //debug();
                int pos = getPosOperation();
                String v1 = operand.get(pos);
                String op = operation.remove(pos);
                String v2 = operand.remove(pos + 1);
                res = oneOperationCalc(v1, op, v2);
                operand.set(pos, res.toString());
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return res;
    }
}
