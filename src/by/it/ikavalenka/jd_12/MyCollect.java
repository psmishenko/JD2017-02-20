package by.it.ikavalenka.jd_12;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by USER on 26.03.2017.
 */
public class MyCollect {
    static Set<Integer> getCross (Set<Integer> a, Set<Integer> b){          //getUnion
        Set<Integer> resm = new HashSet<>(b);
        resm.addAll(a);
//                for (Integer value : a) {
//            if (!b.contains(value))
//                res.add(value);
//        }
        resm.addAll(b);
        return resm;
    }
    static  Set<Integer> gerCross2(Set<Integer> a, Set<Integer> b){
        Set<Integer> resm = new HashSet<>(a);
        // Set<Integer> res = new HashSet<>();
        resm.addAll(a);
        resm.retainAll(b);
//                for (Integer value : a) {
//            if (!b.contains(value))
//                res.add(value);
//}
            return resm;
    }
}
