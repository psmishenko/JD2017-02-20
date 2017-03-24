package by.it.korzun.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> values = new ArrayList<>();
        String str;
        while (!(str = scanner.nextLine()).equals("END")){
            try {
                Double value = Double.parseDouble(str);
                if(value < 0){
                    throw new ArithmeticException("Отрицательное значение под корнем");
                }
                values.add(Math.sqrt(value));
                Double sum = 0.0;
                for (Double val:values) {
                    sum += val;
                }
                System.out.printf("Сумма корней =%f\n",sum);
            }catch (NumberFormatException e){
                System.out.printf("Некорректный ввод строки %s\n",str);
            }catch (ArithmeticException e){
                System.out.printf("Арифмитическая ошибка: %s\n",e.getMessage());
            }
        }
    }
}
