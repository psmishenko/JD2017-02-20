package by.it.kolenda.jd01_12;


import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class MyCollect {

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(b);
        res.addAll(a);

        return res;
    }

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(b);
        //first
        res.addAll(a);
        res.retainAll(b);

//        second
//        for (Integer value: a){
//            if (!b.contains(value))
//                res.add(value);
//        }
        return res;
    }


    }

