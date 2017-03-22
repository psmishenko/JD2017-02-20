package by.it.loktev.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner scanner=null;
        try {
            scanner=new Scanner(System.in);
            List<Double> values = new ArrayList<>();
            String str = "";
            while (!(str = scanner.nextLine()).equals("END")) {
                try {
                    Double value = Double.parseDouble(str);
                    if (value < 0)
                        throw new ArithmeticException("отрицательное подкоренное выражение");
                    //System.out.println(value);
                    values.add(Math.sqrt(value));
                    //System.out.println(values);
                    double Summa = 0;
                    for (Double val : values) {
                        Summa += val;
                    }
                    System.out.println("Сумма корней: " + Summa);
                } catch (NumberFormatException e) {
                    System.out.printf("Некорректный ввод строки %s\n", str);
                } catch (ArithmeticException e) {
                    System.out.printf("Арифметическая ошибка: " + e.getMessage());
                    StackTraceElement [] st=e.getStackTrace();
                    System.out.println("\nСтек:");
                    for ( StackTraceElement el : st ){
                        System.out.println(el.getFileName()+" "+el.getMethodName()+" "+el.getLineNumber());
                    }
                }
            }
        }
        finally {
          if ( scanner!=null ){
              System.out.println("закрываем сканер");
              scanner.close();
          }
        }
    }

}
