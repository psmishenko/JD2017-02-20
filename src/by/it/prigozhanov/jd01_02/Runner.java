package by.it.prigozhanov.jd01_02;

import java.io.IOException;

/**
 * Created by v-omf on 2/22/2017.
 */
public class Runner {
    public static void main(String[] args) throws IOException {

        String line = "12 555 6666";

//        Чтение строки с клавиатуры
//        String line = Util.GetOneLine();

        int arr[] = Util.lineToIntArray(line);

        String max = TaskA.getMax(arr);
        System.out.println(max);
        String min = TaskA.getMin(arr);
        System.out.println(min);

        for (int i : arr) {
            if (TaskA.uniqueDigits(i)) {
                System.out.print("Найдено число из разных цифр: " + i);
                break;
            }
        }

        //интервал (задача 1)
        System.out.println("Задание 1, Интервал");
        System.out.print("Введите число k: ");
        String k = Util.GetLine();
        int kInt = Util.strToInt(k);
        System.out.print("Введите начальное число интервала (n): ");
        String n = Util.GetLine();
        int nInt = Util.strToInt(n);
        System.out.print("Введите конечное число интервала (m): ");
        String m = Util.GetLine();
        int mInt = Util.strToInt(m);
        TaskB.SetNumberAndInterval(kInt, mInt, nInt);

        // Матрица (задача 2)
        System.out.println("Задание 2, Числа от 1 до k в матрице NxN");
        System.out.print("Введите число элементов для создания матрицы: ");
        String z = Util.GetLine();
        int z1 = Util.strToInt(z);

        TaskB.Matrix(z1);

        // квадратное уравнение (задача 3)
        System.out.println("Задание 3, Корни квадратного уравнения");
        System.out.print("Введите число a: ");
        String a = Util.GetLine();
        int a1 = Util.strToInt(a);
        System.out.print("Введите число b: ");
        String b = Util.GetLine();
        int b1 = Util.strToInt(b);
        System.out.print("Введите число c: ");
        String c = Util.GetLine();
        int c1 = Util.strToInt(c);

        TaskB.SqrtExpression(a1, b1, c1);

        // определение месяца (задача 4)
        System.out.println("Задание 4, Определение месяца по номеру");
        System.out.print("Введите месяц от 1 до 12: " );
        String month = Util.GetLine();
        int intMonth = Util.strToInt(month);
        TaskB.CurrentMonth(intMonth);

    }

}
