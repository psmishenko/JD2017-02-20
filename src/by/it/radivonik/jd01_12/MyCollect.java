package by.it.radivonik.jd01_12;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Radivonik on 20.03.2017.
 */
public class MyCollect {
    public static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(a);
        // Способ 1
        res.addAll(b);

        // Способ 2
//        for (Integer value: a) {
//            if (!b.contains(value)) {
//                res.add(value);
//            }
//        }
        return res;
    }

    public static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        // Способ 1
        Set<Integer> res = new HashSet<>(a);
        res.retainAll(b);
        return res;

        // Способ 2
//        Set<Integer> res = new HashSet<>();
//        for (Integer value: a) {
//            if (b.contains(value)) {
//                res.add(value);
//            }
//        }
//        return res;
    }
}
