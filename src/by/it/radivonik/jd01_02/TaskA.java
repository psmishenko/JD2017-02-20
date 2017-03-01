package by.it.radivonik.jd01_02;

/**
 * Created by Radivonik on 28.02.2017.
 */
public class TaskA {
<<<<<<< f1c030438cf71245b23b5a32fb8d20b0ebb8bca6
    public static int getMax(int array []) {
        Integer res = 0;
        for (Integer i: array) {
            if ( res.toString().length() < i.toString().length() ||
                 res.toString().length() == i.toString().length() && res < i ) {
                res = i;
            }
        }
        return res;
    }

    public static int getMin(int array []) {
        Integer res = Integer.MAX_VALUE;
        for (Integer i: array) {
            if ( res.toString().length() > i.toString().length() ||
                 res.toString().length() == i.toString().length() && res > i ) {
                res = i;
            }
        }
        return res;
    }

    public static double mean(int array[]) {
=======
    static String getMin(int array []) {
        Integer res = 0;
        for (Integer i: array) {
            if (res.toString().length() < i.toString().length()) {
                res = i;
            }
        }
        return "MAX=" + res.toString() + " length=" + res.toString().length();
    }

    static String getMax(int array []) {
        Integer res = Integer.MAX_VALUE;
        for (Integer i: array) {
            if (res.toString().length() > i.toString().length()) {
                res = i;
            }
        }
        return "MIN=" + res.toString() + " length=" + res.toString().length();
    }

    static double mean(int array[]) {
>>>>>>> Тест
        double res = 0;
        for (int i: array) {
            res += i;
        }
        res = res / array.length;
        return res;
    }

<<<<<<< f1c030438cf71245b23b5a32fb8d20b0ebb8bca6
    public static boolean uniqueDigits(Integer value) {
=======
    static boolean uniqueDigits(Integer value) {
>>>>>>> Тест
        char ch[] = value.toString().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j])
                    return false;
            }
        }
        return true;
    }
}
