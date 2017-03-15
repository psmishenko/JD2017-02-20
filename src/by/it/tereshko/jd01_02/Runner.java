package by.it.tereshko.jd01_02;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        String line = Util.getOnline();
//        String line = "12 34 566 147 99 852 746 69 753 -951";
        int arr[] = Util.lineToArray(line);

//        1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        String max = TaskA.getMax(arr);
        System.out.println(max);
        String min = TaskA.getMin(arr);
        System.out.println(min);


//        2. Вывести на консоль те числа, длина которых меньше (больше) средней.
        double mean = TaskA.mean(arr);
        System.out.println("Числа, длина которых меньше " + mean + " следующие: ");
        for (Integer i : arr) {
            if (i.toString().length() < mean) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

//        3. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
        for (int i : arr) {
            if (TaskA.uniqueDigits(i)) {
                System.out.print("Найдено число из разных цифр: " + i);
                break;
            }
        }
    }

}
