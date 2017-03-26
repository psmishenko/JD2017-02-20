package by.it.vedom.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> values = new ArrayList<>();
        String str;
        while (!(str = scanner.nextLine()).equalsIgnoreCase("END")) {
            try {
                Double value = Double.parseDouble(str);
                if(value < 0) throw new ArithmeticException("Отрицательное значение корня");
                //в values будут накапливаться все ранее введенные значения (формируем коллекцию)
                values.add(Math.sqrt(value));
                Double sum = 0.0;
                for (Double val: values) {
                    sum = sum +  val;
                }
                System.out.printf("Сумма корней sum = %f\n", sum);

            }
            catch (NumberFormatException e) {
                System.out.printf("Некорректный ввод строки: %s\n", str);
            } catch (ArithmeticException e) {
                System.out.printf("Арифметическая ошибка: %s\n", e.getMessage());
                StackTraceElement[] st = e.getStackTrace();
                System.out.println("Stack:");
                for (StackTraceElement el: st) {
                    System.out.printf("Источник класс: \"%s\" в файл \"%s\" строка \"%d\"",
                            el.getClassName(),
                            el.getFileName(),
                            el.getLineNumber());

                    if(el.getMethodName().equals("main")) break;
                }

            }
            //System.out.println("\nРазмер коллекции равен " + values.size());
        }
    }
}
