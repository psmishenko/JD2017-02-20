package by.it.zeynalov.jd01_02;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

public class TaskD {

    public static void months() {

        Scanner src = new Scanner(System.in);

        String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        System.out.println("Введите число от 1 до 12, что бы выбрать нудный Вам месяц");
        int a;
        do {
            a = src.nextInt()-1;
        } while(a < 0 || a > 11);


        System.out.println(months[a]);
    }

}
