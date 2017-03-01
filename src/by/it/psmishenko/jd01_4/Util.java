package by.it.psmishenko.jd01_4;

/**
 * Метод реализации поставленных задач
 */
public class Util {
    /**
     * Метод решения СЛАУ (Жордана-Гаусса)
     * @param - квадратная матрица коэффициентов СЛАУ
     * @param b - вектор правых частей уравнений СЛАУ
     * @return - вектор-решение X
     */
    public static double[] findRoot (double[][] a,double[] b) {
    int n = a.length;
    double[][] m = new double[n][n + 1];
    double k;
    double[] x = new double[n];
    for (int row = 0; row < n; row++) {
        for (int col = 0; col < n; col++) {
            m[row][col] = a[row][col];
        }
    }
    for (int row = 0; row < n; row++) { // дополняем матрицу m вектором b
        m[row][n] = b[row];
    }
    // прямой ход
    for (int diag = 0; diag < n - 1; diag++) {
        for (int row = diag + 1; row < n; row++) {
            k = m[row][diag] / m[diag][diag];
            for (int col = 0; col < n + 1; col++) {
                m[row][col] -= m[diag][col] * k;
            }
        }
    }
// обратный ход
    for (int diag = n-1 ; diag > 0  ; diag--) {
        for (int row = 0 ; row < diag; row++) {
            k = m[row][diag] / m[diag][diag];
            for (int col = 0; col < n + 1; col++) {
                m[row][col] -= m[diag][col] * k;
            }
        }
    }
// делим строки на диагональные элементы
    for (int i = 0; i <n ; i++) {
        k = 1/m[i][i];
        for (int j = 0; j < n+1 ; j++) {
            m[i][j] *= k;
        }
    }
// достаём из корни из n+1 колонки
    for (int i = 0; i <n ; i++) {
        x[i] = m[i][n];
    }
return x;
}
/////////////////////////////////////////////////////////////////////

    /**
     * Метод поиска обратной матрицы
     * @param a заданная матрица
     * @param b единичная матрица
     * @return обратная матрица
     */
    public static double[][] inverseMatrix (double[][] a,double[][] b) {
      double [][] x = new double[a.length][a.length];
        int n = a.length;
        int r = n+b.length;
        double[][] m = new double[n][r];
        double k;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                m[row][col] = a[row][col];
            }}
        for (int row = 0; row < n; row++) {// дополняем матрицу m вектором b
            for (int col = n; col <r ; col++) {
                    m[row][col] = b[row][col - b.length];
            }
        }
        // прямой ход
        for (int diag = 0; diag < n - 1; diag++) {
            for (int row = diag + 1; row < n; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < r; col++) {
                    m[row][col] -= m[diag][col] * k;
                }
            }
        }
        // обратный ход
        for (int diag = n-1 ; diag > 0  ; diag--) {
            for (int row = 0 ; row < diag; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < r; col++) {
                    m[row][col] -= m[diag][col] * k;
                }
            }
        }
        // делим строки на диагональные элементы
        for (int i = 0; i <n ; i++) {
            k = 1/m[i][i];
            for (int j = 0; j < r ; j++) {
                m[i][j] *= k;
            }
        }
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = m[i][j+n];
            }
        }
        return x;
    }

    /**
     * Метод поиска определителя матрицы
     * @param a - матрица типа double
     * @return det - значение определителя
     */
    public static double findDeterminant (double[][] a) {
        int n = a.length;
        double k ;
        double[][] x = new double[n][n];
        double det = 1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                x[row][col] = a[row][col];
            }
        }
        for (int diag = 0; diag < n ; diag++) {
            for (int row = diag +1; row < n; row++) {
                k = x[row][diag] / x[diag][diag];
                for (int col = 0; col < n ; col++) {
                    x[row][col] -= x[diag][col] * k;
                }
            }
        }
        for (int i = 0; i < n ; i++) {
            det *= x[i][i];
        }

        return det;
    }

    /**
     * Метод определения произведения двумерного массива на вектор
     * @param m1 - двумерный массив типа double
     * @param m2 - одномерный массив типа double
     * @return res - одномерный массив (результат произведения)
     */
    public static double[] arrayMulVector (double[][] m1, double[] m2 ) {
        double [] res = new double[m1.length];
        for (int i = 0; i <m1.length ; i++) {
            for (int j = 0; j <m2.length ; j++) {
                res[i]+=m1[i][j]*m2[j];
            }
        }
        return res;
    }
    /**
     * Метод определения произведения двух двумерных массивов
     * @param m1 - двумерный массив типа double
     * @param m2 - двумерный массив типа double
     * @return res - двумерный массив (результат произведения)
     */
    public static double[][] arrayMulArray (double[][] m1, double[][] m2) {
        double [][] res = new double[m1.length][m2[0].length];
        for (int i = 0; i <m1.length ; i++) {
            for (int j = 0; j <m2[0].length ; j++) {
                for (int k = 0; k <m2.length ; k++) {
                    res[i][j]+=m1[i][k]*m2[k][j];
                }
            }
        }
        return res;
    }
}
