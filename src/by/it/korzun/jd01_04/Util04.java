package by.it.korzun.jd01_04;


class Util04 {
    private static double findDeterminant(double[][] m){
        double res = 1;
        for (int i = 0; i < m.length; i++) {
            res *= m[i][i];
        }
        return res;
    }

    private static double[] arrayMulVector(double[][] x, double[] y){
        double[] z = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                z[i] = z[i] + x[i][j] * y[j];
            }
        }
        return z;
    }

    private static double[][] arrayMulVector(double[][] x, double[][] y){
        double[][] z = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < y.length; k++) {
                    z[i][j] = z[i][j] + x[i][k] * y[k][j];
                }
            }
        }
        return z;
    }

    static void checkRoots(double[][] m, double[] roots, double[] y){
        double[] res = arrayMulVector(m, roots);
        for (int i = 0; i < roots.length; i++) {
            if((int)res[i] != (int)y[i]){
                System.out.println("Некорректные корни");
                return;
            }
        }
        System.out.println("\nКорректные корни");
    }


    static void checkInv(double[][] m, double[][] inv){
        double[][] res = arrayMulVector(m, inv);
        InOut.arrayPrint(m, "M", true);
        InOut.arrayPrint(inv, "Inv", true);
        InOut.arrayPrint(res, "Res", true);
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++){
                if((int)res[i][i] != 1){
                    System.out.println("Некорректная обратная матрица");
                    return;
                }
                if(i != j && (int)res[i][j] != 0){
                    System.out.println("Некорректная обратная матрица");
                    return;
                }
            }
        }
        System.out.println("Корректная обратная матрица");
    }

    static double[] findRoots(double[][] a, double[] y){
        int n = a.length;
        double[][] m = new double[n][n + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                m[i][j] = a[i][j];
            }
            m[i][n] = y[i];
        }
        //прямой ход метода Гаусса
        for(int diag = 0; diag < n - 1; diag++){
            for(int row = diag + 1; row < n; row++){
                double k = m[row][diag]/m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col]-m[diag][col]*k;
                }
            }
        }

        double det = findDeterminant(m);

        //обратный ход
        for(int diag = n - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                double k = m[row][diag] / m[diag][diag];
                for (int col = 0; col < n + 1; col++) {
                    m[row][col] = m[row][col] - m[diag][col] * k;
                }
            }
        }

        //ищем корни
        for(int row = 0; row < n; row++){
            double k = 1/m[row][row];
            for(int col = 0; col < n + 1; col++){
                m[row][col] = m[row][col] * k;
            }
        }
        System.out.println("Определитель = " + det);

        double[] roots = new double[y.length];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = m[i][n];
        }

        return roots;
    }

    static double[][] inverseMatrix(double[][] m){
        double [][]tempMatxix = new double[m[0].length][m.length * 2];
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                tempMatxix[i][j] = m[i][j];
            }
        }
        for(int i = 0; i < m.length; i++){
            tempMatxix[i][i + m[0].length] = 1;
        }


        for(int diag = 0; diag < m.length - 1; diag++){
            for(int row = diag + 1; row < m.length; row++){
                double k = tempMatxix[row][diag]/tempMatxix[diag][diag];
                for (int col = 0; col < tempMatxix.length + m.length; col++) {
                    tempMatxix[row][col] = tempMatxix[row][col]-tempMatxix[diag][col]*k;
                }
            }
        }

        //обратный ход
        for(int diag = m.length - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                double k = tempMatxix[row][diag] / tempMatxix[diag][diag];
                for (int col = 0; col < m.length + tempMatxix.length; col++) {
                    tempMatxix[row][col] = tempMatxix[row][col] - tempMatxix[diag][col] * k;
                }
            }
        }

        //получение единичной матрицы
        for(int i = 0; i < tempMatxix.length; i++){
            double temp = tempMatxix[i][i];
            for(int j = 0; j < tempMatxix.length + m.length; j++){
                tempMatxix[i][j] = tempMatxix[i][j]/temp;
            }
        }


        for(int i = 0; i < m.length; i++){
            for(int j = 0, k = m.length; j < m.length; j++, k++){
                m[i][j] = tempMatxix[i][k];
            }
        }

        return m;
    }
}
