package by.it.prigozhanov.jd01_04;
/**
 * Created by Vladimir on 27.02.2017.
 */
public class InOut {
    static void arrayPrint(double[][] m, String name, boolean showindex) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (showindex) {
                    System.out.printf("%s[%1d,%1d]=%-8.4f ", name, i, j, m[i][j]);
                } else
                System.out.printf("%-8.4f ", m[i][j]);

            }
            System.out.println();
        }
    }

    static void arrayPrint(double[] v, String name, int cols) {
        int col = 0;
        for (int i = 0; i < v.length; i++) {
            System.out.printf("%s[%1d]=%-8.4f ", name, i, v[i]);
            col++;
        if (col == cols){
                System.out.println();
                col = 0;
            }
    }
        System.out.println("-------------");
}
}
