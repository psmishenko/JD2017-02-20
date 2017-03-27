package by.it.psmishenko.jd01_15;

/**
 * Created by user on 27.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("#1:");
        TaskA taskA = new TaskA();
        taskA.runA();
       System.out.println("#2:");
        TaskB taskB = new TaskB();
        taskB.runB();
        System.out.println("#3:");
        TaskC taskC = new TaskC();
        taskC.runC();
    }
}
