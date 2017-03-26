package by.it.radivonik.jd01_13;

/**
 * Created by Radivonik on 22.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("Вариант A");
        TaskA.run();

        System.out.println("\nВариант B");
        try {
            while (true)
                TaskB.level1();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\nВариант C");
        TaskC.run();
    }
}
