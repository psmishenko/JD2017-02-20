package by.it.sorokoee.jd01_12;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyCollect {
    public static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> res=new HashSet<>(b);
//        res.addAll(a);
        for (Integer value:a) {
            if (!b.contains(value))
                res.add(value);

        }
        return res;
    }
    public static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(a);

//res.addAll(a);
        res.retainAll(b);
//        for (Integer value : a) {
//            if (b.contains(value))
//                res.add(value);
//        }
        return res;
    }
}
