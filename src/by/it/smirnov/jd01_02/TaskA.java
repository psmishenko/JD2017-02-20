package by.it.smirnov.jd01_02;

/**
 * Created by aleksey.smirnov on 26.02.2017.
 */
public class TaskA {

    /**
     * Функция поиска и вывода самого длиного элемента массива
     * @version 1.0.0
     * @param a массив
     * @return строка
     */
    public static String getStrWithMaxLenghtElementArray(int[] a) {
        int pos = -1;
        int maxLength = 0;
        for (int i = 0; i < a.length; i++) {
            if (String.valueOf(a[i]).length() > maxLength) {
                pos = i;
                maxLength = String.valueOf(a[i]).length();
            }
        }
        if (pos != -1) {
            return "Значение элемента с максимальной длиной " + a[pos] + ". Длина значения равна " + String.valueOf(a[pos]).length() + ".";
        } else {
            return "Элемент с максимальной длиной не найден";
        }
    }

    /**
     * Функция поиска и вывода самого короткого элемента массива
     * @version 1.0.0
     * @param a массив
     * @return строка
     */
    public static String getStrWithMinLenghtElementArray(int[] a) {
        int pos = -1;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (String.valueOf(a[i]).length() < minLength) {
                pos = i;
                minLength = String.valueOf(a[i]).length();
            }
        }
        if (pos != -1) {
            return "Значение элемента с минимальной длиной " + a[pos] + ". Длина значения равна " + String.valueOf(a[pos]).length() + ".";
        } else {
            return "Элемент с минимальной длиной не найден";
        }
    }

    /**
     * Функция вычисления среднего арифметического значения элементов массива
     * @version 1.0.0
     * @param a массив
     * @return значение double
     */
    public static double getAverageArray(int [] a) {
        double res = 0;
        for (int value : a) {
            res += value;
        }
        res /= a.length;
        return res;
    }

    /**
     * Функция печати тех чисел массива, длина которых меньше среднего арифметического.
     * @version 1.0.0
     * @param a массив
     * @return строка
     */
    public static String printElementsLessAverageArray(int [] a) {
        String res = "";
        double average = getAverageArray(a);
        for (int value : a) {
            if (String.valueOf(value).length()<average)
                res += value + " ";
        }
        return res.trim();
    }

    /**
     * Функция нахождения и печати числа, состоящего только из различных цифр. Если таких чисел несколько,
     * находит первое из них.
     * @version 1.0.0
     * @param a массив
     * @return строка
     */
    public static String printUniqueElementArray(int [] a) {
        String res = "";
        for (int value : a) {
            int[] checker = new int[10];
            boolean isUnique = true;
            for (int i = 0; i < String.valueOf(value).length(); i++) {
                if (checker[Integer.parseInt(String.valueOf(String.valueOf(value).charAt(i)))] == 1) {
                    isUnique = false;
                    break;
                } else {
                    checker[Integer.parseInt(String.valueOf(String.valueOf(value).charAt(i)))]++;
                }
            }
            if (isUnique) {
                res = "Первое число состоящее только из разных цифр: "+value;
                break;
            }
        }
        if (res == "") {
            res = "Нет числа, состоящего только из разных цифр";
        }
        return res;
    }



}
