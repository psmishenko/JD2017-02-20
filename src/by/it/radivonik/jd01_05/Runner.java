package by.it.radivonik.jd01_05;

/**
 * Created by Radivonik on 01.03.2017.
 */
public class Runner {
    public static void main (String[] args) {
        // Вариант 8
        System.out.println("\nВариант 8");

        // Задание 1
        System.out.println("\nЗадание 1");
        System.out.println(Task1.calc1(0.3,-21.17));
        System.out.println(Task1.calc2(0.3,-21.17));

        // Задание 2
        System.out.println("\nЗадание 2");
        System.out.println(Task2.calc(2.57*Math.pow(10,3),0.873));

        // Задание 3
        System.out.println("\nЗадание 3");
        Task3.calc(2,3,0.1);

        // Задание 4
        System.out.println("\nЗадание 4");
        Task4.calc(2.408,0.2,0.4,0.02);
    }
}
