package by.it.prigozhanov.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by v-omf on 3/22/2017!
 */
public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> values = new ArrayList<>();
        String str;
        Double sum = 0D;
        while (!(str=scanner.nextLine()).equalsIgnoreCase("END")) {
             try {
                 Double value = Double.parseDouble(str);
                 if (value < 0) throw new ArithmeticException("Отрицательное значение");
                 values.add(Math.sqrt(value));
                 System.out.println(values);
                 for (Double val : values) {
                     sum += val;
                 }
                 System.out.printf("Сумма корней sum= %f\n", sum);
             }
             catch (NumberFormatException e) {
                 System.out.printf("Некорректный ввод строки: %s\n", e.getMessage());
             }
             catch (ArithmeticException e) {
                 System.out.printf("Арифметическая ошибка: %s\n", e.getMessage());
                 StackTraceElement[] st = e.getStackTrace();
                 System.out.println("Stack: ");
                 for (StackTraceElement el : st) {
                     System.out.printf("Источник:\n В классе \"%s\"\n В файле \"%s\"\n В строке \"%d\"", el.getClassName(), el.getFileName(), el.getLineNumber());
                     if (el.getMethodName().equals("main")) break;
                 }
             }


        }


    }
}
