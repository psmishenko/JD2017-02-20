package by.it.prigozhanov.jd01_12;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by v-omf on 3/20/2017!
 */
public class MyCollect {
    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(b);
        //первый способ
        res.addAll(a);
        // второй способ

//        for (Integer value: a) {
//            if (!b.contains(value)) {
//                res.add(value);
//            }
//        }
        return res;
    }

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(a);
        res.addAll(a);
        res.retainAll(b);
//        for (Integer value: a) {
//            if (b.contains(value)) {
//                res.add(value);
//            }
//        }
        return res;
    }
}
