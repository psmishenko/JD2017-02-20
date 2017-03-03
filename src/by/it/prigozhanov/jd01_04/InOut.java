package by.it.prigozhanov.jd01_04;

/**
 * Created by Vladimir on 27.02.2017.
 */
public class InOut {
    /**
     * Method will print double array to console.
     *
     * @param m         - double array matrix m.
     * @param name      - show the name of matrix before every index.
     * @param showindex - show index of matrix element.
     */
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

    /**
     * Method will print single array to console with different values of columns.
     *
     * @param v - matrix of single array.
     * @param name - show the name of matrix before every index.
     * @param cols - how many columns will have matrix.
     */
    static void arrayPrint(double[] v, String name, int cols) {
        int col = 0;
        for (int i = 0; i < v.length; i++) {
            System.out.printf("%s[%1d]=%-8.4f ", name, i, v[i]);
            col++;
            if (col == cols) {
                System.out.println();
                col = 0;
            }
        }
        System.out.println("-------------");
    }
}
