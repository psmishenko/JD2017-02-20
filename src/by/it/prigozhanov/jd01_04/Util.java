package by.it.prigozhanov.jd01_04;

/**
 * Created by Prigozhanov on 27.02.2017.
 */
public class Util {
    /**
     * Method prints to console changes step by step.
     *
     * @param m       double array - matrix
     * @param showLog - boolean to show changes or no. If boolean is true - changes will
     *                be printed to console, if false - they will not printed.
     */
    private static void log(double[][] m, boolean showLog) {
        if (showLog) {
            InOut.arrayPrint(m, "m", false);
            System.out.println("--------");
        }
    }

    /**
     * Method finds roots from Matrix a and Vector y by Gauss Jordan method.
     *
     * @param showLog - see log function.
     * @param a       - first matrix.
     * @param y       - vector
     * @return
     */
    static double[] findRoots(double[][] a, double[] y, boolean showLog) {
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

//обратный ход Гаусса
        for (int diag = n - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }

            }
        }
        log(m, showLog);
//ищем корни системы
        for (int row = 0; row < n; row++) {
            double k = 1 / m[row][row];
            for (int col = 0; col < n + 1; col++) {
                m[row][col] = m[row][col] * k;
            }
            log(m, showLog);
        }

        //извлекаем результаты
        double x[] = new double[n];
        for (int row = 0; row < n; row++) {
            x[row] = m[row][n];
        }
        return x;
    }

    /**
     * Check matrix roots.
     *
     * @param m - matrix which wi check.
     * @param x roots of this matrix.
     * @see
     */
    static void checker(double[][] m, double[] x) {
        double[][] multarr = new double[m.length][1];
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                sum = m[i][j] * x[j] + sum;
                multarr[i][0] = sum;
            }
            sum = 0;
        }
        System.out.println("Matrix Checked:");
        InOut.arrayPrint(multarr, "C", true);
    }

    /**
     * Method finds determinant of matrix m.
     *
     * @param m - inputted matrix
     * @version 1.0
     */
    static void findDeterminant(double[][] m) {
        int n = m.length;
        double determ = 0;
        //прямой ход метода Гаусса
        for (int diag = 0; diag < n; diag++) {
            for (int row = diag + 1; row < n; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }

            }

            for (int i = 0; i < m.length - 1; i++) {
                determ = m[i][i] * m[i + 1][i + 1];
            }

        }
        System.out.println("Определитель: " + determ);
    }

    /**
     * Method inversing matrix a.
     *
     * @param a       double array for inverse.
     * @param showLog - step log.
     * @return inverted Matrix by Gauss Jordan Method.
     * @version 1.0
     */
    static double[][] inverseMarix(double[][] a, boolean showLog) {

        int n = a.length;
        double[][] m = new double[n][a[0].length + a[0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a[0].length; j++) {
                m[i][j] = a[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            m[i][i + a[0].length] = 1;
        }
        int z = m[0].length;
        //прямой ход метода Гаусса
        for (int diag = 0; diag < n - 1; diag++) {
            for (int row = diag + 1; row < n; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < z; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }

            }
            log(m, showLog);


        }

//обратный ход Гаусса
        for (int diag = n - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < z; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }

            }
        }
// делим каждый элемент ряда на частное диагонали
        for (int diag = 0; diag < n; diag++) {
            double x = 1 / m[diag][diag];
            for (int col = 0; col < z; col++) {
                m[diag][col] = m[diag][col] * x;
            }
        }
// отделяем инвертированную матрицу от единичной
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = m[i][j + n];
            }
        }
        System.out.println("Инверсированная матрица");
        return a;
    }

    /**
     * @param firstarr  - double array (first matrix)
     * @param secondarr - double array (second matrix)
     * @author Vladimir Prigozhanov
     * @version 1.0
     */
    public static void matrixMultipliedByMatrix(double firstarr[][], double secondarr[][]) {
        double[][] multarr = new double[firstarr.length][secondarr[0].length];
        for (int i = 0; i < firstarr.length; i++) {
            for (int j = 0; j < secondarr[0].length; j++) {
                for (int k = 0; k < secondarr.length; k++) {
                    multarr[i][j] += firstarr[i][k] * secondarr[k][j];
                }
            }

        }
        System.out.println("Перемноженные матрицы");
        InOut.arrayPrint(multarr, "M", false);
    }
}
