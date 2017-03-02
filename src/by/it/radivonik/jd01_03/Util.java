package by.it.radivonik.jd01_03;

/**
 * Created by user on 24.02.2017.
 */
public class Util {
    static void sort(double[] ar) {
        boolean swap; // признак сортированности
        int last = ar.length - 1;
        do {
            swap = false;

            for (int i = 0; i < last; i++) {
                if (ar[i] > ar[i+1]) {
                    double buf = ar[i];
                    ar[i] = ar[i+1];
                    ar[i+1] = buf;
                    swap = true;
                }
            }

            last--;
        } while(swap);
    }
}
