package by.it.korzun.jd01_12;

import java.util.*;

public class TaskA {
    void runA1(){
        List<Integer> table = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            table.add((int)(Math.round(Math.random() * 9) + 1));
        }
        System.out.println("Все оценки: " + table);

        Iterator<Integer> it = table.iterator();
        while (it.hasNext()){
            Integer value = it.next();
            if(value < 0){
                it.remove();
            }
        }
//        System.out.println("Только положительные оценки: " + table);

        //Второй способ
        Integer[] bad = new Integer[]{1,2,3};
        List<Integer> badCollect = new ArrayList<>(Arrays.asList(bad));
//       table.removeAll(badCollect);
//        System.out.println("Только положительные оценки: " + table);

        //Третий способ
        table.removeAll(Arrays.asList(new Integer[]{1,2,3}));
        System.out.println("Только положительные оценки: " + table);

    }

    void runA2(){
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            a.add((int)(Math.round(Math.random() * 9) + 1));
        }
        for (int i = 0; i < 6; i++) {
            b.add((int)(Math.round(Math.random() * 9) + 1));
        }
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("Объединение: " + MyCollect.getUnion(a, b));
        System.out.println("Пересечение: " + MyCollect.getCross(a, b));
    }

    void runA3(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add((int)(Math.round(Math.random() * 9) - 5));
        }
        System.out.println("Все значения: " + list);

        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2;
            }
        };

        Collections.sort(list, c);
        System.out.println("Расставленные значения: " + list);
    }
}
