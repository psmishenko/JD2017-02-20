package by.it.zeynalov.jd01_13;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> values = new ArrayList<>();
        String str = ""; //с помощью String читаем строку
        while (!(str = scanner.nextLine()).equals("END")) {
            try {
                Double value = Double.parseDouble(str);
                values.add(Math.sqrt(value));
                if (value < 0) throw new ArithmeticException("Отрицательное значение корня");
                Double sum = 0.0;
                for (Double val : values) {
                    sum += val;
                }
                System.out.printf("Сумма корней sum=%f\n", sum);
            } catch (NumberFormatException e) {
                System.out.printf("Некорректный ввод строки %s\n", str);
            } catch (ArithmeticException e) {
                System.out.printf("Арифметическая ошибка %s\n", e.getMessage());
                StackTraceElement[] st = e.getStackTrace();
                System.out.println("Stack:");
                for (StackTraceElement el : st) {
                    System.out.printf("В классе \"%s\" в файле \"%s\" в строке \"%d\n",
                            el.getClassName(),
                            el.getFileName(),
                            el.getLineNumber());
                    if (el.getMethodName().equals("main")) {
                        break;
                    }
                }
            }
        }
    }
}

