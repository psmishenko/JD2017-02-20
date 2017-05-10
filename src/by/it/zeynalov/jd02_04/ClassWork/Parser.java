package by.it.zeynalov.jd02_04.ClassWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final List<String> priority = new ArrayList<>(Arrays.asList("=,+,-,*,/".split(",")));
    private List<String> operation = new ArrayList<>();
    private List<String> operand;

    private int getPosOperation() {
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

    private Var oneOperationCalc(String v1, String op, String v2) throws MathExcepton {
        Var res = null;
        Var one = createVar(v1);
        Var two = createVar(v2);
        if (op.equals("=") && two!=null) {
            two.save(v1);
            return two;
        }
        if (one == null)
            throw new MathExcepton("Неизвеcтное значение " + v1);
        if (two == null)
            throw new MathExcepton("Неизвеcтное значение " + v2);
        switch (op) {
            case "+":
                res = one.add(two);
                break;
            case "-":
                res = one.sub(two);
                break;
            case "*":
                res = one.mul(two);
                break;
            case "/":
                res = one.div(two);
                break;
        }
        return res;
    }

    private Var createVar(String part) {
        Var res;
      if (part.matches(Patterns.exVec)) {
            res = new VarV(part);
        } else if (part.matches(Patterns.exVal)) {
            res = new VarF(part);
        } else
            res = Var.vars.get(part);
        return res;
    }

    Var calc(String expression) {
        Var res = null;
        try {
            String[] part = expression.split(Patterns.exOper);
            operand = new ArrayList<>(Arrays.asList(part));
            Pattern p = Pattern.compile(Patterns.exOper);
            Matcher m = p.matcher(expression);
            while (m.find()) operation.add(m.group());
            if (debugOn) System.out.printf("\tDEBUG: %s operand=%s operation=%s\n",expression,operand,operation);
            while (operation.size() > 0) {
                if (debugOn) debug();
                int pos = getPosOperation();
                String v1 = operand.get(pos);           //прочитаем первый операд (не удаляя, т.к. сюда запишем результат)
                String op = operation.remove(pos);      //прочитаем операцию удаляя ее
                String v2 = operand.remove(pos + 1);    //прочитаем второй операнд удаляя его
                res = oneOperationCalc(v1, op, v2);
                operand.set(pos, res.toString());       //сохраним результат
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return res;
    }

    private void debug() {
        StringBuilder sb = new StringBuilder("\t\tdebug: "+operand.get(0));
        for (int i = 0; i < operation.size(); i++) {
            sb.append(operation.get(i)).append(operand.get(i + 1));
        }
        System.out.println(sb.toString());
    }

    enum Debug{
        ON,OFF
    }
    private boolean debugOn;

    public Parser(Debug debugStatus) {
        this.debugOn = debugStatus==Debug.ON;
    }

    public Parser() {
        this(Debug.OFF);
    }
}
