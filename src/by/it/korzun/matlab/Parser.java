package by.it.korzun.matlab;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private static Map<String, Integer> priority = new HashMap<>();
    static {
        priority.put("*", 3);
        priority.put("/", 3);
        priority.put("+", 2);
        priority.put("-", 2);
        priority.put("=", 1);
    }

    private List<String> operation = new ArrayList<>();
    private List<String> operand;

    private void resultOut(String expression, Var res){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Var.path + "log.txt", true))){
            System.out.printf("%s\n", res.toString());
            bw.write(expression + " = " + res.toString() + "\n");
        }catch (IOException ignored){

        }
    }

    private Var calcString(String expression){
        Var res = null;
        try {
            String[] part = expression.split(Patterns.exOper);
            operand = new ArrayList<>(Arrays.asList(part));
            Pattern p = Pattern.compile(Patterns.exOper);
            Matcher m = p.matcher(expression);
            while (m.find()) {
                operation.add(m.group());
            }

            while (operation.size() > 0) {
                int pos = getPosOperation();
                String v1 = operand.get(pos);
                String op = operation.remove(pos);
                String v2 = operand.remove(pos + 1);
                res = oneOperationCalc(v1, op, v2);
                operand.set(pos, res.toString());
            }

        }catch (MathException e){
            new MathException(expression + " - неверное выражение");
        }
        return res;
    }

    private Var oneOperationCalc(String v1, String op, String v2) throws MathException{
        Var res = null;
        Var one = compileToVar(v1);
        if (one == null && (!op.equals("="))) {
            throw new MathException("Неизвеcтное значение " + v1);
        }
        Var two = compileToVar(v2);
        if (two == null) {
            throw new MathException("Неизвеcтное значение " + v2);
        }
        switch (op) {
            case "=":
                two.save(v1);
                res = two;
                break;
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

    private int getPosOperation() {
        int level = -1;
        int pos = -1;
        int i = 0;
        for (String op : operation) {
            int currentLevel = priority.get(op);
            if (level < currentLevel) {
                level = currentLevel;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    private Var compileToVar(String str) {
        Var v;
        if (str.matches(Patterns.exVal)) {
            v = new VarF(str);
        } else if (str.matches(Patterns.exVec)) {
            v = new VarV(str);
        } else if (str.matches(Patterns.exMat)) {
            v = new VarM(str);
        } else {
            v = Var.getVars().get(str);
        }
        return v;
    }

    Var parseString(String expression, boolean isFirstOut) throws MathException{
        Var res;
        Var temp;
        if(!BracketsChecker.check(expression)){
            new MathException(expression + " - скобки расставлены неправильно");
        }

        Pattern patternBrackets = Pattern.compile("[()]");
        Matcher matcherBrackets = patternBrackets.matcher(expression);
        int posOpen = -1;
        String underBrackets;

        while(matcherBrackets.find()){
            if(expression.charAt(matcherBrackets.start()) == '('){
                posOpen = matcherBrackets.start() + 1;
            }
            if(expression.charAt(matcherBrackets.start()) == ')'){
                underBrackets = expression.substring(posOpen, matcherBrackets.start());
                temp = calcString(underBrackets);
                expression = expression.replace("(" + underBrackets + ")", temp.toString());
                matcherBrackets = patternBrackets.matcher(expression);
                matcherBrackets.reset();
            }
        }

        res = calcString(expression);

        if(!isFirstOut){
            resultOut(expression, res);
        }

        return res;
    }
}
