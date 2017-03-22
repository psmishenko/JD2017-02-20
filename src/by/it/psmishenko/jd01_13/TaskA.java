package by.it.psmishenko.jd01_13;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 22.03.2017.
 */
public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> values = new ArrayList<>();
        String str;
        while (!(str=scanner.nextLine()).equalsIgnoreCase("END")){
            try {
            Double value = Double.parseDouble(str);
                if(value<0) throw new ArithmeticException("Отрицательное значение корня");
                values.add(Math.sqrt(value));
               Double sum = 0.0;
                for (Double val:values) {
                    sum+=val;
                }
                System.out.printf("Сумма корней = %f\n",sum);
            }catch (NumberFormatException e){
                System.out.printf("Некорректный ввод строки %s\n",str);
            }catch (ArithmeticException e){
                System.out.printf("Арифметическая ошибка %s\n", e.getMessage());
                StackTraceElement[] st = e.getStackTrace();
                System.out.println("Stack:");
                for (StackTraceElement el:st) {
                    System.out.printf("В файле\"%s\",в классе \"%s\" ,в методе \"%s\" , в строке\"%s\" ошибка\n",el.getFileName(),el.getClassName(),el.getMethodName(),el.getLineNumber());
                    if(el.getMethodName().equals("main"))break;
                }
            }
        }
    }
}
