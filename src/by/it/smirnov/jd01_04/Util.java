package by.it.smirnov.jd01_04;

/**
 * Created by aleksey.smirnov on 27.02.2017.
 */
public class Util {
    /**
     * Функция объединения массива и вектора
     * @version 1.0.0
     * @param mA массив
     * @param mY вектор
     * @return результат в виде двумерного массива
     */
    public static double[][] concatArray(double[][] mA, double[] mY) {
        int n=mA.length;
        double[][] m= new double [n][n+1];
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                m[row][col]=mA[row][col];

        for (int row = 0; row < n; row++)
            m[row][n] = mY[row];
        return m;
    }

    /**
     * Функция объединения двух массивов
     * @version 1.0.0
     * @param mA массив
     * @param mY массив
     * @return результат в виде двумерного массива
     */
    public static double[][] concatArray(double[][] mA, double[][] mY) {
        int n=mA.length;
        double[][] m= new double [n][n+mY.length];
        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                m[row][col]=mA[row][col];

        for (int row = 0; row < n; row++)
            for (int col = 0; col < n; col++)
                m[row][col + n]=mY[row][col];
        return m;
    }

    /**
     * Метод Гаусса (прямой ход)
     * @version 1.0.0
     * @param m массив
     */
    public static void methodGaussDirectArray(double[][] m) {
        int n=m.length;
        int r=m[0].length;
        double k;
        // прямой цикл
        for (int diag = 0; diag < n-1; diag++) {
            for (int row = diag+1; row < n; row++) {
                k=m[row][diag]/m[diag][diag];
                for (int col = 0; col < r; col++)
                    m[row][col]=m[row][col]-m[diag][col]*k;
            }
        }
    }

    /**
     * Метод Гаусса (обратный ход)
     * @version 1.0.0
     * @param m массив
     */
    public static void methodGaussReverceArray(double[][] m) {
        int n=m.length;
        int r=m[0].length;
        double k;
        // обратный цикл
        for (int diag = n-1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                k=m[row][diag]/m[diag][diag];
                for (int col = 0; col < r; col++)
                    m[row][col]=m[row][col]-m[diag][col]*k;
            }
        }
    }

    /**
     * Функция решения системы уравнений методом Гаусса
     * @version 1.0.0
     * @param mA двумерный массив
     * @param mY вектор
     * @param showSteps флаг отладки
     * @return вектор со значениями решения
     */
    public static double[] findRoot(double[][] mA, double[] mY, boolean showSteps){
        double[][] m = concatArray(mA, mY);

        log(m,"m", showSteps);

        methodGaussDirectArray(m);
        methodGaussReverceArray(m);

        double k;
        int n=mA.length;
        // главная диагональ к 1
        for (int i = 0; i < n; i++) {
            k = m[i][i];
            for (int j = 0; j < n+1; j++)
                m[i][j] = m[i][j] / k;

        }
        log(m,"m", showSteps);

        double[] x=new double[n];
        for (int i = 0; i < n; i++)
            x[i]=m[i][n];

        return x;
    }

    /**
     * Функция вывода на консоль двумерного массива в зависимости от флага вывода
     * @version 1.0.0
     * @param a массив
     * @param nameArray наименование массива
     * @param showLog флаг вывода
     */
    public static void log(double[][] a, String nameArray, boolean showLog) {
        if (showLog) InOut.arrayPrint2D(a,nameArray);
    }
    /**
     * Функция вывода на консоль одномерного массива в зависимости от флага вывода
     * @version 1.0.0
     * @param a массив
     * @param nameArray наименование массива
     * @param showLog флаг вывода
     */
    public static void log(double[] a, String nameArray, boolean showLog) {
        if (showLog) InOut.printDoubleArray(a,nameArray,1);
    }

    /**
     * Функция перемножения двух двумерных массивов double
     * @version 1.0.0
     * @param x массив
     * @param y массив
     * @return результат в виде двумерного массива
     */
    public static double[][] arrayMulVector(double[][] x,double[][] y) {
        double[][] z = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y[0].length; j++)
                for (int k = 0; k < y.length; k++)
                    z[i][j] += x[i][k]*y[k][j];
        return z;
    }

    /**
     * Функция поиска определителя матрицы
     * @version 1.0.0
     * @param mA двумерный массив
     * @param showSteps флаг отладки
     * @return детерминант
     */
    public static double findDeterminant(double[][] mA, boolean showSteps){
        log(mA, "A", showSteps);
        methodGaussDirectArray(mA);
        log(mA, "A", showSteps);

        double res = 1;
        for (int diag = 0; diag < mA.length; diag++)
            res *= mA[diag][diag];
        return res;
    }

    /**
     * Функция создания обратной матрицы
     * @version 1.0.0
     * @param mA двумерный массив
     * @param showSteps флаг отладки
     * @return обратная матрица
     */
    public static double[][] inverseMatrix(double[][] mA, boolean showSteps) {
        double[][] mY = new double[mA.length][mA.length];
        for (int i = 0; i < mY.length; i++)
            mY[i][i] = 1;
        double[][] m = concatArray(mA, mY);

        methodGaussDirectArray(m);
        methodGaussReverceArray(m);

        log(m,"m", showSteps);

        double k;
        // главная диагональ к 1
        for (int i = 0; i < m.length; i++) {
            k = m[i][i];
            for (int j = 0; j < m[0].length; j++)
                m[i][j] = m[i][j] / k;

        }

        log(m,"m", showSteps);
        for (int i = 0; i < mY.length; i++)
            for (int j = 0; j < mY[0].length; j++)
                mY[i][j] = m[i][j+mA.length];

        return mY;
    }
}
