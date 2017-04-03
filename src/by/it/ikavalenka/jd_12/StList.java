package by.it.ikavalenka.jd_12;



import java.util.*;

/**
 * Created by USER on 25.03.2017.
 */
public class StList {
    void runA1(){
        List<Integer> tableA = new ArrayList<>();
        for (int i = 0; i < 28; i++) {
            Integer value = (int)Math.round(Math.random()*9.0)+1;
                    tableA.add(value);
        }
        System.out.println("All assessments:" + tableA);
        Iterator<Integer> it = tableA.iterator();
        while (it.hasNext()){
            Integer value = it.next();
            if (value < 2);
                it.remove();
        }
        System.out.println("Only positiv assessments:" + tableA);
            tableA.removeAll(Arrays.asList(new Integer[]{1, 2}));
        System.out.println("Only negative assessments:" + tableA);
    }
    void runA2(){
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < 10 ; i++) {
            Integer value = (int) Math.round(Math.random()*9.0) + 1;
            a.add(value);
        }
        for (int i = 0; i < 6; i++) {
            Integer value = (int) Math.round(Math.random()*9.0) + 1;
            b.add(value);
        }
        System.out.println("a" + a);
        System.out.println("b" + b);
        System.out.println("a & b" + MyCollect.getCross(a,b));
        System.out.println("a + b" + MyCollect.gerCross2(a,b));
    }
    void RunA3(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20 ; i++) {
            Integer value = (int)Math.round(Math.random()*9.0)+1;
            list.add(value);
        }
        System.out.println("All values:" + list);
        Comparator<Integer> k = new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//                return o2;
                return o1;

            }
        };
        list.sort(k);
        System.out.println("Position for values" + list);
    }
}
