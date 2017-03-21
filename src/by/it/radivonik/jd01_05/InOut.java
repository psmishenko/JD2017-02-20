package by.it.radivonik.jd01_05;

/**
 * Created by Radivonik on 05.03.2017.
 */
public class InOut {
    static void arrayPrint(double[] ar, String name, int colCount) {
        System.out.println("Массив " + name);
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("%s[%d]=%-10.5f ",name,i,ar[i]);
            if ((i+1)%colCount == 0)
                System.out.println();
        }
    }
}
