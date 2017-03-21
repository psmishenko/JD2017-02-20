package by.it.tereshko.jd01_02;

public class TaskA {

    static String getMax(int array[]) {
        Integer res = 0;
        for (Integer i : array) {
            if (res.toString().length() < i.toString().length()) {
                res = i;
            }
        }
        return "MAX=" + res.toString() + " length" + res.toString().length();
    }

    static String getMin(int array[]) {
        Integer res = Integer.MIN_VALUE;
        for (Integer i : array) {
            if (res.toString().length() > i.toString().length()) {
                res = i;
            }
        }
        return "MIN=" + res.toString() + " length=" + res.toString().length();
    }

    static double mean(int array[]) {
        double res = 0;
        for (int i : array) res = res + i;
        res = res / array.length;
        return res;
    }

    static boolean uniqueDigits(Integer value) {
        char ch[] = value.toString().toCharArray();
        for (int i = 0; i < ch.length; i++)
            for (int j = i + 1; j < ch.length; j++)
                if (ch[i] == ch[j])
                    return false;
            return true;
    }

}
