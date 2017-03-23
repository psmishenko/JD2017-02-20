package by.it.psmishenko.jd01_12;

import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        boolean zxc = true ;
        do {
            System.out.println("a,b or c?");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice) {
                case "a":
                    TaskA taskA = new TaskA();
                    taskA.runA1(); System.out.println("-------------------------------");
                    taskA.runA2(); System.out.println("-------------------------------");
                    taskA.runA3(); System.out.println("-------------------------------");
                    break;
                case "b":
                    TaskB taskB = new TaskB();
                    taskB.runB1(Data.test);
                    //taskB.runB1(Data.text);
                    int n = 800; // N для B2
                    Timer t = new Timer();
                    taskB.processArray(n);
                    System.out.println("ArrayList: " + t);
                    taskB.processLinked(n);
                    System.out.println("LinkedList: " + t);
                    break;
                case "c":
                    TaskC taskC = new TaskC();
                    taskC.runC1();
                    break;
                default:
                    zxc = false;
            }

        }while (zxc);
    }
    public static class Timer {
        private long iniTime;
        private Double Delta;

        public Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            Delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();

            return "Прошло " + Delta.toString() + " микросекунд.";
        }
    }
}
