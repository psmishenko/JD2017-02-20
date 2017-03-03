package by.it.psmishenko.jd01_2;



import java.io.IOException;
import java.util.Random;

public class Runner {
    public static void main(String[] args) throws IOException {
        boolean zxc = true;
        do {
            System.out.println("Введите уровень (a,b or c). Выход из программы - любой иной символ");
            String numLevel = Util.getOneLine();
            switch (numLevel) {
                case "a":
                    // TaskA
                    System.out.println("Введите числа!");
                    String line = Util.getOneLine(); // вводим значения
                    int arr[] = Util.lineToIntArray(line);
                    //#1
                    String resMax = TaskA.getMax(arr);
                    System.out.println(resMax);
                    String resMin = TaskA.getMin(arr);
                    System.out.println(resMin);
                    //#2
                    double mean = TaskA.mean(arr);
                    for (int i : arr) {
                        if (i < mean) {
                            System.out.println(i + " - Число, меньшее " + mean);
                        }
                    }
                    //#3
                    for (int i : arr) {
                        if (TaskA.uniqueDigits(i)) {
                            System.out.println("Найдено число из разных цифр: " + i);
                            break;
                        }
                    }
                    break;

                case "b":
                    //   TaskB #1
                    System.out.println("Введите число k, начало диапазона n и конец диапазона m");
                    String param = Util.getOneLine(); // вводим значения
                    int arrParam[] = Util.lineToIntArray(param);
                    if (TaskB.checkNumber(arrParam)) {
                        System.out.println("Значение k принадлежит интервалу");
                    } else System.out.println("Значение k не принадлежит интервалу");
                    // #2
                    System.out.println("Введите число 2 для задания №2");
                    String paramM = Util.getOneLine();
                    int paramMatrix = Integer.parseInt(paramM);
                    TaskB.printNewMatrix(paramMatrix);
                    // #3
                    System.out.println("Решим квадратное уравнение: a(x)^2 + bx +c.Введите параметры квадратного уравнения (a,b,c)");
                    String coefForQ = Util.getOneLine();
                    int coefForQuadr[] = Util.lineToIntArray(coefForQ);
                    TaskB.determQuadr(coefForQuadr);
                    // #4
                    System.out.println("Введите число от 1 до 12");
                    String nOfMonth = Util.getOneLine();
                    int numberOfMonth = Integer.parseInt(nOfMonth);
                    TaskB.printMonth(numberOfMonth);
                    break;
                // Task C
                case "c":
                    System.out.println("Введите размерность матрицы");
                    String n = Util.getOneLine(); // вводим значения
                    int num = Integer.parseInt(n);
                    TaskC.createMatrix(num);
                    break;
            default: zxc = false;
            }
        }while (zxc);
                }

    }



