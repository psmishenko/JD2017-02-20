package by.it.smirnov.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aleksey.smirnov on 22.03.2017.
 */
public class TaskA {
    /**
     * Функция:
     *  открывает консоль;
     *  считывает данные из консоли построчно;
     *  переводит каждую строку в число и выводит в консоль данное число и сумму корней всех
     *   ранее введенных чисел, включая введенное;
     *  если перевести ввод в число невозможно или невозможно извлечь корень, то программа
     *   обрабатывает ошибку и показывает на русском языке соответствующее сообщение в
     *   консоли;
     *  закрывается при вводе в консоль слова END.
     * @version 1.0.0
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> values = new ArrayList<>();
        String str = "";
        while (!(str=scanner.nextLine()).equals("END")) {
            try {
                Double value = Double.parseDouble(str);
                if (value<0) throw new ArithmeticException("Отрицательное значение");
                values.add( Math.sqrt(value));
                Double sum = 0.0;
                for (Double val:values) sum = sum + val;
                System.out.printf("Сумма корней sum = %f%n", sum);
            } catch ( NumberFormatException e) {
                System.out.printf("Некорректный ввод строки %s%n", str);
            }
            catch ( ArithmeticException e) {
                System.out.println("Ошибка: " + e.getMessage());
                for (StackTraceElement el : e.getStackTrace()) {
                    System.out.printf("В классе \"%s\" в файле \"%s\" в строке \"%d\" возникла ошибка: %s%n",
                            el.getFileName(),el.getMethodName(),el.getLineNumber(), e.getMessage());
                    if (el.getMethodName().equals("main")) break;
                }
            }
        }

    }
}
