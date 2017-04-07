package by.it.smirnov.jd02_04_matlab.Parser;

import by.it.smirnov.jd02_04_matlab.Error.MatLabException;
import by.it.smirnov.jd02_04_matlab.Log.ILog;
import by.it.smirnov.jd02_04_matlab.Storage.IStorage;
import by.it.smirnov.jd02_04_matlab.Streams.IStream;
import by.it.smirnov.jd02_04_matlab.Vars.Var;
import by.it.smirnov.jd02_04_matlab.Vars.VarF;
import by.it.smirnov.jd02_04_matlab.Vars.VarM;
import by.it.smirnov.jd02_04_matlab.Vars.VarV;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс парсера
 */
public class Parser {
    private static IStream inputStream;
    private static IStream outputStream;
    private static IStorage storage;
    private static ILog log;

    private final Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            put("=", 0);
            put("-", 1);
            put("+", 1);
            put("*", 2);
            put("/", 2);
        }
    };
    private List<String> operation = new ArrayList<>();
    private List<String> operand;

    public Parser(IStream inputStream, IStream outputStream, IStorage storage, ILog log) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.storage = storage;
        this.log = log;
    }


    /**
     * Функция вывода строки в лог
     * @param x строка
     */
    private void print(String x) {
        log.debug(x);
    }

    /**
     * Функция расчета формулы из входного потока и вывод на консоль
     */
    public void calculateAndPrint() {
        calculate();
        print();
    }

    /**
     * Функция вычисления позиции следующей операции в соответствии с приоритетом операций
     * @return позиция
     */
    int getPosOperation() {
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

    /**
     * Функция разбиения строки на операнды и операции
     * @param expression строка
     */
    private void parsingExpression(String expression) {
        Var res = null;
        try {
            String[] part = expression.split(Patterns.exOper);
            operand = new ArrayList<>(Arrays.asList(part));
            Pattern p = Pattern.compile(Patterns.exOper);
            Matcher m = p.matcher(expression);
            while (m.find()) {
                operation.add(m.group());
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Функция преобразования строки в Var
     * @param x строка
     * @return Var
     */
    public static Var getVar(String x) throws MatLabException {
        Pattern p = Pattern.compile(Patterns.exMat);
        if (p.matcher(x).matches()) {
            return new VarM(x);
        } else {
            p = Pattern.compile(Patterns.exVec);
            if (p.matcher(x).matches()) {
                return new VarV(x);
            } else {
                p = Pattern.compile(Patterns.exVal);
                if (p.matcher(x).matches()) {
                    return new VarF(x);
                } else {
                    if (storage!=null)
                        return storage.getValue(x);
                    else
                        return null;
                }
            }
        }
    }

    /**
     * Функция расчета операции
     * @param v1 левый операнд
     * @param v2 правый операнд
     * @param op операция
     * @return Var
     */
    Var oneOperationCalc(String v1, String op, String v2) throws MatLabException {
        Var result = null;
        Var one = getVar(v1);
        if (one == null && (!op.equals("=")))
            throw new MatLabException("Неизвеcтное значение " + v1);
        Var two = getVar(v2);
        if (two == null)
            throw new MatLabException("Неизвеcтное значение " + v2);
        switch (op.charAt(0)) {
            case '+': result = one.add(two);  break;
            case '-': result = one.sub(two);  break;
            case '*': result = one.mul(two);  break;
            case '/': result = one.div(two);  break;
            case '=': result = two;
                if (storage!=null) storage.setMap(v1, two);
            break;
        }
        return result;
    }

    /**
     * Функция расчета выражения
     * @param expression выражение
     * @return Var
     */
    public Var calcExpression (String expression) throws MatLabException {
        Var result = null;
        Bracket bracket = null;
        do {
            bracket = Brackets.getPart(expression);
            if (bracket.getPart().length()>0) {
                //Var var = calcExp(bracket.getPart());
                Var var = calcExpThread(bracket.getPart());
                StringBuilder sb = new StringBuilder(expression);
                sb.delete(bracket.getLeftPos(),bracket.getRightPos()+1);
                sb.insert(bracket.getLeftPos(), var);
                expression = sb.toString();
                //System.out.println(expression);
            }

        } while (bracket.getPart().length()>0);

        parsingExpression(expression);

        while (operation.size() > 0) {
            int pos = getPosOperation();
            String v1 = operand.get(pos);
            String op = operation.remove(pos);
            String v2 = operand.remove(pos + 1);
            result = oneOperationCalc(v1, op, v2);
            operand.set(pos, result.toString());
        }
        return result;
    }

    /**
     * Функция обычной рекурсии для calcExpression
     * @param expression выражение
     * @return Var
     */
    private Var calcExp(String expression) throws MatLabException {
        return calcExpression(expression);
    }

    /**
     * Функция рекурсии через Callable для calcExpression
     * @param expression выражение
     * @return Var
     */
    private Var calcExpThread(String expression) throws MatLabException {
        final String part=expression;
        Callable<Var> procCall= new Callable<Var>(){
            @Override
            public Var call() throws Exception {
                return calcExpression(part);
            }
        };
        FutureTask<Var> task = new FutureTask<>(procCall);
        Thread thread = new Thread(task);
        thread.start();
        Var var = null;
        try {
            var = task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return var;
    }

    /**
     * Функция выполнения вычисления
     */
    public void calculate() {
        outputStream.set(null);
        inputStream.load();
        String[] arrExpression = inputStream.get().split("\n");
        try {
            for (String expression : arrExpression) {
                Pattern p = Pattern.compile(Patterns.exPrintVar);
                if (p.matcher(expression).matches()) {// печать списка
                    print("Печать списка созданных в ходе присваивания переменных:");
                    outputStream.set(storage.getListKey());
                } else {
                    p = Pattern.compile(Patterns.exSortVar);
                    if (p.matcher(expression).matches()) {// печать отсортированного списка
                        print("Печать списка имен и значений переменных (имя при этом сортируется по алфавиту методами коллекций):");
                        outputStream.set(storage.getSortListKeyValue());
                    } else {
                        Var result = calcExpression(expression);
                        print("Результат : "+result);
                        outputStream.set(result.toString());
                        //throw new MatLabException("Строка: "+expression+" не является формулой");
                    }
            }
            }
        } catch (MatLabException e) {
            log.error("Ошибка калькулятора: " + e.getMessage());
        } catch (Exception e) {
            log.error("Неизвестная ошибка: " + e.getMessage());
            for (StackTraceElement el : e.getStackTrace()) {
                log.error(String.format("В классе \"%s\" в файле \"%s\" в строке \"%d\" возникла ошибка: %s%n",
                        el.getFileName(), el.getMethodName(), el.getLineNumber(), e.getMessage()));
                if (el.getMethodName().equals("main")) break;
            }
        }
    }

    public void print() {
        outputStream.save();
    }

}
