package by.it.korzun.jd01_04;


class InOut {
    static void arrayPrint(double[][] m, String name, boolean showIndex){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                if(showIndex){
                    System.out.printf("%s[%1d,%1d]=%-5.2f ", name, i, j, m[i][j]);
                }else {
                    System.out.printf("%-8.2f ", m[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }

    static void arrayPrint(double[] v, String name, int cols){
        int col = 0;
        for(int i = 0; i < v.length; i++){
            System.out.printf("%s[%1d]=%-5.2f ", name, i, v[i]);
            col++;
            if(col == cols){
                System.out.println();
                col = 0;
            }
        }
        System.out.println("\n-------------------------------");
    }
}
