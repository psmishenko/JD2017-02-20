package by.it.prigozhanov.jd01_02;

/**
 * Created by v-omf on 2/22/2017.
 */
public class TaskA {
    static String getMax(int array[]) {
        Integer res = 0;
        for (Integer i : array) {
            if (res.toString().length() < i.toString().length()) {
                res = i;
            }
        }
        return "MAX= " + res.toString() + " length=" + res.toString().length();
    }

    static String getMin(int array[]) {
        Integer res = Integer.MAX_VALUE;
        for (Integer i : array) {
            if (res.toString().length() > i.toString().length()) {
                res = i;
            }
        }
        return "Min=" + res.toString() + " length=" + res.toString().length();
    }
    static boolean uniqueDigits(Integer value) {
        char ch[]=value.toString().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch.length; j++) {
                if (ch[i] == ch[j]) return false;
            }
        }
        return true;
    }
}
