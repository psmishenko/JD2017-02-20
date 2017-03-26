package by.it.radivonik.jd01_13;

import java.util.*;

/**
 * Created by Radivonik on 22.03.2017.
 * Класс, реализующий задания Варианта A
 */
public class TaskA {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        List<Double> values = new ArrayList<>();
        String str;

        try {
            System.out.println("Вводите числа (END - окончание ввода):");
            while (!(str = scanner.nextLine()).toUpperCase().equals("END")) {
                try {
                    Double value = Double.parseDouble(str);
                    if (value < 0)
                        throw new ArithmeticException("Число не может быть отрицательным");
                    values.add(Math.sqrt(value));
                    Double sum = 0.0;
                    for (Double val : values) {
                        sum += val;
                    }
                    System.out.printf("Сумма корней = %f\n", sum);
                } catch (NumberFormatException e) {
                    System.out.printf("Некорректное число: %s\n", str);
                } catch (ArithmeticException e) {
                    System.out.printf("Арифметическая ошибка: %s\n", e.getMessage());
                    StackTraceElement[] eSt = e.getStackTrace();
                    System.out.printf("Стек ошибок:\n");
                    for (StackTraceElement el : eSt) {
                        System.out.printf(
                                "Ошибка произошла: в классе '%s', в файле '%s', в методе '%s', в строке '%d'\n",
                                el.getClassName(), el.getFileName(), el.getMethodName(), el.getLineNumber());
                    }
                }
            }
        }
        finally {
            if (scanner != null)
                scanner.close();
        }
    }
}
