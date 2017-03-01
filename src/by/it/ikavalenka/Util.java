package JD_01_2017_03.jd_01_04;

/**
 * Created by USER on 27.02.2017.
 */
public class Util {
    private static void log(double[][] m, boolean showlog) {
        if (showlog) {
            InOut.arrayPrint(m, "m", false);
            System.out.println("--------");
        }
    }

    static double[] findRoots(double[][] a, double[] y, boolean showlog) {
//формирование матрицы 4 на 5
        int n = a.length;
        double[][] m = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = a[i][j];
            }
            m[i][n] = y[i];
        }
        log(m, showlog);

        //InOut.arrayPrint(m, "m", true);
        //прямой ход метода Гаусса
        for (int diag = 0; diag < n - 1; diag++) {
            for (int row = diag + 1; row < n; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
            log(m, showlog);
            //InOut.arrayPrint(m, "M", false);
            //System.out.println("--------");
        }
        //return y;

        //обратный ход

        for (int diag = n - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
            log(m, showlog);
            //InOut.arrayPrint(m, "M", false);
            //System.out.println("--------");
        }


        //ищем корни
        for (int row = 0; row < n; row++) {
            double k = 1 / m[row][row];
            for (int col = 0; col < n + 1; col++) {
                m[row][col] = m[row][col] * k;
            }
        }
        log(m, showlog);
        //InOut.arrayPrint(m, "m", false);
        //System.out.println("--------");
        //return y;

        // извлекаем результаты

        double[] x = new double[n];
        for (int row = 0; row < n; row++) {
            x[row] = m[row][n];

        }
        log(m, showlog);

        return x;

    }
}
