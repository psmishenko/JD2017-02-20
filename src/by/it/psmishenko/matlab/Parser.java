package by.it.psmishenko.matlab;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    static  final List<String> priority = new ArrayList<>(Arrays.asList("=,+,-,*,/".split(",")));
    private List<String> operation = new ArrayList<>();
    private List<String> operand;
    int getPosOperation(){
        int level = -1;
        int pos = -1;
        int i = 0;
        for (String op:operation){
            int curLevel = priority.indexOf(op);
            if(level<curLevel){
                level = curLevel;
                pos = i;
            }
            i++;
        }
        return pos;
    }
     Var createVar(String part) throws MathException {
        Var res;
        if (part.matches(Patterns.exMat)) {
            res = new VarM(part);
        } else if (part.matches(Patterns.exVec)) {
            res = new VarV(part);
        } else if (part.matches(Patterns.exVal)) {
            res = new VarF(part);
        } else res = Var.vars.get(part);
        return res;
    }
    Var oneOperationCalc (String v1, String op, String v2) throws MathException {
        Var res = null;
        Var one = createVar(v1);
        if(one == null&&!op.equals("=")) throw new MathException("");
        Var two = createVar(v2);
        // if
        // 1 operation
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

     Var calc(String expression)throws MathException {
        Var res = null;
        try {
        String[] part = expression.split(Patterns.exOper);
            operand = new ArrayList<>(Arrays.asList(part));
        Pattern p = Pattern.compile(Patterns.exOper);
        Matcher m = p.matcher(expression);
       // String op = "";
        while (m.find()) operation.add(m.group());
          while (operation.size()>0){
              int pos = getPosOperation();
              String v1 = operand.get(pos);
              String op = operation.remove(pos);
              String v2 = operand.remove(pos+1);
              res = oneOperationCalc(v1,op,v2);
              operand.set(pos,res.toString());
          }
            
            
            
            
            
            
            
            
            
            
            
            
    /*    Var one = createVar(part[0]);
        Var two = createVar(part[1]);
        // 1 operation
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
        }*/
        }catch (MathException e){
            System.out.println("Ошибка:"+e.getMessage());
            StackTraceElement[] st = e.getStackTrace();
            System.out.println("Stack:");
            for (StackTraceElement el:st) {
                System.out.printf("В классе \"%s\" ,в методе \"%s\" , в строке \"%s\"\n",
                        el.getClassName(),el.getMethodName(),el.getLineNumber());
                if(el.getMethodName().equals("main"))break;
            }
            System.out.println("----------------------------------------------------------------------------");
            try {
                IOData.saveErrorsInTxt(st,e.getMessage());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if(res!=null) IOData.saveOperationsInTxt(expression,res.toString());
        return res;
    }

}
