package by.it.loktev.jd01_02;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;

        System.out.println("===================");
        System.out.println("Задание JD01_02 B 1");
        System.out.println("===================");

        {
            System.out.print("Введите начало интервала (n): ");
            line = scanner.nextLine();
            int n = Integer.parseInt(line);

            System.out.print("Введите конец интервала (m): ");
            line = scanner.nextLine();
            int m = Integer.parseInt(line);

            System.out.print("Введите проверяемое значение (k): ");
            line = scanner.nextLine();
            int k = Integer.parseInt(line);

            if (k >= n && k <= m)
                System.out.println("Значение " + k + " принадлежит диапазону [" + n + "," + m + "]");
            else
                System.out.println("Значение " + k + " НЕ принадлежит диапазону [" + n + "," + m + "]");
        }

        System.out.println("===================");
        System.out.println("Задание JD01_02 B 2");
        System.out.println("===================");

        {
            System.out.print("Введите k: ");
            line = scanner.nextLine();
            int k = Integer.parseInt(line);
            int side=(int)Math.sqrt(k);
            if ( k!=side*side )
                System.out.println("Значение " + k + " не является квадратом целого числа!");
            else
            {
                int i=1;
                int maxDigits=(int)Math.ceil(Math.log10(k));
                for (int row=1; row<=side; row++)
                {
                    for (int col=1; col<=side; col++)
                        System.out.print(Utils.fixedInteger(i++,maxDigits)+" ");
                    System.out.println("");
                }

            }

        }

        System.out.println("===================");
        System.out.println("Задание JD01_02 B 3");
        System.out.println("===================");

        {
          double a=Double.parseDouble(args[0]);
          double b=Double.parseDouble(args[1]);
          double c=Double.parseDouble(args[2]);
          System.out.println("a="+a+" b="+b+" c="+c);
          if ( a==0 )
            System.out.println("Уравнение НЕ является квадратным");
          else
          {
              double d=b*b-4*a*c;
              if (d<0)
                  System.out.println("Уравнение не имеет корней");
              else if (d==0) {
                  double x=-b / 2 / a;
                  System.out.println("Уравнение имеет один корень: " + x);
              }
              else {
                  double x1=(-b+Math.sqrt(d)) / 2 / a;
                  double x2=(-b-Math.sqrt(d)) / 2 / a;
                  System.out.println("Уравнение имеет два корня: " + x1+" "+x2);
              }
          }
        }

        System.out.println("===================");
        System.out.println("Задание JD01_02 B 4");
        System.out.println("===================");

        {
            System.out.print("Введите номер месяца: ");
            line = scanner.nextLine();
            int mn = Integer.parseInt(line);
            if (mn<1 || mn>12)
                System.out.println("Введён некорректный номер месяца");
            else
            {
                String [] months={null,"январь","февраль","март","апрель","май","июнь","июль","август","сентябрь","октябрь","ноябрь","декабрь"};
                System.out.println("Месяц: "+months[mn]);
            }
        }

    }
}
