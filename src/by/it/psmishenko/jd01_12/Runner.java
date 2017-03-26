package by.it.psmishenko.jd01_12;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


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
                    System.out.println("#1:"); taskA.runA1(); System.out.println("-------------------------------");
                    System.out.println("#2:"); taskA.runA2(); System.out.println("-------------------------------");
                    System.out.println("#3:"); taskA.runA3(); System.out.println("-------------------------------");
                    break;
                case "b":
                    TaskB taskB = new TaskB();
                    //taskB.runB1(Data.test);
                    System.out.println("#1:"); taskB.runB1(Data.text);
                    int n = 800; // N для B2
                    Timer t = new Timer();
                    System.out.println("#2:");taskB.processArray(n);
                    System.out.println("ArrayList: " + t);
                    taskB.processLinked(n);
                    System.out.println("LinkedList: " + t);
                    break;
                case "c":
                    TaskC taskC = new TaskC();
                    System.out.println("#1:");taskC.runC1();System.out.println("-------------------------------");
                    Set<String> a1 = new HashSet<>(); Set<String> b1 = new HashSet<>();
                    Set<Double> a2 = new HashSet<>(); Set<Double> b2 = new HashSet<>();
                    for (int i = 0; i <3 ; i++) {
                       a1.add(Data.arr1[i]);
                       a2.add(3.14+i);
                    }
                    for (int i = 0; i <3 ; i++) {
                      b1.add(Data.arr2[i]);
                      b2.add(3.14-i);
                    }
                    System.out.println("#2:");
                    taskC.runC2(a1,b1);System.out.println("-------------------------------");
                    taskC.runC2(a2,b2);System.out.println("-------------------------------");
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
