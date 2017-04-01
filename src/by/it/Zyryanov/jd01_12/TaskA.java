package by.it.Zyryanov.jd01_12;




import java.util.*;

public class TaskA {
    void runA1() {
        List<Integer> table = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Integer value = (int) Math.round(Math.random() * 9.0) + 1;
            table.add(value);
        }
        System.out.println("Все оценки: " + table);
        //первый способ
        Iterator<Integer> it = table.iterator();
        while (it.hasNext()) {
            Integer value = it.next();
            if (value < 2)
                it.remove();
        }
        System.out.println(">1 оценки: " + table);

        //второй способ
        Integer[] bad = new Integer[]{1, 2};
        List<Integer> badCollect = new ArrayList<>(Arrays.asList(bad));
        table.removeAll(badCollect);
        System.out.println(">2 оценки: " + table);

        //третий способ
        table.removeAll(Arrays.asList(new Integer[]{1, 2, 3}));
        System.out.println("Только положительные оценки: " + table);
    }

    void runA2() {
        Set<Integer> a=new HashSet<>();
        Set<Integer> b=new HashSet<>();
        for (int i = 0; i < 4; i++) {
            Integer value=(int) Math.round(Math.random() * 9.0) + 1;
            a.add(value);
        }
        for (int i = 0; i < 6; i++) {
            Integer value=(int) Math.round(Math.random() * 9.0) + 1;
            b.add(value);
        }
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("a u b="+MyCollect.getUnion(a,b));
        System.out.println("a + b="+MyCollect.getCross(a,b));
    }

    void runA3() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Integer value = (int) Math.round(Math.random() * 9.0) -5;
            list.add(value);
        }
        System.out.println("Все значения: " + list);

        Comparator<Integer> c=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2;
            }
        };

        Collections.sort(list,c);
        System.out.println("Расставленные значения: " + list);

    }

}
