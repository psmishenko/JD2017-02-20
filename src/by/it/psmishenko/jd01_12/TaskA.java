package by.it.psmishenko.jd01_12;

import java.util.*;

/**
 * Created by user on 20.03.2017.
 */
public class TaskA {
    void runA1(){
        List<Integer> table = new ArrayList<>();
        for (int i = 0; i < 20 ; i++) {
            Integer value = (int) Math.round(Math.random()*9)+1;
            table.add(value);
        }
        System.out.println("Все оценки: "+table);


        Iterator<Integer> it = table.iterator();
        while (it.hasNext()){
            Integer value = it.next();
            if(value<4) it.remove();
        }
        System.out.println("Только положительные: "+table);
        // второй вариант
        Integer[] bad = new Integer[]{1,2,3};
        List<Integer> badCollect =new ArrayList<>(Arrays.asList(bad)); // лучше имеено так, а не просто Arrays.asList
        table.removeAll(badCollect);
        //краткая запись
       // table.removeAll(Arrays.asList(new Integer[]{1,2,3}));
        System.out.println("Только положительные: "+table);
    }
void runA2(){
    Set<Integer> a = new HashSet<>();
    Set<Integer> b = new HashSet<>();
    for (int i = 0; i <4 ; i++) {
        Integer value = (int) Math.round(Math.random()*9)+1;
        a.add(value);
    }
    for (int i = 0; i <6 ; i++) {
        Integer value = (int) Math.round(Math.random()*9)+1;
        b.add(value);
    }
    System.out.println("a="+a);
    System.out.println("b="+b);
    System.out.println("aUb"+MyCollect.getUnion(a,b));
    System.out.println("a_b"+MyCollect.getCross(a,b));
}
    void runA3 (){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20 ; i++) {
            Integer value = (int) Math.round(Math.random()*9)-5;
            list.add(value);
        }
        System.out.println("Все значения: "+list);
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        Collections.sort(list,c);
        System.out.println("Переставленные значения= "+list);

    }
}
