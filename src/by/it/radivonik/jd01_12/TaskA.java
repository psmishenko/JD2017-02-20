package by.it.radivonik.jd01_12;

import java.util.*;

/**
 * Created by Radivonik on 20.03.2017.
 */
public class TaskA {
    public void runA1() {
        List<Integer> table = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Integer value = (int) Math.round(Math.random() * 9 + 1);
            table.add(value);
        }
        System.out.println("Все оценки: " + table);

        // Способ 1
        Iterator<Integer> it = table.iterator();
        while (it.hasNext()) {
            Integer value = it.next();
            if (value <= 1)
                it.remove();
        }
        System.out.println("Только положительные оценки: " + table);

        // Способ 2
        Integer[] bad = new Integer[]{1, 2};
        List<Integer> badList = new ArrayList<Integer>(Arrays.asList(bad));
        table.removeAll(badList);
        System.out.println("Только положительные оценки: " + table);

        // Способ 3
        table.removeAll(Arrays.asList(new Integer[]{1, 2, 3}));
        System.out.println("Только положительные оценки: " + table);
    }

    public void runA2() {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < 8; i++) {
            Integer value = (int) Math.round(Math.random() * 9 + 1);
            a.add(value);
            value = (int) Math.round(Math.random() * 9 + 1);
            b.add(value);
        }
        System.out.println("Множество А: " + a);
        System.out.println("Множество B: " + b);
        System.out.println("Объединение множеств A и B: " + MyCollection.getUnion(a, b));
        System.out.println("Пересечение множеств A и B: " + MyCollection.getCross(a, b));
    }

    public void runA3() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Integer value = (int) Math.round(Math.random() * 9 - 5);
            list.add(value);
        }
        System.out.println("Исходный список: " + list);

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2;// - o1;
            }
        };
        Collections.sort(list, comp);
        System.out.println("Отсортированный список: " + list);
    }
}