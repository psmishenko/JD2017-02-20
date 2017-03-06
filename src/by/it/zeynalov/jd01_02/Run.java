package by.it.zeynalov.jd01_02;

import static by.it.zeynalov.jd01_02.TaskA.interval;
import static by.it.zeynalov.jd01_02.TaskB.matrica;
import static by.it.zeynalov.jd01_02.TaskC.equation;
import static by.it.zeynalov.jd01_02.TaskD.months;

public class Run {

    public static void main(String[] args) {

        interval(35,50,100);
        System.out.println(interval(35,50,100));

        matrica(36);
        equation();
        months();
    }
}
