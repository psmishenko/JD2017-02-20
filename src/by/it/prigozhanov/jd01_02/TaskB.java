package by.it.prigozhanov.jd01_02;

import java.io.IOException;


/**
 * Created by v-omf on 2/23/2017.
 */
public class TaskB {
    //
    static void SetNumberAndInterval(int k, int m, int n) throws IOException {
        if ((k >= n && k <= m) || (k <= n && k >= m)) {
            System.out.println("Число " + k + " принадлежит интервалу " + "[" + n + ", " + m + "]");
        } else System.out.println("Число " + k + " не принадлежит интервалу " + "[" + n + ", " + m + "]");
    }

    static void Matrix(int k) {
        int[] intArr = new int[k*k+1];
        for (int i = 1; i < k*k+1 ; i++) {
            intArr[i] = i;
            if (intArr[i]%k==0) {
                System.out.printf("%- 1d%n",intArr[i]);
            } else System.out.printf("%- 5d", intArr[i]);
        }
        }


// Квадратное уравнение
    public static void SqrtExpression(int a, int b, int c) {
        if (a > 0 || a < 0) {

            int d = (b * b) - (4 * a * c);
            if (d > 0) {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("x1=" + x1 + " " + "x2=" + x2);

            } else if (d == 0) {
                double x = (-1 * (b / (2 * a)));
                System.out.println("Уравнение имеет один корень равный " + x);
            } else if (d < 0) {
                System.out.println("Корней нет, дискриминант отрицательный!");
            }
        } else System.out.println("Ошибка, первый элемент не должен ровняться нулю!");
    }

    static void CurrentMonth(int a) {
        if (a > 1 || a < 12) {
            switch (a) {
                case 1: {
                    System.out.println("Январь");
                    break;
                }
                case 2: {
                    System.out.println("Февраль");
                    break;
                }
                case 3: {
                    System.out.println("Март");
                    break;
                }
                case 4: {
                    System.out.println("Апрель");
                    break;
                }
                case 5: {
                    System.out.println("Май");
                    break;
                }
                case 6: {
                    System.out.println("Июнь");
                    break;
                }
                case 7: {
                    System.out.println("Июль");
                    break;
                }
                case 8: {
                    System.out.println("Август");
                    break;
                }
                case 9: {
                    System.out.println("Сентябрь");
                    break;
                }
                case 10: {
                    System.out.println("Октябрь");
                    break;
                }
                case 11: {
                    System.out.println("Ноябрь");
                    break;
                }
                case 12: {
                    System.out.println("Декабрь");
                    break;
                } default:
                    System.out.println("Такого месяца не существует!");
            }
        } else System.out.println("Такого месяца не существет");

    }
}


