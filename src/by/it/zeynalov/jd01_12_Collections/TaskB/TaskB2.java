package by.it.zeynalov.jd01_12_Collections.TaskB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        processArray();
        System.out.println("--------------------------------");
        processLinked();
    }

    public static void processArray() {
        ArrayList<Integer> sd = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            sd.add(i);
        }
        System.out.println(sd);
        long t = System.nanoTime();
        for (int i = 0; sd.size() > 1; i = (i + 2) % sd.size()) {
            sd.remove(i);
            //System.out.println(sd);
        }
        System.out.println("ArrayListTime: " + (System.nanoTime() - t));
    }

    public static void processLinked() {
        LinkedList<Integer> sd = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            sd.add(i);
        }
        long t = System.nanoTime();
        int n = 0;
        while (sd.size() > 1) {
            Iterator<Integer> iter = sd.iterator();
            while (iter.hasNext()) {
                iter.next();
                if (n % 2 == 0) iter.remove();
                n++;
            }
        }
        System.out.println(sd);
        System.out.println("LinkedListTime: " + (System.nanoTime() - t));
    }
}
