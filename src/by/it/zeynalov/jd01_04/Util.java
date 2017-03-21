package by.it.zeynalov.jd01_04;

public class Util {

    //умножаем матрицу на вектор
    public static double[] arrayVector(double[][] x, double[] y) {
        double[] z = new double[x.length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y.length; j++)
                z[i] = z[i] + x[i][j] * y[j];
        return z;
    }

    //умножаем матрицу на матрицу
    public static double[][] arrayMatrix(double[][] x, double[][] y) {
        double[][] z = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y[0].length; j++)
                for (int k = 0; k < y.length; k++)
                    z[i][j] = z[i][j] + x[i][k] * y[k][j];
        return z;
    }

    static private void log(double[][] m, boolean showLog) {
        if (showLog) {
            InOut.arrayPrint(m, "m", false);
            System.out.println("----------------------------");
        }
    }

    static double[] findRoots(double[][] a, double[] y, boolean showLog) {
        //формируем матрицу m 4 на 5 (n на n+1)
        int n = a.length;
        double[][] m = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = a[i][j];
            }
            m[i][n] = y[i];
        }
        log(m, showLog);

        //прямой ход метода Гаусса
        for (int diag = 0; diag < n - 1; diag++) {
            for (int row = diag + 1; row < n; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
            log(m, showLog);
        }

        //обратный ход метода Гаусса
        for (int diag = n - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
            log(m, showLog);
        }
        //приводим главную диагональ к 1
        for (int row = 0; row < n; row++) {
            double k = 1 / m[row][row];
            for (int col = 0; col < n + 1; col++) {
                m[row][col] = m[row][col] * k;
            }
            log(m, showLog);
        }

        //извлекаем результаты
        double[] x = new double[n];
        for (int row = 0; row < n; row++) {
            x[row] = m[row][n];
        }
        return x;
    }

    //ходим по диагонали и перемножаем значения
    public static double findDeterminant(double[][] a) {
        double c = 1.0;
        for (int i = 0; i < a.length; i++) {
            c *= a[i][i];
        }
        return c;
    }
}
