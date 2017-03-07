package by.it.dashkevich.jd01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by дёня on 02.03.2017.
 */
public class TaskB_1 {
    //определяем принодлежность числа k к интервалу [n, m] !!!задание 1
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(rd.readLine());  //число k
        int n = Integer.parseInt(rd.readLine());  //число n, начало интервала
        int m = Integer.parseInt(rd.readLine());  //число m, конец интервала
        int[] array = new int[m-n+1]; //храним интервал [n, m]

        for(int i = n; i<=m; i++) {
            int count = 0;
            array[count] = n;
            count++;
        }
        System.out.println(result(k, array));

    }
    // проверяем входит ли k в интервал
    static boolean result(int k, int[] array) {
        boolean res = false;
        for(int i: array) {
            if (k==i) res = true;
        }
        return res;
    }
}
