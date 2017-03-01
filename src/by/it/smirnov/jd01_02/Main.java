package by.it.smirnov.jd01_02;

/**
 * Created by aleksey.smirnov on 26.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        //String line = Util.consoleReadLine();
        // A
        /*
        String line = "11 11 189 774 15 58 9";

        System.out.println(line);
        int[] a = Util.readIntArrayFromLine(line, " ");
        System.out.println(TaskA.getStrWithMaxLenghtElementArray(a));
        System.out.println(TaskA.getStrWithMinLenghtElementArray(a));
        System.out.println("Среднее арифметическое значение элементов массива = " + TaskA.getAverageArray(a));
        System.out.println("Те чисел массива, длина которых меньше среднего арифметического: " + TaskA.printElementsLessAverageArray(a));
        System.out.println(TaskA.printUniqueElementArray(a));
        */

        //B
        /*
        //String line = Util.consoleReadLine();
        String line = "9 10 189";
        int[] b = Util.readIntArrayFromLine(line, " ");
        if (TaskB.getAccessoryInterval(b[0], b[1], b[2])) {
            System.out.println("Значение "+ b[0] +" принадлежит интервалу ["+b[1]+","+b[2]+"]");
        } else {
            System.out.println("Значение "+ b[0] +" не принадлежит интервалу ["+b[1]+","+b[2]+"]");

        }

        System.out.println("Решение уравнения "+args[0]+"x2+"+args[1]+"x+"+args[2]+"=0");
        System.out.println(
                TaskB.getSolutionQuadraticEquation(
                    Integer.valueOf(args[0]),
                    Integer.valueOf(args[1]),
                    Integer.valueOf(args[2]))
        );


        System.out.println("Введите k:");
        TaskB.printArray(Integer.valueOf(Util.consoleReadLine()));


        System.out.println("Введите номер месяца:");
        System.out.println(TaskB.getMonthName(Integer.valueOf(Util.consoleReadLine())));
        */

        // C
        System.out.println("Введите размерность матрицы n:");
        int n = Integer.valueOf(Util.consoleReadLine());
        double[][] a = new double[n][n];
        TaskC.fillRandomArray(a,(-1)*n,n);
        Util.arrayPrint2D(a,"a");
        System.out.println("Сумма элементов матрицы, расположенных между первым и"+
                " вторым положительными элементами каждой строки равна "+
                TaskC.getSummElements(a));

        System.out.println("Транспонированная матрица:");
        TaskC.transponArray(a);
        Util.arrayPrint2D(a,"a");

        System.out.println("Массив, повернутый на 90 градусов против часовой стрелки:");
        a = TaskC.rotate90Array(a);
        Util.arrayPrint2D(a,"a");

        System.out.println("Среднее арифметическое значение массива равно " + TaskC.getMeanArray(a));
        System.out.println("Массив, из элементов каждой строки вычитаем ее среднее арифметическое:");
        a = TaskC.getArrayElementMinusMean(a);
        Util.arrayPrint2D(a,"a");

        //a[3][2] = -500;
        //a[2][2] = -500;
        System.out.println("Максимальный элемент массива: "+TaskC.getMaxArray(a));
        System.out.println("Минимальный элемент массива: "+TaskC.getMinArray(a));
        System.out.println("Матрица, без строк и столбцов, содержащих максимальный элемент массива:");
        Util.arrayPrint2D(TaskC.getArrayWithOutMaxValue(a),"a");
        System.out.println("Перемещение минимального элемента на место [1,1] путем перестановки строк и столбцов:");
        TaskC.moveMinValueArray(a);
        Util.arrayPrint2D(a,"a");
        System.out.println("Преобразованная матрица таким образом, чтобы элементы, равные нулю, располагались после всех остальных:");
        TaskC.moveZeroValueEndRowArray(a);
        Util.arrayPrint2D(a,"a");
        }

}
