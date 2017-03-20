package by.it.radivonik.jd01_12;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Radivonik on 20.03.2017.
 */
public class MyCollection {
    public static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(b);
        // Способ 1
//        for (Integer value: a) {
//            if (!b.contains(value)) {
//                res.add(value);
//            }
//        }

        // Способ 2
        res.addAll(a);
        return res;
    }

    public static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        // Способ 1
//        Set<Integer> res = new HashSet<>();
//        for (Integer value: a) {
//            if (b.contains(value)) {
//                res.add(value);
//            }
//        }
//        return res;

        // Способ 2
        Set<Integer> res2 = new HashSet<>(a);
        res2.retainAll(b);
        return res2;
    }
}
