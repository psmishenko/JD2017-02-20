package by.it.vedom.jd01_02;


/**
 * Created by Владислав on 25.02.2017.
 */
public class TaskA {
        //----------------------------------------------------------------------------------------------------------
        // Самое короткое число
        static String getMin (int array []) {
            Integer res = Integer.MAX_VALUE;
            for (Integer i : array) {
                if(res.toString().length() > i.toString().length()) {
                    res = i;
                }
            }
            return "MIN = " + res.toString() + " length = " +res.toString().length();
        }
        // Самое длинное число
        static String getMax (int array []) {
            Integer res = 0;
            for (Integer i : array) {
                if(res.toString().length() < i.toString().length()) {
                    res = i;
            }
        }
        return "MAX = " + res.toString() + " length = " + res.toString().length();
    }
    //-------------------------------------------------------------------------------------------------------------

    // Поиск среднего арифметического
    static double mean (int array[]) {
            double res = 0;
            for (int i : array) {
                res += i;
            }
            res /= array.length;
            return res;
    }
    //-------------------------------------------------------------------------------------------------------------

    static boolean isDigitsDifferent (Integer number) {
            char symbol[] = number.toString().toCharArray();
            if(symbol.length < 2)
                return false;
        for (int i = 0; i < symbol.length; i++)
            for (int j = i+1; j < symbol.length ; j++)
                if(symbol[i] == symbol[j])
                    return false;
        return true;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
