package by.it.radivonik.jd02_05;

/**
 * Created by Radivonik on 07.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("Вариант A");
        (new TaskA()).run(args);
        System.out.println("\nВариант B");
        (new TaskB()).run(args);
        System.out.println("\nВариант C");
        (new TaskC()).run(args);
    }
}
