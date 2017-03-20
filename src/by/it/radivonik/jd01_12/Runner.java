package by.it.radivonik.jd01_12;

/**
 * Created by Radivonik on 20.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
        TaskA taskA = new TaskA();
        System.out.println("Вариант A");
        System.out.println("Задание 1");
        taskA.runA1();
        System.out.println("Задание 2");
        taskA.runA2();
        System.out.println("Задание 3");
        taskA.runA3();

        TaskB taskB = new TaskB();
        System.out.println("\nВариант B");
        System.out.println("Задание 1");
        taskB.runB1();
        System.out.println("Задание 2");
        taskB.runB2();
        System.out.println("Задание 3");
        taskB.runB3();

        TaskC taskC = new TaskC();
        System.out.println("\nВариант C");
        System.out.println("Задание 1");
        taskC.runC1();
        System.out.println("Задание 2");
        taskC.runC2();
        System.out.println("Задание 3");
        taskC.runC3();
    }
}
