package by.it.radivonik.calculator;

import java.util.regex.*;

/**
 * Created by Radivonik on 19.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
        oneRes("3.8+6.2");
        oneRes("87.4-23.1");
        oneRes("1.04*5.9");
        oneRes("12.7*5");
        oneRes("-6+12");
        oneRes("-7*3.1");
        oneRes("-4/8");
        oneRes("-9-0.9");

//        String s = "-2.5-5+{-2.5,3.6,5}+{4,-5,0}+4.8";
//        Pattern p = Pattern.compile(IPatterns.ExExp);
//        Matcher m = p.matcher(s);
//        while (m.find()) {
//            System.out.println(m.group());
//        }
    }

    private static void oneRes(String exp, Var var) {
        System.out.printf("%s = %s\n",exp,var);
    }

    private static void oneRes(String exp) {
        oneRes(exp,Calc.calculate(exp));
    }
}
