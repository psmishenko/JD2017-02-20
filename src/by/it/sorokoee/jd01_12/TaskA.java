package by.it.sorokoee.jd01_12;

import java.util.*;

public class TaskA {
    void runA1() {
        List<Integer> mark = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            Integer value = (int) Math.round(Math.random() * 9.0) + 1;
            mark.add(value);

        }
        System.out.println("Все оценки " + mark);
        Iterator<Integer> it = mark.iterator();
        while ((it.hasNext())) {
            Integer value = it.next();
            if (value <= 4)
                it.remove();
        }
        System.out.println("только положительные оценки " + mark);

        Integer[] bad = new Integer[]{1, 2, 3, 4};
        List<Integer> badCollect = new ArrayList<>(Arrays.asList(bad)); // передача массива в коллек. через конструктор
        mark.removeAll(badCollect);
//        System.out.println("Только положительные оценки" + mark);

        mark.removeAll(Arrays.asList(new Integer[]{1, 2, 3, 4}));
    }

    void runA2() {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            Integer value = (int) Math.round(Math.random() * 9.0) + 1;
            a.add(value);
        }
        for (int i = 0; i < 6; i++) {
            Integer value = (int) Math.round(Math.random() * 9.0) + 1;
            b.add(value);
        }
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println(MyCollect.getUnion(a, b));
        System.out.println(MyCollect.getCross(a, b));
    }

    public void runA3() {
        List<Integer> lisr = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            Integer value = (int) Math.round(Math.random() * 9.0) - 5;
            lisr.add(value);
        }
            System.out.println("Все оценки " + lisr);
            Comparator<Integer> c = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            };
            Collections.sort(lisr, c);


        System.out.println("сортиров " + lisr);

    }
}
