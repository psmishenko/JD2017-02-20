package by.it.akhmelev.jd01_04;

public class Util {

    static private void log(double[][] m, boolean showLog) {
        if (showLog) {
            InOut.arrayPrint(m, "m", false);
            System.out.println("-----------");
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
        log(m,showLog);
        //прямой ход метода Гаусса
        for (int diag = 0; diag < n - 1; diag++) {
            for (int row = diag + 1; row < n; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
            log(m,showLog);
        }

        //обратный ход метода Гаусса
        for (int diag = n - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
            log(m,showLog);
        }
        //ищем корни системы
        for (int row = 0; row < n; row++) {
            double k = 1 / m[row][row];
            for (int col = 0; col < n + 1; col++) {
                m[row][col] = m[row][col] * k;
            }
        }
        log(m,showLog);
        //извлекаем результаты
        double[] x = new double[n];
        for (int row = 0; row < n; row++) {
            x[row] = m[row][n];
        }
        return x;
    }
}
