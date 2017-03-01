package by.it.radivonik.jd01_02;

import java.io.IOException;

/**
 * Created by Radivonik on 28.02.2017.
 */
public class Runner {
  public static void main(String[] args) throws IOException {
//      String line = Util.getOneLine();
      String line = "232 224 776 6687 89899 2323 656 797898 32 76767 7979 321212 68686";
      int arr[] = Util.lineToIntArray(line);

      // A1
      String max = TaskA.getMax(arr);
      System.out.println(max);
      String min = TaskA.getMin(arr);
      System.out.println(min);

      // A2
      double mean = TaskA.mean(arr);
      System.out.print("Числа меньше " + mean + " таковы: ");
      for (int i : arr) {
          if (i < mean) {
              System.out.print(i + " ");
          }
      }
      System.out.println();

      // A3
      for (int i : arr) {
          if (TaskA.uniqueDigits(i)) {
              System.out.print("Найдено число из разных цифр: " + i);
              break;
          }
      }
      System.out.println();

      // B4
      System.out.print("Введите номер месяца: ");
      int n = Integer.parseInt(Util.getOneLine());
      System.out.println(TaskB.getMonthName(n));
  }
}
