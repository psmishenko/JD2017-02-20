package by.it.prigozhanov.jd01_04;

/**
 * Created by Natasha on 27.02.2017.
 */
public class Util {
    private static void log(double[][] m, boolean showLog) {
        if (showLog) {
            InOut.arrayPrint(m, "m", false);
            System.out.println("--------");
        }
    }

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

    static void inverseMarix(double[][] a, boolean showLog) {

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
        int z = m.length;
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
            InOut.arrayPrint(m, "I", false);
        }
    }
