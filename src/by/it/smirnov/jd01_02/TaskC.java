package by.it.smirnov.jd01_02;

import java.util.Random;

/**
 * Created by aleksey.smirnov on 26.02.2017.
 */
public class TaskC {
    /**
     * Функция заполнения матрицы произвольными значениями в пределах интервала.
     * @version 1.0.0
     * @param n массив
     * @param minValue нижнее значение интервала заполнения
     * @param maxValue верхнее значение интервала заполнения
     */
    public static void fillRandomArray(double[][] n, int minValue, int maxValue) {
        Random r = new Random();
        for (int i = 0; i < n.length; i++)
            for (int j = 0; j < n[i].length; j++)
                n[i][j] = minValue + (maxValue - minValue) * r.nextDouble();
    }

    /**
     * Функция нахождения суммы элементов массива, расположенных между первым и вторым
     * положительными элементами каждой строки
     * @version 1.0.0
     * @param n массив
     * @return сумма элементов
     */
    public static double getSummElements(double[][] n) {
        double result = 0;
        boolean isBeginCalc = false;
        for (int i = 0; i < n.length; i++){
            isBeginCalc = false;
            for (int j = 0; j < n[i].length; j++) {
                if (n[i][j] > 0) {
                    if (isBeginCalc) {
                        break;
                    } else {
                        isBeginCalc = true;
                        continue;
                    }
                }
                if (isBeginCalc) result +=n[i][j];
            }
        }
        return result;
    }

    /**
     * Функция транспонирования матрицы
     * @version 1.0.0
     * @param n массив
     */
    public static void transponArray(double[][] n) {
        for (int i = 0; i < n.length; i++)
            for (int j = i+1; j < n[i].length; j++) {
                double value = n[i][j];
                n[i][j] = n[j][i];
                n[j][i] = value;
            }
    }

    /**
     * Функция, поворачивающая матрицу на 90 градусов против часовой стрелки.
     * @version 1.0.0
     * @param n массив
     * @return повернутый массив
     */
    public static double[][] rotate90Array(double[][] n) {
        double[][] a = new double[n[0].length][n.length];
        for (int i = 0; i < n.length; i++)
            for (int j = n[i].length - 1; j >= 0; j--)
                a[n[i].length - j - 1][i] = n[i][j];
        return a;
    }

    /**
     * Функция нахождения среднего арифметического матрицы
     * @version 1.0.0
     * @param n массив
     * @return среднее арифметическое
     */
    public static double getMeanArray(double[][] n) {
        double result = 0;
        for (int i = 0; i < n.length; i++)
            for (int j = 0; j < n[0].length; j++)
                result += n[i][j];
        result = result / (n.length*n[0].length);
        return result;
    }

    /**
     * Функция построения матрицы, вычитая из элементов каждой строки ее среднее арифметическое
     * @version 1.0.0
     * @param n массив
     * @return массив
     */
    public static double[][] getArrayElementMinusMean(double[][] n) {
        double[][] a = new double[n.length][n[0].length];
        double mean = getMeanArray(n);
        for (int i = 0; i < n.length; i++)
            for (int j = 0; j < n[0].length; j++)
                a[i][j] = n[i][j] - mean;
        return a;
    }

    /**
     * Функция нахождения максимального значения матрицы
     * @version 1.0.0
     * @param n массив
     * @return максимальное значение
     */
    public static double getMaxArray(double[][] n) {
        double result = Double.MIN_VALUE;
        for (int i = 0; i < n.length; i++)
            for (int j = 0; j < n[0].length; j++)
                if (n[i][j] > result) result = n[i][j];
        return result;
    }

    /**
     * Функция нахождения минимального значения матрицы
     * @version 1.0.0
     * @param n массив
     * @return минимальное значение
     */
    public static double getMinArray(double[][] n) {
        double result = Double.MAX_VALUE;
        for (int i = 0; i < n.length; i++)
            for (int j = 0; j < n[0].length; j++)
                if (n[i][j] < result) result = n[i][j];
        return result;
    }

    /**
     * Функция нахождения максимального элемента(ов) в матрице и удаления из матрицы всех
     * строк и столбцов, его содержащих.
     * @version 1.0.0
     * @param n массив
     * @return массив
     */
    public static double[][] getArrayWithOutMaxValue(double[][] n) {
        int[] row = new int[n.length];
        int[] col = new int[n[0].length];
        double maxValue = getMaxArray(n);
        for (int i = 0; i < n.length; i++)
            for (int j = 0; j < n[0].length; j++)
                if (n[i][j] == maxValue) {
                    row[i] = 1;
                    col[j] = 1;
                }
        int rowCount = 0;
        for (int i : row) rowCount += (i == 1) ? 0 : 1;

        int colCount = 0;
        for (int i : col) colCount += (i == 1) ? 0 : 1;

        int currCol = -1, currRow = -1;
        double[][] result = new double[rowCount][colCount];
        for (int i = 0; i < n.length; i++) {
            if (row[i]==1) continue;
            currCol = -1;
            currRow++;
            for (int j = 0; j < n[0].length; j++){
                if (col[j]==1) continue;
                currCol++;
                result[currRow][currCol] = n[i][j];
            }
        }
        return result;
    }

    /**
     * Функция перемещения столбцов
     * @version 1.0.0
     * @param n массив
     * @param fromCol индекс столбца
     * @param toCol индекс столбца
     */
    public static void changeValueCols(double[][] n, int fromCol, int toCol) {
        for (int i = 0; i < n.length; i++) {
            double value = n[i][toCol];
            n[i][toCol] = n[i][fromCol];
            n[i][fromCol] = value;
        }
    }

    /**
     * Функция перемещения строк
     * @version 1.0.0
     * @param n массив
     * @param fromRow индекс строки
     * @param toRow индекс строки
     */
    public static void changeValueRows(double[][] n, int fromRow, int toRow) {
        for (int i = 0; i < n[0].length; i++) {
            double value = n[toRow][i];
            n[toRow][i] = n[fromRow][i];
            n[fromRow][i] = value;
        }
    }

    /**
     * Функция поиска в матрице минимального элемента и перемещения его на место [1,1]
     * путем перестановки строк и столбцов.
     * @version 1.0.0
     * @param n массив
     */
    public static void moveMinValueArray(double[][] n) {
        int fixCol = 1;
        int fixRow = 1;
        int col = -1;
        int row = -1;
        double minValue = getMinArray(n);
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++)
                if (n[i][j] == minValue) {
                    row = i;
                    col = j;
                    break;
                }
            if (col != -1) break;
        }

        int k = (col>fixCol) ? -1 : 1;
        while (col!=fixCol) {
            changeValueCols(n, col, col + k);
            col += k;
        }
        k = (row>fixRow) ? -1 : 1;
        while (row!=fixRow) {
            changeValueRows(n, row, row + k);
            row += k;
        }
    }

    /**
     * Функция преобразования строки матрицы таким образом, чтобы элементы,
     * равные нулю, располагались после всех остальных.
     * путем перестановки строк и столбцов.
     * @version 1.0.0
     * @param n массив
     */
    public static void moveZeroValueEndRowArray(double[][] n) {
        for (int i = 0; i < n.length; i++) {
            for (int j = n.length - 1; j >= 0 ; j--) {
                if (n[i][j]==0)
                    for (int k = j; k < n.length - 1; k++) {
                        double value = n[i][k+1];
                        n[i][k+1]=n[i][k];
                        n[i][k]=value;
                    }
            }
        }
    }

}
