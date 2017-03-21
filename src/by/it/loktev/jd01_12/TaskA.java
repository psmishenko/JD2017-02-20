package by.it.loktev.jd01_12;

import java.util.*;

public class TaskA {

    /*
    A1. Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками (1-10). Удалить
неудовлетворительные оценки из списка (1-4). Вывести на консоль оба варианта.
     */

    void runA1(){
        List<Integer> table=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Integer value=(int)Math.floor(Math.random()*10+1);
            table.add(value);
        }
        System.out.println("Все оценки: "+table);

        /*
        Iterator<Integer> it=table.iterator();
        while (it.hasNext()){
            Integer value=it.next();
            if (value<=4)
                it.remove();
        }
        System.out.println("Только положительные оценки: "+table);
        */

        // второй способ

        Integer [] bad=new Integer[]{1,2,3,4};
        List<Integer> badCollect=new ArrayList<Integer>(Arrays.asList(bad));
        table.removeAll(badCollect);
        System.out.println("Только положительные оценки: "+table);

    }

    void runA2(){

        Set<Integer> a=new HashSet<>();
        Set<Integer> b=new HashSet<>();

        for (int i = 0; i < 8; i++) {
            Integer value=(int)Math.floor(Math.random()*10+1);
            a.add(value);
        }
        System.out.println("Первый список: "+a);

        for (int i = 0; i < 8; i++) {
            Integer value=(int)Math.floor(Math.random()*10+1);
            b.add(value);
        }
        System.out.println("Второй список: "+b);

        Set<Integer> c=MyCollect.getUnion(a,b);
        System.out.println("Объединение: "+c);

        Set<Integer> d=MyCollect.getCross(a,b);
        System.out.println("Пересечение: "+d);

    }

    void runA3(){
        List<Integer> table=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Integer value=(int)Math.floor(Math.random()*10-5);
            table.add(value);
        }
        System.out.println("Исходный список: "+table);

        Comparator<Integer> c=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        Collections.sort(table,c);
        System.out.println("Сортированный список: "+table);

    }

}
