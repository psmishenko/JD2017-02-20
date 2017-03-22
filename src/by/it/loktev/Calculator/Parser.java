package by.it.loktev.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    static public String assignRE=" *([a-zA-Z]+) *= *";
    static public String varNameRE=" *([a-zA-Z]+) *";

    ExpressionPart [] exprParts;
    int exprCount;
    int capacity;

    public Parser() {
        capacity=0;
        exprParts=null;
        exprCount=0;
    }

    public boolean parseString(StringBuffer exprSB, boolean showDebug) throws CalculatorException {

        // распарсим строку выражения в массив частей выражения

        exprCount=0;

        while ( exprSB.length()!=0 ){

            if (exprCount==capacity){
                capacity=capacity*2+5;
                ExpressionPart [] newExprParts=new ExpressionPart[capacity];
                if (exprCount>0)
                  System.arraycopy(exprParts,0,newExprParts,0,exprCount);
                exprParts=newExprParts;
                //System.out.println("!!! mem");
            }

            // чтобы определить, какие части выражения сейчас могут встретиться, установим, находимся ли мы сейчас
            // в начале подвыражения или в конце
            ExpressionPart lastPart=null;
            if ( exprCount>0 )
                lastPart=exprParts[exprCount-1];
            boolean IsSubExprStart=(lastPart==null)||lastPart.isSubExprStart();
            boolean IsSubExprEnd=(lastPart!=null)&&lastPart.isSubExprEnd();

            //System.out.println("Разбор остатка строки: "+exprSB);

            // имена переменных могут идти только в начале субвыражений
            if (IsSubExprStart) {
                Pattern pattVarName = Pattern.compile("^" + varNameRE);
                Matcher matchVarName = pattVarName.matcher(exprSB);
                if (matchVarName.find()) {
                    String varName = matchVarName.group(1);
                    //System.out.println("Обнаружен VarM: " + literal);
                    //VarM varM = new VarM(literal);
                    //System.out.println("Построен VarM: " + varM);
                    if (!Storage.isExist(varName)){
                        throw new CalculatorException("переменная "+varName+" не найдена в хранилище");
                    }
                    exprParts[exprCount++] = Storage.restore(varName);
                    exprSB.delete(0, matchVarName.group(0).length());
                    continue;
                }
            }

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
                    exprSB.delete(0, matchOper2.group(0).length());
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
                    exprSB.delete(0, matchOper1Pref.group(0).length());
                    continue;
                }

            }

            // скобки ожидаем всегда, хоть можно и умнее
            {

                Pattern pattBracket = Pattern.compile("^" + Bracket.bracketRE);
                Matcher matchBracket = pattBracket.matcher(exprSB);
                if (matchBracket.find()) {
                    String literal = matchBracket.group(1);
                    //System.out.println("Обнаружена скобка: "+literal);
                    Bracket bracket= new Bracket(literal);
                    exprParts[exprCount++] = bracket;
                    exprSB.delete(0, matchBracket.group(0).length());
                    continue;
                }

            }

            throw new CalculatorException("невозможно распарсить остаток строки: "+exprSB);
        }

        ExpressionPart lastPart=null;
        if ( exprCount>0 )
            lastPart=exprParts[exprCount-1];
        boolean IsSubExprEnd=lastPart.isSubExprEnd();
        if ( !IsSubExprEnd )
        {
          throw new CalculatorException("выражение окончилось неожиданно");
        }

        if (showDebug) {
            System.out.println("Выражение распарсено:");
            showExprParts();
        }

        return true;
    }

    // вычисляет выражения [fromIndex,toIndex)
    public Var calculateFragment(int fromIndex, int toIndex, boolean showDebug) throws CalculatorException {

        if ( showDebug )
        {
            System.out.println("Рассчитываем фрагмент:");
            showExprParts(fromIndex,toIndex);
        }

        // ищем фрагменты в скобках

        // ищем слева направо первую же правую скобку
        boolean continueBrackets=true;
        while (continueBrackets){
            continueBrackets=false;

            for ( int R=fromIndex; R<toIndex; R++ ){
                ExpressionPart rightPart=exprParts[R];
                if ( (rightPart.getPartType()==ExpressionPart.PartType.partBracket) && (((Bracket)rightPart).bracket.equals(")")) )
                {
                    // правая скобка найдена, влево от неё ищем соответствующую левую
                    for ( int L=R-1; L>=fromIndex; L-- )
                    {
                        ExpressionPart leftPart=exprParts[L];
                        if ( (leftPart.getPartType()==ExpressionPart.PartType.partBracket) && (((Bracket)leftPart).bracket.equals("(")) )
                        {
                            // левая скобка найдена, фрагмент [L+1,R-1) не имеет скобок
                            if ( showDebug )
                            {
                                System.out.println("Найдены скобки, рекурсия...");
                            }
                            Var bracketsRes=calculateFragment(L+1,R,showDebug);
                            if ( showDebug )
                            {
                                System.out.println("Результат расчёта скобок: "+bracketsRes);
                                System.out.println("Полное выражение после расчёта скобок:");
                                showExprParts();
                            }
                            // exprParts уже изменилось, exprCount уменьшилось, R указывает некорректно
                            exprParts[L]=bracketsRes;
                            System.arraycopy(exprParts,L+3,exprParts,L+1,exprCount-L-1);
                            exprCount-=2; // только на скобку
                            toIndex-=(R-L);
                            if ( showDebug )
                            {
                                System.out.println("Полное выражение после удаления скобок:");
                                showExprParts();
                            }
                            continueBrackets=true;
                            break;
                        }

                    }

                }
                if ( continueBrackets ) // левая для этой правой уже отработана, надо всё начать сначала, т.к. exprParts изменилось
                    break;
            }

        };


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
                        throw new CalculatorException("унарный минус применим только к скалярам");
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
                        throw new CalculatorException("унарный плюс применим только к скалярам");
                    }
                }

            }
        }

        if (showDebug) {
            System.out.println("Отработали унарные префиксные операции:");
            showExprParts(fromIndex, toIndex);
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
                        throw new CalculatorException("умножение применимо только к переменным");
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
                        throw new CalculatorException("деление применимо только к переменным");
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
                        throw new CalculatorException("сложение применимо только к переменным");
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
                        throw new CalculatorException("вычитание применимо только к переменным");
                    }
                }

            }
        }

        if (showDebug) {
            System.out.println("Отработали бинарные операции:");
            showExprParts(fromIndex, toIndex);
        }

        if ( (toIndex-fromIndex!=1) || !(exprParts[fromIndex] instanceof Var) ) {
            throw new CalculatorException("выражение рассчитано не до конца");
        }

        return (Var)exprParts[fromIndex];
    }

    /*
    public Var calculate(boolean showDebug) {
      return calculateFragment(0,exprCount,showDebug);
    }
    */

    public void showExprParts(int fromIndex, int toIndex){
        for (int i = fromIndex; i < toIndex; i++) {
            System.out.println(i+" / "+exprParts[i].getPartType().toString()+" / "+exprParts[i]);
        }
    }

    public void showExprParts(){
        showExprParts(0,exprCount);
    }

    public static Var parseAndCalc(String str2, boolean showDebug)
    {
        if (str2.equals("printvar")){
            Storage.print();
            return null;
        }
        if (str2.equals("sortvar")){
            Storage.printSort();
            return null;
        }

        StringBuffer exprSB=new StringBuffer(str2.trim());

        String assignToVarName=null;

        // если это присваивание - сразу получим имя переменной и нужное значение
        Pattern pattAssign = Pattern.compile("^" + Parser.assignRE);
        Matcher matchAssign = pattAssign.matcher(exprSB);
        if (matchAssign.find()) {
            assignToVarName = matchAssign.group(1);
            //VarM varM = new VarM(literal);
            //System.out.println("Построен VarM: " + varM);
            //exprParts[exprCount++] = varM;
            //System.out.println(matchAssign.group(0));
            exprSB.delete(0, matchAssign.group(0).length());
            //System.out.println(exprSB);
            //System.out.println(exprSB);
            //Var assignRes=parseAndCalc(exprSB.toString(),showDebug);
            //Storage.store(varName,assignRes);
            //System.out.println("Присваивание: " + varName+" "+assignRes);
            //return true;
        }

        Parser parser=new Parser();

        Var V=null;

        try {
            if (!parser.parseString(exprSB, showDebug)) {
                return null;
            }
            //Var V=parser.calculate(showDebug);
            V=parser.calculateFragment(0,parser.exprCount,showDebug);
            if ( V==null )
                return null;
        }
        catch ( CalculatorException e )
        {
            System.out.println("Исключение в парсере: "+e);
            return null;
        }


        if (assignToVarName!=null) {
            Storage.store(assignToVarName, V);
            //if (showDebug)
              //System.out.println("Присваивание: " + assignToVarName+" "+V);
            return null;
        }

        return V;

    }

}
