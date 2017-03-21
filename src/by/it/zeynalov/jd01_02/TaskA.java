package by.it.zeynalov.jd01_02;

public class TaskA {

    // принадлежность числа в интервале
    public static boolean interval(int k, int n, int m) {
        // более развернутый вариант
        /*
        if (k > n && k < m) {
            return true;
        }
        return false;*/
        // укороченный вариант,но оптимизированный
        return k > n && k < m;
    }
}
