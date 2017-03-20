package by.it.radivonik.jd01_12;

import java.util.*;

/**
 * Created by Radivonik on 20.03.2017.
 */
public class TaskB {
    public void runB1() {

    }

    public void runB2() {
        for (int i = 0; i < 4; i++) {
            int n = 100;
            switch(i) {
                case 1:
                    n = 1000; break;
                case 2:
                    n = 10000; break;
                case 3:
                    n = 100000; break;
            }

            ArrayList<Integer> listArray = new ArrayList<>(n);
            LinkedList<Integer> listLinked = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                listArray.add(j);
                listLinked.add(j);
            }

            processB2(listArray);
            processB2(listLinked);
        }
    }

    private <T extends List<?>> void processB2(T list) {
        System.out.printf("Счет для %s из %d элементов... ",list.getClass().getName(),list.size());
        Timer t = new Timer();
        while(list.size() > 1) {
            // Вариант 1
            int c = 1;
            for (Iterator<?> it = list.iterator(); it.hasNext(); c++) {
                it.next();
                if (c%2 == 0)
                    it.remove();
            }

            // Вариант 2
//            int size = list.size();
//            for (int c = 1; c <= size; c++) {
//                if (c%2 == 0) {
//                    list.remove(c - 1);
//                    size--;
//                }
//            }
        }
        System.out.println(t);
    }

    public static class Timer {
        private long timeBegin;
        public Timer() {
            timeBegin = System.nanoTime();
        }
        public String toString() {
            double timeDelta = (double)(System.nanoTime() - timeBegin) / 1000;
            timeBegin = System.nanoTime();
            return "Затрачено " + timeDelta + " микросекунд";
        }
    }
}
