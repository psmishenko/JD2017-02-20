package by.it.sorokoee.jd01_02;

public class TaskA {
    public static void getMaxMin(String line, int[] arr) {
        String[] strArr = line.split(" ");
        int maxLen = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int len = strArr[i].length();
            if (len > maxLen)
                maxLen = len;
            if (len < minLen)
                minLen = len;
        }
        System.out.println("maxLenn=" + maxLen + " minLen=" + minLen);
    }

    public static void lenMean(String line, int[] arr) {
        int summa = 0;
        String[] strArr = line.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            summa += arr[i];
        }
        double sr = ((double) summa) / strArr.length;
        System.out.print("Числа, длина которых меньше среднего значения их велечин: ");
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].length() < sr)

                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean uniqueDigits(Integer value) {

        char[] ch = value.toString().toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    return false;
                }
            }
        }
        return true;
    }


}
