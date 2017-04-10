package by.it.kolenda.jd02_01;

public class Runner {
    public static void main(String[] args) {
        new TaskA.MyThread("-First thread ").start();
        new TaskA.MyThread("-Second thread ").start();
        new TaskA.MyThread("-Third thread ").start();
    }
}
