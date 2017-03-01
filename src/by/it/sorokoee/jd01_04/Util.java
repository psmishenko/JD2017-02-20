package by.it.sorokoee.jd01_04;

public class Util {
    private  static  void log(double[][] m, boolean showLog){
        if (showLog){
            InOut.arrayPrint(m,"M",false);
            System.out.println("---------------------------------------------");
        }
    }
    public static double[] findRoots(double[][] a, double[] y, boolean showLog) {
        int n = a.length;
        double[][] m = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = a[i][j];
            }
            m[i][n] = y[i];

        }


        log(m,showLog);
//        прямой ход метода гауса
        for(int diag=0;diag<n;diag++){
            for (int row = diag+1; row <n ; row++) {
                double k=m[row][diag]/m[diag][diag];
                for (int col = 0; col <n+1 ; col++) {
                    m[row][col]-=m[diag][col]*k;
                    
                }

            }
            log(m,showLog);
        }
//        обратный ход
        for(int diag=n-1;diag>0;diag--){
            for (int row = 0; row <diag ; row++) {
                double k=m[row][diag]/m[diag][diag];
                for (int col = 0; col <n+1 ; col++) {
                    m[row][col]-=m[diag][col]*k;

                }

            }
            log(m,showLog);
        }
//        ищем корни системы
        for (int row = 0; row <n ; row++) {
            double k=1/m[row][row];
            for (int col = 0; col <n+1 ; col++) {
                m[row][col]*=k;

            }

        }
        log(m,showLog);
        double x[]=new double[n];
        // извлекаем результаты
        for (int row = 0; row <n ; row++) {
            x[row]=m[row][n];
        }
        return x;
    }
}
