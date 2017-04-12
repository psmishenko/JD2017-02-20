package by.it.radivonik.calculator;

import by.it.radivonik.calculator.exception.MathException;
import by.it.radivonik.calculator.exception.ParseException;
import by.it.radivonik.calculator.log.Log;
import by.it.radivonik.calculator.parser.Parser;

/**
 * Created by Radivonik on 18.03.2017.
 */
public class Calc {
    public static String calculate(String exp) {
        String res = null;
        try {
            res = (new Parser()).parseCalc(exp);
        }
        catch (MathException e) {
            System.out.println("Ошибка математическая: " + e.getMessage());
            Log.getLog().write(e);
        }
        catch (ParseException e) {
            System.out.println("Ошибка преобразования: " + e.getMessage());
            Log.getLog().write(e);
        }
        catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            Log.getLog().write(e);
        }

        return res;
    }

    static void calculatePrint(String exp) {
        calculatePrint(exp,Calc.calculate(exp),false);
    }

    static void calculatePrint(String exp, boolean newLineResult) {
        calculatePrint(exp,Calc.calculate(exp),newLineResult);
    }

    private static void calculatePrint(String exp, String val, boolean newLineResult) {
        System.out.printf("%s =%s%s\n",exp,(newLineResult?"\n":" "),val);
    }

}
