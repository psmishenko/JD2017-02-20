package by.it.loktev.jd01_15;

public class Runner {

    public static void main(String[] args) {

        System.out.println("=== задание A");
        TaskA.taskA();

        System.out.println("=== задание B");
        TaskB.taskB();

        System.out.println("=== задание C");
        TaskC taskC=new TaskC();
        taskC.listenCommands();

    }

}
