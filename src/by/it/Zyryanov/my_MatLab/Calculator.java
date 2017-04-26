package by.it.Zyryanov.my_MatLab;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

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


    private Var oneOperationCalc(String v1, String op, String v2) throws Exception {    //throws MathExcepton
        Var res = null;
        Var one = VarFactory.getInstance().createVar(v1);
        Var two = VarFactory.getInstance().createVar(v2);
        if (op.equals("=") && two != null) {
            two.save(v1);
            return two;
        }
        //иначе проверим переменные на существование
        if (one == null)
            throw new Exception("Неизвеcтное значение " + v1);
        if (two == null)
            throw new Exception("Неизвеcтное значение " + v2);
        //и выполним арифметическую операцию
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


    Var calculate(String expression) {
        Var res = null;
        try {
            //получим операнды
            String[] part = expression.split(Expressions.OPERATION);
            operand = new ArrayList<>(Arrays.asList(part));
            //получим операции
            Pattern p = Pattern.compile(Expressions.OPERATION);
            Matcher m = p.matcher(expression);
            while (m.find()) operation.add(m.group());
            if (debugOn) System.out.printf("\tDEBUG: %s operand=%s operation=%s\n", expression, operand, operation);
            //пока есть операции найдем позицию приоритетной и выполним её
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
            Singleton.getInstance().errorLogger("Ошибка! (123  строка Calculator)");
        }
        Printer.print2(Var.varMap);
        return res;
    }


    private void debug() {
        StringBuilder sb = new StringBuilder("\t\tdebug: " + operand.get(0));
        for (int i = 0; i < operation.size(); i++) {
            sb.append(operation.get(i)).append(operand.get(i + 1));
        }
        System.out.println(sb.toString());
    }


    enum Debug {
        ON, OFF
    }

    private boolean debugOn;

    public Calculator(Debug debugStatus) {
        this.debugOn = debugStatus == Debug.ON;
    }

    public Calculator() {
        this(Debug.OFF);
    }

}
