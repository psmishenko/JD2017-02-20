package by.it.loktev.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    ExpressionPart [] exprParts;
    int exprCount;

    public Parser() {
    }

    public void parseString(String expr){

        // распарсим строку выражения в массив частей выражения
        exprParts=new ExpressionPart[10000]; // мы пока коллекций не знаем, допустим что больше 10000 частей выражения не будет
        exprCount=0;

        StringBuffer exprSB=new StringBuffer(expr.trim());
        while ( exprSB.length()!=0 ){

            // чтобы определить, какие части выражения сейчас могут встретиться, установим, находимся ли мы сейчас
            // в начале подвыражения или в конце
            ExpressionPart lastPart=null;
            if ( exprCount>0 )
                lastPart=exprParts[exprCount-1];
            boolean IsSubExprStart=(lastPart==null)||lastPart.isSubExprStart();
            boolean IsSubExprEnd=(lastPart==null)||lastPart.isSubExprEnd();

            //System.out.println("Разбор остатка строки: "+exprSB);

            // литералы значений могут идти только в начале субвыражений
            if (IsSubExprStart) {
                // в выражении может идти литерал матрицы - VarM
                Pattern pattVarM = Pattern.compile("^" + VarM.matrixRE);
                Matcher matchVarM = pattVarM.matcher(exprSB);
                if (matchVarM.find()) {
                    String literal = matchVarM.group();
                    System.out.println("Обнаружен VarM: " + literal);
                    VarM varM = new VarM(literal);
                    System.out.println("Построен VarM: " + varM);
                    exprParts[exprCount++] = varM;
                    exprSB.delete(0, literal.length());
                    continue;
                }

                // в выражении может идти литерал вектора - VarV
                Pattern pattVarV = Pattern.compile("^" + VarV.vectorRE);
                Matcher matchVarV = pattVarV.matcher(exprSB);
                if (matchVarV.find()) {
                    String literal = matchVarV.group();
                    //System.out.println("Обнаружен VarV: "+literal);
                    VarV varV = new VarV(literal);
                    //System.out.println("Построен VarV: "+varV);
                    exprParts[exprCount++] = varV;
                    exprSB.delete(0, literal.length());
                    continue;
                }

                // в выражении может идти литерал числа - VarF
                Pattern pattVarF = Pattern.compile("^" + VarF.doubleRE);
                Matcher matchVarF = pattVarF.matcher(exprSB);
                if (matchVarF.find()) {
                    String literal = matchVarF.group();
                    //System.out.println("Обнаружен VarF: "+literal);
                    VarF varF = new VarF(literal);
                    //System.out.println("Построен VarF: "+varF);
                    exprParts[exprCount++] = varF;
                    exprSB.delete(0, literal.length());
                    continue;
                }
            }

            // бинарные операции могут идти только в после субвыражений
            if (IsSubExprEnd) {

                Pattern pattOper2 = Pattern.compile("^" + Oper2.oper2RE);
                Matcher matchOper2 = pattOper2.matcher(exprSB);
                if (matchOper2.find()) {
                    String literal = matchOper2.group();
                    System.out.println("Обнаружена бинарная операция: "+literal);
                    Oper2 oper2 = new Oper2(literal);
                    exprParts[exprCount++] = oper2;
                    exprSB.delete(0, literal.length());
                    continue;
                }

            }

            // унарные префиксные операции могут идти только до субвыражений
            if (IsSubExprStart) {

                Pattern pattOper1Pref = Pattern.compile("^" + Oper1Pref.oper1PrefRE);
                Matcher matchOper1Pref = pattOper1Pref.matcher(exprSB);
                if (matchOper1Pref.find()) {
                    String literal = matchOper1Pref.group();
                    System.out.println("Обнаружена унарная префиксная операция: "+literal);
                    Oper1Pref oper1Pref = new Oper1Pref(literal);
                    exprParts[exprCount++] = oper1Pref;
                    exprSB.delete(0, literal.length());
                    continue;
                }

            }

            new CalculatorError("невозможно распарсить остаток строки: "+exprSB);
            break;
        }

    }

    public void showExprParts(){
        for (int i = 0; i < exprCount; i++) {
            System.out.println(i+" / "+exprParts[i].getPartType().toString()+" / "+exprParts[i]);
        }
    }

}
