package by.it.smirnov.jd01_13_matlab.Parser;

import by.it.smirnov.jd01_13_matlab.Error.MatLabException;
import by.it.smirnov.jd01_13_matlab.Vars.Var;
import by.it.smirnov.jd01_13_matlab.Storage.IStorage;
import by.it.smirnov.jd01_13_matlab.Streams.IStream;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.smirnov.jd01_09.Parser.Patterns.exAny;
import static by.it.smirnov.jd01_09.Parser.Patterns.exOper;

/**
 * Класс парсера
 */
public class Parser {
    private IStream inputStream;
    private IStream outputStream;
    private IStorage storage;
    private boolean debug = false;

    public Parser(IStream inputStream, IStream outputStream, IStorage storage){
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.storage = storage;
    }

    public Parser(IStream inputStream, IStream outputStream, IStorage storage, boolean debug){
        this(inputStream, outputStream, storage);
        this.debug = debug;
    }

    /**
     * Функция вывода строки на консоль
     * @param x строка
     */
    private void print(String x) {
        if (debug) System.out.println(x);
    }

    /**
     * Функция расчета формулы из входного потока и вывод на консоль
     */
    public void calculateAndPrint() {
        calculate();
        print();
    }

    /**
     * Функция расчета выражения
     * @param expression выражение
     * @return Var
     */
    private Var calcExpression (String expression) throws MatLabException {
        StringBuilder formula = new StringBuilder(expression);
        Var[] vars;
        String[] opers;

        Pattern pAny = Pattern.compile(exAny);
        Pattern pOper = Pattern.compile(exOper);
        Matcher m=pAny.matcher(formula);

        int countArg = 0;
        while (m.find()) countArg++;

        vars = new Var[countArg];
        opers = new String[countArg-1];

        int i = 0;
        int endPos = 0;
        m.reset();

        while(m.find()){
            vars[i] = Var.getVar(m.group());
            print("Операнд : "+m.group());
            formula.delete(0,m.end());
            m = pOper.matcher(formula);
            if(m.find()) {
                opers[i] = m.group();
                print("Знак : "+opers[i]);
                formula.delete(0,m.end());
            }
            m = pAny.matcher(formula);
            i++;
        }

        Var result = vars[0];
        for (int j = 1; j < vars.length; j++) {
            Var var = vars[j];
            switch (opers[j-1].charAt(0)) {
                case '+': result = result.add(var);  break;
                case '-': result = result.sub(var);  break;
                case '*': result = result.mul(var);  break;
                case '/': result = result.div(var);  break;
            }
        }
        return result;
    }

    /**
     * Функция расчета равенства
     * @param expression выражение
     */
    private void calcAssignment(String expression) throws MatLabException {
        String[] operands = expression.split("=");
        String key = operands[0];
        Var value= calcExpression(operands[1]);
        storage.setMap(key, value);
    }

    /**
     * Функция выполнения вычисления
     */
    public void calculate() {
        outputStream.set(null);
        inputStream.load();
        String expression = inputStream.get();
        try {
            print("Выражение: "+expression);
            Pattern p = Pattern.compile(Patterns.exFull);
            if (p.matcher(expression).matches()) {// является ли строка формулой
                Var result = calcExpression(expression);
                print("Результат : "+result);
                outputStream.set(result.toString());
            } else {
                p = Pattern.compile(Patterns.exAssign);
                if (p.matcher(expression).matches()) {// является ли присвоением
                    print("Присваивание");
                    calcAssignment(expression);
                    outputStream.set(expression);
                } else {
                    p = Pattern.compile(Patterns.exPrintVar);
                    if (p.matcher(expression).matches()) {// печать списка
                        print("Печать списка созданных в ходе присваивания переменных:");
                        outputStream.set(storage.getListKey());
                    } else {
                        p = Pattern.compile(Patterns.exSortVar);
                        if (p.matcher(expression).matches()) {// печать отсортированного списка
                            print("Печать списка имен и значений переменных (имя при этом сортируется по алфавиту методами коллекций):");
                            outputStream.set(storage.getSortListKeyValue());
                        } else {
                            throw new MatLabException("Строка: "+expression+" не является формулой");
                        }
                    }
                }
            }
        } catch (MatLabException e) {
            System.out.println("Ошибка калькулятора: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
            for (StackTraceElement el : e.getStackTrace()) {
                System.out.printf("В классе \"%s\" в файле \"%s\" в строке \"%d\" возникла ошибка: %s%n",
                        el.getFileName(), el.getMethodName(), el.getLineNumber(), e.getMessage());
                if (el.getMethodName().equals("main")) break;
            }
        }
    }

    public void print() {
        outputStream.save();
    }

}
