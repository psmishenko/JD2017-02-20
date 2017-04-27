package by.it.Zyryanov.jd01_13.homework;




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
                values.add(Math.sqrt(value));
                Double sum = 0.0;
                for (Double val:values){
                    sum = sum + val;
                }
                System.out.printf("Сумма корней sum=%f\n", sum);
            }
            catch (NumberFormatException e) {
                System.out.printf("Ошибка ввода строки %s\n", str);
            }
            catch (ArithmeticException e){
                System.out.println("Арифметическая ошибка" + e.getMessage());
                StackTraceElement [] st = e.getStackTrace();
                System.out.println("Stack: ");
                for (StackTraceElement el:st){
                    System.out.printf("источник класс: \"%s файл: \"%s\" строка \"d%",
                            el.getClassName(),
                            el.getFileName(),
                            el.getLineNumber());
                }
            }
        }


    }
}
