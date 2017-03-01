package by.it.radivonik.jd01_04;

/**
 * Created by Radivonik on 28.02.2017.
 */
public class InOut {
    static void arrayPrint(double[] ar, String name, int colCount) {
        System.out.println("Array " + name);
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("%s[%d]=%-10.5f ",name,i,ar[i]);
            if ((i+1)%colCount == 0)
                System.out.println();
        }
    }

    static void arrayPrint2D(double[][] ar, String name) {
        System.out.println("Array " + name);
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                System.out.printf("%s[%d,%d]=%-10.5f ",name,i,j,ar[i][j]);
            }
            System.out.println();
        }
    }
}
