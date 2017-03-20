package by.it.zeynalov.jd01_12_Collections;

import java.util.HashSet;
import java.util.Set;

public class MyCollect {
    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(b);

        //первый способ
        res.addAll(a);

        //второй способ
        /*for (Integer value : a) {
            if (!b.contains(value))
                res.add(value);
        }*/
        return res;
    }

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>();
        res.addAll(a);
        //первый способ
        res.retainAll(b);

        //второй способ
        /*for (Integer value : a) {
            if (b.contains(value))
                res.add(value);
        }*/
        return res;
    }
}
