package by.it.radivonik.jd01_02;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Radivonik on 28.02.2017.
 */
public class Runner {
  public static void main(String[] args) throws IOException {
//      String line = Util.getOneLine();
      String line = "232 224 776 6687 89899 2323 656 797898 32 76767 7979 321212 68686";
      int arr[] = Util.lineToIntArray(line);

      // Исходный массив чисел к задачам уровня A
      System.out.println("Исходный массив (к задачам уровня A:");
      System.out.println(line);

      // Задача A1
      System.out.println("\nЗадача A1");
      int max = TaskA.getMax(arr);
      System.out.println("Самый длинный = " + max + ", длина = " + String.valueOf(max).length());
      int min = TaskA.getMin(arr);
      System.out.println("Самый короткий = " + min + ", длина = " + String.valueOf(min).length());

      // Задача A2
      System.out.println("\nЗадача A2");
      double mean = TaskA.mean(arr);
      System.out.print("Числа меньше среднего " + mean + " таковы: ");
      for (int i : arr) {
          if (i < mean) {
              System.out.print(i + " ");
          }
      }
      System.out.println();

      // Задача A3
      System.out.println("\nЗадача A3");
      for (int i : arr) {
          if (TaskA.uniqueDigits(i)) {
              System.out.println("Найдено число из разных цифр: " + i);
              break;
          }
      }

      Scanner scanner = new Scanner(System.in);

      // Задача B1
      {
          System.out.println("\nЗадача B1");
          System.out.print("Введите проверяемое значение: ");
          int k = Integer.parseInt(scanner.nextLine());
          System.out.print("Введите начало интервала: ");
          int n = Integer.parseInt(scanner.nextLine());
          System.out.print("Введите конец интервала: ");
          int m = Integer.parseInt(scanner.nextLine());
          if (TaskB.isIn(k,n,m))
              System.out.println("Значение " + k + " принадлежит интервалу [" + n + "," + m + "]");
          else
              System.out.println("Значение " + k + " не принадлежит интервалу [" + n + "," + m + "]");
      }

      // Задача B2
      {
          System.out.println("\nЗадача B2");
          System.out.print("Введите количество элементов квадратной матрицы: ");
          int k = Integer.parseInt(scanner.nextLine());
          TaskB.printMatrix(k);
      }

      // Задача B3
      {
          System.out.println("\nЗадача B3");
          double a;
          double b;
          double c;
          if (args.length >= 1)
              a = Double.parseDouble(args[0]);
          else {
              System.out.print("Введите коэффициент а квадратного уравнения: ");
              a = Double.parseDouble(scanner.nextLine());
          }
          if (args.length >= 2)
              b = Double.parseDouble(args[0]);
          else {
              System.out.print("Введите коэффициент b квадратного уравнения: ");
              b = Double.parseDouble(scanner.nextLine());
          }
          if (args.length >= 2)
              c = Double.parseDouble(args[0]);
          else {
              System.out.print("Введите коэффициент c квадратного уравнения: ");
              c = Double.parseDouble(scanner.nextLine());
          }

          System.out.println("Решение уравнения: " + a + "*x*x + " + b + "*x + " + c + " = 0");
          System.out.println(TaskB.getKorenUr(a,b,c));
      }

      // Задача B4
      {
          System.out.println("\nЗадача B4");
          System.out.print("Введите номер месяца: ");
          int n = Integer.parseInt(scanner.nextLine());
          System.out.println(TaskB.getMonthName(n));
      }
  }
}
