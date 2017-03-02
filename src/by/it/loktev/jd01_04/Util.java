package by.it.loktev.jd01_04;

public class Util {

    static double[] findRoots(double[][] mA, double[] mY, boolean showSteps) {
        int n = mA.length;
        double[][] m = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = mA[i][j];
            }
            m[i][n] = mY[i];
        }

        if (showSteps)
            InOut.arrayPrint(m, "m", false);

        double k;

        // прямой ход
        for (int diag = 0; diag < n - 1; diag++) {
            for (int row = diag + 1; row < n; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++)
                    m[row][col] -= m[diag][col] * k;
            }
        }

        if (showSteps)
            InOut.arrayPrint(m, "m", false);

        // обратный ход
        for (int diag = n - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++)
                    m[row][col] -= m[diag][col] * k;
            }
        }

        if (showSteps)
            InOut.arrayPrint(m, "m", false);

        // подготовим столбец корней
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = m[i][n] / m[i][i];

        }

        return x;
    }


    static public double findDeterminant(double [] [] mA, boolean showSteps){
        int n=mA.length;
        double [] [] m=new double[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                m[i][j]=mA[i][j];
            }
        }

        if (showSteps)
            InOut.arrayPrint(m,"m",false);

        double k;

        // прямой ход
        for (int diag=0; diag<n-1; diag++){
            for (int row=diag+1; row<n; row++){
                k=m[row][diag]/m[diag][diag];
                for (int col=0; col<n; col++)
                    m[row][col]-=m[diag][col]*k;
            }
        }

        if (showSteps)
            InOut.arrayPrint(m,"m",false);

        double deter=1;
        for (int diag=0; diag<n; diag++){
            deter*=m[diag][diag];
        }

        return deter;

    }

    static double [] [] inverseMatrix(double[][] mA, double[] mY, boolean showSteps) {

        int n = mA.length;
        int nn=n*2+1; // столько столбцов в дополненной матрице

        double[][] m = new double[n][nn];
        for (int i = 0; i < n; i++) {
            // копируем исходную матрицу
            for (int j = 0; j < n; j++) {
                m[i][j] = mA[i][j];
            }
            // копируем вектор
            m[i][n] = mY[i];
            // ставим единичный элемент в дополнении
            m[i][n+1+i]=1;
        }

        if (showSteps)
            InOut.arrayPrint(m, "m", false);

        double k;

        // прямой ход
        for (int diag = 0; diag < n - 1; diag++) {
            for (int row = diag + 1; row < n; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < nn; col++)
                    m[row][col] -= m[diag][col] * k;
            }
        }

        if (showSteps)
            InOut.arrayPrint(m, "m", false);

        // обратный ход
        for (int diag = n - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < nn; col++)
                    m[row][col] -= m[diag][col] * k;
            }
        }

        if (showSteps)
            InOut.arrayPrint(m, "m", false);

        // приведём главную диагональ к 1
        for (int i = 0; i <n ; i++) {
            k=m[i][i];
            for (int j = 0; j <nn ; j++) {
                m[i][j]/=k;
            }
        }

        if (showSteps)
            InOut.arrayPrint(m, "m", false);

        // вырежем обратную матрицу
        double [] [] x = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = m[i][n+1+j];
            }
        }

        return x;
    }


    public static double [] arrayMulVector(double [] [] x, double [] y){
        double [] z=new double[x.length];
        for (int i=0; i<x.length; i++)
            for (int j=0; j<y.length; j++)
                z[i]+=x[i][j]*y[j];
        return z;
    }

    public static double [] [] arrayMulVector(double [] [] x, double [] [] y){
        double [] [] z=new double[x.length][y[0].length];
        for (int i=0; i<x.length; i++)
            for (int j=0; j<y[0].length; j++)
                for (int k=0; k<y.length; k++)
                    z[i][j]+=x[i][k]*y[k][j];
        return z;
    }

}


