package by.it.smirnov.jd01_06;

/**
 * Created by aleksey.smirnov on 03.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("Задание А:");
        TaskA.run();
        System.out.println();

        System.out.println("Задание B:");
        TaskB.runPartA();
        System.out.println();
        TaskB.runPartB();
        System.out.println();

        System.out.println("Задание C:");
        TaskC.runPartA();
        System.out.println();
        TaskC.runPartB();
        System.out.println();
    }

}
