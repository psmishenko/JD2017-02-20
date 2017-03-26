package by.it.tereshko.jd01_12;

import java.util.HashSet;
import java.util.Set;

public class MyCollect {
    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(b);

//        variant 1
        res.addAll(a);

//        variant 2
//        for (Integer value : a) {
//            if (!b.contains(value))
//                res.add(value);
//        }
        return res;
    }

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>();

//        variant 1
        res.addAll(a);
        res.retainAll(b);

//        variant 2
//        for (Integer value : a) {
//            if (!b.contains(value))
//                res.add(value);
//        }
        return res;
    }
}