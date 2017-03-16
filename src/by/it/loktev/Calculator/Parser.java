package by.it.loktev.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    ExpressionPart [] exprParts;
    int exprCount;

    public Parser() {
    }

    public Boolean parseString(String expr, boolean showDebug){

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
            boolean IsSubExprEnd=(lastPart!=null)&&lastPart.isSubExprEnd();

            //System.out.println("Разбор остатка строки: "+exprSB);

            // литералы значений могут идти только в начале субвыражений
            if (IsSubExprStart) {
                // в выражении может идти литерал матрицы - VarM
                Pattern pattVarM = Pattern.compile("^" + VarM.matrixRE);
                Matcher matchVarM = pattVarM.matcher(exprSB);
                if (matchVarM.find()) {
                    String literal = matchVarM.group();
                    //System.out.println("Обнаружен VarM: " + literal);
                    VarM varM = new VarM(literal);
                    //System.out.println("Построен VarM: " + varM);
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
                    String literal = matchOper2.group(1);
                    //System.out.println("Обнаружена бинарная операция: "+literal);
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
                    String literal = matchOper1Pref.group(1);
                    //System.out.println("Обнаружена унарная префиксная операция: "+literal);
                    Oper1Pref oper1Pref = new Oper1Pref(literal);
                    exprParts[exprCount++] = oper1Pref;
                    exprSB.delete(0, literal.length());
                    continue;
                }

            }

            new CalculatorError("невозможно распарсить остаток строки: "+exprSB);
            return false;
        }

        ExpressionPart lastPart=null;
        if ( exprCount>0 )
            lastPart=exprParts[exprCount-1];
        boolean IsSubExprEnd=lastPart.isSubExprEnd();
        if ( !IsSubExprEnd )
        {
          new CalculatorError("выражение окончилось неожиданно");
          return false;
        }

        if (showDebug) {
            System.out.println("Выражение распарсено:");
            showExprParts();
        }

        return true;
    }

    // вычисляет выражения [fromIndex,toIndex)
    public Var calculateFragment(int fromIndex, int toIndex, boolean showDebug) {

        // ищем унарные префиксные операторы, справа налево

        for ( int i=toIndex-1; i>=fromIndex; i-- ){
            ExpressionPart currPart=exprParts[i];
            if ( currPart.getPartType()==ExpressionPart.PartType.partOper1Pref ) {

                Oper1Pref currPartOper1Pref=(Oper1Pref)currPart;

                if (currPartOper1Pref.operation.equals("-")){ // унарный минус - изменение знака
                    ExpressionPart nextPart=exprParts[i+1];
                    if ( nextPart instanceof VarF ){
                        ((VarF)nextPart).neg();
                        System.arraycopy(exprParts,i+1,exprParts,i,exprCount-i-1);
                        exprCount--;
                        toIndex--;
                    }
                    else
                    {
                        new CalculatorError("унарный минус применим только к скалярам");
                        return null;
                    }
                }

                if (currPartOper1Pref.operation.equals("+")){ // унарный плюс - ничего не делает
                    ExpressionPart nextPart=exprParts[i+1];
                    if ( nextPart instanceof VarF ){
                        System.arraycopy(exprParts,i+1,exprParts,i,exprCount-i-1);
                        exprCount--;
                        toIndex--;
                    }
                    else
                    {
                        new CalculatorError("унарный плюс применим только к скалярам");
                        return null;
                    }
                }

            }
        }

        if (showDebug) {
            System.out.println("Отработали унарные префиксные операции:");
            showExprParts();
        }

        // ищем бинарные операторы умножения и деления, слева направо

        for ( int i=fromIndex; i<toIndex; i++ ){
            ExpressionPart currPart=exprParts[i];
            if ( currPart.getPartType()==ExpressionPart.PartType.partOper2 ) {
                Oper2 currPartOper2=(Oper2)currPart;

                if (currPartOper2.operation.equals("*")){ // умножение
                    ExpressionPart prevPart=exprParts[i-1];
                    ExpressionPart nextPart=exprParts[i+1];
                    if ( (prevPart instanceof Var) && (nextPart instanceof Var) ){
                        exprParts[i-1]=((Var)prevPart).mul(((Var)nextPart));
                        System.arraycopy(exprParts,i+2,exprParts,i,exprCount-i-2);
                        exprCount-=2;
                        toIndex-=2;
                        i--;
                    }
                    else
                    {
                        new CalculatorError("умножение применимо только к переменным");
                        return null;
                    }
                }

                if (currPartOper2.operation.equals("/")){ // деление
                    ExpressionPart prevPart=exprParts[i-1];
                    ExpressionPart nextPart=exprParts[i+1];
                    if ( (prevPart instanceof Var) && (nextPart instanceof Var) ){
                        exprParts[i-1]=((Var)prevPart).div(((Var)nextPart));
                        System.arraycopy(exprParts,i+2,exprParts,i,exprCount-i-2);
                        exprCount-=2;
                        toIndex-=2;
                        i--;
                    }
                    else
                    {
                        new CalculatorError("деление применимо только к переменным");
                        return null;
                    }
                }

            }
        }

        // ищем бинарные операторы сложения и вычитания, слева направо

        for ( int i=fromIndex; i<toIndex; i++ ){
            ExpressionPart currPart=exprParts[i];
            if ( currPart.getPartType()==ExpressionPart.PartType.partOper2 ) {
                Oper2 currPartOper2=(Oper2)currPart;

                if (currPartOper2.operation.equals("+")){ // сложение
                    ExpressionPart prevPart=exprParts[i-1];
                    ExpressionPart nextPart=exprParts[i+1];
                    if ( (prevPart instanceof Var) && (nextPart instanceof Var) ){
                        exprParts[i-1]=((Var)prevPart).add(((Var)nextPart));
                        System.arraycopy(exprParts,i+2,exprParts,i,exprCount-i-2);
                        exprCount-=2;
                        toIndex-=2;
                        i--;
                    }
                    else
                    {
                        new CalculatorError("сложение применимо только к переменным");
                        return null;
                    }
                }

                if (currPartOper2.operation.equals("-")){ // вычитание
                    ExpressionPart prevPart=exprParts[i-1];
                    ExpressionPart nextPart=exprParts[i+1];
                    if ( (prevPart instanceof Var) && (nextPart instanceof Var) ){
                        exprParts[i-1]=((Var)prevPart).sub(((Var)nextPart));
                        System.arraycopy(exprParts,i+2,exprParts,i,exprCount-i-2);
                        exprCount-=2;
                        toIndex-=2;
                        i--;
                    }
                    else
                    {
                        new CalculatorError("вычитание применимо только к переменным");
                        return null;
                    }
                }

            }
        }

        if (showDebug) {
            System.out.println("Отработали бинарные операции:");
            showExprParts();
        }

        if ( (exprCount!=1) || !(exprParts[0] instanceof Var) ) {
            new CalculatorError("выражение рассчитано не до конца");
            return null;
        }

        return (Var)exprParts[0];
    }

    public Var calculate(boolean showDebug) {
      return calculateFragment(0,exprCount,showDebug);
    }

    public void showExprParts(){
        for (int i = 0; i < exprCount; i++) {
            System.out.println(i+" / "+exprParts[i].getPartType().toString()+" / "+exprParts[i]);
        }
    }

    public static Var parseAndCalc(String str, boolean showDebug)
    {
        Parser parser=new Parser();
        if ( !parser.parseString(str,showDebug) )
            return null;
        Var V=parser.calculate(showDebug);
        return V;

    }

}
